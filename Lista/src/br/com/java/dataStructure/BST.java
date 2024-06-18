package br.com.java.dataStructure;


public class BST {
	//nó raiz
	public Node root;
	
	//classe nó
	public class Node{
		public int value; //valor do nó
		public Node left; //lado esquerdo
		public Node right; //lado direito
		
		//construtor insere o valor
		public Node (int value) {
			this.value = value;
		}
		
	}
	
	//inserir
	public void insert(int value) {
		if(root == null) {
			root = new Node(value);
		} else {
			insert(root, value);
		}
	}

	//metodo
	private void insert(final Node root, final int value) {
		if (root == null) return; //se a raiz estiver vazia
		if (value == root.value) return; //se o valor for igual a raiz
		
		if (value > root.value) { //se o valor for maior que a raiz, aloca para direita
			if (root.right == null) root.right = new Node(value); //se tiver espaço, adiciona
			else insert(root.right, value); //senão, navega no nó até encontrar um espaço a direita
			
		} else { //se o valor for menor que a raiz, aloca para a esquerda
			if (root.left == null) root.left = new Node(value);
			else insert(root.left, value); //senão, navega no nó até encontrar um espaço a esquerda
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	//metodo para imprimir na ordem crescente
	private void inOrder(final Node node) {
		//E R D
		if (node == null) return;
		inOrder(node.left);
		System.out.println(node.value);
		inOrder(node.right);
	}
	
	//contem item
	public boolean contains(int value) {
		return contains(root, value);
	}
	
	//metodo 
	private boolean contains(final Node root, int value) {
		if (root == null) return false; //raiz vazia
		if (root.value == value) return true;
		if (value > root.value) return contains(root.right, value);
		else return contains (root.left, value);
	}

	//metodo utilitario, retorna o menor valor de uma arvore
	public int minValue(Node currentNode) {
		while (currentNode.left != null) { //os menores valor são a esquerda
			currentNode = currentNode.left; //navegar ao seu máximo a esquerda
		}
		
		return currentNode.value;
	}
	
	//remover item
	public void deleteNode(int value) {
		root = deleteNode(root, value);
	}
	
	//metodo
	private Node deleteNode(final Node root, final int value) {
		if (root == null) return null;
		
		if(value < root.value) {
			root.left = deleteNode(root.left, value);
		} else if (value > root.value) {
			root.right = deleteNode(root.right, value);
		} else {
			if((root.left == null) && (root.right == null)){ //se for ma folha
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else { //quando o nó a ser removido tem o lado esquerdo e direito 
				int minValue = minValue(root.left);
				root.value = minValue;
				root.right = deleteNode(root.right, minValue);
			}
		}
		return root;
	}
	

	public static void main (String[] args) {
		BST tree = new BST();
		//inserindo valores na arvore
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(45);
		tree.insert(41);
		tree.insert(102);
		tree.insert(67);
		tree.insert(89);
		tree.insert(82);
		tree.insert(70);
		
		/*
		//imprimindo os valores da arvore em ordem
		tree.inOrder();
		*/
		
		/*
		System.out.println(tree.contains(41)); //"contem o valor 41 true
		System.out.println(tree.contains(4)); //"contem o valor 4? false
		*/
		
		//removendo
		tree.deleteNode(41);
		tree.inOrder();
		
	}
	
	
}
