package com.example.jumpsortapp.presentation.jumpflow.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jumpsortapp.ui.theme.ElectricBlue

@Composable
fun element(
    element:String
) {
    Box(modifier = Modifier
        .size(30.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(ElectricBlue), contentAlignment = Alignment.Center){
        Text(text = "$element", fontSize = 15.sp, style = TextStyle(color = Color.White))
    }
}