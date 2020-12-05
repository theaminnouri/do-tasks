include(":feature_add")
pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
    }

    plugins {
        id("com.android.application") version "4.1.1"
        id("com.android.library") version "4.1.1"
        id("com.android.dynamic-feature") version "4.1.1"
        id("org.jetbrains.kotlin.jvm") version "1.4.20"
        id("org.jetbrains.kotlin.android") version "1.4.20"
        id("org.jetbrains.kotlin.android.extensions") version "1.4.20"
        id("io.gitlab.arturbosch.detekt") version "1.15.0-RC1"
        id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
    }

    resolutionStrategy {

        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.dynamic-feature",
                "com.android.library"
                -> useModule("com.android.tools.build:gradle:4.1.1")
            }
        }
    }
}
rootProject.buildFileName = "build.gradle.kts"
include(
    ":app",
    ":library_base",
    ":feature_add"
)
