package io.yeti.diablotracker.ui.create_run

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import io.yeti.diablotracker.R
import io.yeti.diablotracker.ui.components.*
import io.yeti.diablotracker.ui.select_run.SelectRunScreen
import io.yeti.diablotracker.ui.select_run.SelectRunState
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.ui.theme.STANDARD_PADDING


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateRunScreen(
    onSaveComplete: () -> Unit,
    state : CreateRunState,
    onEvent : (CreateRunEvent) -> Unit,

) {

    val runName = remember { mutableStateOf("") }

    var expanded by remember {
        mutableStateOf(false)
    }

    // remember the selected item
    var selectedItem by remember {
        mutableStateOf(state.playerNumberList[0])
    }

    if (state.saveIsComplete) {
        AlertDialogBox(
            title = stringResource(id = R.string.save_complete),
            text = stringResource(id = R.string.save_complete_description),
            yesNameClickText = R.string.okay,
            onYesClicked = {
                runName.value = ""
                expanded = false
                selectedItem = state.playerNumberList[0]
                onEvent(CreateRunEvent.ClearState)
                onSaveComplete()
            },
            onNoClicked = {}) {}
    }
    //TODO : Switch this to error dialog in OutlineEdit.
    if (state.isError) {
        AlertDialogBox(
            title = stringResource(id = R.string.no_run_name_found),
            text = stringResource(id = R.string.no_run_name_description),
            yesNameClickText = R.string.okay,
            onYesClicked = {
                onEvent(CreateRunEvent.ClearState)
            },
            onNoClicked = {}) {}
    }



    TopBar(title = R.string.create_run) {
        Column(
            modifier = Modifier
                .padding(top = 32.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            OutLineEdit(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    ),
                label = R.string.label_enter_run,
                onValueChanged = {
                    Log.i("Select Run", "updating Value $it")
                    runName.value = it
                },
                leaderIcon = null,
            )

            Spacer(modifier = Modifier.height(16.dp))


            // box
            ExposedDropdownMenuBox(
                modifier = Modifier
                    //.fillMaxWidth()
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp)
                    .background(MaterialTheme.colors.primaryVariant).align(Alignment.Start),
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                TextField(
                    value = selectedItem.toString(),
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = stringResource(id = R.string.player_count)) },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                // menu
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    state.playerNumberList.forEach { selectedOption ->
                        // menu item
                        DropdownMenuItem(onClick = {
                            selectedItem = selectedOption
                            expanded = false
                        }) {
                            GenericText(mutableText = selectedOption.toString(),
                            staticText = null,
                                typography = MaterialTheme.typography.h3)
                        }
                    }
                }
            }


            Spacer(modifier = Modifier.weight(1f))
            Row {
                MainButton(
                    buttonPressed = {
                        Log.i("Select Run", "Run Name ${runName.value}")
                        onEvent(CreateRunEvent.OnSaveClicked(
                            runName.value,
                            selectedItem))
                    },
                    buttonText = stringResource(id = R.string.complete)
                )
            }

        }

    }


}

@PreviewModes
@Composable
fun PreviewCreateRun() {
    DiabloTrackerTheme {
        CreateRunScreen(onSaveComplete = {}, state = CreateRunState(),
            onEvent = {})
    }
}