package com.example.demoweather.util

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

object DateTime {

    fun getDate(s: String): String? {
        try {
            val sdf = SimpleDateFormat("E, dd/MMMM/yyyy", Locale.US)
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

    fun getTime(s: String): String? {
        try {
            val sdf = SimpleDateFormat("HH:mm:ss", Locale.US)
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

    fun isToday(s: String): String? {
        DateUtils.isToday(1231)
        try {
            val sdf = SimpleDateFormat("E, dd/MMMM/yyyy", Locale.US)
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }
}