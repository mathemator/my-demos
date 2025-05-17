plugins {
    java
    application
}

group = "ru.mathemator.demo"
version = "1.0"

val nativeSrcDir = file("src/main/native")
val nativeBuildDir = file("$buildDir/native")
val nativeLibOutputDir = file("$buildDir/libs/native")

val compileNative by tasks.registering(Exec::class) {
    inputs.dir(nativeSrcDir)
    outputs.dir(nativeBuildDir)

    doFirst {
        nativeBuildDir.mkdirs()
    }

    commandLine(
        "gcc",
        "-I", System.getenv("JAVA_HOME") + "/include",
        "-I", System.getenv("JAVA_HOME") + "/include/linux",
        "-shared", "-fPIC",
        "-o", File(nativeBuildDir, "libnative_example.so").absolutePath,
        File(nativeSrcDir, "native_example.c").absolutePath
    )
}

val copyNative by tasks.registering(Copy::class) {
    from(nativeBuildDir)
    into(nativeLibOutputDir)
    dependsOn(compileNative)
}

tasks.named("compileJava") {
    dependsOn(compileNative)
}

tasks.named("processResources") {
    dependsOn(copyNative)
}

application {
    mainClass.set("ru.mathemator.demo.NativeExample")
}

tasks.named<JavaExec>("run") {
    dependsOn(copyNative)
    doFirst {
        jvmArgs("-Djava.library.path=${nativeLibOutputDir.absolutePath}")
    }
}
