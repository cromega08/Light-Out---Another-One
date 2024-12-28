package cromega.studio.light.out.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LightText(
    text: String,
    lightOn: Boolean = true
) =
    Text(
        text = text,
        color =
            if (lightOn) Color.White
            else Color.Black
    )
