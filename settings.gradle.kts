rootProject.name = "kata-gradle-starter"
include("template", "arrange-act-assert", "test-doubles")
include(":tdd:mars-rover", ":tdd:my-list")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
