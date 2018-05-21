package com.example.iyung.host

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.slice.widget.SliceLiveData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //onStart fetches a slice by URI and adds an observer to it. the observer appends the slice to the SliceView
    override fun onStart() {
        super.onStart()
        SliceLiveData.fromUri(this,Uri.parse("content://com.example.iyung.provider/slice"))
                .observe(this, Observer { slice ->
                    if (slice != null) {
                        slice_view.slice = slice
                    }
                })
    }
}
