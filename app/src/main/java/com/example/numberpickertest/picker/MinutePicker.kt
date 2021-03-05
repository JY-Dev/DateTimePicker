package com.example.numberpickertest.picker

import android.content.Context
import android.util.AttributeSet
import java.util.*
import kotlin.math.min

class MinutePicker(context: Context, attributeSet: AttributeSet) : BasePicker(context,attributeSet) {
    private val minuteList = Array(60){if(it < 10) "0$it" else it}.toList()
    init {
        data = minuteList
        setCurrent()
    }

    fun getSelectMinute() : Int =
        currentItemPosition

    fun setIndex(minute : Int) {
        selectedItemPosition = minute
    }

    fun setCurrent(){
        setIndex(Calendar.getInstance().get(Calendar.MINUTE))
    }
}