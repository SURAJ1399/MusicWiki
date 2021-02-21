package net.developers.api.albumdetails

data class Track(
    val attr: Attr,
    val artist: Artist,
    val duration: String,
    val name: String,
    val streamable: Streamable,
    val url: String
)