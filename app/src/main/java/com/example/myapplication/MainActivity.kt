package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtWeight = findViewById<TextView>(R.id.txtWeight)
        val txtHeight = findViewById<TextView>(R.id.txtHeight)

        btnCalculate.setOnClickListener(){
            val weight:String = txtWeight.text.toString()
            val weightInKg:Double = weight.toDouble()
            val height:String = txtHeight.text.toString()
            val heightInM:Double = height.toDouble()

            val BMI:Double = calculateBMI(weightInKg,heightInM)

            if (BMI < 18.5) {
                imageView.setImageResource(R.drawable.under)
                textViewResult.text = "Result: " + "%.2f".format(BMI) + " Underweight"}
            else if (BMI <= 24.9) {
                imageView.setImageResource(R.drawable.normal)
                textViewResult.text = "Result: " + "%.2f".format(BMI) + " Normal"}
            else {
                imageView.setImageResource(R.drawable.over)
                textViewResult.text = "Result: " + "%.2f".format(BMI) + " Overweight"}
        }

        btnReset.setOnClickListener(){
            txtHeight.text = ""
            txtWeight.text = ""
            textViewResult.text = ""
            imageView.setImageResource(R.drawable.empty)
        }
    }

    fun calculateBMI(weightInKg: Double, heightInM: Double): Double {
        val BMI:Double = weightInKg / (heightInM*heightInM)
        return BMI
    }
}
