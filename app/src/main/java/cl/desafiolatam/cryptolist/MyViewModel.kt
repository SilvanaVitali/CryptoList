package cl.desafiolatam.cryptolist

import androidx.lifecycle.*
import cl.desafiolatam.cryptolist.model.Crypto
import cl.desafiolatam.cryptolist.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel: ViewModel() {

    private val repository = Repository()

    fun cryptoList(): LiveData<List<Crypto>> = repository.cryptoList


    init {
        getAllCryptos()
    }

    fun getAllCryptos() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.getAllCryptos()
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Crypto>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }



}