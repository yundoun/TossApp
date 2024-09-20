package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.common.CustomIndicator
import com.example.tossapp.ui.components.InterestStockList

@Composable
fun Section3() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var expandedItemIndex by remember { mutableIntStateOf(-1) } // 5열 아이템의 확장 상태

    val tabNames = listOf("미국", "대한민국", "ISA", "성장주", "배당주")

    // 더미 데이터
    val stockData = listOf(
        listOf( // 미국
            Triple("이튼", "-0.4%", "436,191원"),
            Triple("애플", "+1.2%", "172,920원"),
            Triple("테슬라", "+0.8%", "896,500원")
        ),
        listOf( // 대한민국
            Triple("삼성전자", "-0.3%", "67,800원"),
            Triple("카카오", "+0.9%", "54,000원"),
            Triple("네이버", "+1.1%", "230,500원")
        ),
        listOf( // ISA
            Triple("삼성증권", "+0.7%", "50,200원"),
            Triple("한국투자증권", "+0.5%", "92,000원"),
            Triple("NH투자증권", "-0.6%", "12,400원")
        ),
        listOf( // 성장주
            Triple("엔씨소프트", "+1.8%", "391,000원"),
            Triple("넷마블", "-0.2%", "83,500원"),
            Triple("하이브", "+2.0%", "250,000원")
        ),
        listOf( // 배당주
            Triple("SK텔레콤", "+1.0%", "51,000원"),
            Triple("KT&G", "+0.3%", "80,000원"),
            Triple("한국전력", "-1.5%", "20,300원")
        )
    )

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

@Composable
fun ExpandableItem(
    name: String,
    item: List<Triple<String, String, String>>,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        // 아이템 제목과 드롭다운 아이콘
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = name, fontSize = 16.sp, color = Color.Black)
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }

        // 확장된 상태에서 보이는 세부 정보
        if (expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            ) {
                item.forEach { stock ->
                    InterestStockList(stock.first, stock.second, stock.third)
                }
            }
        }
    }
}



@Preview
@Composable
fun PreviewSection3() {
    Section3()
}

