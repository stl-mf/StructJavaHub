package br.com.java.dataStructure;


public class Tree {
	//nó raiz
	public Node root;
	
	//classe nó
	public static class Node{
		//valore que irá armazenar
		public int value;
		
		//nó à esquerda
		public Node left;
		
		//nó à direita
		public Node right;
		
		//construtor
		public Node(int value) {
			this.value = value;
		}
	
		//é uma folha?
		public boolean isLeaf (Node node) {
			return (this.left == null) && (this.right == null); //se os filhos do determinado nó são vazios
		}
	
	}
	
	/*
	//valor que quero inserir na arvore
	public void insert (int value) {
		if (root == null) root = new Node(value); //se a arvore estiver vazia, adiciona o novo valor que foi indicado no parametro
		else { //senão
			Queue<Node> queue = new LinkedList<>(); //verificar o motivo do erro
			queue.add(root);
			while(queue.size() > 0) {
				Node currentNode = queue.remove();
				if (currentNode.left == null) {
					
				}
			}
			
			
		}
	}
	*/
	
	
	
}
