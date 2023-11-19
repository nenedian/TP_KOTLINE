import retrofit2.Call
import retrofit2.http.GET


interface Api_Users {

    @GET("Users")

    fun getUsers(): Call<List<User>>
}