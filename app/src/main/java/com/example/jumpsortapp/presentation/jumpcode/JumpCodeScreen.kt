package com.example.jumpsortapp.presentation.jumpcode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jumpsortapp.ui.theme.Aquamarine

@Composable
fun JumpCodeScreen(navController: NavController) {
    val verticalState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Jump Sort Code", textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon", modifier = Modifier.size(35.dp))
                    }
                },
                contentColor = Color.White,
            )
    }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Aquamarine)
                .verticalScroll(verticalState)
        ) {
            Text(
                text = "Code in kotlin",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            )
            Text(text = "fun searchKeyIndex(list : List<String>,length : Int, k : String): Int{\n" +
                    "        if (list.value==null){\n" +
                    "            return -1\n" +
                    "        }\n" +
                    "        var step = floor(sqrt(length.toDouble()))\n" +
                    "        var prev = 0\n" +
                    "        while (list.value!![min(step.toInt(),length) -1]<k){\n" +
                    "            prev = step.toInt()\n" +
                    "            step += floor(sqrt(length.toDouble()))\n" +
                    "            if (prev >= length){\n" +
                    "                return -1\n" +
                    "            }\n" +
                    "        }\n" +
                    "        while (list.value!![prev]<k){\n" +
                    "            prev++\n" +
                    "            if (prev == min(step.toInt(),length))\n" +
                    "                return -1\n" +
                    "        }\n" +
                    "\n" +
                    "        if (list.value!![prev] == k)\n" +
                    "            return prev\n" +
                    "\n" +
                    "        return -1\n" +
                    "    }", style = TextStyle(fontSize = 18.sp, color = Color.White)
            )
        }
    }
}