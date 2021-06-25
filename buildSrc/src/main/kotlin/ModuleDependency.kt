import kotlin.reflect.full.memberProperties

private const val FEATURE_PREFIX = ":feature_"

object ModuleDependency {
    const val APP = ":app"
    const val FEATURE_TASKS = FEATURE_PREFIX + "tasks"
    const val FEATURE_ADD_TASK = FEATURE_PREFIX + "add_task"
    const val FEATURE_PROFILE = FEATURE_PREFIX + "profile"

    fun getAllModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

    fun getDynamicFeatureModules() = getAllModules()
        .filter { it.startsWith(FEATURE_PREFIX) }
        .toSet()
}