rootProject.name = "kata-gradle-starter"
include(":template")
include(":given-when-then")
include(":test-doubles")
include(":tdd:mars-rover")
include(":tdd:my-stack")
include(":legacy-code:chart-smart")
include(":code-smells")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
