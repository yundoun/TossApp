package com.example.tossapp.common


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Box(
        modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(color)
    )
}
