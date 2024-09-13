package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyAccount() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "내 계좌",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "13:47 기준 >"
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .weight(1f)
                    .height(80.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.CenterStart,
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                ) {
                    Text(
                        text = "원화",
                    )
                    Text(
                        text = "0원"
                    )
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .weight(1f)
                    .height(80.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.CenterStart,
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                ) {
                    Text(
                        text = "달러",
                    )
                    Text(
                        text = "$ 0"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MyAccountPreview() {
    MyAccount()
}