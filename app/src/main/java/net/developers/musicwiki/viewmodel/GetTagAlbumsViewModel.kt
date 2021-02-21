package net.developers.musicwiki.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.developers.api.tagalbum.Album
import net.developers.musicwiki.repo.globalRepo


class GetTagAlbumsViewModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var tagalbum=MutableLiveData<List<Album>>()

    fun fetchTagAlbum() = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getTagAlbum().body().apply {
        
            tagalbum.postValue(this?.albums?.album)

        }

    }}