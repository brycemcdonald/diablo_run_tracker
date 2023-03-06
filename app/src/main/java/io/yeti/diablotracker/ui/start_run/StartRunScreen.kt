package io.yeti.diablotracker.ui.start_run


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.yeti.diablotracker.R
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.ui.components.GenericText
import io.yeti.diablotracker.ui.components.MainButton
import io.yeti.diablotracker.ui.components.PreviewModes
import io.yeti.diablotracker.ui.components.TopBar
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme

@Composable
fun StartRunScreen(
    onBackClicked: () -> Unit,
    runComplete : (Run) -> Unit,
    state: StartRunState,
    event: (StartRunEvent) -> Unit
) {

    if (state.runComplete) {
        runComplete(state.run)
    }

    TopBar(title = R.string.start_run, showActionBarIcon = true,
        showActionOnClick = { onBackClicked() }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(Modifier.align(Alignment.End)) {


/*
                Icon(
                    modifier = Modifier.padding(16.dp).width(36.dp)
                        .height(36.dp),
                    imageVector = if (state.run.isFavourite) Icons.Rounded.Star else Icons.Outlined.Star,
                    contentDescription = "Star"
                )

 */
            }


            GenericText(
                textSize = 17.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                staticText = null,
                mutableText = "Name: " + state.run.runName
            )

            GenericText(
                textSize = 17.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                staticText = null,
                mutableText = "Runs: " + state.run.runAmounts.toString()
            )


            Spacer(modifier = Modifier.weight(1f))
            Row {
                MainButton(
                    buttonPressed = {
                        event(StartRunEvent.OnRunFinished)
                    },
                    buttonText = stringResource(id = R.string.complete)
                )
            }
        }
    }
}

@PreviewModes
@Composable
fun PreviewStartRunScreen() {
    DiabloTrackerTheme {
        StartRunScreen(
            event = {},
            state = StartRunState(),
            onBackClicked = {},
        runComplete = {})
    }

}