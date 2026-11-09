plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Задача 1: Запуск всех тестов
tasks.test {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true   // показывать println из тестов в консоли
    }
    outputs.upToDateWhen { false }   // всегда запускать тесты заново
    finalizedBy("testsOver")         // после завершения test запустить testsOver
}

// Задача 2: Пишет в консоль после прогона тестов
tasks.register("testsOver") {
    group = "verification"
    doLast {
        println("Test run is over")
    }
}

// Учебная задача: только тесты с меткой Smoke
tasks.register<Test>("smoke") {
    group = "tests"
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath

    systemProperty("CIRCUIT", System.getProperty("CIRCUIT", "DEV"))
    useJUnitPlatform {
        includeTags("Smoke")
    }
    testLogging {
        showStandardStreams = true
    }
    outputs.upToDateWhen { false }
}

// Кодировка, чтобы русские буквы показывались нормально
tasks.withType<JavaExec> {
    jvmArgs("-Dfile.encoding=UTF-8", "-Dstdout.encoding=UTF-8", "-Dstderr.encoding=UTF-8")
}
tasks.withType<Test> {
    jvmArgs("-Dfile.encoding=UTF-8", "-Dstdout.encoding=UTF-8", "-Dstderr.encoding=UTF-8")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}