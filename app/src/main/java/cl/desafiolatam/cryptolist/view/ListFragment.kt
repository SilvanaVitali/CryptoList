package cl.desafiolatam.cryptolist.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import cl.desafiolatam.cryptolist.MyViewModel
import cl.desafiolatam.cryptolist.databinding.FragmentListBinding
import com.google.android.material.textfield.TextInputEditText

class ListFragment: Fragment() {

    private val TAG = "ListFragment"
    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<MyViewModel>()
    private lateinit var adapter: CryptoAdapter
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var textInput: TextInputEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fileNameSP = "cl.desafiolatam.cryptolist"
        sharedPreferences = context.getSharedPreferences(fileNameSP, Context.MODE_PRIVATE)

    }

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
        textInput = binding.nameInput
        var  name = sharedPreferences.getString("User","")
        Log.d(TAG, "$name")
        binding.nameInput.setText(name)

        adapter = CryptoAdapter()
        binding.rvCryptoList.adapter = adapter
        binding.rvCryptoList.layoutManager = GridLayoutManager(context,1)

        binding.nameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                sharedPreferences.edit().putString("User",s.toString()).apply()
                var  name = sharedPreferences.getString("User","")
                Log.d(TAG, "2do $name")
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun registerObserver() {
        viewModel.cryptoList().observe(viewLifecycleOwner) {
            it?.let {
                adapter.update(it)
            }
        }
    }



}