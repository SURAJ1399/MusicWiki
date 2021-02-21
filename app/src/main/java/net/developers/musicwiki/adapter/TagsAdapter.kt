package com.example.android.rvtutorial




import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import net.developers.api.artistalbum.Album
import net.developers.api.tags.Tag
import net.developers.musicwiki.R
import net.developers.musicwiki.databinding.ListItemTagBinding
import net.developers.musicwiki.ui.HomeActivity
import net.developers.musicwiki.util.SharedPref


class TagsAdapter(viewt:Int)

    :RecyclerView.Adapter<TagViewHolder>(){

    val tags:ArrayList<Tag> = ArrayList()
 lateinit var context:Context
    var displaysize=10000;
    val viewt=viewt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
context=parent.context
        if(viewt==1)
        return TagViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item_tag,
                        parent,
                        false
                )
        )
        else
            return TagViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                    R.layout.list_item_tagb,
                    parent,
                    false
                )
            )

    }

    override fun getItemCount(): Int {
if(displaysize>tags.size)
   return tags.size
        else
    return  displaysize
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {

                ListItemTagBinding.bind(holder.itemView).apply {

                    tagname.text=tags.get(position).name
                    tagname.setOnClickListener {
                        val sharedPref=SharedPref(context)
                        sharedPref.setValue("tagname","tagname",tags.get(position).name)
                        val intent = Intent(context, HomeActivity::class.java)
                        intent.putExtra("tagname",tags.get(position).name)
                        context.startActivity(intent)
                   }
                }

    }
    fun updatetag(tagss: List<Tag>)
    {
        Log.i("resp",tagss.size.toString())
        tags.clear();
        tags.addAll(tagss)
        notifyDataSetChanged()
    }

    fun setDisplaycount(numberofentry:Int)
    {
        displaysize=numberofentry
        notifyDataSetChanged()
    }


}

class TagViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {



}

