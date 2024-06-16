package br.com.java.dataStructure;

public class ConjuntoInvertido {
	
	public static void main (String[] args) {
		int [] numeros = {5, 4, 3, 2, 1}; //vetor de numeros inteiros
	
		//invertendo os numeros
		inverter(numeros);
		
	}
	
	//método inverter
	private static void inverter(final int[] numeros) { //irá ler o vetor e armazenar dentro de uma pilha
		Stack stack = new Stack(numeros[0]);
		
		for (int i = 1; i < numeros.length; i++) { 
			stack.push(numeros[i]);			
		}
		var node = stack.pop();
		while (node != null) {
			System.out.println(node.getValue());
			node = stack.pop();
		}
	}
}
