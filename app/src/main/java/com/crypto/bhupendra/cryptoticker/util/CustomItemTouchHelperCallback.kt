package com.crypto.bhupendra.cryptoticker.util

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import com.crypto.bhupendra.cryptoticker.OnUpdate

/**
 * Created by bhupendra on 12/2/18.
 */
class CustomItemTouchHelperCallback(dragDirs: Int, swipeDirs: Int, listener: OnUpdate) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    private var listener = listener
    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        Log.e(viewHolder.layoutPosition.toString(), target.layoutPosition.toString())
        listener.onChangeposition(viewHolder.layoutPosition, target.layoutPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.RIGHT) {
            listener.onRemoveItem(viewHolder.adapterPosition)
        }
    }
}