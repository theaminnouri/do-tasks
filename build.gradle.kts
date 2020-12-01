import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

    repositories {
        google()
        google()
        jcenter()
        gradlePluginPortal()
    }
    dependencies {
        classpath(GradleDependency.gradleBuildTools)
        classpath(GradleDependency.kotlinGradlePlugin)
        classpath(GradleDependency.detectGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

plugins {
    id(GradlePluginId.detekt) version GradlePluginVersion.detekt
    id(GradlePluginId.ktlintGradle) version GradlePluginVersion.ktlingGradle
}

// All kotlin modules
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

task("staticCheck") {
    afterEvaluate {
        val lintDependencies = subprojects.mapNotNull { "${it.name}:lint" }
        dependsOn(lintDependencies + listOf("ktlintCheck", "detekt"))
    }
}
