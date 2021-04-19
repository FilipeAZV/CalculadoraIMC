package com.SantosFlores.Gabriela;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {
    // Atributos (variáveis)
    EditText edtAltura, edtPeso;
    RadioButton rbSexoF;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
        // Oculta a barra que mostra o nome do app
        getSupportActionBar().hide();

        // Vincula os componentes da tela
        referenciarComponentes();

        // Listener do botão Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void referenciarComponentes() {
        edtAltura = findViewById(R.id.edtAltura);
        edtPeso = findViewById(R.id.edtPeso);
        rbSexoF = findViewById(R.id.rbSexoF);
        btnCalcular = findViewById(R.id.btnCalcular);
    }

    private void calcularIMC() {

         // 1. GUARDA OS VALORES INFORMADOS PELO USUÁRIO
        String strAltura = edtAltura.getText().toString();
        String strPeso = edtPeso.getText().toString();

        // 2. VERIFICA SE OS CAMPOS FORAM PREENCHIDOS
        //if (strAltura.equals("")) { // O mesmo que o código abaixo
        if (strAltura.isEmpty()) {
            // Posiciona o cursor no campo Altura
            edtAltura.requestFocus();

            // Mostra a mensagem de alerta (com Toast)
            Toast.makeText(this, "Informe sua Altura", Toast.LENGTH_SHORT).show();

            /*
            // Mostra a mensagem de alerta (com Alert)
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Atenção");
            msg.setMessage("Informe sua Altura");
            msg.setNeutralButton("OK", null);
            msg.show();
            */

            return;
        }

        if (strPeso.isEmpty()) {
            // Posiciona o cursor no campo Peso
            edtPeso.requestFocus();

            // Mostra a mensagem de alerta (com Toast)
            Toast.makeText(this, "Informe seu Peso", Toast.LENGTH_SHORT).show();
            return;
        }

        // 3. CONVERTE OS VALORES INFORMADOS PARA NÚMEROS
        double altura = Double.parseDouble(strAltura);
        double peso = Double.parseDouble(strPeso);

        String sexo = "M";

        if (rbSexoF.isChecked()) {
            sexo = "F";
        }

        // 4. CALCULA O PESO IDEAL
        IMC imc = new IMC();
        double pesoIdeal = imc.calcularPesoIdeal(altura, sexo);

        // 5. CALCULA O IMC
        double valorIMC = imc.calcularIMC(altura, peso);

        // 6. VERIFICA A FAIXA DE PESO
        imc.verificarFaixaPeso(valorIMC, pesoIdeal);

        // ABRE A NOVA JANELA E MOSTRA O RESULTADO ENCONTRADO
        abrirJanelaResultado();
    }

    private void abrirJanelaResultado() {
        // Super classe que carrega um objeto na memória para ser utilizado (câmera, janela etc)
        Intent janelaResultado = new Intent(this, Tela_Resultado.class);
        startActivity(janelaResultado);
    }
}
