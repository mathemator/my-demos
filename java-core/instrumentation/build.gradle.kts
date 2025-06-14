plugins {
    java
    application
}

group = "ru.mathemator.demo.instrumentation"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    // Например:
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

application {
    // Укажи имя своего главного класса с методом main
    mainClass.set("ru.mathemator.demo.instrumentation.Main")
}

tasks.jar {
    manifest {
        attributes(
            "Premain-Class" to "ru.mathemator.demo.instrumentation.Agent",
            "Agent-Class" to "ru.mathemator.demo.instrumentation.Agent",
            "Main-Class" to "ru.mathemator.demo.instrumentation",
            "Can-Redefine-Classes" to "true",       // по желанию
            "Can-Retransform-Classes" to "true"     // по желанию
        )
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from({
        configurations.runtimeClasspath.get().map { zipTree(it) }
    })
}