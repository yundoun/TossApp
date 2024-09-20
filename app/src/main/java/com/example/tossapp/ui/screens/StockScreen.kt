package com.example.tossapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StockScreen(selectedTabIndex: Int) {
    // 탭에 맞는 콘텐츠 표시
    Column(modifier = Modifier.fillMaxSize()) {
        when (selectedTabIndex) {
            0 -> TossStockHome()
            1 -> TabFind()
            2 -> TabNews()
        }
    }
}

@Preview
@Composable
fun PreviewStockScreen() {
    StockScreen(selectedTabIndex = 0)
}