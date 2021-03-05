package com.example.numberpickertest.picker

import android.content.Context
import android.util.AttributeSet
import java.text.SimpleDateFormat
import java.util.*

class DatePicker(context: Context, attrs: AttributeSet) : BasePicker(context,attrs) {
    private val timeList = mutableListOf<Long>()
    private val dateList = mutableListOf<String>()
    var currentDateTime = 0L
    var maxDay = 0
    init {
        cal.apply {
            set(Calendar.HOUR, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            currentDateTime = timeInMillis
            maxDay = getMaxDay(cal.get(Calendar.YEAR).isLeapYear())
            set(Calendar.MONTH, 0)
            set(Calendar.DATE, 0)
        }

        for (month in 1..maxDay) {
            cal.add(Calendar.DATE, 1)
            timeList.add(cal.timeInMillis)
        }
        timeList.forEach {
            if(currentDateTime == it)
                dateList.add("今日")
            else
                dateList.add(it.formatDate())
        }
        data = dateList
        selectedItemPosition = timeList.indexOf(currentDateTime)
    }
    private fun Int.isLeapYear(): Boolean =
        (this % 4 == 0 && (this % 100 != 0 || this % 400 == 0))

    private fun getMaxDay(isLeapYear : Boolean) : Int =
        if(isLeapYear) 366 else 365

    private fun Long.formatDate() : String =
        SimpleDateFormat("M月d日 E", Locale.JAPAN).format(Date(this))

    fun setCurrent(){
        selectedItemPosition = timeList.indexOf(currentDateTime)
    }

    fun getCurrentTime() : Long =
        timeList[currentItemPosition]

    fun getCurrentDateString() : String =
        dateList[currentItemPosition]

    fun setNextIndex(){
        selectedItemPosition = (currentItemPosition+1)%maxDay
    }

    fun setPreIndex(){
        val preIndex = if(currentItemPosition == 0) maxDay else currentItemPosition-1
        selectedItemPosition = preIndex%maxDay
    }
}