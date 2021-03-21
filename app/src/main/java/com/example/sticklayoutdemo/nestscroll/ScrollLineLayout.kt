package com.example.sticklayoutdemo.nestscroll

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.NestedScrollingParent3
import com.example.sticklayoutdemo.R

class ScrollLineLayout(context: Context?, attrs: AttributeSet?)
    : LinearLayout(context, attrs),NestedScrollingParent3 {

    private var mHeaderView:TextView? = null
    private var mHeaderViewHeight:Int = 0

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {

    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        return true
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {

        var headerScrollUp = dy >0 && scrollY < mHeaderViewHeight

        var headerScrollDown = dy < 0 && scrollY > 0 && !target.canScrollVertically(-1);
        Log.d("dbs", "dy:$dy scrollY:$scrollY target:${target.toString()}")
        if (headerScrollUp || headerScrollDown) {
            scrollBy(0, dy)
            consumed[1] = dy
        }
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
    }

    override fun onStopNestedScroll(target: View, type: Int) {
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if(mHeaderView == null) mHeaderView = findViewById<TextView>(R.id.tv_header)
        mHeaderViewHeight = mHeaderView?.measuredHeight ?:0

    }
}