package com.example.tossapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tossapp.R

@Composable
fun MyInvest() {

    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.myInvestment),
        )
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(id = R.string.totalInvestment),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = ""
            )
        }
        Text(
            text = stringResource(id = R.string.totalProfit),
            color = Color.Red
        )
    }

}


@Preview
@Composable
fun PreviewMyInvest() {
    MyInvest()
}