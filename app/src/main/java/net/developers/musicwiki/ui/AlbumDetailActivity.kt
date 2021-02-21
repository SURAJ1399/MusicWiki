package net.developers.musicwiki.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.android.rvtutorial.TagsAdapter
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.activity_album_detail.*
import kotlinx.android.synthetic.main.activity_album_detail.desc
import kotlinx.android.synthetic.main.activity_main.tagsRecyclerView
import net.developers.api.tags.Tag
import net.developers.musicwiki.R
import net.developers.musicwiki.viewmodel.GetAlbumDetailViewModel

@AndroidEntryPoint
class AlbumDetailActivity : AppCompatActivity() {
    lateinit var getAlbumDetailViewModel: GetAlbumDetailViewModel
    lateinit var Albumname:String
    lateinit var artistname:String
    lateinit var tagsAdapter:TagsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_album_detail)
        Albumname=intent.getStringExtra("albumname");
        artistname=intent.getStringExtra("artistname");
        getAlbumDetailViewModel = ViewModelProvider(this).get(GetAlbumDetailViewModel::class.java)
        getAlbumDetailViewModel.fetchAlbumDetail(artistname,Albumname)
        getAlbumDetailViewModel.fetchTags()

        getAlbumDetailViewModel.albumdetail.observe({lifecycle}){

            toolbar.title=Albumname+" By "+artistname

            desc.text=it?.wiki?.summary

            Glide.with(this).load(it.image.get(3).text)
                .into(imageview)

        }
        tagsAdapter = TagsAdapter(2)


        tagsRecyclerView?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        tagsRecyclerView?.adapter = tagsAdapter

        getAlbumDetailViewModel.tags.observe({lifecycle}){
            Log.i("tags",it.toString())
            tagsAdapter.updatetag(it as ArrayList<Tag>)
        }


    }
}