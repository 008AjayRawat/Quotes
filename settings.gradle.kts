pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Quotes"
include(":app")
include(":feature:authorQuotes")
include(":feature:tagQuotes")
include(":core:network")
include(":feature:randomQuotes")
