package io.yeti.diablotracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment


@Composable
fun BasicDropDown (
    listForDropDown : List<Any>
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        contentAlignment = Alignment.Center
    ) {

        Text(text = "Play Count")
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Open Options"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            listForDropDown.forEachIndexed { itemIndex, itemValue ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                    },
                    enabled = (itemIndex != 1)
                ) {
                    GenericText(
                        typography = MaterialTheme.typography.h3,
                        staticText = null,
                        mutableText = itemValue.toString()
                    )
                }
            }
        }
    }

}