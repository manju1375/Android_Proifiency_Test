package com.johncodeos.pulltorefreshexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.androidtest.samplenewsapp.R
import com.androidtest.samplenewsapp.model.RowModel
import kotlinx.android.synthetic.main.item_row.view.*

class NewsAdapter(private var itemsCells: List<RowModel>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemsCells?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as ItemViewHolder
        Glide.with(itemViewHolder.itemView).load(itemsCells?.get(position)?.imageHref).override(300,200).into(itemViewHolder.itemView.img)
        itemViewHolder.itemView.itemtextview.text = itemsCells?.get(position)?.title
        itemViewHolder.itemView.itemtextviewdesc.text = itemsCells?.get(position)?.description
        itemViewHolder.itemView.img.visibility = if(itemsCells?.get(position)?.imageHref == null)View.GONE else View.VISIBLE
        itemViewHolder.itemView.itemtextview.visibility = if(itemsCells?.get(position)?.title == null)View.GONE else View.VISIBLE
        itemViewHolder.itemView.itemtextviewdesc.visibility = if(itemsCells?.get(position)?.description == null)View.GONE else View.VISIBLE
        itemViewHolder.itemView.visibility = if((itemsCells?.get(position)?.title == null) &&(itemsCells?.get(position)?.description == null)) View.GONE else View.VISIBLE

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}


