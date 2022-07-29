package cl.desafiolatam.cryptolist.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import cl.desafiolatam.cryptolist.MyViewModel
import cl.desafiolatam.cryptolist.databinding.FragmentListBinding
import cl.desafiolatam.cryptolist.model.Crypto

class ListFragment: Fragment() {

    private val TAG = "ListFragment"
    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<MyViewModel>()
    private lateinit var adapter: CryptoAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)

        initView()
        registerObserver()


        return binding.root
    }

    private fun initView() {
        adapter = CryptoAdapter()
        binding.rvCryptoList.adapter = adapter
        binding.rvCryptoList.layoutManager = GridLayoutManager(context,1)
    }

    private fun registerObserver() {
        viewModel.cryptoList().observe(viewLifecycleOwner) {
            it?.let {
                adapter.update(it)
            }
        }
    }

//companion object {
//
//
//    interface OnCryptoSelectedListener {
//        fun onCryptoSelected(crypto: Crypto)
//    }
//}



}