
plugins {
    // Apply the java-library plugin to add support for Java Library
    `java-library`
    eclipse
}

group = "edu.sc.seis"
version = "4.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
  implementation("edu.sc.seis:seedCodec:1.0.11")
  implementation("edu.sc.seis:seisFile:1.7.4")
  implementation("edu.sc.seis:sod-model:4.0.0-SNAPSHOT")
  // Use JUnit Jupiter API for testing.
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")

  // Use JUnit Jupiter Engine for testing.
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.1")
}


configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("edu.sc.seis:sod-model")).with(project(":sod-model"))
        substitute(module("edu.sc.seis:sod-util")).with(project(":sod-util"))
        substitute(module("edu.sc.seis:seisFile")).with(project(":seisFile"))
        substitute(module("edu.sc.seis:seedCodec")).with(project(":seedCodec"))
    }
}
