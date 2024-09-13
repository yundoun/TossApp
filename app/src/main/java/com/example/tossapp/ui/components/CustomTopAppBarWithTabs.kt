package com.example.tossapp.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CustomTopAppBarWithTabs(selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    Column {
        // 기존 TopAppBar
        TopAppBar()

        // TabRow를 추가하여 TopAppBar 아래에 탭을 왼쪽 정렬로 표시
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { onTabSelected(0) },
                text = { Text("토스증권 홈") }
            )
            Tab(
                selected = selectedTabIndex == 1,
                onClick = { onTabSelected(1) },
                text = { Text("발견") }
            )
            Tab(
                selected = selectedTabIndex == 2,
                onClick = { onTabSelected(2) },
                text = { Text("뉴스") }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun TopAppBar() {

    val titles = listOf("코스피 2,573.61 +0.05%", "코스닥 727.95 -0.4%")

    var currentTitleIndex by remember { mutableIntStateOf(0) }
    var isTitleVisible by remember { mutableStateOf(true) }

    // 일정 시간마다 타이틀 변경
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // 3초마다 타이틀 변경
            isTitleVisible = false
            delay(300) // 타이틀 전환 시 애니메이션을 위한 짧은 대기
            currentTitleIndex = (currentTitleIndex + 1) % titles.size
            isTitleVisible = true
        }
    }

    // 각 인덱스에 따른 색상 설정
    val numberColor = if (currentTitleIndex == 0) Color.Red else Color.Blue
    val percentageColor = if (currentTitleIndex == 0) Color.Red else Color.Blue

    androidx.compose.material3.TopAppBar(
        title = {
            AnimatedContent(
                targetState = titles[currentTitleIndex],
                transitionSpec = {
                    (slideInVertically { fullHeight -> fullHeight } + fadeIn(
                        animationSpec = tween(
                            200
                        )
                    )) togetherWith
                            (slideOutVertically { fullHeight -> -fullHeight } + fadeOut(
                                animationSpec = tween(200)
                            ))
                }, label = ""
            ) { targetTitle ->

                // 부분적으로 스타일을 적용한 AnnotatedString 생성
                val annotatedTitle = buildAnnotatedString {
                    val parts = targetTitle.split(" ")
                    append(parts[0]) // "코스피" or "코스닥"
                    append(" ")

                    // 숫자 부분에 Red 또는 Blue 적용
                    withStyle(
                        style = SpanStyle(
                            color = numberColor,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(parts[1]) // "2,573.61" or "727.95"
                    }
                    append(" ")

                    // 퍼센트 부분에 작은 글자 크기 적용, Red 또는 Blue
                    withStyle(style = SpanStyle(color = percentageColor, fontSize = 10.sp)) {
                        append(parts[2]) // "+0.05%" or "-0.4%"
                    }
                }

                Text(
                    text = annotatedTitle,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 15.sp
                )
            }
        },
        actions = {
            IconButton(onClick = {
                // 검색 아이콘 클릭 시 수행할 작업
            }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(onClick = {
                // 더보기 아이콘 클릭 시 수행할 작업
            }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "More"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White, // 배경색
            titleContentColor = Color.Black, // 타이틀 텍스트 색상
            actionIconContentColor = Color.Black, // 액션 아이콘 색상
            navigationIconContentColor = Color.Black // 내비게이션 아이콘 색상
        )
    )
}


@Preview
@Composable
fun PreviewCustomTopAppBarWithTabs() {
    // 임의의 selectedTabIndex와 onTabSelected 콜백 정의
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    CustomTopAppBarWithTabs(
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { index -> selectedTabIndex = index }
    )
}