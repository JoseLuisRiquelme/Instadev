package cl.colabora.instadev.core.ui.components.texts

import androidx.annotation.Size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit

@Composable
fun InstaSecondaryText(modifier: Modifier= Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
) {
    Text(modifier = modifier, text = text, color = color, style = MaterialTheme.typography.bodyMedium)

}