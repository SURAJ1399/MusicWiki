package net.developers.musicwiki.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.developers.api.taginfo.Tagb
import net.developers.musicwiki.repo.globalRepo


class GetTagInfoModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var tagInfo=MutableLiveData<Tagb>()

    fun fetchTagsInfo(tagname: String) = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getTagInfo(tagname).body().apply {
        
            tagInfo.postValue(this?.tag)
        }

    }}