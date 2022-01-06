package com.striyank.unitconverter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.striyank.unitconverter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

     fun selectUnit(view : View){

        if (view is RadioButton){
            val checked = view.isChecked

            when(view.getId()){
                R.id.meter_to_decimeter -> {
                    if (checked){
                        navigate(10.0)
                    }
                }

                R.id.meter_to_centimeter -> {
                    if (checked){
                        navigate(100.0)
                    }
                }

                R.id.meter_to_millimeter -> {
                    if (checked){
                        navigate(1000.0)
                    }
                }

                R.id.meter_to_decameter -> {
                    if (checked){
                        navigate(0.1)
                    }
                }

                R.id.meter_to_hectometer -> {
                    if (checked){
                        navigate(0.01)
                    }
                }

                R.id.meter_to_kilometer -> {
                    if (checked){
                        navigate(0.001)
                    }
                }

                R.id.decimeter_to_centimeter -> {
                    if (checked){
                        navigate(10.0)
                    }
                }

                R.id.decimeter_to_millimeter -> {
                    if (checked){
                        navigate(100.0)
                    }
                }

                R.id.decimeter_to_meter -> {
                    if (checked){
                        navigate(0.1)
                    }
                }

                R.id.decimeter_to_decameter -> {
                    if (checked){
                        navigate(0.01)
                    }
                }

                R.id.decimeter_to_hectometer -> {
                    if (checked){
                        navigate(0.001)
                    }
                }

                R.id.decimeter_to_kilometer -> {
                    if (checked){
                        navigate(0.0001)
                    }
                }

                R.id.centimeter_to_millimeter -> {
                    if (checked){
                        navigate(10.0)
                    }
                }

                R.id.centimeter_to_decimeter -> {
                    if (checked){
                        navigate(0.1)
                    }
                }

                R.id.centimeter_to_meter -> {
                    if (checked){
                        navigate(0.01)
                    }
                }

                R.id.centimeter_to_decameter -> {
                    if (checked){
                        navigate(0.001)
                    }
                }

                R.id.centimeter_to_hectometer -> {
                    if (checked){
                        navigate(0.0001)
                    }
                }

                R.id.centimeter_to_kilometer -> {
                    if (checked){
                        navigate(0.00001)
                    }
                }
            }
        }
    }


     fun navigate(unitValue : Double){
        val enteredValue = binding.userInput.text.toString()
        val trueValue = enteredValue.toDoubleOrNull()

         //Log.v(TAG, "${unitValue}")
         //Log.v(TAG, "${trueValue}")


         if (trueValue == null)
             return
        val intent = Intent(this, ConvertActivity::class.java)
        intent.putExtra("selectedId", unitValue)
        intent.putExtra("user_input", trueValue)
         startActivity(intent)
    }
}