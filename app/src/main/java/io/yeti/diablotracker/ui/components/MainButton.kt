package io.yeti.diablotracker.ui.components


import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.testTag
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import io.yeti.diablotracker.ui.theme.STANDARD_PADDING
import io.yeti.diablotracker.ui.theme.STANDARD_TEXT_SIZE




@Composable
fun RowScope.MainButton (
    showIcon : Boolean = false,
    buttonPressed : () -> Unit,
    modifier : Modifier = Modifier,
    buttonText : String //Can make Int.

) {
        Row(

            Modifier
                .weight(1f)
                .align(Alignment.Bottom).then(modifier)) {
            Button(
                modifier = Modifier
                    .testTag("MainPressed")
                    .fillMaxWidth()
                    .padding(STANDARD_PADDING),
                onClick = {
                    buttonPressed()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.DarkGray)
            ) {
                if(showIcon) {
                    Icon(
                        Icons.Filled.Build,
                        contentDescription = "Favorite",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                }
                Text(
                    text = buttonText,
                    color = White,
                    fontSize = STANDARD_TEXT_SIZE)

            }
        }
}



@PreviewModes
@DevicePreviews
@Composable
fun MainButtonPreview () {
    DiabloTrackerTheme {
        Row {
            MainButton(buttonPressed = {  }, buttonText = "Test button", showIcon = true)
        }
    }
}