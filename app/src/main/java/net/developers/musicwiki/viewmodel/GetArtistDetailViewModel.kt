package net.developers.musicwiki.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.developers.api.artistalbum.Album
import net.developers.api.artisttracks.Track
import net.developers.api.tags.Tag
import net.developers.musicwiki.repo.globalRepo


class GetArtistDetailViewModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var artistdetail=MutableLiveData<net.developers.api.artistDetails.Artist>()
    var artistTopalbdetail=MutableLiveData<List<Album>>()
    var artistToptrackdetail=MutableLiveData<List<Track>>()


    fun fetchArtistDetail(artistname:String) = CoroutineScope(Dispatchers.IO)
        .launch {

        globalRepo.getArtistDetail(artistname).body().apply {


            artistdetail.postValue(this?.artist)

        }
    }

        fun fetchArtistTopAlb(artistname: String) = CoroutineScope(Dispatchers.IO)
            .launch {

            globalRepo.getArtistTopAlb(artistname).body().apply {

                Log.i("topalb", this.toString()+artistname)

                artistTopalbdetail.postValue(this?.topalbums?.album)

            }
        }


        fun fetchArtistTopTrack(artistname: String) = CoroutineScope(Dispatchers.IO)
            .launch {

        globalRepo.getArtistTopTracks(artistname).body().apply {


            artistToptrackdetail.postValue(this?.toptracks?.track)

        }
    }


            var tags = MutableLiveData<List<Tag>>()

            fun fetchTags() = CoroutineScope(Dispatchers.IO).
            launch {

                globalRepo.getTag().body().apply {

                    tags.postValue(this?.toptags?.tag)
                }

            }



}
