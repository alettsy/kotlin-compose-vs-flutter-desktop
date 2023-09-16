package infinite_list

import androidx.compose.runtime.mutableStateListOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostManager {
    private val _posts = mutableStateListOf<Post>()
    val posts: List<Post> get() = _posts
    private val apiService = API.getInstance()
    private val max = 10
    private var currentIndex = -10

    init {
        _posts.clear()
        getPosts()
    }

    fun getPosts() {
        currentIndex += max
        apiService.getPosts(max, currentIndex).enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("failed to get posts")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                response.body()?.let { _posts.addAll(it) }
            }
        })
    }
}
