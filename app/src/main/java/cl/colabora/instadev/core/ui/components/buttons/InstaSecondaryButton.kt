package cl.colabora.instadev.core.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun InstaSecondaryButton(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
    border: BorderStroke = BorderStroke(
        0.5.dp,
        MaterialTheme.colorScheme.primary
    ),
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.onBackground,

        )
) {

    OutlinedButton(
        modifier = modifier,
        shape = shape,
        onClick = onClick,
        enabled = enabled,
        border = border,
        colors = colors,
    ) { Text(text = text) }
}