object LibraryVersion {
    const val ANDROID_TEST_ESPRESSO_CORE = "3.3.0"
    const val ANDROID_TEST_JUNIT = "1.1.0"
    const val JUNIT = "4.13.1"
    const val ANDROID_MATERIAL = "1.2.1"
    const val APP_COMPAT = "1.2.0"
    const val ANDROID_CORE_KTX = "1.3.2"
    const val ANDROID_COROUTINE = "1.3.9"
    const val MOCKK = "1.10.3-jdk8"
    const val FLUENT = "1.64"
    const val ROOM = "2.2.5"
    const val ANDROID_PLAY_CORE = "1.9.0"
    const val ANDROID_PLAY_CORE_KTX = "1.8.1"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val ANDROID_LIFECYCLE = "2.3.1"
    const val ANDROID_ARCH = "2.1.0"
    const val TIMBER = "4.7.1"
    const val NAVIGATION = "2.3.5"
}

object LibraryDependency {

    const val KOTLIN =
        "org.jetbrains.kotlin:kotlin-stdlib:${CoreVersion.KOTLIN}"
    const val KOTLIN_REFLECT =
        "org.jetbrains.kotlin:kotlin-reflect:${CoreVersion.KOTLIN}"
    const val ANDROID_CORE_KTX =
        "androidx.core:core-ktx:${LibraryVersion.ANDROID_CORE_KTX}"
    const val APP_COMPAT =
        "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPAT}"
    const val ANDROID_MATERIAL =
        "com.google.android.material:material:${LibraryVersion.ANDROID_MATERIAL}"
    const val COROUTINE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersion.ANDROID_COROUTINE}"
    const val JUNIT =
        "junit:junit:${LibraryVersion.JUNIT}"
    const val ANDROID_TEST_JUNIT =
        "androidx.test.ext:junit:${LibraryVersion.ANDROID_TEST_JUNIT}"
    const val ANDROID_TEST_ESPRESSO_CORE =
        "androidx.test.espresso:espresso-core:${LibraryVersion.ANDROID_TEST_ESPRESSO_CORE}"
    const val KOTLIN_TEST_JUNIT =
        "org.jetbrains.kotlin:kotlin-test-junit:${CoreVersion.KOTLIN}"
    const val COROUTINE_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibraryVersion.ANDROID_COROUTINE}"
    const val MOCKK =
        "io.mockk:mockk:${LibraryVersion.MOCKK}"
    const val FLUENT =
        "org.amshove.kluent:kluent-android:${LibraryVersion.FLUENT}"
    const val ROOM_RUNTIME =
        "androidx.room:room-runtime:${LibraryVersion.ROOM}"
    const val ROOM_COMPILER =
        "androidx.room:room-compiler:${LibraryVersion.ROOM}"
    const val ROOM_KTX =
        "androidx.room:room-ktx:${LibraryVersion.ROOM}"
    const val ROOM_TEST =
        "androidx.room:room-testing:${LibraryVersion.ROOM}"
    const val ANDROID_PLAY =
        "com.google.android.play:core:${LibraryVersion.ANDROID_PLAY_CORE}"
    const val ANDROID_PLAY_KTX =
        "com.google.android.play:core-ktx:${LibraryVersion.ANDROID_PLAY_CORE_KTX}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"
    const val ANDROID_LIFECYCLE_VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersion.ANDROID_LIFECYCLE}"
    const val ANDROID_LIFECYCLE_LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersion.ANDROID_LIFECYCLE}"
    const val ANDROID_LIFECYCLE_COMMON =
        "androidx.lifecycle:lifecycle-common-java8:${LibraryVersion.ANDROID_LIFECYCLE}"
    const val ARCH_CORE_TESTING =
        "androidx.arch.core:core-testing:${LibraryVersion.ANDROID_ARCH}"
    const val TIMBER =
        "com.jakewharton.timber:timber:${LibraryVersion.TIMBER}"
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${LibraryVersion.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${LibraryVersion.NAVIGATION}"
    const val NAVIGATION_DYNAMIC =
        "androidx.navigation:navigation-dynamic-features-fragment:${LibraryVersion.NAVIGATION}"
    const val NAVIGATION_TEST =
        "androidx.navigation:navigation-testing:${LibraryVersion.NAVIGATION}"
}