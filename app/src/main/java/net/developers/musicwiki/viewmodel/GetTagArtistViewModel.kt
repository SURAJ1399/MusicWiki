package net.developers.musicwiki.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.developers.api.tagartist.Artist
import net.developers.musicwiki.repo.globalRepo


class GetTagArtistViewModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var tagartist=MutableLiveData<List<Artist>>()

    fun fetchTagArtist() = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getTagArtist().body().apply {

            Log.i("artist", this?.topartists?.artist.toString())
            tagartist.postValue(this?.topartists?.artist)

        }

    }}