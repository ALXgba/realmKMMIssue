pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KMMRealmIssue"
include(":MongoDB_Realm_Issue_Android")
include(":app")
include(":shared")
include(":ios")