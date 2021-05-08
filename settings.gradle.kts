rootProject.name = "kata-gradle-starter"
include("template", "given-when-then", "test-doubles")
include(":tdd:mars-rover", ":tdd:my-stack")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
