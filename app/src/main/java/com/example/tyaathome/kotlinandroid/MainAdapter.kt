package com.example.tyaathome.kotlinandroid

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.tyaathome.kotlinandroid.MainAdapter.ViewHolder

/**
 * Created by tyaathome on 2017/5/22.
 */

class MainAdapter(val itemList : List<String>): RecyclerView.Adapter<ViewHolder>() {

    private var mListener: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(TextView(view.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv.text = itemList.get(position)
        holder.tv.rootView.setOnClickListener {
            mListener?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setListener(listener: (position: Int) -> Unit) {
        mListener = listener
    }


    class ViewHolder(val tv: TextView): RecyclerView.ViewHolder(tv)
}