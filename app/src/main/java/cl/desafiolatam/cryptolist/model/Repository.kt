package cl.desafiolatam.cryptolist.model

import android.util.Log

import cl.desafiolatam.cryptolist.model.remote.RetrofitClient



class Repository {

    private val TAG = "Repository"

    suspend fun getAllCryptos(): List<Crypto> {
        var cryptoList = mutableListOf<Crypto>()

        val response = RetrofitClient.apiService.getAllCryptos()

        when(response.isSuccessful){
            true -> {
                if (response.body() != null) {
                    cryptoList.addAll(response.body()!!.listCrypto)
                } else {
                    Log.d(TAG, "getAllCryptos: body is null")
                }
            }
            false -> {
                Log.d(TAG, "getAllCryptos: error de code ${response.code()}")
            }
        }
        return cryptoList
    }







//    fun getAllCryptos(): ArrayList<Crypto> {
//
//        val cryptoList = ArrayList<Crypto>()
//
//        val service = CryptoAPI.RetrofitClient.instance()
//        val call = service.getAllCryptos()
//
//        call.enqueue(object : Callback<ArrayList<Crypto>> {
//            override fun onResponse(
//                call: Call<ArrayList<Crypto>>,
//                response: Response<ArrayList<Crypto>>
//            ) {
//                response.body()!!.map {
//                    Log.d(TAG, "onResponse: $it")
//                    cryptoList.addAll(response.body()!!)
//                }
//            }
//            override fun onFailure(call: Call<ArrayList<Crypto>>, t: Throwable) {
//                Log.d(TAG, "Error: no pudimos recuperar los datos desde el api")
//            }
//        })
//        return cryptoList
//    }



}