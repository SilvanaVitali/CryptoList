package cl.desafiolatam.cryptolist.model

import com.google.gson.annotations.SerializedName

//class CryptoData(val cryptoList: List<Crypto>)
//class CryptoData: List<Crypto>

data class CryptoData(

	@field:SerializedName("data")
	val listCrypto:  List<Crypto>,

	@field:SerializedName("timestamp")
	val timestamp: Long
)


data class Crypto(

	@field:SerializedName("symbol")
	val symbol: String,

	@field:SerializedName("volumeUsd24Hr")
	val volumeUsd24Hr: String,

	@field:SerializedName("marketCapUsd")
	val marketCapUsd: String,

	@field:SerializedName("priceUsd")
	val priceUsd: String,

	@field:SerializedName("vwap24Hr")
	val vwap24Hr: String,

	@field:SerializedName("changePercent24Hr")
	val changePercent24Hr: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("explorer")
	val explorer: String,

	@field:SerializedName("rank")
	val rank: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("maxSupply")
	val maxSupply: String,

	@field:SerializedName("supply")
	val supply: String
)
