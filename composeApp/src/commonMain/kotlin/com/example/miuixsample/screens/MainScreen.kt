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
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.SmallTopAppBar
import top.yukonga.miuix.kmp.preference.ArrowPreference
import top.yukonga.miuix.kmp.preference.SliderPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun MainScreen(
    onNavigateToDisplay: () -> Unit,
    onNavigateToAbout: () -> Unit
) {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var soundVolume by remember { mutableStateOf(0.7f) }

    Scaffold(
        topBar = {
            SmallTopAppBar(title = "设置")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            SmallTitle(text = "通用设置")

            Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp).padding(bottom = 12.dp)) {
                ArrowPreference(
                    title = "显示",
                    summary = "主题、字体、深色模式",
                    onClick = onNavigateToDisplay
                )
            }

            SmallTitle(text = "声音与振动")

            Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp).padding(bottom = 12.dp)) {
                SliderPreference(
                    title = "媒体音量",
                    value = soundVolume,
                    onValueChange = { soundVolume = it }
                )
            }

            SmallTitle(text = "通知")

            Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp).padding(bottom = 12.dp)) {
                SwitchPreference(
                    title = "允许通知",
                    summary = "开启后接收应用推送通知",
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )
            }

            SmallTitle(text = "其他")

            Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp).padding(bottom = 12.dp)) {
                ArrowPreference(
                    title = "关于 MIUIX Sample",
                    summary = "版本信息、开源许可",
                    onClick = onNavigateToAbout
                )
            }
        }
    }
}
