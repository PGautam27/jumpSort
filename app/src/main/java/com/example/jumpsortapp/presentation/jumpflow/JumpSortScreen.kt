package com.example.jumpsortapp.presentation.jumpflow

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JumpSortScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)) {
            Text(
                text = "Jump Sort Program Calculator",
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Justify
            )
        }
    }
}