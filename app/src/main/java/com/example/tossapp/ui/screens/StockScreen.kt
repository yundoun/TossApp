package com.example.tossapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StockScreen(){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "Stock Screen")
    }
}

@Preview
@Composable
fun StockScreenPreview(){
    StockScreen()
}