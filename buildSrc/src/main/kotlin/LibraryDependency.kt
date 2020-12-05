object LibraryVersion {
    const val ANDROID_TEST_ESPRESSO_CORE = "3.3.0"
    const val ANDROID_TEST_JUNIT = "1.1.0"
    const val JUNIT = "4.13.1"
    const val ANDROID_MATERIAL = "1.2.1"
    const val APP_COMPAT = "1.2.0"
    const val ANDROID_CORE_KTX = "1.3.2"
}

object LibraryDependency {

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${CoreVersion.KOTLIN}"
    const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.ANDROID_CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPAT}"
    const val ANDROID_MATERIAL =
        "com.google.android.material:material:${LibraryVersion.ANDROID_MATERIAL}"
    const val JUNIT = "junit:junit:${LibraryVersion.JUNIT}"
    const val ANDROID_TEST_JUNIT = "androidx.test.ext:junit:${LibraryVersion.ANDROID_TEST_JUNIT}"
    const val ANDROID_TEST_ESPRESSO_CORE =
        "androidx.test.espresso:espresso-core:${LibraryVersion.ANDROID_TEST_ESPRESSO_CORE}"
}