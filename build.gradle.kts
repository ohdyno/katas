plugins {
    java
}

subprojects {
    apply {
        plugin("java")
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
        testImplementation("com.approvaltests:approvaltests:10.4.1")
        testImplementation("org.assertj:assertj-core:3.19.0")

        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks.test {
        useJUnitPlatform()
    }

}
