package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
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
import com.example.tossapp.common.AnimatedStatusSwitch
import com.example.tossapp.data.StockData

@Composable
fun MyInvestList() {

    var isCurrentPriceSelected by remember { mutableStateOf(false) }
    var isCurrencySelected by remember { mutableStateOf(false) }

    // 더미 데이터 가져오기
    val stockDataList = getDummyStockData()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "가나다 순",
                )
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowUp,
                    contentDescription = "search"
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AnimatedStatusSwitch(
                    isCurrentPriceSelected,
                    onSwitchChange = { isSelected ->
                        isCurrentPriceSelected = isSelected // 사용자가 스위치를 클릭하면 상태 변경
                    },
                    switchWidth = 80.dp,
                    switchHeight = 35.dp,
                    textSize = 10,
                    selectedText = "현재가",
                    unselectedText = "평가금",
                    isFontWeightBold = true
                )

                AnimatedStatusSwitch(
                    isCurrencySelected, // 두 번째 스위치의 상태 사용
                    onSwitchChange = { isSelected ->
                        isCurrencySelected = isSelected // 두 번째 스위치의 상태 관리
                    },
                    switchWidth = 80.dp,
                    switchHeight = 35.dp,
                    textSize = 10,
                    selectedText = "$",
                    unselectedText = "원",
                    isFontWeightBold = true
                )
            }
        }

        // Column으로 아이템을 직접 추가
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            stockDataList.forEach { stock ->
                StockItem(stock)
            }
        }


    }
}


@Composable
fun StockItem(stock: StockData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 아이콘
        Icon(
            imageVector = stock.icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // 주식 이름
        Text(
            text = stock.stockName,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )

        // 잔고
        Text(
            text = stock.balance,
            fontSize = 14.sp,
            modifier = Modifier.padding(end = 8.dp)
        )

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
            color = if (stock.profit.startsWith("+")) Color.Green else Color.Red
        )
    }
}

@Preview
@Composable
fun PreviewMyInvestList() {
    MyInvestList()
}


fun getDummyStockData(): List<StockData> {
    return listOf(
        StockData(Icons.Default.AccountCircle, "마이크로소프트", "1주", "560,000원", "+50,000 (10.0%)"),
        StockData(Icons.Default.AccountCircle, "애플", "2주", "1,120,000원", "+120,000 (12.0%)"),
        StockData(Icons.Default.AccountCircle, "구글", "3주", "1,680,000원", "+180,000 (15.0%)"),
        StockData(Icons.Default.AccountCircle, "아마존", "4주", "2,240,000원", "+240,000 (20.0%)"),
        StockData(Icons.Default.AccountCircle, "테슬라", "5주", "2,800,000원", "+300,000 (25.0%)")
    )
}