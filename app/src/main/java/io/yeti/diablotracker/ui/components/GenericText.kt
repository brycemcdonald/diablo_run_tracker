package io.yeti.diablotracker.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.ui.theme.STANDARD_TEXT_SIZE
import io.yeti.diablotracker.ui.theme.WEIGHT_400


@Composable
fun GenericText(
    textSize: TextUnit = STANDARD_TEXT_SIZE,
    @StringRes staticText : Int?,
    mutableText : String,
    modifier : Modifier = Modifier,
    typography: TextStyle = MaterialTheme.typography.body1

) {
        Text(
            modifier = modifier,
            text =  if(staticText != null)  stringResource(id = staticText) else mutableText,
            fontSize = textSize,
            fontWeight = FontWeight(WEIGHT_400),
            overflow = TextOverflow.Ellipsis,
            style = typography,
            maxLines = 1,
            color = MaterialTheme.colors.onSurface,
        )
}

@PreviewModes
@Composable
fun PreviewGenericText () {
    DiabloTrackerTheme {
        GenericText(staticText = null, mutableText = "Test Text")
    }
}