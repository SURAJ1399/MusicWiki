package net.developers.musicwiki.repo

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import net.developers.musicwiki.retrofit.RetrofitInterface
import net.developers.musicwiki.util.Constants
import net.developers.musicwiki.util.SharedPref
import javax.inject.Inject

class globalRepo
@Inject
constructor(
    val retrofitInterface: RetrofitInterface,
    @ActivityContext
    val context: Context
){


      val sharedPref= SharedPref(context)

       suspend fun getTag()=retrofitInterface.getTags()


       suspend fun getTagInfo(tagname: String) =retrofitInterface
           .getTagInfo("tag.getinfo","json",tagname,Constants.apikey)

       suspend fun getTagAlbum()=retrofitInterface
         .getTagAlbums("tag.gettopalbums","json",sharedPref.getValue("tagname","tagname")
            ,Constants.apikey)

    suspend fun getTagArtist()=retrofitInterface
        .getTagArtist("tag.gettopartists","json",sharedPref.getValue("tagname","tagname")
            ,Constants.apikey)

    suspend fun getTagTracks()=retrofitInterface
        .getTagTracks("tag.gettoptracks","json",sharedPref.getValue("tagname","tagname")
            ,Constants.apikey)

    suspend fun getArtistDetail(artistname:String)=retrofitInterface
        .getArtistDetail("artist.getinfo","json",artistname
            ,Constants.apikey)

    suspend fun getAlbumdetail(artistname:String,albname:String)=retrofitInterface
        .getAlbumDetail("album.getinfo","json",artistname
            ,Constants.apikey,albname)

    suspend fun getArtistTopAlb(artistname:String)=retrofitInterface
        .getArtistTopAlb("artist.gettopalbums","json",artistname
            ,Constants.apikey)

    suspend fun getArtistTopTracks(artistname:String)=retrofitInterface
        .getArtistTopTracks("artist.gettoptracks","json",artistname
            ,Constants.apikey)

}