plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
    // lint plugin Spotless
    id("com.diffplug.spotless") version "6.21.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // MySQL Setting
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.named("compileJava") {
    dependsOn(tasks.named("spotlessApply"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    kotlin {
        target("src/**/*.kt") // 적용할 파일 범위
        // 기본적인 Kotlin 스타일 적용
        ktlint("0.49.1").userData(mapOf("disabled_rules" to "no-wildcard-imports"))
        trimTrailingWhitespace()
        endWithNewline()
    }

    format("misc") {
        target("**/*.gradle", "**/*.md", "**/*.yml", "**/*.yaml", "**/.gitignore")
        trimTrailingWhitespace()
        endWithNewline()
    }
}
