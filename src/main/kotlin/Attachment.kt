import org.w3c.dom.Document

data class AudioAttachment(
    val audio: Audio
) : Attachment {
    override val type = "audio"
}

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val date: Int
)

data class DocAttachment(
    val doc: Document
) : Attachment {
    override val type = "doc"
}

data class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val date: Int,
    val type: Int
)

data class LinkAttachment(
    val link: Link
) : Attachment {
    override val type = "link"
}

data class Link(
    val url: String,
    val title: String,
    val caption: String?,
    val description: String
)

data class PhotoAttachment(
    val photo: Photo
) : Attachment {
    override val type = "photo"
}

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int
)

data class VideoAttachment(
    val video: Video

) : Attachment {
    override val type = "video"
}

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int
)

