plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("com.approvaltests:approvaltests:10.4.1")
    testImplementation("org.assertj:assertj-core:3.19.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation("com.google.guava:guava:30.0-jre")
}

tasks.test {
    useJUnitPlatform()
}
