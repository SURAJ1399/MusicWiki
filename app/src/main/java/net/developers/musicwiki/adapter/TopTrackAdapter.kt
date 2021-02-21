package com.example.android.rvtutorial




import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.DrawableImageViewTarget
import net.developers.api.artisttracks.Track
import net.developers.api.tagalbum.Album

import net.developers.musicwiki.R
import net.developers.musicwiki.databinding.ListItemAlbBinding


class TopTrackAdapter

    :RecyclerView.Adapter<TopTrackViewHolder>(){

    val albs:ArrayList<Track> = ArrayList()
lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTrackViewHolder {
context=parent.context
        return TopTrackViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item_toptrack,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {

   return albs.size
    }

    override fun onBindViewHolder(holder: TopTrackViewHolder, position: Int) {
        Log.i("image",albs.get(position).image.get(2).text)
        ListItemAlbBinding.bind(holder.itemView).apply {

//            Glide.with(context).load(albs.get(position).image.get(2).text)
//                .into(imageview)
            albumName.text=albs.get(position).name

                }

    }
    fun updatealb(albss:ArrayList<Track>)
    {
        Log.i("resp",albss.size.toString())
        albs.clear();
        albs.addAll(albss)
        notifyDataSetChanged()
    }



}

class TopTrackViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {



}
