package com.example.tossapp.data

import androidx.compose.ui.graphics.vector.ImageVector

data class HaveStockData(
    val icon: ImageVector, // 아이콘
    val stockName: String, // 주식 이름
    val balance: String, // 잔고
    val price: String, // 가격
    val profit: String // 수익률
)