import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(GradlePluginId.DETEKT)
    id(GradlePluginId.KTLINT_GRADLE)
    id(GradlePluginId.KOTLIN_JVM) apply false
    id(GradlePluginId.KOTLIN_ANDROID) apply false
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS) apply false
    id(GradlePluginId.ANDROID_APPLICATION) apply false
    id(GradlePluginId.ANDROID_LIBRARY) apply false
}

allprojects {

    repositories {
        google()
        jcenter()
    }
    // We want to apply ktlint at all project level because it also checks build gradle files
    apply(plugin = GradlePluginId.KTLINT_GRADLE)
}

// All kotlin modules
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
subprojects {

    afterEvaluate {
        configureAndroid()
    }
}

fun Project.configureAndroid() {
    (project.extensions.findByName("android") as? com.android.build.gradle.BaseExtension)?.run {
        sourceSets {
            map { it.java.srcDir("src/${it.name}/kotlin") }
        }
    }
}

task("staticCheck") {
    afterEvaluate {
        val lintDependencies = subprojects.mapNotNull { "${it.name}:lint" }
        dependsOn(lintDependencies + listOf("ktlintCheck", "detekt"))
    }
}
buildscript {
    dependencies {
        classpath(GradleOldWayPlugins.ANDROID_GRADLE)
        classpath(GradleOldWayPlugins.NAVIGATION_SAFE_ARGS)
    }
}
