package com.SantosFlores.Gabriela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class Tela_Resultado extends AppCompatActivity {

        // Atributos (variáveis)
        TextView txtResultado, txtIMC;
        Button btnCalcularNovamente, btnSair;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tela_resultado);
            // Oculta a barra que mostra o nome do App
            getSupportActionBar().hide();

            // Vincula os componentes da tela
            referenciarComponentes();

            // Mostra o resultado do cálculo IMC
            mostrarResultado();

            // Calcular novamente
            btnCalcularNovamente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Acessa a primeira tela
                    calcularNovamente();
                }
            });

            // Encerra a aplicação
            btnSair.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Encerra o App
                    encerrarApp();
                }
            });
        }

        private void referenciarComponentes() {
            this.txtResultado = findViewById(R.id.txtResultado);
            this.txtIMC = findViewById(R.id.txtIMC);
            this.btnCalcularNovamente = findViewById(R.id.btnCalcularNovamente);
            this.btnSair = findViewById(R.id.btnSair);
        }

        private void mostrarResultado() {
            txtResultado.setText(IMC.resultado);
            txtIMC.setText(IMC.imcFinal);
            txtIMC.setBackgroundResource(IMC.cor);
            btnCalcularNovamente.setBackgroundResource(IMC.cor);
        }

        private void calcularNovamente() {
            //Intent novaJanela = new Intent(this, TelaPrincipal.class);
            //startActivity(novaJanela);

            startActivity(new Intent(this, TelaPrincipal.class));
        }

        private void encerrarApp() {
            finishAffinity();
            System.exit(0);
        }
    }