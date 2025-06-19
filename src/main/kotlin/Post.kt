data class Post(
    val id: Int = 0,
    val ownerId: Int = 1001,
    val fromId: Int = 1002,
    val date: Int = 1749576224,
    val text: String = "Мир, дружба, жвачка",
    val friendsOnly: Boolean = true,
    val postType: String = "post",
    val isPinned: Boolean = false,
    val isFavorite: Boolean = true,
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views
)

data class Comments(
    val count: Int = 3,
    val canPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Likes(
    val count: Int = 30,
    val userLikes: Boolean = true
)

data class Reposts(
    val count: Int = 24,
    val userReposted: Boolean = true
)

data class Views(
    val count: Int = 50
)

object WallService {
    private var idNumber: Int = 0
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        idNumber ++
        val newPost = post.copy(id = idNumber)
        posts += newPost
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (newPost.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        idNumber = 0
    }
}