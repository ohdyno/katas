import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node").version("3.0.1")
}

node {
    download.set(true)
    version.set("14.16.0")
}

task<NpmTask>("present") {
    dependsOn(tasks.npmInstall)
    args.set(listOf("run", "start"))
}
