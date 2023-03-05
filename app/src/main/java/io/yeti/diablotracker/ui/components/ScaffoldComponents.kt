package io.yeti.diablotracker.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.yeti.diablotracker.navigation.route.Screen
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.ui.theme.STANDARD_PADDING
import io.yeti.diablotracker.ui.theme.STANDARD_TEXT_SIZE
import io.yeti.diablotracker.ui.theme.WEIGHT_400
import kotlinx.coroutines.launch


/**
 * ScaffoldComponents has the list of different custom scaffolds
 * This will be comprise with
 * TopBar only
 *  BottomBar only
 *  Both Top and Bottom
 *
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopBarScaffold(
    floatingActionBar : Boolean = false,
    floatingAction : () -> Unit = {},
    content: @Composable () -> Unit,
){
    val scaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )
    val scope = rememberCoroutineScope()


    Scaffold(
        floatingActionButton = {
            if (floatingActionBar) {
                FloatingActionButton(
                    onClick = { floatingAction() }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "",
                        Modifier.testTag("Floating Pressed"))
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        topBar = {
            TopAppBar {



                IconButton(
                    onClick = {
                        scope.launch { scaffoldState.conceal() }
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Close"
                    )
                }
                Text(
                    fontWeight = FontWeight(WEIGHT_400), //TODO : Put weight in dims folder under "Scaffold"
                    fontSize = STANDARD_TEXT_SIZE,
                    modifier = Modifier.padding(STANDARD_PADDING),
                    text = "Tracker",

                    color = Color.Black)
            }
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            content()
        }
    }
}

@PreviewModes
@Composable
fun PreviewTopBarScaffold(){
    MaterialTheme {
        TopBarScaffold(floatingActionBar = true) {
            Text(text = "Preview Top Bar")
        }
    }

}


//// ------ BOTTOM ---- ///
@Composable
fun BottomBarScaffold(
    content: @Composable () -> Unit,
){
    val navController = rememberNavController()
    val items = listOf(
        Screen.CreateRun,
        Screen.SelectRun,
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
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

@PreviewModes
@Composable
fun PreviewBottomBarScaffold(){
    MaterialTheme {
        BottomBarScaffold(content = { 
            Text(text = "Bottom Bar Scaffold")
        })
    }

}

//COMBINED SCAFFOLD

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CombinedScaffold (
    floatingActionBar : Boolean = false,
    floatingAction : () -> Unit = {},
    content: @Composable  (BoxScope.() -> Unit),
) {

    val scaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val items = listOf(
        Screen.CreateRun,
        Screen.SelectRun,
    )

    Scaffold(
        floatingActionButton = {
            if (floatingActionBar) {
                FloatingActionButton(
                    onClick = { floatingAction() }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "",
                        Modifier.testTag("Floating Pressed"))
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        topBar = {
            TopAppBar {
                IconButton(
                    onClick = {
                        scope.launch { scaffoldState.conceal() }
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Close"
                    )
                }
                Text(
                    fontWeight = FontWeight(WEIGHT_400), //TODO : Put weight in dims folder under "Scaffold"
                    fontSize = STANDARD_TEXT_SIZE,
                    modifier = Modifier.padding(STANDARD_PADDING),
                    text = "Tracker",

                    color = Color.Black
                )
            }
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
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

        Box(  modifier = Modifier
            .padding(it)
            .fillMaxSize())  {
                content(this)
        }
    }
}

@PreviewModes
@Composable
fun PreviewCombinedScaffold () {
    DiabloTrackerTheme {
        CombinedScaffold(floatingActionBar = true) {
            Text(text = "Test Combined Scaffold")
        }
    }
}

@Composable
fun FABTest () {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                /* FAB content */
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                // Defaults to null, that is, No cutout
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {
                /* Bottom app bar content */
            }
        }
    ) {
        Column(Modifier.padding(it)) {
            
        }
    }
}

@PreviewModes
@Composable
fun TestGoogleFAB ()  {
    DiabloTrackerTheme {
        FABTest()
    }
}
