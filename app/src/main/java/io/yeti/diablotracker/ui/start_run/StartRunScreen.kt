package io.yeti.diablotracker.ui.start_run

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.yeti.diablotracker.R
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.ui.components.GenericText
import io.yeti.diablotracker.ui.components.MainButton
import io.yeti.diablotracker.ui.components.PreviewModes
import io.yeti.diablotracker.ui.components.TopBar
import io.yeti.diablotracker.ui.create_run.CreateRunEvent
import io.yeti.diablotracker.ui.select_run.components.RunItem
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.ui.theme.STANDARD_PADDING
import io.yeti.diablotracker.ui.theme.STANDARD_TEXT_SIZE
import io.yeti.diablotracker.ui.theme.WEIGHT_400
import java.util.*

//  onRunSelected : (Run) -> Unit
@Composable
fun StartRunScreen(
    onBackClicked : () -> Unit,
    state : StartRunState,
    event : (StartRunEvent) -> Unit
) {


    TopBar(title = R.string.start_run, showActionBarIcon = true,
    showActionOnClick = { onBackClicked() }) {
        Column {
            Box(contentAlignment = Alignment.TopEnd) {
                Icon(
                    Icons.Default.Star,
                    //painter = painterResource(id = R.drawable.svg_list),
                    contentDescription = "Star"
                )
            }


            GenericText(
                modifier = Modifier.padding(16.dp),
                staticText = null,
                mutableText = state.run.runName)

            GenericText(
                modifier = Modifier.padding(16.dp),
                staticText = null,
                mutableText = "Amount of runs: " + state.run.runAmounts.toString())


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
            onBackClicked = {})
    }

}