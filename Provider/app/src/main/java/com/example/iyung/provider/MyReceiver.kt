package com.example.iyung.provider

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri

class MyReceiver : BroadcastReceiver() {

    //when an intent is received, increments the counter and sends an intent to tell the slice to refresh
    override fun onReceive(context: Context, intent: Intent) {
        MySliceProvider.count++
        context.contentResolver.notifyChange(Uri.parse("slice-content://com.example.iyung.provider/slice"), null)
    }
}
