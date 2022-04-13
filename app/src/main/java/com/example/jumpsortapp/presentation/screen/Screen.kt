package com.example.jumpsortapp.presentation.screen

sealed class Screen(val route : String){
    object JumpSortScreen : Screen("jump_sort_screen")
    object JumpCodeScreen : Screen("jump_code_screen")
}
