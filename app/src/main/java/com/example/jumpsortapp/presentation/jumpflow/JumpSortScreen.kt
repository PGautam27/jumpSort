package com.example.jumpsortapp.presentation.jumpflow

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowColumn

@Composable
fun JumpSortScreen() {
    FlowColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)) {
            Text(
                text = "Jump Sort Program Calculator",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
        }
    }
}