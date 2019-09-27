package com.youtubedemo.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.data_view.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val cellForRow =
            LayoutInflater.from(parent.context).inflate(R.layout.data_view, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val videoTitle = homeFeed.videos.get(position)
        holder.itemView.textView_video_title.text = videoTitle.name
        holder.itemView.textView_description.text = videoTitle.channel.name
        val  imageViewTumb = holder.itemView.imageView_top

        Picasso.get()
            .load("https://rukminim1.flixcart.com/image/800/960/k0mqtu80/sweatshirt/z/p/y/9-10-years-mcbaw19ss015b-miss-chief-original-imafke696tkmfphe.jpeg?q=50")
            .into(imageViewTumb)
    }


    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }
}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

}
