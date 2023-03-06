package io.yeti.diablotracker.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import io.yeti.diablotracker.navigation.route.Screen



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomBar(
    content: @Composable () -> Unit,
    navBackStackEntry: NavBackStackEntry
){
    val navController = rememberNavController()
    val items = listOf(
        Screen.CreateRun,
        Screen.SelectRun,
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
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
        },
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            content()
        }
    }
}
