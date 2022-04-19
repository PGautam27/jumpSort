package com.example.jumpsortapp.presentation.screen

sealed class Screen(val route : String){
    object JumpSortScreen : Screen("jump_sort_screen")
    object JumpCodeScreen : Screen("jump_code_screen")
    object JumpAlgoScreen : Screen("jump_algo_screen")
    object JumpAboutScreen : Screen("jump_about_screen")
}
