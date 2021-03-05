package com.example.numberpickertest.picker

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.numberpickertest.R

class DateTimePicker(context: Context, attributeSet: AttributeSet) : LinearLayout(context,attributeSet) {
    private val view = LayoutInflater.from(context).inflate(R.layout.item_date_time_picker,this,false)
    private val datePicker = view.findViewById<DatePicker>(R.id.date_picker)
    private val hourPicker = view.findViewById<HourPicker>(R.id.hour_picker)
    private val minutePicker = view.findViewById<MinutePicker>(R.id.minute_picker)

    init {
        addView(view)
    }

    fun plusFiveMinute(){
        val plusMinute = minutePicker.getSelectMinute() + 5
        minutePicker.setIndex(plusMinute%60)
        if(plusMinute >= 60){
            val plusHour = hourPicker.getSelectHour() + 1
            hourPicker.setIndex(plusHour%24)
            if(plusHour >= 24)
                datePicker.setNextIndex()
        }
    }

    fun minusFiveMinute(){
        val minusMinute = minutePicker.getSelectMinute() - 5
        val minuteIndex = if(minusMinute<0) minusMinute+60 else minusMinute
        minutePicker.setIndex(minuteIndex)
        if(minusMinute < 0){
            val minusHour = hourPicker.getSelectHour() - 1
            val hourIndex = if(minusHour<0) minusHour+24 else minusHour
            hourPicker.setIndex(hourIndex)
            if(minusHour < 0)
                datePicker.setPreIndex()
        }
    }

    fun setCurrent(){
        datePicker.setCurrent()
        hourPicker.setCurrent()
        minutePicker.setCurrent()
    }


}