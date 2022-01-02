package com.striyank.unitconverter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.striyank.unitconverter.databinding.ActivityConvertBinding
import java.text.NumberFormat


class ConvertActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConvertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConvertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener { convertValue() }

        binding.retakeButton.setOnClickListener { navigateBack() }


    }

    private fun convertValue() {
        val finalResult = calculate()
        binding.resultText.text = getString(R.string.result, finalResult)
    }

     fun calculate() : String? {
         val sentUnitValue = intent?.extras?.getDouble("selectedId")
         val sentUserInput = intent?.extras?.getDouble("user_input")

        var result = sentUnitValue?.times(sentUserInput!!)
         val round = binding.roundUpValue.isChecked
         if (round)
             result = kotlin.math.ceil(result!!)
         val formattedResult = NumberFormat.getNumberInstance().format(result)
        return formattedResult
    }

    fun navigateBack(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}