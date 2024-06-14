package br.com.java.ed.main;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in); //ler o teclado que o usuario vai indicar
		
		int opcao; //armazenando em uma variável
		do {
			System.out.println("\nLista de Compras");
			System.out.println("1 - Inserir");
			System.out.println("2 - Listar");
			System.out.println("3 - Remover");
			System.out.println("4 - Sair");
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt();
			
			switch (opcao) {
			case 1:
					System.out.print("Digite o item a ser inserido");
					String item = scanner.next();
					break;
			case 2:
				break;
			case 3:
				System.out.print("Digite a posição do item a ser removido: ");
				int index = scanner.nextInt();
				break;
			case 4:
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção invalida. Por favor, escolha novamente.");
					
			}
		} while (opcao != 4);
		
		scanner.close();
	}
	//21min
}
