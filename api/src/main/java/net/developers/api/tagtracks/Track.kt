package net.developers.api.tagtracks

data class Track(
    val attr: AttrX,
    val artist: Artist,
    val duration: String,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: Streamable,
    val url: String
)