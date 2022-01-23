plugins {
    id("de.fayard.refreshVersions") version "0.30.2"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

rootProject.name = "ViewBindingProvider"

include(
    ":demo:app",
    ":library",
)
