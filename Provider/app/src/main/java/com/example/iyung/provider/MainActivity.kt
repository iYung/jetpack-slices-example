package com.example.iyung.provider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //updates the main activity to show the counter's value
    override fun onStart() {
        super.onStart()
        main_activity_textview.text = MySliceProvider.count.toString()
    }
}
