package cl.desafiolatam.cryptolist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.cryptolist.databinding.ItemCryptoBinding
import cl.desafiolatam.cryptolist.model.Crypto
import com.squareup.picasso.Picasso
import java.sql.Date
import java.text.SimpleDateFormat


class CryptoAdapter: RecyclerView.Adapter<CryptoVH>() {

    private val cryptoList = mutableListOf<Crypto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoVH {
        val binding = ItemCryptoBinding.inflate(LayoutInflater.from(parent.context))
        return CryptoVH(binding)
    }

    override fun onBindViewHolder(holder: CryptoVH, position: Int) {
        holder.bind(cryptoList[position])
    }

    override fun getItemCount() = cryptoList.size

    fun update(list: List<Crypto>) {
        cryptoList.clear()
        cryptoList.addAll(list)
        notifyDataSetChanged()
    }
}

class CryptoVH(val binding: ItemCryptoBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(crypto: Crypto){
        binding.tvNombreCrypto.text = crypto.symbol
        binding.tvValorCrypto.text = String.format("USD$ ${num(crypto.priceUsd)}")
        Picasso.get().load(getImage(crypto.symbol)).into(binding.ivCrypto)

        this.itemView.setOnClickListener {

           val action = ListFragmentDirections.actionListFragmentToDetailFragment(crypto)
            Navigation.findNavController(it).navigate(action)
        }
    }

    companion object{
        fun num(priceUsd: String): String{
            var price = priceUsd.toFloat()
            var formatPrice = String.format("%.6f", price)
            return formatPrice
        }

        fun getImage(symbol: String) = "https://static.coincap.io/assets/icons/${symbol.toLowerCase()}@2x.png"

        fun convertLongToTime (time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
            return  format.format(date)
        }
    }


}

