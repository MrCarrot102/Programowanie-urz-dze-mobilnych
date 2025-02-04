dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        libs {
            from(files("gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "YourProjectName"
include(":app")
