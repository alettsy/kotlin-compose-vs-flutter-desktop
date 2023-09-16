package infinite_list

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("posts")
    fun getPosts(@Query("_limit") limit: Int, @Query("_start") start: Int): Call<List<Post>>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private var apiService: API? = null
        fun getInstance(): API {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(API::class.java)
            }
            return apiService!!
        }
    }
}
