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
    val runId = navBackStackEntry.arguments?.getInt("runId") ?: 0
    viewModel.getIndividualRun(runId)

    DiabloTrackerTheme {
        StartRunScreen(
            runComplete = { run ->
                          //NavigationToAddRuneScreen
            },
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

