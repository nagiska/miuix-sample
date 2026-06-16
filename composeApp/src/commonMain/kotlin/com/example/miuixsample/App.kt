package com.example.miuixsample

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.miuixsample.screens.AboutScreen
import com.example.miuixsample.screens.DisplayScreen
import com.example.miuixsample.screens.MainScreen
import com.example.miuixsample.theme.MiuixSampleTheme

@Composable
fun App() {
    MiuixSampleTheme {
        var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }

        AnimatedContent(targetState = currentScreen) { screen ->
            when (screen) {
                Screen.Main -> MainScreen(
                    onNavigateToDisplay = { currentScreen = Screen.Display },
                    onNavigateToAbout = { currentScreen = Screen.About }
                )
                Screen.Display -> DisplayScreen(
                    onBack = { currentScreen = Screen.Main }
                )
                Screen.About -> AboutScreen(
                    onBack = { currentScreen = Screen.Main }
                )
            }
        }
    }
}

sealed class Screen {
    data object Main : Screen()
    data object Display : Screen()
    data object About : Screen()
}
