package io.yeti.diablotracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import io.yeti.diablotracker.ui.create_run.CreateRunScreen
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme


@Composable
fun CreateRunNavigation(navController: NavController) {


    DiabloTrackerTheme {
        CreateRunScreen(onSaveComplete = {

        })
    }

}