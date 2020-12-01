import LibraryVersion.androidCoreVersion
import LibraryVersion.androidMaterialVersion
import LibraryVersion.androidTestJUnitVersion
import LibraryVersion.appCompatVersion
import LibraryVersion.espressoCore
import LibraryVersion.jUnitVersion

object LibraryVersion {
    const val espressoCore = "3.3.0"
    const val androidTestJUnitVersion = "1.1.0"
    const val jUnitVersion = "4.13.1"
    const val androidMaterialVersion = "1.2.1"
    const val appCompatVersion = "1.2.0"
    const val androidCoreVersion = "1.3.2"
}

object LibraryDependency {

    const val androidTestEspresso = "androidx.test.espresso:espresso-core:$espressoCore"
    const val androidTestJUnit = "androidx.test.ext:junit:$androidTestJUnitVersion"
    const val jUnit = "junit:junit:$jUnitVersion"
    const val androidMaterial = "com.google.android.material:material:$androidMaterialVersion"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    const val androidCore = "androidx.core:core-ktx:$androidCoreVersion"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${CoreVersion.kotlin}"
}