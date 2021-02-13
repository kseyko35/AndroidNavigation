package com.kseyko.androidnavigation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kseyko.androidnavigation.R
import com.kseyko.androidnavigation.databinding.FragmentSecondBinding
import com.kseyko.androidnavigation.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(R.layout.fragment_third) {

    private var param1: Int? = null
    private var param2: Boolean? = null
    private var param3: String = ""
    private var binding: FragmentThirdBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getInt("calculation")
            param2 = it.getBoolean("isCorrect")
            param3 = it.getString("name").toString()
        }

    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThirdBinding.bind(view)
        binding!!.answer.text="Mr/Mrs $param3, your answer is $param1 and your answer is $param2"
        binding!!.playAgain.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }
        binding!!.turnHome.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}