package teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Teste {

	public static List<String> teste(int n) {
		if(n>9) return null;
		HashMap<String, String> lista = new HashMap<String, String>();
		for(int i = 1000; i<=9999; i++) {
			lista.put(String.valueOf(i), "false");
		}
		for(Map.Entry<String, String> entrada : lista.entrySet()) {
			if(Integer.parseInt(entrada.getKey().substring(0, 1))<=n && 
					Integer.parseInt(entrada.getKey().substring(1, 2))<=n && 
					Integer.parseInt(entrada.getKey().substring(2, 3))<=n && 
					Integer.parseInt(entrada.getKey().substring(3))<=n) {
				String valueToSum = entrada.getKey();
				int sum = Integer.parseInt(valueToSum.substring(0, 1)) + 
						Integer.parseInt(valueToSum.substring(1, 2)) + 
						Integer.parseInt(valueToSum.substring(2, 3)) + 
						Integer.parseInt(valueToSum.substring(3));
				if(sum == 21) lista.replace(entrada.getKey(), "true");
			}
		}
		List<String> resultado = new ArrayList<>();
		for(Map.Entry<String, String> entrada : lista.entrySet()) {
			if(entrada.getValue().contentEquals("true")) {
				resultado.add(entrada.getKey());
			}
		}
		if(resultado.isEmpty()) return null;
		Collections.sort(resultado);
		for(int i=0;i<resultado.size();i++) {
			System.out.println(resultado.get(i));
		}
		return resultado;
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		List<String> teste = teste(n);
		if(teste==null) System.out.println(teste);
	}

}
