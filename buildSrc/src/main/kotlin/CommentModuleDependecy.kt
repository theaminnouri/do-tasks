import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addTestDependencies() {
    androidTestImplementation(LibraryDependency.ANDROID_TEST_JUNIT)
    androidTestImplementation(LibraryDependency.ANDROID_TEST_ESPRESSO_CORE)
    androidTestImplementation(LibraryDependency.FLUENT)
    androidTestImplementation(LibraryDependency.ROOM_TEST)
    androidTestImplementation(LibraryDependency.ROOM_RUNTIME)

    testImplementation(LibraryDependency.KOTLIN_TEST_JUNIT)
    testImplementation(LibraryDependency.COROUTINE_TEST)
    testImplementation(LibraryDependency.MOCKK)
    testImplementation(LibraryDependency.FLUENT)
    testImplementation(LibraryDependency.ROOM_TEST)
}

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)