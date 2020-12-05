import kotlin.reflect.full.memberProperties

private const val FEATURE_PREFIX = ":feature_"

object ModuleDependency {
    const val APP = ":app"
    const val LIBRARY_BASE = ":library_base"
    const val FEATURE_ADD = FEATURE_PREFIX + "add"

    fun getAllModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

    fun getDynamicFeatureModules() = getAllModules()
        .filter { it.startsWith(FEATURE_PREFIX) }
        .toSet()
}