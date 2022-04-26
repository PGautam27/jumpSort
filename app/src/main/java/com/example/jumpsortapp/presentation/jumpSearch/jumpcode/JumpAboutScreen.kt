package com.example.jumpsortapp.presentation.jumpSearch.jumpcode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jumpsortapp.ui.theme.Aquamarine

@Composable
fun JumpAboutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "About Jump Search", textAlign = TextAlign.Center,
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
            modifier = Modifier.fillMaxSize().background(Aquamarine),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Definition",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            )
            Text(
                text = "1. Jump Search is a searching algorithm for sorted arrays. \n\n2. The basic idea is to check fewer elements (than linear search) by jumping ahead by fixed steps or skipping some elements in place of searching all elements.\n\n" +
                        "3. For example, suppose we have an array arr[] of size n and block (to be jumped) size m. \n\n4. Then we search at the indexes arr[0], arr[m], arr[2m]…..arr[km] and so on. \n\n5. Once we find the interval (arr[km] < x < arr[(k+1)m]), we perform a linear search operation from the index km to find the element x.\n",
                style = TextStyle(fontSize = 20.sp, color = Color.White),
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}