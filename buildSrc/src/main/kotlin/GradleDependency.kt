import GradlePluginVersion.detekt
import GradlePluginVersion.gradleBuildToolsVersion

object GradlePluginVersion {
    const val gradleBuildToolsVersion = "4.1.1"
    const val ktlingGradle = "9.4.1"
    const val detekt = "1.15.0-RC1"
}

object GradleDependency {
    const val gradleBuildTools = "com.android.tools.build:gradle:$gradleBuildToolsVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${CoreVersion.kotlin}"
    const val detectGradlePlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detekt"
}

object GradlePluginId {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"


    const val ktlintGradle = "org.jlleitschuh.gradle.ktlint"

    const val detekt = "io.gitlab.arturbosch.detekt"
}
