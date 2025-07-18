plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.mathemator.demo"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//application {
//    mainClass = 'ru.mathemator.demo.javahistory.java1_0.classloader.LoaderTest'
//    applicationDefaultJvmArgs = ["-Duser.dir=${projectDir}"]
//}
