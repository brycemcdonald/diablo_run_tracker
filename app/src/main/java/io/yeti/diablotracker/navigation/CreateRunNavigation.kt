package io.yeti.diablotracker.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import io.yeti.diablotracker.ui.create_run.CreateRunScreen
import io.yeti.diablotracker.ui.create_run.CreateRunViewModel
import io.yeti.diablotracker.ui.select_run.SelectRunViewModel
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme


@Composable
fun CreateRunNavigation(
    navController: NavController,
    viewModel: CreateRunViewModel = hiltViewModel()
) {

    DiabloTrackerTheme {
        CreateRunScreen(onSaveComplete = {
            navController.popBackStack()
        },
        state = viewModel.state,
        onEvent = { event ->
            viewModel.onEvent(event)
        })
    }

}