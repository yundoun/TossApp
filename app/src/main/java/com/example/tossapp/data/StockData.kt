package com.example.tossapp.data

object StockData {
    val stockData = listOf(
        listOf( // 미국
            Triple("이튼", "-0.4%", "436,191원"),
            Triple("애플", "+1.2%", "172,920원"),
            Triple("테슬라", "+0.8%", "896,500원")
        ),
        listOf( // 대한민국
            Triple("삼성전자", "-0.3%", "67,800원"),
            Triple("카카오", "+0.9%", "54,000원"),
            Triple("네이버", "+1.1%", "230,500원")
        ),
        listOf( // ISA
            Triple("삼성증권", "+0.7%", "50,200원"),
            Triple("한국투자증권", "+0.5%", "92,000원"),
            Triple("NH투자증권", "-0.6%", "12,400원")
        ),
        listOf( // 성장주
            Triple("엔씨소프트", "+1.8%", "391,000원"),
            Triple("넷마블", "-0.2%", "83,500원"),
            Triple("하이브", "+2.0%", "250,000원")
        ),
        listOf( // 배당주
            Triple("SK텔레콤", "+1.0%", "51,000원"),
            Triple("KT&G", "+0.3%", "80,000원"),
            Triple("한국전력", "-1.5%", "20,300원")
        )
    )
}