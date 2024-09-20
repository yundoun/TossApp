package com.example.tossapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.common.MenuTitle
import com.example.tossapp.ui.components.MyAccount
import com.example.tossapp.ui.components.MyInvest
import com.example.tossapp.ui.components.MyInvestList

@Composable
fun TossStockHome() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(16.dp)
        ) {
            MyAccount()
            Spacer(modifier = Modifier.padding(16.dp))
            MyInvest()
            MyInvestList()
            Spacer(modifier = Modifier.padding(8.dp))
            MenuTitle("주문내역")
            MenuTitle("판매수익")
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(Color.LightGray)
        )

        var items by remember { mutableStateOf(listOf("Item 1", "Item 2", "Item 3", "Item 4")) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "최근 본 주식",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                items(items.size) { index ->
                    val item = items[index]
                    RowItem(
                        text = item,
                        onDelete = {
                            // 아이템 삭제 로직
                            items = items.filter { it != item }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // 각 아이템 간의 간격
                }
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(Color.LightGray)
        )
    }
}

@Composable
fun RowItem(text: String, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black,
        )
        Text(
            text = "X",
            fontSize = 16.sp,
            color = Color.Red,
            modifier = Modifier
                .clickable { onDelete() }
                .padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewTabScreen1() {
    TossStockHome()
}