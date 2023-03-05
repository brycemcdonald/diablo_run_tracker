package io.yeti.diablotracker.ui.components

import android.app.ActionBar
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import io.yeti.diablotracker.ui.theme.STANDARD_PADDING
import io.yeti.diablotracker.ui.theme.STANDARD_TEXT_SIZE
import io.yeti.diablotracker.ui.theme.WEIGHT_400
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopBar(
    @StringRes title: Int,
    floatingActionBar: Boolean = false,
    floatingAction: () -> Unit = {},
    showActionBarIcon: Boolean = true,
    showActionOnClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    val scaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    /*
    @Composable
fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
     */

    Scaffold(
        floatingActionButton = {
            if (floatingActionBar) {
                FloatingActionButton(onClick = { floatingAction() }) {
                    Icon(
                        Icons.Default.Add, contentDescription = "",
                        Modifier.testTag("Floating Pressed")
                    )
                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = title))
                },
                navigationIcon = {
                    if (showActionBarIcon) {
                        IconButton(onClick = {
                            scope.launch { scaffoldState.conceal() }
                            showActionOnClick()
                        }) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    }

                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp


            )
        }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            content()
        }
    }
}



//                navigationIcon = {}
//                if (floatingActionBar) {
//                    FloatingActionButton(onClick = { floatingAction() }) {
//                        Icon(Icons.Default.Add, contentDescription = "",
//                            Modifier.testTag("Floating Pressed"))
//                    }
//                }
//                if (showActionBarIcon) {
//                    IconButton(
//                        onClick = {
//                            scope.launch { scaffoldState.conceal() }
//                        }
//                    ) {
//                        Icon(
//                            Icons.Default.Close,
//                            contentDescription = "Close"
//                        )
//                    }
//                }
//                Text(
//                    fontWeight = FontWeight(WEIGHT_400), //TODO : Put weight in dims folder under "Scaffold"
//                    fontSize = STANDARD_TEXT_SIZE,
//                    modifier = Modifier.padding(STANDARD_PADDING),
//                    text = "Tracker",
//
//                    color = Color.Black)
//        }
//}
//) {
//    Column(
//        modifier = Modifier
//            .padding(it)
//            .fillMaxSize()
//    ) {
//        content()
//    }
//}
//}

@PreviewModes
@Composable
fun PreviewTopBar() {
    MaterialTheme {
        TopBar(title = io.yeti.diablotracker.R.string.select_run) {

        }
    }

}

//@Composable
//fun ScaffoldWithTopBar() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Top App Bar")
//                },
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(Icons.Filled.ArrowBack, "backIcon")
//                    }
//                },
//                backgroundColor = MaterialTheme.colors.primary,
//                contentColor = Color.White,
//                elevation = 10.dp
//            )
//        }, content = {
//            Column(
//                modifier = Modifier
//                    .padding(it)
//                    .fillMaxSize()
//                    .background(Color(0xff8d6e63)),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Content of the page",
//                    fontSize = 30.sp,
//                    color = Color.White
//                )
//            }
//
//        })
//}