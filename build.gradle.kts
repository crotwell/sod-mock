
plugins {
    // Apply the java-library plugin to add support for Java Library
    `java-library`
}

group = "edu.sc.seis"
version = "4.0.0-SNAPSHOT"

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
  implementation("edu.sc.seis:sod-model:4.0.0-SNAPSHOT")
//  testCompile group: "junit", name: "junit", version: "4.12+"
}


configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("edu.sc.seis:sod-model")).with(project(":sod-model"))
        substitute(module("edu.sc.seis:sod-util")).with(project(":sod-util"))
        substitute(module("edu.sc.seis:seisFile")).with(project(":seisFile"))
    }
}
