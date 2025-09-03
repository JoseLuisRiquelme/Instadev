package cl.colabora.instadev.core.ui.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun InstaTitleText(modifier: Modifier = Modifier,text: String= "Cual es tu numero de telefono?") {
    Text(
        modifier = modifier,
        text =text,
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium
    )
}