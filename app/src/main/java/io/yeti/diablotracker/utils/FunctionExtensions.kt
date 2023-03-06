package io.yeti.diablotracker.utils

import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.navigation.NavController


fun NavController.navigateTo(route: String) {
    Log.i("Mapping", "navigateTo -- can add analytics here.")
    // val navOptions = NavOptions(restoreState()) //TODO :Add restore state here.
    this.navigate(route)
}

fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
