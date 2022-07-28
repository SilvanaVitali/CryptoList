package cl.desafiolatam.cryptolist.model.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatam.cryptolist.model.Crypto

@Database(entities = [Crypto::class], version = 1)
abstract class CryptoDB: RoomDatabase() {
    abstract fun cryptoDao(): CryptoDAO
}

class CryptoApplication: Application() {

    companion object {
        var cryptoDatabase: CryptoDB? = null
    }

    override fun onCreate() {
        super.onCreate()

        cryptoDatabase = Room.databaseBuilder(this,CryptoDB::class.java, "crypto_db").build()
    }
}