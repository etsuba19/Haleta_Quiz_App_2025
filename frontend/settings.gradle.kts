pluginManagement {
    plugins {
        id("io.realm.kotlin") version "1.11.0"
    }
    repositories {
        google ()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Haleta Quiz App"

include(":app")

 