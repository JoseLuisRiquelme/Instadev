package cl.colabora.instadev.core.ui.components.textfield

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InstaSecondaryTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        shape = MaterialTheme.shapes.medium,
        textStyle = MaterialTheme.typography.titleSmall,
        label = { Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant) }
    )
}