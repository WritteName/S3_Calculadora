package com.example.s3_calculadora

import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var optSelect: String = ""
    private var resultado: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val OpA = findViewById<EditText>(R.id.etValA)
        val OpB = findViewById<EditText>(R.id.etValB)
        val OpC = findViewById<EditText>(R.id.etValC)
        val BtnCalc = findViewById<Button>(R.id.btnCalcular)
        val Operadores = findViewById<Spinner>(R.id.spOperador)
        val tvResult = findViewById<TextView>(R.id.tvResultado)

        Operadores.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                optSelect = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Nada
            }
        }

        BtnCalc.setOnClickListener {
            val A = OpA.text.toString().trim().toDoubleOrNull()
            val B = OpB.text.toString().trim().toDoubleOrNull()
            val C = OpC.text.toString().trim().toDoubleOrNull()

            if (A != null && B != null && C != null) {
                when (optSelect) {
                    "Sumar" -> {
                        resultado = A + B + C
                        tvResult.text = "Resultado: $resultado"
                    }

                    "Restar" -> {
                        resultado = A - B - C
                        tvResult.text = "Resultado: $resultado"
                    }

                    "Multiplicar" -> {
                        resultado = A * B * C
                        tvResult.text = "Resultado: $resultado"
                    }

                    "Dividir" -> {
                        if (A != 0.0 && B != 0.0 && C != 0.0) {
                            resultado = (A / B) / C
                            tvResult.text = "Resultado: $resultado"
                        } else {
                            tvResult.text = "No se puede dividir entre 0"
                        }
                    }

                    else -> {
                        tvResult.text = ""
                    }
                }
            } else {
                tvResult.text = "Datos Incorrectos"
            }
        }
    }
}