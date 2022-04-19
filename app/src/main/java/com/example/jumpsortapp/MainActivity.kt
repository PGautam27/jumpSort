package com.example.jumpsortapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jumpsortapp.presentation.jumpcode.JumpCodeScreen
import com.example.jumpsortapp.presentation.jumpflow.JumpSortScreen
import com.example.jumpsortapp.presentation.screen.Screen
import com.example.jumpsortapp.ui.theme.JumpSortAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JumpSortAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.JumpSortScreen.route
                ) {
                    composable(
                        Screen.JumpSortScreen.route
                    ){
                        JumpSortScreen(navController = navController)
                    }
                    composable(
                        Screen.JumpCodeScreen.route
                    ){
                        JumpCodeScreen(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JumpSortAppTheme {
        Greeting("Android")
    }
}