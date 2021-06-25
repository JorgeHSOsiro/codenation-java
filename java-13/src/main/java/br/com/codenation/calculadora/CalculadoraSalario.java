package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase <= 1039.00) {
			return 0;
		} else {
			double salario = calcularInss(salarioBase);
			double res = calcularIRRF(salario);
			return Math.round(res);
		}
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500.0) {
			return salarioBase - (salarioBase * 0.08);
		} else if (salarioBase >= 1500.01 && salarioBase <= 4000.0) {
			return salarioBase - (salarioBase * 0.09);
		} else {
			return  salarioBase - (salarioBase * 0.11);
		}
	}

	private double calcularIRRF(double salarioBruto) {
		if (salarioBruto <=3000.00) {
			return salarioBruto;
		} else if (salarioBruto >= 3000.01 && salarioBruto <= 6000.00) {
			return salarioBruto - (salarioBruto * 0.075);
		} else {
			return salarioBruto - (salarioBruto * 0.15);
		}
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/