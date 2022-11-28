rootProject.name = "kata-gradle-starter"
include(":template")
include(":given-when-then")
include(":test-doubles")
include(":tdd:mars-rover")
include(":tdd:my-stack")
include(":tdd:social-network")
include(":tdd:fizz-buzz")
include(":legacy-code:chart-smart")
include(":legacy-code:ugly-trivia")
include(":code-smells")
include(":duplication:java-version")
include(":duplication:javascript-version")
include(":tell-dont-ask")
include(":rps")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
