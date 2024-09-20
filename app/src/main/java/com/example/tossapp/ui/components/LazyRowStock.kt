package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyRowStock() {

    var items by remember { mutableStateOf(listOf("Item 1", "Item 2", "Item 3", "Item 4")) }

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
