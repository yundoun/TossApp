package com.example.tossapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tossapp.common.CommonSpacer
import com.example.tossapp.ui.screens.section.Section1
import com.example.tossapp.ui.screens.section.Section2
import com.example.tossapp.ui.screens.section.Section3
import com.example.tossapp.ui.screens.section.Section4
import com.example.tossapp.ui.screens.section.Section5
import com.example.tossapp.ui.screens.section.Section6
import com.example.tossapp.ui.screens.section.Section7
import com.example.tossapp.ui.screens.section.Section8

@Composable
fun TossStockHome() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Section1()

            CommonSpacer()

        Section2()

            CommonSpacer()

        Section3()

            CommonSpacer()

        Section4()

            CommonSpacer()

        Section5()

            CommonSpacer()

        Section6()

        Section7()

        Section8()
    }
}


@Preview
@Composable
fun PreviewTabScreen1() {
    TossStockHome()
}