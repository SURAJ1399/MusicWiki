package com.example.android.rvtutorial




import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.DrawableImageViewTarget
import net.developers.api.artistalbum.Album
import net.developers.musicwiki.R
import net.developers.musicwiki.databinding.ListItemAlbBinding
import net.developers.musicwiki.ui.AlbumDetailActivity

import net.developers.musicwiki.ui.ArtistDetailActivity


class TopAlbumAdapter

    :RecyclerView.Adapter<TopAlbumViewHolder>(){

    val albs:ArrayList<Album> = ArrayList()
lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAlbumViewHolder {
context=parent.context
        return TopAlbumViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item_topalb,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {

   return albs.size
    }

    override fun onBindViewHolder(holder: TopAlbumViewHolder, position: Int) {
        ListItemAlbBinding.bind(holder.itemView).apply {

            Glide.with(context).load(albs.get(position).image.get(2).text)
                .into(imageview)
          albumName.text=albs.get(position).name

            imageview.setOnClickListener {
                val intent = Intent(context, AlbumDetailActivity::class.java)
                intent.putExtra("artistname",albs.get(position).artist.name)
                intent.putExtra("albumname",albs.get(position).name)
                context.startActivity(intent)
            }
                }

    }
    fun updatealb(albss:ArrayList<Album>)
    {
        Log.i("resp",albss.size.toString())
        albs.clear();
        albs.addAll(albss)
        notifyDataSetChanged()
    }



}

class TopAlbumViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {



}
