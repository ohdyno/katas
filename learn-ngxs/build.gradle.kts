import com.github.gradle.node.npm.task.NpmTask

plugins {
  id("com.github.node-gradle.node").version("3.0.1")
}

node {
  download.set(true)
  version.set("14.16.0")
}

tasks.register("build") {
  dependsOn(tasks.npmInstall)
}
