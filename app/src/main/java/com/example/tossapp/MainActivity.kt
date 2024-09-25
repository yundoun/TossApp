package com.example.tossapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tossapp.ui.components.BottomNavigationBar
import com.example.tossapp.ui.components.CustomTopAppBarWithTabs
import com.example.tossapp.ui.components.items
import com.example.tossapp.ui.screens.StockScreen
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
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // 현재 선택된 라우트 가져오기
    val currentRoute = navBackStackEntry?.destination?.route
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
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
        NavHost(
            navController = navController,
            startDestination = items[3].route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                SimpleTextScreen(stringResource(id = R.string.screen_1))
            }
            composable("benefits") {
                SimpleTextScreen(stringResource(id = R.string.screen_2))
            }
            composable("tossPay") {
                SimpleTextScreen(stringResource(id = R.string.screen_3))
            }
            composable("stock") {
                StockScreen(selectedTabIndex)
            }
            composable("allMenu") {
                SimpleTextScreen(stringResource(id = R.string.screen_5))
            }
        }
    }
}

@Composable
fun SimpleTextScreen(text: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
