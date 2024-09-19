package com.example.tossapp.common

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun AnimatedStatusSwitch(
    initialIsSelected: Boolean = true, // 스위치의 기본 상태를 결정하는 매개변수
    onSwitchChange: (Boolean) -> Unit,
    switchWidth: Dp = 100.dp,
    switchHeight: Dp = 40.dp,
    selectedText: String = "현재가",
    unselectedText: String = "평가금",
    backgroundColor: Color = Color.LightGray,
    thumbColor: Color = Color.White,
    selectedTextColor: Color = Color.Black,
    unselectedTextColor: Color = Color.Gray,
    textSize: Int = 12,
    isFontWeightBold: Boolean = true,
    cornerRadius: Dp = 12.dp
) {
    // 스위치 상태 관리
    var isCurrentPriceSelected by remember { mutableStateOf(initialIsSelected) }
    val thumbWidth = switchWidth / 2

    // 애니메이션을 위한 오프셋 값을 Dp로 관리
    val offsetX by animateDpAsState(
        targetValue = if (isCurrentPriceSelected) 0.dp else thumbWidth,
        label = ""
    )

    // 스위치 컴포저블
    Box(
        modifier = Modifier
            .wrapContentSize()
            .height(switchHeight + 10.dp)
            .padding(8.dp)
    ) {
        // 배경 그레이 박스
        Box(
            modifier = Modifier
                .width(switchWidth)
                .height(switchHeight)
                .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))
        )

        // 선택된 항목을 나타내는 흰색 박스
        Box(
            modifier = Modifier
                .width(thumbWidth)
                .height(switchHeight)
                .offset(x = offsetX)
                .padding(4.dp)
                .background(thumbColor, shape = RoundedCornerShape(cornerRadius - 4.dp))
        )

        // 선택된 텍스트와 비선택된 텍스트
        Row(
            modifier = Modifier
                .width(switchWidth)
                .clickable {
                    isCurrentPriceSelected = !isCurrentPriceSelected
                    onSwitchChange(isCurrentPriceSelected)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 선택된 텍스트
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = selectedText,
                    color = if (isCurrentPriceSelected) selectedTextColor else unselectedTextColor,
                    fontSize = textSize.sp,
                    fontWeight = if (isFontWeightBold) FontWeight.Bold else FontWeight.Normal
                )
            }

            // 비선택된 텍스트
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = unselectedText,
                    color = if (isCurrentPriceSelected) unselectedTextColor else selectedTextColor,
                    fontSize = textSize.sp,
                    fontWeight = if (isFontWeightBold) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAnimatedStatusSwitch() {
    // 애니메이션 적용된 스위치 호출
    AnimatedStatusSwitch(
        initialIsSelected = false, // 기본 상태를 오른쪽으로 설정
        onSwitchChange = { isSelected ->
            // 스위치 상태 변경을 처리하는 로직
        },
        switchWidth = 150.dp,
        switchHeight = 50.dp,
        selectedText = "On",
        unselectedText = "Off",
        backgroundColor = Color.Gray,
        thumbColor = Color.Green,
        selectedTextColor = Color.White,
        unselectedTextColor = Color.LightGray,
        textSize = 16,
        cornerRadius = 16.dp
    )
}
