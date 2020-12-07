object GradlePluginVersion {
    const val ANDROID_GRADLE = "4.1.1"
    const val KTLINT_GRADLE = "9.4.1"
    const val DETEKT = "1.15.0-RC1"
    const val KOTLIN = CoreVersion.KOTLIN
}

object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KOTLIN_ANDROID_EXTENSIONS = "org.jetbrains.kotlin.android.extensions"
    const val KTLINT_GRADLE = "org.jlleitschuh.gradle.ktlint"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val KOTLIN_KAPT = "org.jetbrains.kotlin.kapt"
}

object GradleOldWayPlugins {
    const val ANDROID_GRADLE =
        "com.android.tools.build:gradle:${GradlePluginVersion.ANDROID_GRADLE}"
}
