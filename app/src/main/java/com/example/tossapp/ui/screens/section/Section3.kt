package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.common.CustomIndicator
import com.example.tossapp.data.StockData
import com.example.tossapp.ui.components.ExpandableItem

@Composable
fun Section3() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var expandedItemIndex by remember { mutableIntStateOf(-1) } // 5열 아이템의 확장 상태

    val tabNames = listOf("미국", "대한민국", "ISA", "성장주", "배당주")

    // 더미 데이터
    val stockData = StockData.stockData

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {
        // 타이틀
        Text(
            text = "관심 종목",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )

        // Scrollable Tab Row
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 0.dp,
            contentColor = Color.Black,
            containerColor = Color.White,
            modifier = Modifier.fillMaxWidth(),
            indicator = { tabPositions ->
                CustomIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .width(tabPositions[selectedTabIndex].width)
                        .padding(horizontal = 18.dp),
                    color = Color.Black
                )
            }
        ) {
            tabNames.forEachIndexed { index, name ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        expandedItemIndex = -1 // 새로운 탭 선택 시 확장된 아이템 초기화
                    },
                    text = {
                        Text(
                            name,
                            color = if (selectedTabIndex == index) Color.Black else Color.Gray,
                        )
                    },
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 5개의 Row로 고정된 아이템 리스트
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            tabNames.forEachIndexed { index, name ->
                ExpandableItem(
                    name = name,
                    item = stockData[index],
                    expanded = expandedItemIndex == index,
                    onClick = {
                        expandedItemIndex = if (expandedItemIndex == index) -1 else index
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Preview
@Composable
fun PreviewSection3() {
    Section3()
}

