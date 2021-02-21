package net.developers.musicwiki.retrofit

import net.developers.api.albumdetails.AlbumDetails
import net.developers.api.artistDetails.ArtistDetails
import net.developers.api.artistalbum.ArtistAlbum
import net.developers.api.artistalbum.Topalbums
import net.developers.api.artisttracks.ArtistTracks
import net.developers.api.tags.Toptag
import net.developers.api.tagalbum.TagAlbums
import net.developers.api.tagartist.TagArtist
import net.developers.api.taginfo.TagInfo
import net.developers.api.tagtracks.TagTracks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface
{


    @GET("/2.0/?method=tag.getTopTags&format=json&api_key=ea935f89b50e034122b200e1670bfbb7")
        suspend fun getTags(

        ):Response<Toptag>


    @GET("/2.0/")
    suspend fun getTagInfo(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("tag")tag:String,
        @Query("api_key")apikey:String


    ):Response<TagInfo>

    @GET("/2.0/")
    suspend fun getTagAlbums(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("tag")tag:String,
        @Query("api_key")apikey:String


    ):Response<TagAlbums>

    @GET("/2.0/")
    suspend fun getTagArtist(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("tag")tag:String,
        @Query("api_key")apikey:String


    ):Response<TagArtist>

    @GET("/2.0/")
    suspend fun getTagTracks(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("tag")tag:String,
        @Query("api_key")apikey:String


    ):Response<TagTracks>

    @GET("/2.0/")
    suspend fun getArtistDetail(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("artist")artst:String,
        @Query("api_key")apikey:String


    ):Response<ArtistDetails>

    @GET("/2.0/")
    suspend fun getAlbumDetail(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("artist")artst:String,
        @Query("api_key")apikey:String,
        @Query("album")alb:String



    ):Response<AlbumDetails>

    @GET("/2.0/")
    suspend fun getArtistTopAlb(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("artist")artst:String,
        @Query("api_key")apikey:String


    ):Response<ArtistAlbum>


    @GET("/2.0/")
    suspend fun getArtistTopTracks(
        @Query("method")method:String,
        @Query("format")format:String,
        @Query("artist")artst:String,
        @Query("api_key")apikey:String


    ):Response<ArtistTracks>

}