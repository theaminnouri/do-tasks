package com.pignasoft.dotasks.base.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.pignasoft.dotasks.R
import timber.log.Timber

/**
 * When trying to navigate to a destination that is not included in the current navigation graph
 * the app will crash:
 * java.lang.IllegalArgumentException: Navigation action/destination X cannot be found
 *
 * This happens when a (second) navigation request is triggered from a fragment that is no longer the
 * current
 * location (currentDestination) in the navController. In other words, when navigating from A to B, there is
 * a moment when:
 *     - Fragment A is still active and showing.
 *     - The navigation library already changed its current location,currentDestination, to Fragment B.
 *
 * Crash happens when a second request to navigate from fragment A comes in at exactly this moment (usually
 *  due
 * to extremely fast clicking or multitouch), and it uses a destination that is not included in B’s graph.
 * More: https://medium.com/@ffvanderlaan/fixing-the-dreaded-is-unknown-to-this-navcontroller-68c4003824ce
 *
 * This method navigates only if this is safely possible; when this Fragment is still the current
 * destination.
 */
fun Fragment.navigateSafe(directions: NavDirections, navOptions: NavOptions? = null) {
    if (canNavigate()) findNavController().navigate(directions, navOptions)
}

/**
 * Returns true if the navigation controller is still pointing at 'this' fragment, or false
 * if it already navigated away.
 */
fun Fragment.canNavigate(): Boolean {
    val navController = findNavController()
    val navControllerDestinationId = navController.currentDestination?.id

    // add tag_navigation_destination_id to your res\values\ids.xml so that it's unique:
    val fragmentDestinationId =
        view?.getTag(R.id.tag_navigation_destination_id) ?: navControllerDestinationId

    // check that the navigation graph is still in 'this' fragment, if not then the app already navigated:
    return if (navControllerDestinationId == fragmentDestinationId) {
        view?.setTag(R.id.tag_navigation_destination_id, fragmentDestinationId)
        true
    } else {
        Timber.d("May not navigate: current destination is not the current fragment.")
        false
    }
}