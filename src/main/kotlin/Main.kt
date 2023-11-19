import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://655a1b7b6981238d054d202a.mockapi.io/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    val api = retrofit.create(Api_Users::class.java)

    val response = api.getUsers().execute()

    if (response.isSuccessful) {

        val bod =  response.body()
        bod?.forEachIndexed { index, user ->
            println("User : ${index + 1} | name : ${user.name} | email : ${user.email} | password : ${user.password}")
        }
    } else {
        println("Erreur d'acces a l'API : ${response.code()}")
    }
}
