package io.yeti.diablotracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import io.yeti.diablotracker.navigation.route.Screen


@Composable
fun AppNavigation(
    modifier: Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SelectRun.route,
        modifier = modifier,
    ) {
        // bottom navigation screens & nested graphs
//        CreateRunNavigation(navController)
//        SelectRunNavigation(navController)
//        DataNavigation(navController)

        // common screens in entire app
        // newsDetailGraph()

    }
}


fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(startDestination = Screen.SelectRun.route, route = Screen.SelectRun.route) {
        composable(Screen.CreateRun.route) {
            CreateRunNavigation(navController)
        }
        composable(Screen.SelectRun.route) {

        }
    }
}