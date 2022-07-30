package cl.desafiolatam.cryptolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.cryptolist.model.Crypto
import cl.desafiolatam.cryptolist.model.CryptoData
import cl.desafiolatam.cryptolist.model.Repository
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    private val repository = Repository()

    fun cryptoList(): LiveData<List<Crypto>> = repository.cryptoList


    init {
        getAllCryptos()
    }

    fun getAllCryptos() = viewModelScope.launch {
        repository.getAllCryptos()
    }




}