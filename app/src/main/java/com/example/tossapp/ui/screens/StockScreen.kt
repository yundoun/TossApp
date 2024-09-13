package com.example.tossapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StockScreen(selectedTabIndex: Int) {
    // 탭에 맞는 콘텐츠 표시
    Column(modifier = Modifier.fillMaxSize()) {
        when (selectedTabIndex) {
            0 -> TabScreen1()
            1 -> TabScreen2()
            2 -> TabScreen3()
        }
    }
}

@Composable
fun TabScreen1() {
    Text(text = "Tab 1")
}

@Composable
fun TabScreen2() {
    Text(text = "Tab 2")
}

@Composable
fun TabScreen3() {
    Text(text = "Tab 3")
}
