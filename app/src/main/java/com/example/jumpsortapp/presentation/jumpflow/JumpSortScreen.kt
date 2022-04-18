package com.example.jumpsortapp.presentation.jumpflow

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jumpsortapp.presentation.jumpflow.component.element
import com.example.jumpsortapp.ui.theme.Aquamarine
import com.example.jumpsortapp.ui.theme.ElectricBlue
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

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
    val list1 = listOf<String>("70","15","85","35","08")
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp), contentPadding = PaddingValues(start = 12.dp)) {
                Text(
                    text = "Jump Sort Program Calculator",
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                )
            }
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(12.dp)) {
                FlowRow(modifier = Modifier
                    .fillMaxSize(),
                    mainAxisSpacing = 6.dp,
                    crossAxisAlignment = FlowCrossAxisAlignment.Center,
                    mainAxisAlignment = MainAxisAlignment.Center,
                    crossAxisSpacing = 0.dp) {
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(125.dp)
                            .clickable { },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Code", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(125.dp)
                            .clickable { },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Code",fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(125.dp)
                            .clickable { },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Code",fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalState)
                .background(Aquamarine),
        ) {
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
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "The Array : ",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White),
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.padding(6.dp))
            FlowRow(
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp),
                mainAxisSpacing = 20.dp,
                crossAxisAlignment = FlowCrossAxisAlignment.Center,
                mainAxisAlignment = MainAxisAlignment.Center,
                crossAxisSpacing = 5.dp,

                ) {
                list1.sorted().forEach { it ->
                    element(element = it)
                }
            }
            Spacer(modifier = Modifier.padding(14.dp))
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

        }
    }

}