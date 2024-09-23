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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Box as Box

@Composable
fun CustomTopAppBarWithTabs(selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    val tabWidths = remember { mutableStateOf(List(3) { 0f }) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // 기존 TopAppBar
        TopAppBar()

        // Box로 ScrollableTabRow를 감싸서 전체 가로 길이 채움
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            // ScrollableTabRow는 왼쪽에 위치하도록 설정
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.TopStart), // 왼쪽에 위치시킴
                edgePadding = 16.dp, // 좌우 여백을 없앰
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .width(Dp(tabWidths.value[selectedTabIndex])), // 탭 너비로 인디케이터 너비 설정
                        color = Color.Black
                    )
                },
                containerColor = Color.White, // 배경색 투명
            ) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { onTabSelected(0) },
                    text = { tabText("토스증권 홈", 0, tabWidths) }, // 텍스트의 너비를 측정하여 조절
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { onTabSelected(1) },
                    text = { tabText("발견", 1, tabWidths) }, // 텍스트의 너비를 측정하여 조절
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray
                )
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = { onTabSelected(2) },
                    text = { tabText("뉴스", 2, tabWidths) }, // 텍스트의 너비를 측정하여 조절
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray
                )
            }

            // 하단에 Divider 추가
            Divider(
                modifier = Modifier
                    .fillMaxWidth() // 전체 너비로 확장
                    .align(Alignment.BottomCenter) // 하단에 위치
                    .height(1.dp), // Divider의 높이
                color = Color.LightGray // Divider 색상
            )
        }
    }
}
// 탭의 텍스트 너비를 측정하는 함수
@Composable
fun tabText(text: String, index: Int, tabWidths: MutableState<List<Float>>) {
    Text(
        text = text,
        modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
            // 탭의 텍스트 너비를 계산하고 저장
            val width = layoutCoordinates.size.width.toFloat()
            tabWidths.value = tabWidths.value.toMutableList().apply {
                this[index] = width
            }
        }
    )
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