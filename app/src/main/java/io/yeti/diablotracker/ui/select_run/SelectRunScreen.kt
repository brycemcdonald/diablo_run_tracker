package io.yeti.diablotracker.ui.select_run

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.yeti.diablotracker.R
import io.yeti.diablotracker.domain.models.Run
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
fun SelectRunScreen(
    state: SelectRunState,
    onRunSelected: (Run) -> Unit,
    onEvent : (SelectRunEvent) -> Unit,
) {


    TopBar(title = R.string.select_run) {
        Column {
            if (state.runList.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        color = MaterialTheme.colors.onSurface,
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.please_add_run)
                            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ENGLISH) else it.toString() },
                        fontWeight = FontWeight(WEIGHT_400),
                        fontSize = STANDARD_TEXT_SIZE,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(STANDARD_PADDING)
                            .align(Alignment.Center)
                    )
                }
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.runList) { runFound ->
                    RunItem(
                        run = runFound,
                        onStartRun = {
                            onRunSelected(runFound)
                        }
                    )
                    Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(0.dp))
                }
            }
        }
    }
}

@PreviewModes
@Composable
fun PreviewSelectRunScreen() {
    DiabloTrackerTheme {
        SelectRunScreen(state = SelectRunState(), onRunSelected = {}, onEvent = {})
    }

}