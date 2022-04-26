package com.example.jumpsortapp.presentation.jumpSearch.jumpcode

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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jumpsortapp.ui.theme.Aquamarine

@Composable
fun JumpAlgoScreen(navController: NavController) {
    val verticalScroll = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Jump Search Algo", textAlign = TextAlign.Center,
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
            modifier = Modifier
                .fillMaxSize()
                .background(Aquamarine).verticalScroll(verticalScroll),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Explanation : ",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            )
            Text(text = "Step1 :- Start\n\n"+ "Step2 :- Find the square root of size of array \n n <- size of array \n m <- sqrt(n)\n\n"+"Step3 :- Check if current value matches the key\n -> Check for the bounds at which the key lies\n -> If the first element of the bound is lesser than the key then jump\n\n"+"Step5 :- Apply linear search in the bound starting from the low value till the end element of the bound\n\n"+"Step6 :- If key is found return the index at which the key was found else return -1",
                style = TextStyle(fontSize = 18.sp, color = Color.White), modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = "Algorithm : ",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            )
            Text(text = "Step1 :- Start\n\n"+"Step2 :- prev <- 0\n step <- floor(sqrt(length))\n\n"+"Step3 <- while list[(step to length) -1] < key\nprev <- step\nstep = step + step\nif prev >= length\nreturn -1\n\n"+"Step4 :- while lis[prev] < key\nprev++\nif prev == min(step to length)\nreturn -1\n\n"+"step5 :- if list[prev] == key\nreturn prev\nelse return -1\n\n"+"Step6 :- Stop",
                style = TextStyle(fontSize = 18.sp, color = Color.White), modifier = Modifier.padding(start = 10.dp, bottom = 20.dp)
            )
        }
    }
}