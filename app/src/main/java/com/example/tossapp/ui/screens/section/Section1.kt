package com.example.tossapp.ui.screens.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tossapp.R
import com.example.tossapp.common.MenuTitle
import com.example.tossapp.ui.components.MyAccount
import com.example.tossapp.ui.components.MyInvest
import com.example.tossapp.ui.components.MyInvestList

@Composable
fun Section1() {
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
        MenuTitle(stringResource(id = R.string.orderDetails))
        MenuTitle(stringResource(id = R.string.salesRevenue))
    }
}

@Preview
@Composable
fun PreviewSection1() {
    Section1()
}