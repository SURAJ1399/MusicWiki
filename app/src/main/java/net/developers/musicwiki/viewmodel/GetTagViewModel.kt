package net.developers.musicwiki.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.developers.api.tags.Tag
import net.developers.musicwiki.repo.globalRepo


class GetTagViewModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var tags=MutableLiveData<List<Tag>>()

    fun fetchTags() = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getTag().body().apply {
        
            tags.postValue(this?.toptags?.tag)
        }

    }}