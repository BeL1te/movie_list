package com.be1te.big.movielist.ui.activities

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.be1te.big.movielist.R

class ReminderBroadcast(private val title: String) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val builder =
            NotificationCompat.Builder(context!!, "notify").setSmallIcon(R.drawable.ic_movie)
                .setContentTitle("Notification!")
                .setContentText("You wanted to watch $title")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(200, builder.build())
    }
}