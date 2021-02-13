package com.kseyko.androidnavigation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kseyko.androidnavigation.R
import com.kseyko.androidnavigation.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {

    private val args: SecondFragmentArgs by navArgs()
    private var binding: FragmentSecondBinding? = null
    private var calculation : Int = 0

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSecondBinding.bind(view)
        var isCorrect : Boolean
        binding.welcome.text =  if(args.name.isEmpty() )"Welcome again!"
                                else  "Welcome ${args.name} ${args.surname}"

        binding.calculation.text =calculateNumber()

        binding.calculate.setOnClickListener {
            isCorrect = calculation.toString() == binding.thirdNumber.text.toString()
            val bundle = bundleOf("calculation" to calculation,
                "name" to args.name,
                "isCorrect" to isCorrect)
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }

    }

    private fun calculateNumber(): String {
        val firstnumber = (1..10).random()
        val secondNumber = (1..10).random()
        val operationNumber = (0..3).random()
        val operation = arrayOf('+', '*', '/', '-')
        calculation = when (operation[operationNumber]) {
            '+' -> firstnumber + secondNumber
            '*' -> firstnumber * secondNumber
            '/' -> firstnumber / secondNumber
            '-' -> firstnumber - secondNumber
            else -> 999
        }
        return "$firstnumber ${operation[operationNumber]} $secondNumber = ?"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

