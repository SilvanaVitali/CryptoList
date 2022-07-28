package cl.desafiolatam.cryptolist.model

import com.google.gson.annotations.SerializedName

data class Crypto2(

	@field:SerializedName("datos")
	val datos: Datos? = null,

	@field:SerializedName("marca de tiempo")
	val marcaDeTiempo: Long? = null
)

data class Datos(

	@field:SerializedName("volumeUsd24Hr")
	val volumeUsd24Hr: String? = null,

	@field:SerializedName("suministro")
	val suministro: String? = null,

	@field:SerializedName("rango")
	val rango: String? = null,

	@field:SerializedName("marketCapUsd")
	val marketCapUsd: String? = null,

	@field:SerializedName("símbolo")
	val sMbolo: String? = null,

	@field:SerializedName("priceUsd")
	val priceUsd: String? = null,

	@field:SerializedName("vwap24Hr")
	val vwap24Hr: String? = null,

	@field:SerializedName("changePercent24Hr")
	val changePercent24Hr: String? = null,

	@field:SerializedName("explorer")
	val explorer: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("maxSupply")
	val maxSupply: String? = null,

	@field:SerializedName("nombre")
	val nombre: String? = null
)
