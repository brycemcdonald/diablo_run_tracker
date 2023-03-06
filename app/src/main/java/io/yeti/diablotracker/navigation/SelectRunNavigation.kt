package io.yeti.diablotracker.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import io.yeti.diablotracker.navigation.route.Screen
import io.yeti.diablotracker.ui.select_run.SelectRunScreen
import io.yeti.diablotracker.ui.select_run.SelectRunViewModel
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.utils.navigateTo


@Composable
fun SelectRunNavigation(
    navController: NavController,
    viewModel: SelectRunViewModel = hiltViewModel()
) {
    DiabloTrackerTheme {
        SelectRunScreen(
            state = viewModel.state,
            onRunSelected = { run ->
                val transfer = "/${run.id}/${run.runeName}/${run.playerNumber}"
                navController.navigateTo(
                    route = Screen.StartRun.route+transfer
                )
            },
            onEvent = { event ->
                viewModel.onEvent(event)
            }
        )
    }
}