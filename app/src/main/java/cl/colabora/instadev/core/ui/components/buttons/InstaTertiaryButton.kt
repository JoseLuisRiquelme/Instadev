package cl.colabora.instadev.core.ui.components.buttons

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun InstaTertiaryButton(
    modifier: Modifier = Modifier,
    onclick: () -> Unit,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
) {
    TextButton(modifier = modifier, onClick = onclick, enabled = enabled, shape = shape, colors = colors
        ) { }
}