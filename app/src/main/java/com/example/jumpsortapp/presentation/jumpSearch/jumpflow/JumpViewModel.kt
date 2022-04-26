package com.example.jumpsortapp.presentation.jumpSearch.jumpflow

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.math.floor
import kotlin.math.min
import kotlin.math.sqrt
import kotlin.properties.Delegates

@HiltViewModel
class JumpViewModel  @Inject constructor() :ViewModel(){

    private val list = MutableStateFlow<List<String>?>(null)
    val _list = list.asStateFlow()

    private var length by Delegates.notNull<Int>()

    private val key = MutableStateFlow<String?>(null)
    val _key = key.asStateFlow()

    fun jumpSearch(lst: List<String>){
        length = lst.size
        list.value = lst.sorted()
    }

    fun searchKeyIndex(k: String): Int {

        if (list.value == null) {
            return -1
        }
        var step = floor(sqrt(length.toDouble()))
        var prev = 0
        while (list.value!![min(step.toInt(), length) - 1] < k) {
            prev = step.toInt()
            step += floor(sqrt(length.toDouble()))
            if (prev >= length) {
                return -1
            }
        }
        while (list.value!![prev] < k) {
            prev++
            if (prev == min(step.toInt(), length)) {
            }
            return -1
        }

        if (list.value!![prev] == k) {
        }
        return prev

        return -1
    }

    fun eraseList(){
        list.value = emptyList()
    }
}