package com.example.tossapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tossapp.common.CustomIndicator

@Composable
fun CustomScrollableTabRow(
    selectedTabIndex: Int,
    tabNames: List<String>,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 0.dp,
        contentColor = Color.Black,
        containerColor = Color.White,
        modifier = modifier,
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
                onClick = { onTabSelected(index) },
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

