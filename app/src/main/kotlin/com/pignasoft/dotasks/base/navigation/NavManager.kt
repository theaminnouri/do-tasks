package com.pignasoft.dotasks.base.navigation

import androidx.navigation.NavDirections

class NavManager {
    private var navEventListener: ((NavDirections) -> Unit)? = null

    fun navigate(navDirections: NavDirections) {
        navEventListener?.invoke(navDirections)
    }

    fun setOnNavEventListener(navEventListener: ((NavDirections) -> Unit)) {
        this.navEventListener = navEventListener
    }
}