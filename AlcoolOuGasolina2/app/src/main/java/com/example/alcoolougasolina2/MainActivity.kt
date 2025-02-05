package com.example.alcoolougasolina2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Função para iniciar os componentes da interface
        inicializarComponentesInterface()

        //Instanciar a função de calcular melhor preço
        btnCalcular.setOnClickListener { calcularMelhorPreco() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }

    //Função para validar o melhor preço
    private fun calcularMelhorPreco(){
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos (precoGasolina, precoAlcool)

        if (resultadoValidacao){

            val resultado = precoAlcool.toDouble()/precoGasolina.toDouble()

            if (resultado >= 0.7){
                textResultado.text = "Melhor utilizar Gasolina!"
            } else {
                textResultado.text = "Melhor utilizar o Álcool!"
            }




        }
    }

    //Função para validar se os campos estão preenchidos
    private fun validarCampos(pGasolina: String, pAlcool: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if(pAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do Álcool"
            return false;
        } else if (pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da Gasolina"
            return false;
        }

        return true;
    }


    //Função para iniciar os componentes criados
    private fun inicializarComponentesInterface() {
        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.editgasolina)

        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.editalcool)

        btnCalcular = findViewById(R.id.calcular)
        textResultado = findViewById(R.id.resultado)


    }


}

