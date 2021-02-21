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
import net.developers.api.tagalbum.Album
import net.developers.api.tagartist.Artist
import net.developers.musicwiki.R
import net.developers.musicwiki.databinding.ListItemAlbBinding
import net.developers.musicwiki.ui.ArtistDetailActivity


class ArtistAdapter

    :RecyclerView.Adapter<ArtistViewHolder>(){

    val albs:ArrayList<Artist> = ArrayList()
lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
context=parent.context
        return ArtistViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item_alb,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {

   return albs.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        Log.i("image",albs.get(position).image.get(2).text)
        ListItemAlbBinding.bind(holder.itemView).apply {

            Glide.with(context).load(albs.get(position).image.get(2).text)
                .into(imageview)
            albumName.text=albs.get(position).name


                    imageview.setOnClickListener {
                        val intent = Intent(context, ArtistDetailActivity::class.java)
                        intent.putExtra("artistname",albs.get(position).name)
                        context.startActivity(intent)
                   }
                }

    }
    fun updatealb(albss:ArrayList<Artist>)
    {
        Log.i("resp",albss.size.toString())
        albs.clear();
        albs.addAll(albss)
        notifyDataSetChanged()
    }



}

class ArtistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {



}
