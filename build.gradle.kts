plugins {
    application
    id("java")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "uk.ac.nott.cs.comp2013"
version = "1.0.0"

repositories {
    mavenCentral()
}

val mockitoAgent = configurations.create("mockitoAgent")

dependencies {
    implementation("org.apache.commons:commons-csv:1.12.0")
    implementation("org.openjfx:javafx-media:22.0.1")
    implementation("org.openjfx:javafx-graphics:19")
    implementation("org.openjfx:javafx-base:19.0.2")
    implementation("org.openjfx:javafx-controls:19.0.2")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.vintage:junit-vintage-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("com.pholser:junit-quickcheck-core:1.0")
    testImplementation("com.pholser:junit-quickcheck-generators:1.0")
    testImplementation("org.mockito:mockito-core:5.14.+")
    mockitoAgent("org.mockito:mockito-core:5.14.+") { isTransitive = false }
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("-javaagent:${mockitoAgent.asPath}")
}

tasks.processResources {
    from("src/main/resources") {
        into("resources")
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

application {
    mainClass = "uk.ac.nott.cs.comp2013.froggerApp.controller.Main"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    sourceSets {
        main {
            java {
                srcDirs("src/main/java")
            }
            resources {
                srcDirs( "src/main/resources")
            }
        }
    }
}

javafx {
    version = "22.0.1"
    modules = listOf("javafx.controls", "javafx.fxml","javafx.media")
}




