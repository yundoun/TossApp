package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tossapp.R
import com.example.tossapp.data.CardData
import com.example.tossapp.ui.components.LookAroundBox

@Composable
fun Section6() {

    val dataList = CardData.dataList

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.takeATour),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(dataList) { data ->
                LookAroundBox(
                    topText = data.first,
                    bottomText = data.second,
                    icon = {
                        Icon(
                            imageVector = data.third,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun Section6Preview() {
    Section6()
}