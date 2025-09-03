package cl.colabora.instadev.core.ui.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun InstaPrimaryText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        fontSize = 18.sp,
        style = MaterialTheme.typography.bodyLarge
    )
}