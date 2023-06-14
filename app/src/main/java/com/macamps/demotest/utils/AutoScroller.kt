package com.macamps.demotest.utils

import androidx.viewpager2.widget.ViewPager2

class AutoScroller(private val viewPager: ViewPager2) : Runnable {
    private var interval =0L
    private var isRunning = false

    fun start() {
        if (!isRunning) {
            isRunning = true
            viewPager.post(this)
        }
    }

    fun stop() {
        isRunning = false
    }
    fun setInterval(intervalDuration:Long){
        interval =intervalDuration
    }
    override fun run() {
        if (isRunning) {
            viewPager.currentItem = (viewPager.currentItem + 1) % viewPager.adapter!!.itemCount
            viewPager.postDelayed(this, interval)
        }
    }
}