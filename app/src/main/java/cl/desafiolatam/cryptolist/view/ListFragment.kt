package cl.desafiolatam.cryptolist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.desafiolatam.cryptolist.MyViewModel
import cl.desafiolatam.cryptolist.databinding.FragmentListBinding

class ListFragment: Fragment() {

    private val TAG = "ListFragment"
    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)

        registerObserver()
        return binding.root
    }

    private fun registerObserver() {
        viewModel.cryptoList().observe(viewLifecycleOwner) {
            Log.d(TAG, "registerObserver: ${it[0]}")
        }
    }
}