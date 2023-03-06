package io.yeti.diablotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import io.yeti.diablotracker.navigation.CreateRunNavigation
import io.yeti.diablotracker.navigation.SelectRunNavigation
import io.yeti.diablotracker.navigation.StartRunNavigation
import io.yeti.diablotracker.navigation.route.Screen
import io.yeti.diablotracker.ui.components.TopBar
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme

@AndroidEntryPoint class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiabloTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FullNavigationStack()
                }
            }
        }
    }
}

@Composable
private fun FullNavigationStack ()  {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                Screen.listOfBottomScreens().forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Image(
                                painterResource(screen.iconId ?: R.drawable.svg_list),
                                contentDescription = "",
                            )
                               },
                        label = { Text(stringResource(screen.resourceId), color = MaterialTheme.colors.onSurface) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.SelectRun.route, Modifier.padding(innerPadding)) {
            composable(Screen.SelectRun.route) { SelectRunNavigation(navController) }
            composable(Screen.CreateRun.route) { CreateRunNavigation(navController) }
            composable(Screen.Data.route) { SelectRunNavigation(navController) }
            composable(Screen.Data.route,
                arguments = listOf(
                navArgument("runId") { type = NavType.IntType },
                navArgument("runName") { type = NavType.StringType },
                navArgument("playerNumber") { type = NavType.IntType },
            )) { StartRunNavigation(navController = navController)}
        }
    }
}

