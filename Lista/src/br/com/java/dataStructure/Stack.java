package br.com.java.dataStructure;

public class Stack {
	
	private Node top; //Nó top
	private int height; //altura da pilha
	
	//classe Nó
	public class Node {
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
		}

		public int getValue() {
			return value;
		}		
		
	}
	
	//construtor
	public Stack(int value) {
		Node newNode = new Node(value);
		top = newNode; //nó vai ser o topo da pilha
		height = 1; //com isso a altura da pilha será 1
	}
	
	//método imprimir top
	public void getTop() {
		if (top == null) { //se a pilha estiver vazia
			System.out.println("Pilha vazia.");
		} else {
			System.out.println("Topo: "+top.value);

		}
	}
	
	//altura da pilha
	public void getHeight() {
		System.out.println("Altura :"+height);
	}
	
	//visualizar elementos da pilha
	public void print() {
		System.out.println("##########################");
		Node temp = top; 
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
		System.out.println("##########################");
	}
	
	//inserir elemento (push) - inserindo no topo
	public void push(int value) {
		Node newNode = new Node(value); //cria o nó
		if (height == 0) { //se a pilha estiver vazia
			top = newNode; //o novo Nó "vira" o topo
		} else { //senão
			newNode.next = top; //o próximo elemento do Nó será o topo
			top = newNode; //topo vai apontar para esse newNode
		}
		height++; //incrementar na altura
	}	
	
	
	//remover (pop) - retirar o elemento pelo topo
	public Node pop() {
		if (height == 0) return null; //se a lista estiver vazia, retorna null
		
		Node temp = top; //leitor
		top = top.next; //irá apontar para a próxima posição
		temp.next = null; //removendo
		height--; //decrementar a altura
		
		return temp; //retorna o elemento removido
		
	}
	
	
	//método main
	public static void main (String[] args) {
				Stack myStack = new Stack(2);
				/*
				myStack.getTop(); //topo é 2
				myStack.getHeight(); //altura é 1
				myStack.print();
				*/ 
				
				//inserir
				myStack.push(1);
				
				/*
				myStack.print();
				myStack.getTop(); //topo agora é 1 (pois foi inserido)
				myStack.getHeight(); //altura fica 2
				*/
				
				//removendo
				System.out.println(myStack.pop().value); //removendo o elemento 1 (pois foi o ultimo a ser inserido)
				System.out.println(myStack.pop().value); //removendo o elemento 2
				
				System.out.println(myStack.pop() == null); //tentando remover elemento em uma pilha vazia
				
	}
}