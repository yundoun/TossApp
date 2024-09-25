package com.example.tossapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.data.News

@Composable
fun NewsItem(news: News) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = news.stockName,
                    color = if (news.priceChange.startsWith("+")) Color.Red else Color.Blue,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = news.priceChange,
                    color = if (news.priceChange.startsWith("+")) Color.Red else Color.Blue,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = news.newsTitle,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = news.newsSource,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = news.publishedAt,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }

        Image(
            painter = painterResource(id = news.imageResource),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
        )
    }
}

@Preview
@Composable
fun PreviewNewsItem() {
    NewsItem(
        news = News(
            stockName = "삼성전자",
            priceChange = "+1.23%",
            newsTitle = "삼성전자, 3분기 실적 발표",
            newsSource = "머니투데이",
            publishedAt = "2021.10.15",
            imageResource = com.example.tossapp.R.drawable.news
        )
    )
}
