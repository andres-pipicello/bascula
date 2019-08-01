package com.github.bascula.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.bascula.Measurement
import com.github.bascula.R
import com.github.bascula.StandardMeasure.FAT
import com.github.bascula.StandardMeasure.WEIGHT
import com.github.bascula.StandardUnit.KG
import com.github.bascula.Unit
import kotlinx.android.synthetic.main.input_layout.*

class InputFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.input_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        inputAccept.setOnClickListener{
            val weight = inputWeight.text.toString().toFloat()
            val fat = inputFat.text.toString().toFloat()
            val weightMeasurement = Measurement(WEIGHT, weight, KG)
            val fatMeasurement = Measurement(FAT, fat, Unit.percentageOf(WEIGHT))
            println("$weightMeasurement, $fatMeasurement")
        }
    }
}