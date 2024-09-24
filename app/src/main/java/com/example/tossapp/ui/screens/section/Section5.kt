package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.ui.components.RecommendStockItem
import kotlinx.coroutines.delay

@Composable
fun Section5() {

    // 테마와 더미 주식 데이터를 관리하는 상태
    val themes = listOf("원전", "UAM", "엔터")
    val themeState = remember { mutableStateOf(themes[1]) }


    // 5초마다 테마 변경
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            val nextIndex = (themes.indexOf(themeState.value) + 1) % themes.size
            themeState.value = themes[nextIndex] // 테마 순환 변경
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "윤도운님이 관심 있어 할\n${themeState.value} 관련 주식",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = "최근 찾아 본 주식을 분석했어요",
            fontSize = 10.sp,
            color = Color.Gray
        )

        // 현재 테마에 해당하는 주식 리스트 가져오기
        val stockData = getStockDataForTheme(themeState.value)

        // 각 주식을 RecommendStockItem으로 표시
        stockData.forEach { stock ->
            RecommendStockItem(stock)
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}

// 주식 데이터를 테마에 맞게 반환하는 함수
fun getStockDataForTheme(theme: String): List<Triple<String, String, String>> {
    return when (theme) {
        "원전" -> listOf(
            Triple("두산에너빌리티", "+1.5%", "18,240원"),
            Triple("한전기술", "+0.1%", "68,500원"),
            Triple("보성파워텍", "-5.0%", "3,390원")
        )

        "UAM" -> listOf(
            Triple("조비 에비에이션", "0.0%", "6,862원"),
            Triple("릴리움", "0.0%", "971원"),
            Triple("아처 에비에이션", "0.0%", "4,069원")
        )

        "엔터" -> listOf(
            Triple("JYP Ent.", "+1.2%", "45,200원"),
            Triple("하이브", "-1.3%", "157,800원"),
            Triple("에스엠", "+2.0%", "59,200원")
        )

        else -> listOf()
    }
}

@Preview
@Composable
fun PreviewSection5() {
    Section5()
}