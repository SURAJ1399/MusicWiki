package net.developers.musicwiki.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.developers.api.tagtracks.Track
import net.developers.musicwiki.repo.globalRepo


class GetTagTracksViewModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var tagtracks=MutableLiveData<List<Track>>()

    fun fetchTagTracks() = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getTagTracks().body().apply {
        
            tagtracks.postValue(this?.tracks?.track)

        }

    }}