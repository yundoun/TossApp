package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.R
import com.example.tossapp.data.NewsRepository
import com.example.tossapp.ui.components.NewsItem

@Composable
fun Section4() {

    val holdingItems = stringResource(id = R.string.holdingItems)
    val interestedItems = stringResource(id = R.string.interestedItems)
    var selectedButton by remember { mutableStateOf(interestedItems) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.recommendNews),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            ToggleButton(
                text = holdingItems,
                isSelected = selectedButton == holdingItems,
                onClick = { selectedButton = holdingItems },
            )

            Spacer(modifier = Modifier.width(8.dp))

            ToggleButton(
                text = interestedItems,
                isSelected = selectedButton == interestedItems,
                onClick = { selectedButton = interestedItems }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            NewsRepository.newsData.forEach { news ->
                NewsItem(news = news)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        HorizontalDivider(
            thickness = 1.dp,   // 구분선 두께 지정
            color = Color.LightGray // 구분선 색상 지정
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(50.dp)
                .clickable {

                }
        ) {
            Text(
                text = stringResource(id = R.string.seeMore),
                color = Color.Gray,
                fontSize = 16.sp,
            )
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
