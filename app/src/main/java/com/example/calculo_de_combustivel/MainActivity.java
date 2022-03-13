package com.example.calculo_de_combustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.controls.actions.BooleanAction;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);



    }

    public void calcularPreco(View view){
        //capturar informacoes

        String precoAlcool      = editPrecoAlcool.getText().toString();
        String precoGasolina    = editPrecoGasolina.getText().toString();

        //verificar
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if( camposValidados ){
            //convertendo
            double valorAlcool = Double.parseDouble( precoAlcool );
            double valorGasolina = Double.parseDouble( precoGasolina );

            //calculo
            double resultado = valorAlcool/valorGasolina;
            if (resultado >= 0.7){
                textResultado.setText("Gasolina é a melhor opção ");
            }else if(resultado <= 0.7){
                textResultado.setText("Alcool é a melhor opção ");
            }

        }else{
            textResultado.setText("Preencha os preços primeiro!");

    }}

    Boolean validarCampos (String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){

            camposValidados = false;
        }
        if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
        }
}