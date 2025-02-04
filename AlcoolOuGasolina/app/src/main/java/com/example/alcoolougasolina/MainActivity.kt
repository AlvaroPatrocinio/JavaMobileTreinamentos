package com.example.alcoolougasolina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editPrecoAlcool = findViewById<EditText>(R.id.editPrecoAlcool)
        val editPrecoGasolina = findViewById<EditText>(R.id.editPrecoGasolina)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textResultado = findViewById<TextView>(R.id.textResultado)

        btnCalcular.setOnClickListener {
            val precoAlcool = editPrecoAlcool.text.toString().toDoubleOrNull()
            val precoGasolina = editPrecoGasolina.text.toString().toDoubleOrNull()

            if (precoAlcool != null && precoGasolina != null && precoGasolina > 0) {
                val indice = precoAlcool / precoGasolina
                textResultado.text = if (indice < 0.7) "Álcool é mais vantajoso" else "Gasolina é mais vantajosa"
            } else {
                textResultado.text = "Insira valores válidos"
            }
        }
    }
}
