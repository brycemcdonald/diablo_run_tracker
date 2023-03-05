package io.yeti.diablotracker.ui.create_run

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.yeti.diablotracker.R
import io.yeti.diablotracker.ui.components.*
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme


@Composable
fun CreateRunScreen(
    onSaveComplete: () -> Unit
) {

    AlertDialogBox(
        title = "Test box",
        text = "Info" ,
        onYesClicked = {  },
        onNoClicked = {}) {}

    val runName = remember { mutableStateOf("") }
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
                    runName.value = it
                },
                leaderIcon = null,
            )

            Spacer(modifier = Modifier.weight(1f))
            Row {
                MainButton(
                    buttonPressed = {
                        onSaveComplete()
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
        CreateRunScreen(onSaveComplete = {})
    }
}