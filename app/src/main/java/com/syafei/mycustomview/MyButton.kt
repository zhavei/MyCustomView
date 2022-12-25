package com.syafei.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class MyButton : AppCompatButton {

    private lateinit var enabledBackground: Drawable
    private lateinit var disabledBackground: Drawable
    private var txtColor: Int = 0

    constructor(contex: Context) : super(contex) {
        init()
    }

    constructor(contex: Context, attributeSet: AttributeSet) : super(contex, attributeSet) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init()
    }

    // Metode onDraw() digunakan untuk mengcustom button ketika enable dan disable
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // Mengubah background dari Button
        background = if (isEnabled) enabledBackground else disabledBackground

        // Mengubah warna text pada button
        setTextColor(txtColor)
        textSize = 12f
        // Menjadikan object pada button menjadi center
        gravity = Gravity.CENTER
        // Mengubah text pada button pada kondisi enable dan disable
        text = if (isEnabled) "Submit" else "Isi dulu gan"


    }

    private fun init() {
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button) as Drawable
        disabledBackground =
            ContextCompat.getDrawable(context, R.drawable.bg_button_disable) as Drawable
    }
}