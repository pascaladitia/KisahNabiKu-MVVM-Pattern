package com.pascal.kisahnabiku.view.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.pascal.kisahnabiku.R
import com.pascal.kisahnabiku.model.ResponseMain
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterMain(
    val data: List<ResponseMain?>,
    val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.bind(item!!)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: ResponseMain) {
            view.item_name.text = item.name

            Glide.with(view.context)
                .load(item.imageUrl)
                .apply(RequestOptions())
                .override(500, 500)
                .placeholder(R.drawable.ic_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(view.item_img)

            view.setOnClickListener {
                itemClick.detail(item)
            }
        }
    }

    interface OnClickListener {
        fun detail(item: ResponseMain)
    }
}