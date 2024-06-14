package br.com.java.ed.implementation;

public class SupermarketArray implements Supermarket{

	//vetor
	private final String[] items;
	
	//marcar a posição do ultimo item inserido
	private int lastIndex;
	
	
	//construtor
	public SupermarketArray
	(final int size) { //parametro: receber a quantidade de elementos do vetor
		items = new String[size];
		lastIndex = -1;
	}

	//implementando todos os métodos da interface Supermarket
	@Override
	public void add(String item) {
		if (lastIndex == items.length-1) { //validar se o ultimo indice é igual a ultima posição (tamanho maximo do vetor -1)  
			System.err.println("Lista de Supermercado cheia."); //err: para imprimir linha em vermelho na tela
		} else { //caso contrario, segue com a add
			lastIndex++; //soma 1
			items[lastIndex] = item; //recebe para indicar a quantidade
		}
		
	}

	@Override
	public void print() {
		System.out.println("##########################");
		//navegar ate o ultimo elemento
		//quando o lastIndex for negativo, significa que a lista está vazia -> conceito de Pilha > representação
		if (lastIndex < 0) {
			System.out.println("Lista de Supermercado vazia.");
		}
		//vai navegar até o ultimo elemento que foi inserido
		for (int i = 0; i <= lastIndex; i++) {
			System.out.println(i+" - "+items[i]);
		}
		System.out.println("##########################");
	}

	@Override
	public void delete(final int index) {
		//validar o index
		if(index >= 0 && index <= lastIndex) {
			//deletar
			shift(index);
			lastIndex--;
		} else {
			System.err.println("Indeice invalido: "+index);
		}
		
	}
	
	private void shift (final int index) {
		for(int i= index; i < lastIndex; i++) {
			items[i] = items[i+1]; //puxando os elementos da direita para esquerda
		}
	}
	
}
