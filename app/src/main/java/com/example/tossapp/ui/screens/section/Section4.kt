package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.R
import com.example.tossapp.data.NewsRepository
import com.example.tossapp.ui.components.NewsItem

@Composable
fun Section4() {

    var selectedButton by remember { mutableStateOf("관심 종목") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "윤도운님을 위한 추천 뉴스",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            ToggleButton(
                text = "보유 종목",
                isSelected = selectedButton == "보유 종목",
                onClick = { selectedButton = "보유 종목" }
            )

            Spacer(modifier = Modifier.width(8.dp))

            ToggleButton(
                text = "관심 종목",
                isSelected = selectedButton == "관심 종목",
                onClick = { selectedButton = "관심 종목" }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            NewsRepository.newsData.forEach { news ->
                NewsItem(news = news)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ToggleButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color.DarkGray else Color.White
    val textColor = if (isSelected) Color.White else Color.Gray
    val borderColor = if (isSelected) Color.Transparent else Color.Gray

    Box(
        modifier = Modifier
            .background(backgroundColor, shape = RoundedCornerShape(16.dp))
            .border(1.dp, borderColor, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = text, color = textColor, fontSize = 16.sp)
    }
}

@Preview
@Composable
fun PreviewSection4() {
    Section4()
}
