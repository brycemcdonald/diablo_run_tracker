package io.yeti.diablotracker.ui.select_run.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.yeti.diablotracker.domain.models.Run
import io.yeti.diablotracker.ui.components.GenericText
import io.yeti.diablotracker.ui.components.PreviewModes
import io.yeti.diablotracker.ui.theme.DiabloTrackerTheme
import java.time.LocalDateTime

@Composable
fun RunItem(
    run: Run,
    modifier: Modifier = Modifier,
    onStartRun: () -> Unit
) {

    Box(modifier.fillMaxWidth().padding(16.dp).clickable(
        interactionSource = remember { MutableInteractionSource() },
        onClick = { onStartRun() },
        indication = rememberRipple(bounded = true)
    )) {
        Row(
            horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
//                        .clickable(
//                            interactionSource = remember { MutableInteractionSource() },
//                            onClick = { onStartRun() },
//                            indication = rememberRipple(bounded = true)
//                        )
        ) {
            GenericText(
                staticText = null,
                mutableText = "p"+run.playerNumber.toString(),
                typography = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(8.dp))
            GenericText(
                staticText = null,
                mutableText = run.runeName,
                typography = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(16.dp))
            GenericText(
                //textSize = 11.sp,
                staticText = null,
                mutableText = "Runs Complete: " + run.runAmounts.toString(),
                typography = MaterialTheme.typography.body2
            )
        }
        IconButton(
            onClick = onStartRun,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "start run", //TODO : Move to strings.
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
@PreviewModes
fun PreviewRunItem() {

    val run by remember { mutableStateOf(Run(
        //id = 1,
        runeName = "Secret Cow",
        runAmounts = 98,
        playerNumber = 1,
        runesFound = arrayListOf(),
        uniquesFound = 10,
        setFounds = 7,
        isFavourite = true,
        isActive = true,
        createdAt = LocalDateTime.now()
    )) }

    DiabloTrackerTheme {
        RunItem(
            onStartRun = {},
            run = run
        )
    }
}