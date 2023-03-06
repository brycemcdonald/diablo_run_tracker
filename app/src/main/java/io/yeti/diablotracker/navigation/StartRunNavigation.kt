package io.yeti.diablotracker.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
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
    viewModel: StartRunViewModel = hiltViewModel()
) {



    DiabloTrackerTheme {
        StartRunScreen()
    }

}

