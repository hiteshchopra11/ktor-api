val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val ktorm_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.ktorm:ktorm-core:${ktorm_version}")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    implementation("mysql:mysql-connector-java:8.0.26")
    implementation("org.mindrot:jbcrypt:0.4")

    // JWT Authentication
    implementation("io.ktor:ktor-server-auth:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt:$ktor_version")

    // Logging
    implementation("io.ktor:ktor-server-call-logging:$ktor_version")

    // Koin
    implementation("io.insert-koin:koin-ktor:$koin_version")

    /* The core module of Ktorm (ktorm-core) only provides support for
    standard SQL, if we want to use some special features of a database, we need to support dialects. */
    implementation("org.ktorm:ktorm-support-mysql:${ktorm_version}")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    // Content Negotiation
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")

    // Json serialization for Content Negotiation
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
}