package com.example.jumpsortapp.presentation.jumpflow

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jumpsortapp.presentation.jumpflow.component.element
import com.example.jumpsortapp.presentation.screen.Screen
import com.example.jumpsortapp.ui.theme.Aquamarine
import com.example.jumpsortapp.ui.theme.ElectricBlue
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import kotlinx.coroutines.flow.forEach

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun JumpSortScreen(
    navController: NavController,
    viewModel: JumpViewModel = hiltViewModel()
) {

    val lists by viewModel._list.collectAsState()

    val verticalState = rememberScrollState()
    val inputValues = remember {
        mutableStateOf("")
    }
    val keyValue = remember {
        mutableStateOf("")
    }
    val listValue = remember {
        mutableListOf<String>()
    }
    val keyIndexValue = remember {
        mutableStateOf("")
    }
    val enabled = remember {
        mutableStateOf(true)
    }
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp), contentPadding = PaddingValues(start = 12.dp)) {
                Text(
                    text = "Jump Search Program Calculator",
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                )
            }
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.fillMaxWidth()) {
                FlowRow(modifier = Modifier
                    .fillMaxSize(),
                    mainAxisSpacing = 6.dp,
                    crossAxisAlignment = FlowCrossAxisAlignment.Center,
                    mainAxisAlignment = MainAxisAlignment.Center,
                    crossAxisSpacing = 0.dp) {
                    Column(
                        modifier = Modifier
                            .height(90.dp)
                            .width(LocalConfiguration.current.screenWidthDp.dp / 3 - 10.dp)
                            .clickable { navController.navigate(Screen.JumpCodeScreen.route) },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Code", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(LocalConfiguration.current.screenWidthDp.dp / 3 - 10.dp)
                            .clickable { },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Algo",fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .width(LocalConfiguration.current.screenWidthDp.dp / 3 - 10.dp)
                            .clickable { },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "About",fontWeight = FontWeight.Bold, fontSize = 22.sp)
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
                    .width(LocalConfiguration.current.screenWidthDp.dp)
                    .padding(start = 10.dp, end = 10.dp),
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
                onClick = {
                    var li = inputValues.value.split(" ".toRegex())
                    li.forEachIndexed{ i, s ->
                        listValue.add(i,s)
                    }
                    viewModel.jumpSearch(listValue)
                          },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            ) {
                Text(text = "Insert")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "The Sorted Array : ",
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
                lists?.forEach { it ->
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
                        modifier = Modifier
                            .height(50.dp)
                            .width(60.dp)
                            .align(Alignment.CenterHorizontally),
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
                        onClick = {
                            keyIndexValue.value = viewModel.searchKeyIndex(keyValue.value).toString()
                        }, modifier = Modifier
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
                        enabled = false,
                        modifier = Modifier
                            .height(50.dp)
                            .width(60.dp)
                            .align(Alignment.CenterHorizontally),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = ElectricBlue,
                            unfocusedBorderColor = ElectricBlue,
                            cursorColor = Color.White,
                            textColor = Color.White,
                            disabledBorderColor = ElectricBlue,
                            disabledLabelColor = ElectricBlue,
                            disabledTextColor = Color.White
                        ),
                        maxLines = 1
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

        }
    }

}