pluginManagement {
    plugins {
        id("com.android.application")
        id("org.jetbrains.kotlin.android") version "1.9.23"
//        id("io.realm.kotlin") version "1.12.0" apply false
    }
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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
project(":app").projectDir = file("app")

 