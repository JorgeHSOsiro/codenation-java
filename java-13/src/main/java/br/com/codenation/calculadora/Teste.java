package br.com.codenation.calculadora;

public class Teste {
    public static void main(String[] args) {
        CalculadoraSalario calc = new CalculadoraSalario();
        double res = calc.calcularSalarioLiquido(1500.00);
        System.out.println(res);
    }
}
