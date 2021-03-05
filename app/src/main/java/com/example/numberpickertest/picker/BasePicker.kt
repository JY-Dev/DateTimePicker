package com.example.numberpickertest.picker

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import com.example.numberpickertest.WheelPicker
import java.util.*

open class BasePicker(context: Context,attributeSet: AttributeSet) : WheelPicker(context,attributeSet) {
    val cal = Calendar.getInstance()
    init {
        isCyclic = true
        isCurved = true
        visibleItemCount = 5
        selectedItemTextColor = Color.BLACK
        itemTextColor = Color.LTGRAY
        itemTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 18f, resources.displayMetrics).toInt()
    }
}