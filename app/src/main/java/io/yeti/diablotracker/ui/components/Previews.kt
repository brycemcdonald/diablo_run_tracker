package io.yeti.diablotracker.ui.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light Mode",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true)
@Preview(name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true)
annotation class PreviewModes

@Preview(name = "Pixel", group = "Devices", device = Devices.PIXEL, showSystemUi = true)
annotation class DevicePreviews