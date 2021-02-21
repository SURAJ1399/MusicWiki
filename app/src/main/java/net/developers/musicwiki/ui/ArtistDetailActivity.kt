package net.developers.musicwiki.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.rvtutorial.TagsAdapter
import com.example.android.rvtutorial.TopAlbumAdapter
import com.example.android.rvtutorial.TopTrackAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_artist_detail.*
import kotlinx.android.synthetic.main.activity_artist_detail.tagsRecyclerView
import net.developers.api.artistalbum.Album
import net.developers.api.artisttracks.Track
import net.developers.api.tags.Tag
import net.developers.musicwiki.R
import net.developers.musicwiki.viewmodel.GetArtistDetailViewModel

@AndroidEntryPoint
class ArtistDetailActivity : AppCompatActivity() {
    lateinit var getArtistDetailViewModel: GetArtistDetailViewModel
    lateinit var artistname:String
    lateinit var tagsAdapter:TagsAdapter
lateinit var  topAlbumAdapter: TopAlbumAdapter
    lateinit var topTrackAdapter: TopTrackAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_artist_detail)
        artistname = intent.getStringExtra("artistname");
        getArtistDetailViewModel = ViewModelProvider(this).get(GetArtistDetailViewModel::class.java)

        getArtistDetailViewModel.fetchArtistDetail(artistname)
        getArtistDetailViewModel.fetchTags()
        getArtistDetailViewModel.fetchArtistTopAlb(artistname)
        getArtistDetailViewModel.fetchArtistTopTrack(artistname)

        getArtistDetailViewModel.artistdetail.observe({ lifecycle }) {

            name.text = it.name
            followers.text = it.stats.listeners
            playcount.text = it.stats.playcount
            desc.text = it.bio.summary


        }

        tagsAdapter = TagsAdapter(2)
        tagsRecyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        tagsRecyclerView?.adapter = tagsAdapter

        getArtistDetailViewModel.tags.observe({ lifecycle }) {
            Log.i("tags", it.toString())
            tagsAdapter.updatetag(it)

        }

        topAlbumAdapter = TopAlbumAdapter()
        topalbRecyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        topalbRecyclerView?.adapter = topAlbumAdapter

            getArtistDetailViewModel.artistTopalbdetail.observe({ lifecycle }) {
                topAlbumAdapter.updatealb(it as ArrayList<Album>)
            }


        topTrackAdapter = TopTrackAdapter()
        toptracksRecyclerView?.layoutManager =LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        toptracksRecyclerView?.adapter = topTrackAdapter
        getArtistDetailViewModel.artistToptrackdetail.observe({ lifecycle }) {
            topTrackAdapter.updatealb(it as ArrayList<Track>)
        }


    }

}