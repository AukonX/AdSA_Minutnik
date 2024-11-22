package com.example.minutnik

import android.os.CountDownTimer
import android.view.View
import android.widget.Button

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

    fun Start(view: View) {
        clock = object : CountDownTimer(totalMiliSecs, 1000) {
            override fun onTick(p0: Long) {
                view.findViewById<Button>(R.id.ButtonCounterSecondsMinus).performClick()
            }

            override fun onFinish() {
            }
        }.start()
    }

    fun Stop()
    {
        clock.cancel()
    }
}