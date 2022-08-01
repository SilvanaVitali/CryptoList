package cl.desafiolatam.cryptolist.model

import android.util.Log
import androidx.lifecycle.LiveData
import cl.desafiolatam.cryptolist.model.local.CryptoApplication
import cl.desafiolatam.cryptolist.model.remote.RetrofitClient
import kotlinx.coroutines.flow.Flow

class Repository {

    private val TAG = "Repository"
    private val cryptoDao = CryptoApplication.cryptoDatabase!!.cryptoDao()
    val cryptoList = cryptoDao.getAllCryptos()

    suspend fun getAllCryptos(){
        val response = RetrofitClient.apiService.getAllCryptos()

        when(response.isSuccessful){
            true -> {
                if (response.body() != null) {
                    cryptoDao.insert(response.body()!!.listCrypto.map {
                        it.copy(timestamp = response.body()!!.timestamp) })
                } else {
                    Log.d(TAG, "getAllCryptos: body is null")
                }
            }
            false -> {
                Log.d(TAG, "getAllCryptos: error de code ${response.code()}")
            }
        }
    }

    fun searchDatabase(searchQuery: String): Flow<List<Crypto>> {
        return cryptoDao.searchDatabase(searchQuery)
    }









}