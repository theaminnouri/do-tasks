import CoreVersion.JAVA
import ModuleDependency.APP

plugins {
    id(GradlePluginId.ANDROID_DYNAMIC_FEATURE)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.SAFE_ARGS)
}
android {
    compileSdk = AndroidConfig.COMPILE_SDK_VERSION
    buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK
        version = AndroidConfig.VERSION_CODE
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
    }
    compileOptions {
        sourceCompatibility = JAVA
        targetCompatibility = JAVA
    }

    kotlinOptions {
        jvmTarget = JAVA.toString()
    }

    testOptions {
        unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
    }
    buildFeatures.viewBinding = true
}

dependencies {
    implementation(project(APP))

    addTestDependencies()
}
