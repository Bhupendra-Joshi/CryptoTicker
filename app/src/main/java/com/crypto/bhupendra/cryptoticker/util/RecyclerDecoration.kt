package com.crypto.bhupendra.cryptoticker.util

import android.content.Context
import android.graphics.*
import android.support.v7.widget.RecyclerView
import android.view.View
import com.crypto.bhupendra.cryptoticker.R


/**
 * Created by bhupendra on 31/1/18.
 */
class RecyclerDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var paint: Paint? = null
    private var offset: Int = 0

    private val myMsg: Bitmap?
    private val otherMsg: Bitmap?
    private val time: Bitmap?

    init {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint?.color = Color.RED
        paint?.style = Paint.Style.FILL
        paint?.strokeWidth = 10f
        myMsg = BitmapFactory.decodeResource(context.resources, R.drawable.bubble1)
        otherMsg = BitmapFactory.decodeResource(context.resources, R.drawable.bubble2)
        time = BitmapFactory.decodeResource(context.resources, android.R.drawable.ic_menu_info_details)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
//            if (i % 2 == 0) {
                child.background = parent.context.getDrawable(R.drawable.bubble1)
//            } else {
//                child.background = parent.context.getDrawable(R.drawable.bubble2);
//            }
        }


    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(offset, offset, offset, offset)
    }
}