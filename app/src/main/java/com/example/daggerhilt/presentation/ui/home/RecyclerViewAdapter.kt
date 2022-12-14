package com.example.daggerhilt.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daggerhilt.R
import com.example.daggerhilt.network.RecyclerData
import kotlinx.android.synthetic.main.recycler_row.view.*

class  RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setlistData(listData: List<RecyclerData>?) {
        this.listData = listData
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val thumbImage = view.thumbImage
        val tvName = view.tvName
        val tvDesc = view.tvDesc

        fun bind(data: RecyclerData) {
            tvName.text = data.name
            tvDesc.text = data.description

            Glide.with(thumbImage)
                .load(data.owner?.avatar_url)
                .into(thumbImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listData == null) return 0
            return listData?.size!!

    }
}