package com.miggue.mylogin01.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryColor,
    secondary = SecondaryColor

)

@Composable
fun MyLogin01Theme(content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}