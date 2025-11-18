package de.moooon.acrylicons

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.ScrollView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.reflect.Field


class MainActivity : Activity() {

    var drawables: Array<Field> = R.drawable::class.java.fields

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<GridLayout>(R.id.main_layout)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById<ScrollView>(android.R.id.content)) { v, insets ->
            val insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            WindowInsetsCompat.CONSUMED
        }

        var row = 0
        var column = 0

        drawables.sortBy { it.name }

        for (drawable in drawables) {
            if (drawable.name.startsWith("icon_")) {
                val imageView = ImageView(this)
                imageView.setImageResource(drawable.getInt(null))
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP

                var layoutParams = GridLayout.LayoutParams(
                        GridLayout.spec(row, 1),
                        GridLayout.spec(column, 1))

                layoutParams.width = Resources.getSystem().displayMetrics.widthPixels / 2
                layoutParams.height = Resources.getSystem().displayMetrics.widthPixels / 2

                layout.addView(imageView, layoutParams)

                column += 1
                if (column == 2) {
                    column = 0
                    row += 1
                }
            }
        }
    }
}