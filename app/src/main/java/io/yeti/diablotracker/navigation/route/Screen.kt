package io.yeti.diablotracker.navigation.route

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.yeti.diablotracker.R

sealed class Screen (
    val route: String,
                     @StringRes val resourceId: Int,
    @DrawableRes val iconId : Int?) {
    object SelectRun : Screen("profile", R.string.select_run, R.drawable.svg_list)
    object CreateRun : Screen("create", R.string.create_run,  R.drawable.svg_create_icon)
    object Data : Screen(route = "data", resourceId = R.string.data_of_runs, R.drawable.svg_data)

    object StartRun : Screen(route = "start_run/{runId}/{runName}/{playerNumber}", resourceId = R.string.start_run, iconId= null)


    companion object {
        fun listOfBottomScreens () : List<Screen> {
            return arrayListOf(SelectRun, CreateRun, Data)
        }
    }

}