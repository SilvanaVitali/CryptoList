package cl.desafiolatam.cryptolist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cl.desafiolatam.cryptolist.databinding.FragmentDetailBinding
import cl.desafiolatam.cryptolist.model.Crypto
import cl.desafiolatam.cryptolist.view.CryptoVH.Companion.convertLongToTime
import cl.desafiolatam.cryptolist.view.CryptoVH.Companion.getImage
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var crypto: Crypto

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater)

        crypto = DetailFragmentArgs.fromBundle(requireArguments()).crypto

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            tvTimestamp.text = convertLongToTime(crypto.timestamp)
            tvSymbol.text = crypto.symbol
            tvName.text = crypto.name
            tvPrice.text = String.format("USD$ ${CryptoVH.num(crypto.priceUsd)}")
            percent24hr.text = "${CryptoVH.num(crypto.changePercent24Hr)}%"
            percent24hr.setTextColor(CryptoVH.textColor(crypto.changePercent24Hr))
            tvVolume.text = String.format("VolumeUsd24Hr \n ${crypto.volumeUsd24Hr}")
            tvSupply.text = String.format("Supply \n ${crypto.supply}")
            tvMarketcap.text = String.format("Marketcap \n ${crypto.marketCapUsd}")
            tvExplorer.text = crypto.explorer
            constraintDetalle.setBackgroundResource(CryptoVH.background(crypto.changePercent24Hr))
            Picasso.get().load(getImage(crypto.symbol))
                .into(ivSymbol)
        }
    }
}

