package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecommendStockItem(stock: Triple<String, String, String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Column {
                Text(text = stock.first) // 회사 이름
                Text(text = stock.third) // 가격
            }
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(
                    when {
                        stock.second == "0.0%" -> Color.Gray
                        stock.second.startsWith("+") -> Color.Red
                        else -> Color.Blue
                    }
                )
                .padding(4.dp) // 텍스트 주변 여백 추가
        ) {
            Text(
                text = stock.second, // 변동률
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun PreviewRecommendStockItem() {
    RecommendStockItem(
        Triple("삼성전자", "+0.3%", "67,800원")
    )
}