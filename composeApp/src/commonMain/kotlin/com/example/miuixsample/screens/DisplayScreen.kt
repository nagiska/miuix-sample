package com.example.miuixsample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.HorizontalDivider
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.preference.RadioButtonPreference
import top.yukonga.miuix.kmp.preference.SliderPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun DisplayScreen(onBack: () -> Unit) {
    var darkMode by remember { mutableStateOf(false) }
    var fontSize by remember { mutableStateOf(0.5f) }
    var selectedFontIndex by remember { mutableStateOf(0) }
    var selectedTheme by remember { mutableStateOf(0) }
    val fontOptions = listOf("MiSans", "Roboto", "思源黑体")
    val themeOptions = listOf("默认", "经典", "活力")

    Scaffold(
        topBar = {
            TopAppBar(
                title = "显示",
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(MiuixIcons.Back, contentDescription = "返回")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            SmallTitle(text = "外观")

            Card(modifier = Modifier.fillMaxWidth()) {
                SwitchPreference(
                    title = "深色模式",
                    summary = "切换浅色与深色主题",
                    checked = darkMode,
                    onCheckedChange = { darkMode = it }
                )
            }

            SmallTitle(text = "字体")

            Card(modifier = Modifier.fillMaxWidth()) {
                OverlayDropdownPreference(
                    title = "系统字体",
                    items = fontOptions,
                    selectedIndex = selectedFontIndex,
                    onSelectedIndexChange = { selectedFontIndex = it }
                )

                SliderPreference(
                    title = "字体大小",
                    summary = "当前: ${(fontSize * 100).toInt()}%",
                    value = fontSize,
                    onValueChange = { fontSize = it }
                )
            }

            SmallTitle(text = "主题色")

            Card(modifier = Modifier.fillMaxWidth()) {
                themeOptions.forEachIndexed { index, label ->
                    RadioButtonPreference(
                        title = label,
                        selected = selectedTheme == index,
                        onClick = { selectedTheme = index }
                    )
                    if (index < themeOptions.size - 1) {
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}
