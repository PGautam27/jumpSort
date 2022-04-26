package com.example.jumpsortapp.presentation.selectionSort.selectionCode

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class SelectionViewModel @Inject constructor():ViewModel() {

    private val _selectList = MutableStateFlow<Array<String>?>(null)
    val selectList = _selectList.asStateFlow()

    private var length by Delegates.notNull<Int>()

    fun readArray(list: List<String>){
        _selectList.value = list.toTypedArray()
        length = list.size
    }

    fun selectionSort(){
        for (i in 0..length){
            var min_idx: Int = i
            for ( j in i+1..length){
                if (_selectList.value?.get(j)!! < _selectList.value?.get(min_idx)!!){
                    min_idx = j
                }
            }
            val temp = _selectList.value?.get(min_idx)!!
            _selectList.value!![min_idx] = _selectList.value?.get(i)!!
            _selectList.value!![i] = temp
        }
    }
}