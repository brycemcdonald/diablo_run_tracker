package io.yeti.diablotracker.ui.components

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.yeti.diablotracker.R
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme


@Composable
fun AlertDialogBox(
    title: String,
    text: String,
    onYesClicked: () -> Unit,
    onNoClicked: () -> Unit,
    onDismiss: () -> Unit

) {

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(
            color = Color.Blue,
            text = title,
            fontWeight = FontWeight(400))
                },
        text = { Text(
            color = Color.Blue,
            text = text) },
        backgroundColor = Color.White,
        confirmButton = {
//            Button(onClick = { /*TODO*/ }) {
//                Text(text = stringResource(id = R.string.yes))
//            }
//
            ButtonRow {
                TextButton(onClick = { onYesClicked() }) {
                    Text(text = stringResource(id = R.string.yes))
                }
                Spacer(modifier = Modifier.width(16.dp))
                TextButton(onClick = { onNoClicked() }) {
                    Text(text = stringResource(id = R.string.no))
                }
            }

        }
    )

}

@Composable
fun ButtonRow(
    buttonRow: @Composable RowScope.() -> Unit,
) {
    Row {
        buttonRow()
    }
}


@PreviewModes
@Composable
fun PreviewDialogBox() {
    DiabloTrackerTheme {
        AlertDialogBox(
            onDismiss = {},
            onNoClicked = {},
            onYesClicked = {},
            title = "This is an alert box",
            text = "This is the main description of an alert box "
        )
    }
}
