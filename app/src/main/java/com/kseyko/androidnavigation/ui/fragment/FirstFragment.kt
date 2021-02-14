package com.kseyko.androidnavigation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kseyko.androidnavigation.R
import com.kseyko.androidnavigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var fragmentFirstBinding: FragmentFirstBinding? = null

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        var binding = FragmentFirstBinding.bind(view)
        fragmentFirstBinding = binding
        binding = FragmentFirstBinding.bind(view)

        binding.login.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                binding.name.text.toString(),
                binding.surname.text.toString()
            )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentFirstBinding = null
    }
}