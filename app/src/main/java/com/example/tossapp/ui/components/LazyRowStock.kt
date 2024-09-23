package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.ui.theme.baseColor
import com.example.tossapp.ui.theme.textColor2

@Composable
fun LazyRowStock() {

    var items by remember {
        mutableStateOf(
            listOf(
                "테슬라 +1.0%",
                "애플 -0.1%",
                "아마존 +2.17%",
                "마이크로소프트 +0.2%",
                "구글 -1.2%"
            )
        )
    }

    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(items.size) { index ->
            val item = items[index]
            RowItem(
                text = item,
                onDelete = {
                    // 아이템 삭제 로직
                    items = items.filter { it != item }
                }
            )
            Spacer(modifier = Modifier.width(8.dp)) // 각 아이템 간의 간격
        }
    }
}

@Composable
fun RowItem(text: String, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .background(baseColor, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val parts = text.split(" ")
        val stockName = parts[0]
        val stockChange = parts[1]

        val changeColor = when {
            stockChange.startsWith("+") -> Color.Red  // 상승일 때 빨간색
            stockChange.startsWith("-") -> Color.Blue // 하락일 때 파란색
            else -> Color.Black
        }

        Text(
            text = stockName,
            fontSize = 16.sp,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = stockChange,
            fontSize = 14.sp,
            color = changeColor, // 변화율에 따른 색상 적용
        )

        Text(
            text = "X",
            fontSize = 16.sp,
            color = textColor2,
            modifier = Modifier
                .clickable { onDelete() }
                .padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun LazyRowStockPreview() {
    LazyRowStock()
}
