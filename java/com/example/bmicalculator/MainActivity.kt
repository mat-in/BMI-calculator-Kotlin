package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250

        binding.weightPicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }
        binding.heightPicker.setOnValueChangedListener {_,_,_ ->
            calculateBMI()
        }
        }
    private fun calculateBMI() {
        var height = binding.heightPicker.value
        var doubleheight = height.toDouble() / 100

        var weight = binding.weightPicker.value

        var bmi = weight.toDouble() / (doubleheight * doubleheight)

        binding.results.text = String.format("Your BMI is: %.2f", bmi)
        binding.health.text = String.format("Considered: %s", healthy(bmi))
    }

    private fun healthy(bmi: Double): String {
        if (bmi < 18.5)
            return "Underweight"
        if (bmi < 25.0)
            return "Healthy"
        if (bmi < 30.0)
            return "Overweight"

        return "Obese"
    }
}

