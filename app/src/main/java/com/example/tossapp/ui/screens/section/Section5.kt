package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.R
import com.example.tossapp.data.StockData.themeData
import com.example.tossapp.ui.components.RecommendStockItem
import kotlinx.coroutines.delay

@Composable
fun Section5() {

    // 테마와 더미 주식 데이터를 관리하는 상태
    val themes = listOf(
        stringResource(id = R.string.theme_nuclear),
        stringResource(id = R.string.theme_uam),
        stringResource(id = R.string.theme_entertain)
    )
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
            text = stringResource(id = R.string.mightBeInterestedStock),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = stringResource(id = R.string.analysisRecent),
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

// 테마에 맞는 인덱스를 반환하는 함수
@Composable
fun getThemeIndex(theme: String): Int? {
    return when (theme) {
        stringResource(id = R.string.theme_nuclear) -> 0
        stringResource(id = R.string.theme_uam) -> 1
        stringResource(id = R.string.theme_entertain) -> 2
        else -> null
    }
}

// 주식 데이터를 테마에 맞게 반환하는 함수
@Composable
fun getStockDataForTheme(theme: String): List<Triple<String, String, String>> {
    val index = getThemeIndex(theme)
    return if (index != null) {
        themeData[index]
    } else {
        listOf()
    }
}

@Preview
@Composable
fun PreviewSection5() {
    Section5()
}