package cl.desafiolatam.cryptolist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cl.desafiolatam.cryptolist.databinding.FragmentDetailBinding
import cl.desafiolatam.cryptolist.model.Crypto
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    //private var crypto : Crypto? = null
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
            tvSymbol.text = crypto.symbol
            tvName.text = crypto.name
            tvPrice.text = crypto.priceUsd
            tvSupply.text = crypto.supply
            tvMarketcap.text = crypto.marketCapUsd
            Picasso.get().load("https://static.coincap.io/assets/icons/${crypto.symbol.toLowerCase()}@2x.png")
                .into(ivSymbol)
        }
    }
}

/*

                                    android:id="@+id/tvTimestamp"
                                    android:id="@+id/ivSymbol"
 */