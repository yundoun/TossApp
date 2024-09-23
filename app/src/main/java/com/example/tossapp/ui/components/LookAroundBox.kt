package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LookAroundBox(
    topText: String,
    bottomText: String,
    icon: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Text(
                text = topText,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = bottomText,
                fontSize = 16.sp,
            )

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            icon() // 전달된 아이콘을 호출
        }
    }
}

@Preview
@Composable
fun LookAroundBoxPreview() {
    LookAroundBox(
        "실시간",
        "거래량 많은\n주식보기",
        icon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    )
}