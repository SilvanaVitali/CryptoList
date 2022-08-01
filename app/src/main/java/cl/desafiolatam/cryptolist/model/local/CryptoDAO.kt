package cl.desafiolatam.cryptolist.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.desafiolatam.cryptolist.model.Crypto
import kotlinx.coroutines.flow.Flow


@Dao
interface CryptoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cryptoList: List<Crypto>)

    @Query("SELECT * FROM crypto")
    fun getAllCryptos(): LiveData<List<Crypto>>

    @Query("SELECT * FROM crypto WHERE name LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Crypto>>

}