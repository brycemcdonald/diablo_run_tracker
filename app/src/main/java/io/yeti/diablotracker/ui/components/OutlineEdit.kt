package io.yeti.diablotracker.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import io.yeti.diablotracker.R
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.ui.theme.STANDARD_TEXT_SIZE

@Composable
fun OutLineEdit(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    text: String = "",
    enabled: Boolean = true,
    onValueChanged: (String) -> Unit,
    isError: Boolean = false,
    leaderIcon: Int? //Make drawable for the icon when complete.
    

) {

    var inputValue by remember { mutableStateOf(text) }


    Column {
        OutlinedTextField(
            modifier = modifier,
            singleLine = true,
            value = inputValue,
            onValueChange = {
                onValueChanged(it)
                inputValue = it
                            },
            label = { Text(
                fontSize = STANDARD_TEXT_SIZE,
                text = stringResource(id = label)
            ) },

            enabled = enabled,
            textStyle = TextStyle(
                color = MaterialTheme.colors.onSurface,
                fontSize = STANDARD_TEXT_SIZE,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal
            ),
            isError = isError,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

            )
    }
    /*
         leadingIcon = {
                if (leaderIcon != null) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "",
                        tint = colorResource(R.color.teal_200),
                        modifier = Modifier.clickable {}
                    )
                }
            },
     */


}

@Composable
fun TestOutline () {

    OutlinedTextField(
        value = "",
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { },
        label = { Text(stringResource(R.string.create_run)) },
        isError = false,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { }
        ),
    )
}

@PreviewModes
@Composable
fun PreviewTestOutLines () {
    DiabloTrackerTheme {
        TestOutline()
    }
}

@PreviewModes
@Composable
fun OutLineEditPreview() {
    DiabloTrackerTheme {
        OutLineEdit(
            label = R.string.create_run,
            text = "Text",
            leaderIcon = null,
            onValueChanged = {}
        )
    }
}