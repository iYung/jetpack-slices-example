package com.example.iyung.provider

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat

import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.SliceAction

class MySliceProvider : SliceProvider() {

    //public variable to hold the value of the counter
    companion object {
        var count = 0
    }

    override fun onCreateSliceProvider(): Boolean {
        return true
    }

    //creates a slice depending on the URI it receives
    override fun onBindSlice(sliceUri: Uri): Slice? {
        val context = context ?: return null
        return if (sliceUri.path == "/slice") {
            ListBuilder(context, sliceUri)
                    .addRow {
                        it.setPrimaryAction(SliceAction(createIntent(), IconCompat.createWithResource(context, R.drawable.ic_add),"Add"))
                        it.setTitle(count.toString())
                    }.build()
        } else {
            // Error: Path not found.
            ListBuilder(context, sliceUri)
                    .addRow { it.setTitle("URI not found.") }
                    .build()
        }
    }

    //creates an intent that goes to the receiver
    private fun createIntent(): PendingIntent {
        var intent = Intent()
        intent.setClass(context,MyReceiver::class.java)
        return PendingIntent.getBroadcast(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}
