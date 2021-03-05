package com.example.numberpickertest.picker

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.numberpickertest.R

class TimePicker(context: Context, attributeSet: AttributeSet) : LinearLayout(context,attributeSet) {
    var view : View = LayoutInflater.from(context).inflate(R.layout.item_time_picker,this,false)
    init {
        addView(view)
    }


}