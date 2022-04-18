package com.example.jumpsortapp.presentation.jumpflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jumpsortapp.ui.theme.Aquamarine
import com.example.jumpsortapp.ui.theme.ElectricBlue

@Composable
fun JumpSortScreen() {
    val verticalState = rememberScrollState()
    val inputValues = remember {
        mutableStateOf("")
    }
    val keyValue = remember {
        mutableStateOf("")
    }
    val keyIndexValue = remember {
        mutableStateOf("")
    }
    val enabled = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(verticalState)
            .background(Aquamarine),
    ) {
        TopAppBar(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp), contentPadding = PaddingValues(start = 12.dp)) {
            Text(
                text = "Jump Sort Program Calculator",
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Your Input : ",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White),
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = inputValues.value,
            onValueChange = { inputValues.value = it },
            enabled = enabled.value,
            modifier = Modifier
                .height(90.dp)
                .width(400.dp)
                .padding(start = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = ElectricBlue,
                unfocusedBorderColor = ElectricBlue,
                cursorColor = Color.White,
                textColor = Color.White,
                disabledBorderColor = ElectricBlue,
            ),
            maxLines = 3
            )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clip(
                    RoundedCornerShape(10.dp)
                )
        ) {
            Text(text = "Insert")
        }
        Spacer(modifier = Modifier.padding(28.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Enter Key : ",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White),
                )
                Spacer(modifier = Modifier.padding(5.dp))
                OutlinedTextField(
                    value = keyValue.value,
                    onValueChange = { keyValue.value = it },
                    enabled = enabled.value,
                    modifier = Modifier.size(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ElectricBlue,
                        unfocusedBorderColor = ElectricBlue,
                        cursorColor = Color.White,
                        textColor = Color.White,
                        disabledBorderColor = ElectricBlue,
                    ),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                ) {
                    Text(text = "Search")
                }
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(140.dp)
            ) {
                Text(
                    text = "Key index : ",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                )
                Spacer(modifier = Modifier.padding(5.dp))
                OutlinedTextField(
                    value = keyIndexValue.value,
                    onValueChange = { keyIndexValue.value = it },
                    enabled = enabled.value,
                    modifier = Modifier.size(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ElectricBlue,
                        unfocusedBorderColor = ElectricBlue,
                        cursorColor = Color.White,
                        textColor = Color.White,
                        disabledBorderColor = ElectricBlue,
                    ),
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        BottomAppBar(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(12.dp)) {
            Button(onClick = { /*TODO*/ }) {

            }
        }
    }
}