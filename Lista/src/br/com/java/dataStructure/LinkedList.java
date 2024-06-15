package br.com.java.dataStructure;

public class LinkedList {
	//operação: cabeça (um dos campos principais)
	private Node head;
	
	//operação: cauda (um dos campos principais)
	private Node tail;
	
	//operação tamanho (um dos campos principais)
	private int length;
	
	
	//classe nó
	class Node {
		String data; //informação que vai armazenar
		Node next; //todo nó aponta para outro nó, referencia o pr[oximo nó
		
		//construtor
		Node (String data) { //todo nó
			this.data = data; //precisa ter um dado armazenado
		}
	}
	
	//construtor, irá inicializar a Cabeça, Cauda e Tamanho
	public LinkedList(String data) {
		length = 1;
		Node newNode = new Node(data);
		head = newNode;
		tail = newNode;
	}
	
	//métodos
	public void getTail(){ //cauda
		if (this.tail == null) {
			System.out.println("Lista vazia");
		} else {
			System.out.println("Tail: "+tail.data);
		}
	}
	
	public void getHead() { //cabeça
		if (this.head == null) {
			System.out.println("Lista vazia");
		} else {
			System.out.println("Head: "+head.data);
		}
	}
	
	public void getLength() { //tamanho
		System.out.println("Length: "+this.length);
	}
	
	public void makeEmpty(){ //tornar a lista vazia
		head = null;
		tail = null;
		length = 0;
	}
	
	public void print() { //nó que vai navegar de forma sequencial na lista ligada
		System.out.println("###############################");
		Node temp = this.head; //nó temp de leitura, vai apontar a cabeça da lista
		while (temp != null) { //enquanto o nó temp for 
			System.out.println(temp.data); //imprime o elemento
			temp = temp.next; //navegar para o próximo elemento da lista
		}
		System.out.println("###############################");
	}
	
	//referencia ao Nó Cauda
	public void append(String data) { //inserindo um elemento, o parametro que vai receber é do tipo string para o usuário informar qual o elemento 
		Node newNode = new Node(data); //a inforação será armazenada em um nó
		if (length == 0) { //se a lista estiver vazia
			head = newNode; //vai aponntar pro novo nó
			tail = newNode; //vai aponntar pro novo nó
		} else {
			tail.next = newNode; //o próximo elemento do final será o newNode
			tail = newNode; //agora o ultimo elemento será esse elemento que foi adicionado
		}
		length++; //tamanho da lista
	}
	
	
	
	public static void main(String[] args) { //método main
		LinkedList list = new LinkedList("elemento 1");
		
		//acionando outro elemento
		list.append("elemento 2");
		list.append("elemento 3");
	
		list.getHead();
		list.getTail();
		list.getLength();
		list.print();
	}	
}
