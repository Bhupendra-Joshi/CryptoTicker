package com.crypto.bhupendra.cryptoticker

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.crypto.bhupendra.cryptoticker.databinding.ListItemBinding

/**
 * Created by bhupendra on 31/1/18.
 */
class RecyclerAdapter(list: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    private var list = list

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerAdapter.RecyclerViewHolder {
        val binding: ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.list_item, parent, false);
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.RecyclerViewHolder?, position: Int) {
        holder?.bindData(list.get(position))
    }


    fun removeItemFromList(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class RecyclerViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding = binding

        fun bindData(data: String) {
            binding?.text = data
        }
    }

    fun changeItemPosition(originalPosition: Int, targetPosition: Int) {
        var item = list.get(originalPosition)
        list.removeAt(originalPosition)
        list.add(targetPosition, item)

        notifyDataSetChanged()

    }
}