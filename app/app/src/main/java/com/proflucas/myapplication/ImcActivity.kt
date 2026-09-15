package com.proflucas.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class ImcActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_imc)

        val txtPeso = findViewById<EditText>(R.id.txtPeso)
        val txtAltura = findViewById<EditText>(R.id.txtAltura)

        val labelImc = findViewById<TextView>(R.id.labelImc)
        val btnCalcularImc = findViewById<Button>(R.id.btnCalcularImc)

        btnCalcularImc.setOnClickListener {

            val peso = txtPeso.text.toString().toDoubleOrNull()
            val altura = txtAltura.text.toString().toDoubleOrNull()

            if (peso == null || altura == null || altura <= 0) {
                labelImc.text = "Dados inválidos"
                return@setOnClickListener
            }

            val imc = peso / (altura * altura)

            labelImc.text = "IMC: %.2f".format(imc)
        }

        val btnSwitchToMedia =
            findViewById<Button>(R.id.btnSwitchToMedia)

        btnSwitchToMedia.setOnClickListener {

            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }
    }
}