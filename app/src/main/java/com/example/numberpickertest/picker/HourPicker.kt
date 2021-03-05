package com.example.numberpickertest.picker

import android.content.Context
import android.util.AttributeSet
import java.text.SimpleDateFormat
import java.util.*

class HourPicker(context: Context, attributeSet: AttributeSet) : BasePicker(context,attributeSet) {
    private val hourList = Array(24){if(it < 10) "0$it" else it}.toList()
    init {
        data = hourList
        setCurrent()
    }

    fun getSelectHour() : Int =
        currentItemPosition

    fun setIndex(hour : Int) {
        selectedItemPosition = hour
    }

    fun setCurrent(){
        setIndex(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
    }

    private fun Long.formatDate() : String =
        SimpleDateFormat("hh", Locale.JAPAN).format(Date(this))
}