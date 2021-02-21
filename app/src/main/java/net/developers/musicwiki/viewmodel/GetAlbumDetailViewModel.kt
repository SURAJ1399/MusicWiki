package net.developers.musicwiki.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.developers.api.albumdetails.Album
import net.developers.api.tags.Tag
import net.developers.musicwiki.repo.globalRepo


class GetAlbumDetailViewModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var albumdetail=MutableLiveData<Album>()

    fun fetchAlbumDetail(artistname:String,albumname:String) = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getAlbumdetail(artistname,albumname).body().apply {

Log.i("albdet",this.toString())
            albumdetail.postValue(this?.album)

        }

    }
    var tags=MutableLiveData<List<Tag>>()

    fun fetchTags() = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getTag().body().apply {

            tags.postValue(this?.toptags?.tag)
        }

    }


}
