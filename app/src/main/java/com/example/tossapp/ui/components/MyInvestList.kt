package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
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
import com.example.tossapp.common.AnimatedStatusSwitch

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

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            stockDataList.forEach { stock ->
                StockItem(stock)
            }
        }

        HorizontalDivider(
            Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}



@Preview
@Composable
fun PreviewMyInvestList() {
    MyInvestList()
}


