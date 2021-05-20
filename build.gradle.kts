plugins {
    java
}

configure(
    listOf(
        project(":template"),
        project(":given-when-then"),
        project(":test-doubles"),
        project(":tdd:mars-rover"),
        project(":tdd:my-stack"),
        project(":legacy-code:chart-smart"),
        project(":legacy-code:ugly-trivia"),
        project(":duplication:java-version"),
    )
) {
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
