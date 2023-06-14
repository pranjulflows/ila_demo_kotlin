package com.macamps.demotest.utils

import android.view.View
import android.widget.ScrollView
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.setShowSideItems(pageMarginPx : Int, offsetPx : Int) {

    clipToPadding = false
    clipChildren = false
    offscreenPageLimit = 3

    setPageTransformer { page, position ->

        val offset = position * -(2 * offsetPx + pageMarginPx)
        if (this.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
            if (ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                page.translationX = -offset
            } else {
                page.translationX = offset
            }
        } else {
            page.translationY = offset
        }
    }

}
fun collapseViewOnScroll(view: View, scrollView: ScrollView) {

    // Get the height of the view to be collapsed.
    val viewHeight = view.measuredHeight

    // Set a listener on the scroll view to detect scroll events.
    scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

        // If the scroll view is scrolled down, collapse the view.
        if (scrollY > oldScrollY) {
            view.layoutParams.height = 0
            view.requestLayout()
        }

        // If the scroll view is scrolled up, expand the view.
        else if (scrollY < oldScrollY) {
            view.layoutParams.height = viewHeight
            view.requestLayout()
        }
    }
}