object GradlePluginVersion {
    const val ANDROID_GRADLE = "7.1.1"
    const val KTLINT_GRADLE = "9.4.1"
    const val DETEKT = "1.15.0-RC1"
    const val KOTLIN = CoreVersion.KOTLIN
    const val NAVIGATION = LibraryVersion.NAVIGATION
}

object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KOTLIN_PARCELIZE = "org.jetbrains.kotlin.plugin.parcelize"
    const val KTLINT_GRADLE = "org.jlleitschuh.gradle.ktlint"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val KOTLIN_KAPT = "org.jetbrains.kotlin.kapt"
    const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
}

object GradleOldWayPlugins {
    const val ANDROID_GRADLE =
        "com.android.tools.build:gradle:${GradlePluginVersion.ANDROID_GRADLE}"
    const val NAVIGATION_SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${GradlePluginVersion.NAVIGATION}"
}
