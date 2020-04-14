plugins {
    kotlin("jvm") version "1.3.72"
    `maven-publish`
    `java-library`
}

group = "com.andrewthom"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.poi:poi-ooxml:4.1.2")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
//
//    val sourcesJar by creating(Jar::class) {
//        dependsOn(JavaPlugin.CLASSES_TASK_NAME)
//        archiveClassifier.set("sources")
//        from(sourceSets["main"].allSource)
//    }
//
//    artifacts {
//        add("archives", sourcesJar)
//    }
}
