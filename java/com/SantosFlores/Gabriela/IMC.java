 package com.SantosFlores.Gabriela;

public class IMC{
    // Atributos (variáveis) ESTÁTICOS
    public static String resultado;
    public static String imcFinal;
    public static int cor;

    // CONSTANTES
    private static final String ABAIXO = "ABAIXO DO PESO: 18 ou menos"
            + "\n\nOrganismo vulnerável a infecções.";

    private static final String NORMAL = "PESO NORMAL: 19 a 24"
            + "\n\nPeso adequado para a altura.";

    private static final String ACIMA = "ACIMA DO PESO: 25 a 30"
            + "\n\nPredisposição à obesidade, pré-diabetes e hipertensão.";

    private static final String OBESO_1 = "OBESIDADE: 31 a 39"
            + "\n\nRisco de desenvolver diabetes, hipertensão e doenças cardiovasculares.";

    private static final String OBESO_2 = "OBESIDADE MÓRBIDA: 40 ou mais" +
            "\n\nRisco de 90% de desenvolver doenças como diabetes, reumatismos, " +
            "hipertensão, doenças cardiovasculares e câncer.";

    // Métodos
    public Double calcularIMC(double altura, double peso) {
        altura = altura / 100;
        return peso / (altura * altura);

        /*
		O cálculo do IMC é feito da seguinte forma:
		A altura é multiplicada pela altura (ex: 1.70 * 1.70)
		O peso é dividido pelo resultado da multiplicação da altura (65 / 2.89)
		*/
    }

    public Double calcularPesoIdeal(double altura, String sexo) {
        if (sexo.equals("F")) {
            return (altura - 100) * 0.85; // 59,5
        }

         return (altura - 100) * 0.90; // 63
    }

    public void verificarFaixaPeso(double valorIMC, double pesoIdeal) {
        // Formata para 1 casa decimal

        // 1ª forma (Java)
        /*DecimalFormat decimal = new DecimalFormat("0.0");
        String strIMC = decimal.format(valorIMC);

        this.imcFinal = "Seu IMC: " + strIMC;*/

        // 2ª forma (Formatando o Float)
        this.imcFinal = "Seu IMC: " + String.format("%.1f", valorIMC);

        this.resultado = "";

        // Verifica a faixa de IMC
        if (valorIMC < 18) {
            this.resultado = ABAIXO;
            this.cor = R.color.colorAbaixo;

        } else if (valorIMC >= 18 && valorIMC < 25) {
            this.resultado = NORMAL;
            this.cor = R.color.colorNormal;

        } else if (valorIMC >= 25 && valorIMC < 30) {
            this.resultado = ACIMA;
            this.cor = R.color.colorAcima;

        } else if (valorIMC >= 30 && valorIMC < 40) {
            this.resultado = OBESO_1;
            this.cor = R.color.colorObeso1;

        } else {
            this.resultado = OBESO_2;
            this.cor = R.color.colorObeso2;
        }

        resultado += "\n\nPeso ideal: " + pesoIdeal;
    }
}
