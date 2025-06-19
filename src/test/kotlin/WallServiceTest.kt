import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.Int
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addNewPost() {
        // arrange
        val newPost = Post(
            id = 0,
            ownerId = 1001,
            fromId = 1002,
            date = 1749576224,
            text = "Мир, дружба, жвачка",
            friendsOnly = true,
            postType = "post",
            isPinned = false,
            isFavorite = true,
            comments = Comments(3, true, true, true),
            likes = Likes(30, true),
            reposts = Reposts(24, true),
            views = Views(50)
        )

        //act
        val result: Post = WallService.add(
            post = newPost
        )
        val id = result.id

        //assert
        assertEquals(1, id)
    }

    @Test
    fun UpdateExisting() {
        // arrange
        WallService.add(Post(
            id = 0,
            ownerId = 1001,
            fromId = 1002,
            date = 1749576224,
            text = "Мир, дружба, жвачка",
            friendsOnly = true,
            postType = "post",
            isPinned = false,
            isFavorite = true,
            comments = Comments(3, true, true, true),
            likes = Likes(30, true),
            reposts = Reposts(24, true),
            views = Views(50)
        ))
        val updatePost = Post(
            id = 1,
            ownerId = 1001,
            fromId = 1002,
            date = 1749576224,
            text = "Мир, дружба, жвачка",
            friendsOnly = true,
            postType = "post",
            isPinned = false,
            isFavorite = true,
            comments = Comments(3, true, true, true),
            likes = Likes(30, true),
            reposts = Reposts(24, true),
            views = Views(50))

        //act
        val result = WallService.update(updatePost)

        //assert
        assertTrue(result)
    }

    @Test
    fun NotUpdateExisting() {
        // arrange
        WallService.add(Post(
            id = 0,
            ownerId = 1001,
            fromId = 1002,
            date = 1749576224,
            text = "Мир, дружба, жвачка",
            friendsOnly = true,
            postType = "post",
            isPinned = false,
            isFavorite = true,
            comments = Comments(3, true, true, true),
            likes = Likes(30, true),
            reposts = Reposts(24, true),
            views = Views(50)
        ))
        val updatePost = Post(
            id = 2,
            ownerId = 1001,
            fromId = 1002,
            date = 1749576224,
            text = "Мир, дружба, жвачка",
            friendsOnly = true,
            postType = "post",
            isPinned = false,
            isFavorite = true,
            comments = Comments(3, true, true, true),
            likes = Likes(30, true),
            reposts = Reposts(24, true),
            views = Views(50))

        //act
        val result = WallService.update(updatePost)

        //assert
        assertFalse(actual = result)
    }
}