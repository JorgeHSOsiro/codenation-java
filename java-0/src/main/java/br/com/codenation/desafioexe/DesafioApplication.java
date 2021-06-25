package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		ArrayList<Integer> fibo = new ArrayList<>();
		fibo.add(0);
		fibo.add(1);
		for (int i = 2; i<=350; i++) {
			int elem = fibo.get(i-1) + fibo.get(i-2);
			if (elem >=400) {
				break;
			}
			fibo.add(elem);
		}
		System.out.println(fibo);
		return fibo;
	}

	public static Boolean isFibonacci(Integer a) {
		ArrayList<Integer> checkFibo = new ArrayList<>(fibonacci());
		if (checkFibo.contains(a)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		fibonacci();
	}
}