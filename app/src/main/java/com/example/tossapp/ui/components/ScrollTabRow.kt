package com.example.tossapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tossapp.R
import com.example.tossapp.common.CustomIndicator

@Composable
fun ScrollTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit, // selectedTabIndex 변경을 위한 람다 함수 추가
    expandedItemIndex: Int,
    onItemExpanded: (Int) -> Unit
) {


    val tabNames = listOf(
        stringResource(id = R.string.tab_us),
        stringResource(id = R.string.tab_korea),
        stringResource(id = R.string.tab_isa),
        stringResource(id = R.string.tab_growth),
        stringResource(id = R.string.tab_dividend)
    )

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
                    onTabSelected(index)
                    onItemExpanded(-1) // 새로운 탭 선택 시 확장된 아이템 초기화
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
}