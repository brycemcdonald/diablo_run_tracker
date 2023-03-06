package io.yeti.diablotracker.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import io.yeti.diablotracker.ui.select_run.SelectRunScreen
import io.yeti.diablotracker.ui.select_run.SelectRunViewModel
import io.yeti.diablotracker.ui.start_run.StartRunScreen
import io.yeti.diablotracker.ui.start_run.StartRunViewModel
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.utils.navigateTo


@Composable
fun StartRunNavigation(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry,
    viewModel: StartRunViewModel = hiltViewModel()
) {
    /*
             navArgument("runId") { type = NavType.IntType },
                navArgument("runName") { type = NavType.StringType },
                navArgument("playerNumber") { type = NavType.IntType },
     */

    val runName = navBackStackEntry.arguments?.getString("runName") ?: "Not Found"
    val runId = navBackStackEntry.arguments?.getInt("runId") ?: 0
    val playerNumber = navBackStackEntry.arguments?.getInt("playerNumber") ?: 0

    viewModel.getIndividualRun(runId)

    DiabloTrackerTheme {
        StartRunScreen(
            onBackClicked = {
              navController.popBackStack()
            },
            event = { event ->
                viewModel.onEvent(event)
            },
            state = viewModel.state
        )
    }

}

