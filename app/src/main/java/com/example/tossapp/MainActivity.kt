package com.example.tossapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tossapp.ui.components.BottomNavigationBar
import com.example.tossapp.ui.components.TopAppBar
import com.example.tossapp.ui.components.items
import com.example.tossapp.ui.screens.AllMenuScreen
import com.example.tossapp.ui.screens.BenefitsScreen
import com.example.tossapp.ui.screens.HomeScreen
import com.example.tossapp.ui.screens.StockScreen
import com.example.tossapp.ui.screens.TossPayScreen
import com.example.tossapp.ui.theme.TossAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TossAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val navController = rememberNavController()

    // 현재의 백스택 항목을 추적하여 현재 화면의 라우트를 확인
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Scaffold(
        topBar = {
            // TopAppBar에 Tabs 포함
            if (currentRoute == "stock") {
                CustomTopAppBarWithTabs(
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = { index -> selectedTabIndex = index }
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        // 탭에 맞는 화면을 표시 (탭 내 콘텐츠)
        Column(Modifier.padding(paddingValues)) {
            when (selectedTabIndex) {
                0 -> TabScreen1()
                1 -> TabScreen2()
                2 -> TabScreen3()
            }
        }

        // 네비게이션 콘텐츠 (탭 바깥의 일반 네비게이션 콘텐츠)
        NavHost(
            navController = navController,
            startDestination = items[3].route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                HomeScreen()
            }
            composable("benefits") {
                BenefitsScreen()
            }
            composable("tossPay") {
                TossPayScreen()
            }
            composable("stock") {
                null
            }
            composable("allMenu") {
                AllMenuScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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

@Composable
fun TabScreen1() {
    // Tab 1 화면
    Text(text = "Tab 1")
}

@Composable
fun TabScreen2() {
    // Tab 2 화면
    Text(text = "Tab 2")
}

@Composable
fun TabScreen3() {
    // Tab 3 화면
    Text(text = "Tab 3")
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
