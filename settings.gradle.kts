pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
    }

    plugins {
        id("com.android.application") version "7.0.0"
        id("com.android.library") version "7.0.0"
        id("com.android.dynamic-feature") version "7.0.0"
        id("androidx.navigation.safeargs.kotlin") version "2.3.5"
        id("org.jetbrains.kotlin.jvm") version "1.5.21"
        id("org.jetbrains.kotlin.android") version "1.5.21"
        id("org.jetbrains.kotlin.plugin.parcelize") version "1.5.21"
        id("io.gitlab.arturbosch.detekt") version "1.15.0-RC1"
        id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
        id("org.jetbrains.kotlin.kapt") version "1.5.21"
    }

    resolutionStrategy {

        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.dynamic-feature",
                "com.android.library"
                -> useModule("com.android.tools.build:gradle:7.0.0")
            }
        }
    }
}
rootProject.buildFileName = "build.gradle.kts"
include(
    ":app",
    ":feature_tasks",
    ":feature_add_task",
    ":feature_profile"
)
