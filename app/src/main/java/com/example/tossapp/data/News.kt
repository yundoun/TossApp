package com.example.tossapp.data

import com.example.tossapp.R

data class News(
    val stockName: String,
    val priceChange: String,
    val newsTitle: String,
    val newsSource: String,
    val publishedAt: String,
    val imageResource: Int
)

object NewsRepository {
    val newsData = listOf(
        News(
            stockName = "삼성전자",
            priceChange = "+0.5%",
            newsTitle = "삼성전자, AI 시장 진출 본격화",
            newsSource = "연합뉴스",
            publishedAt = "1시간 전",
            imageResource = R.drawable.news
        ),
        News(
            stockName = "카카오",
            priceChange = "-1.2%",
            newsTitle = "카카오, 전자상거래 사업 확장",
            newsSource = "한국경제",
            publishedAt = "30분 전",
            imageResource = R.drawable.news
        ),
        News(
            stockName = "테슬라",
            priceChange = "+2.3%",
            newsTitle = "테슬라, 전기차 판매량 급증",
            newsSource = "머니투데이",
            publishedAt = "3시간 전",
            imageResource = R.drawable.news
        ),
        News(
            stockName = "애플",
            priceChange = "+1.8%",
            newsTitle = "애플, 새로운 아이폰 출시 예정",
            newsSource = "매일경제",
            publishedAt = "2시간 전",
            imageResource = R.drawable.news
        ),
        News(
            stockName = "네이버",
            priceChange = "-0.7%",
            newsTitle = "네이버, 클라우드 서비스 확대",
            newsSource = "중앙일보",
            publishedAt = "45분 전",
            imageResource = R.drawable.news
        )
    )
}