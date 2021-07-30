import CoreVersion.JAVA

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_PARCELIZE)
    id(GradlePluginId.KTLINT_GRADLE)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.SAFE_ARGS)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = AndroidConfig.ID
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK_VERSION
        buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildType.Companion.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

        getByName(BuildType.Companion.DEBUG) {
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

    dynamicFeatures.addAll(ModuleDependency.getDynamicFeatureModules().toMutableSet())

    testOptions {
        unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
    }

    buildFeatures {
        viewBinding = true
    }

    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {
    api(LibraryDependency.KOTLIN)
    api(LibraryDependency.KOTLIN_JDK8)
    api(LibraryDependency.ANDROID_CORE_KTX)
    api(LibraryDependency.APP_COMPAT)
    api(LibraryDependency.ANDROID_MATERIAL)
    api(LibraryDependency.COROUTINE)
    api(LibraryDependency.JUNIT)
    api(LibraryDependency.TIMBER)
    api(LibraryDependency.KOTLIN_REFLECT)
    api(LibraryDependency.ANDROID_LIFECYCLE_VIEW_MODEL_KTX)
    api(LibraryDependency.ANDROID_LIFECYCLE_COMMON)
    api(LibraryDependency.CONSTRAINT_LAYOUT)
    api(LibraryDependency.NAVIGATION_FRAGMENT)
    api(LibraryDependency.NAVIGATION_UI)
    api(LibraryDependency.NAVIGATION_DYNAMIC)

    implementation(LibraryDependency.ANDROID_PLAY)
    implementation(LibraryDependency.ANDROID_PLAY_KTX)
    implementation(LibraryDependency.ROOM_RUNTIME)
    kapt(LibraryDependency.ROOM_COMPILER)
    implementation(LibraryDependency.ROOM_KTX)

    addTestDependencies()
}
