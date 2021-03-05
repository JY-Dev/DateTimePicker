package com.example.numberpickertest

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.NumberPicker
import java.text.SimpleDateFormat
import java.util.*

class DatePicker(context: Context?, attrs: AttributeSet?) : WheelPicker(context,attrs) {
    private val timeList = mutableListOf<Long>()
    private val dateList = mutableListOf<String>()
    init {
        var currentTime = 0L
        var maxDay = 0
        val cal = Calendar.getInstance().apply {
            set(Calendar.HOUR, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            currentTime = timeInMillis
            maxDay = getMaxDay(get(Calendar.YEAR).isLeapYear())
            set(Calendar.MONTH, 0)
            set(Calendar.DATE, 0)
        }

        for (month in 1..maxDay) {
            cal.add(Calendar.DATE, 1)
            timeList.add(cal.timeInMillis)
        }
        timeList.forEach {
            if(currentTime == it)
                dateList.add("今日")
            else
                dateList.add(it.formatDate())
        }
        data = dateList
        isCyclic = true
        isCurved = true
        visibleItemCount = 5
        selectedItemTextColor = Color.BLACK
        itemTextColor = Color.LTGRAY
        selectedItemPosition = timeList.indexOf(currentTime)
    }
    private fun Int.isLeapYear(): Boolean =
        (this % 4 == 0 && (this % 100 != 0 || this % 400 == 0))

    private fun getMaxDay(isLeapYear : Boolean) : Int =
        if(isLeapYear) 366 else 365

    private fun Long.formatDate() : String =
        SimpleDateFormat("M月d日 E", Locale.JAPAN).format(Date(this))

    fun getCurrentTime() : Long =
        timeList[currentItemPosition]

    fun getCurrentDateString() : String =
        dateList[currentItemPosition]

}