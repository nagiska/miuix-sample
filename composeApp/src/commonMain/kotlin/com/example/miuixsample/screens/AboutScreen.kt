package com.example.miuixsample.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.HorizontalDivider
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TextButton
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.icon.extended.Settings
import top.yukonga.miuix.kmp.overlay.OverlayBottomSheet
import top.yukonga.miuix.kmp.overlay.OverlayDialog

@Composable
fun AboutScreen(onBack: () -> Unit) {
    var showVersionDialog by remember { mutableStateOf(false) }
    var showLicenseSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = "关于",
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
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(48.dp))

            Icon(
                imageVector = MiuixIcons.Settings,
                contentDescription = "App Icon",
                modifier = Modifier.size(72.dp)
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "MIUIX Sample",
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "基于 Miuix 组件库构建的示例应用",
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(32.dp))

            SmallTitle(text = "信息")

            Card(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                    InfoRow(label = "版本", value = "1.0.0")
                    HorizontalDivider()
                    InfoRow(label = "Miuix 版本", value = "0.9.2")
                    HorizontalDivider()
                    InfoRow(label = "构建平台", value = "Android")
                }
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { showVersionDialog = true },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("版本详情")
                }

                Button(
                    onClick = { showLicenseSheet = true },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColorsPrimary()
                ) {
                    Text("开源许可")
                }
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "HyperOS Design",
                textAlign = TextAlign.Center
            )
        }

        OverlayDialog(
            title = "版本详情",
            summary = "这是使用 Compose Multiplatform + Miuix 构建的示例应用，模拟小米 HyperOS 设置页面设计风格。",
            show = showVersionDialog,
            onDismissRequest = { showVersionDialog = false }
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                TextButton(
                    text = "关闭",
                    onClick = { showVersionDialog = false },
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(20.dp))
                TextButton(
                    text = "了解更多",
                    onClick = { showVersionDialog = false },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.textButtonColorsPrimary()
                )
            }
        }

        OverlayBottomSheet(
            show = showLicenseSheet,
            title = "开源许可",
            onDismissRequest = { showLicenseSheet = false }
        ) {
            Column(modifier = Modifier.padding(vertical = 16.dp)) {
                Text("Miuix: Apache-2.0 License")
                Spacer(Modifier.height(8.dp))
                Text("Compose Multiplatform: Apache-2.0 License")
                Spacer(Modifier.height(8.dp))
                Text("Kotlin: Apache-2.0 License")
                Spacer(Modifier.height(16.dp))
                TextButton(
                    text = "关闭",
                    onClick = { showLicenseSheet = false },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label)
        Text(text = value)
    }
}
