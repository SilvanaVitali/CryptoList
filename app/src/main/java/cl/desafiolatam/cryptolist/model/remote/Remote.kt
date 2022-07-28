package cl.desafiolatam.cryptolist.model.remote

import cl.desafiolatam.cryptolist.model.Crypto
import cl.desafiolatam.cryptolist.model.CryptoData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAPI {


    @GET("assets")
    suspend fun getAllCryptos(): Response<CryptoData>

//    @GET("assets/{id}")
//    suspend fun getCrypto(@Path("id") id: String): Response<Crypto>
}


class RetrofitClient {
    private constructor()

    companion object {
        val apiService: CryptoAPI by lazy {
            instance().create(CryptoAPI::class.java)
        }

        private const val BASE_URL = "https://api.coincap.io/v2/"
        fun instance() = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}