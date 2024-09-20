package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
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


@Composable
fun Section3() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {
        Text(
            text = "관심 종목",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            // Scrollable Tab Row
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 0.dp,
                contentColor = Color.Black,
                containerColor = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                indicator = { tabPositions ->
                    val selectedTab = tabPositions[selectedTabIndex]
                    CustomIndicator(
                        Modifier
                            .tabIndicatorOffset(selectedTab)
                            .width(selectedTab.width)
                            .padding(horizontal = 18.dp), // 텍스트 주변에 약간의 여백을 줍니다
                        color = Color.Black
                    )
                },
                divider = {}
            ) {
                val tabNames = listOf("미국", "대한민국", "ISA", "성장주", "배당주")


                tabNames.forEachIndexed { index, name ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                name,
                                color = if (selectedTabIndex == index) Color.Black else Color.Gray
                            )
                        },
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )

            // 오른쪽 끝에 위치한 편집 버튼
            Text(
                text = "편집",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier
                    .clickable { /* 편집 버튼 동작 */ }
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSection3() {
    Section3()
}