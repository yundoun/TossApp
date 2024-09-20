package com.example.tossapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.data.HaveStockData


@Composable
fun StockItem(stock: HaveStockData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        ) {
        // 아이콘
        Icon(
            imageVector = stock.icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // 주식 이름
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stock.stockName,
                    fontSize = 16.sp,

                    )

                // 잔고
                Text(
                    text = stock.balance,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                // 가격
                Text(
                    text = stock.price,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )

                // 수익률
                Text(
                    text = stock.profit,
                    fontSize = 14.sp,
                    color = if (stock.profit.startsWith("+")) Color.Red else Color.Blue
                )
            }
        }
    }
}

fun getDummyStockData(): List<HaveStockData> {
    return listOf(
        HaveStockData(Icons.Default.AccountCircle, "마이크로소프트", "1주", "560,000원", "+50,000 (10.0%)"),
        HaveStockData(Icons.Default.AccountCircle, "애플", "2주", "1,120,000원", "+120,000 (12.0%)"),
        HaveStockData(Icons.Default.AccountCircle, "구글", "3주", "1,680,000원", "-180,000 (15.0%)"),
        HaveStockData(Icons.Default.AccountCircle, "아마존", "4주", "2,240,000원", "+240,000 (20.0%)"),
        HaveStockData(Icons.Default.AccountCircle, "테슬라", "5주", "2,800,000원", "+300,000 (25.0%)")
    )
}

@Preview
@Composable
fun PreviewStockItem() {
    StockItem(getDummyStockData()[0])
}