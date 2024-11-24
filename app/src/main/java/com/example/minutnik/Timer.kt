package com.example.minutnik

import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

object Timer {
    var minutesTens : Int = 0
    var minutes : Int = 0
    var secondsTens : Int = 0
    var seconds : Int = 0
    var totalMiliSecs : Long = 0
    lateinit var clock : CountDownTimer

    fun CalculateTotalMiliSecs()
    {
        totalMiliSecs += minutesTens * 600
        totalMiliSecs += minutes * 60
        totalMiliSecs += secondsTens * 10
        totalMiliSecs += seconds
        totalMiliSecs *= 1000


    }

    fun Start(button: Button, buttonStop: Button?) {
        clock = object : CountDownTimer(totalMiliSecs, 1000) {
            override fun onTick(p0: Long) {
                button.performClick()
            }

            override fun onFinish() {
                buttonStop?.performClick()
            }
        }.start()
    }

    fun Stop()
    {
        clock.cancel()
    }
}