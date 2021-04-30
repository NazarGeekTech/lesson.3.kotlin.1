package com.example.lesson3kotlin1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var counter = 0

    //region methods() Nazar zapiwi sosisku
    val count = MutableLiveData<Int>()

    val trubaHistoryMinus = MutableLiveData<String>()

    val trubaHistoryPlus = MutableLiveData<String>()

    //endOshregion

    fun plus() {
        count.value = ++counter
        trubaHistoryPlus.value = trubaHistoryPlus.value + plus
    } 

    fun minus() {
        count.value = --counter
        trubaHistoryMinus.value = trubaHistoryMinus.value + minus
    }

    init {
        count.postValue(0)
        trubaHistoryPlus.postValue("")
        trubaHistoryMinus.postValue("")
    }

    companion object {
        const val plus = "➕"
        const val minus = "➖"
    }
}