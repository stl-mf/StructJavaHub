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
	
	//remover o ultimo elemento
	public Node removeLast() { //método não terá parametro
		if(length == 0) return null; //se o tamanho da lista for 0 retorna null
		Node pre = head; //a leitura da lista sempre se inicia da cabeça
		Node temp = null; //nó temp para retornar qual o nó será removido
		
		while (pre.next != tail) { //enquanto o pre não for a cauda (ultimo)
			pre = pre.next; //irá navegar pela lista até localizar o penultimo elemento
		}
		
		temp = tail; //ultimo nó será removido
		//movimento
		tail = pre; //ultimo irá ser igual ao penultimo
		tail.next = null; //o próximo do penultimo será vazio (removendo o ultimo)
		
		//diminuir o tamanho da lista, pois foi removido um elemento
		length--;
		if (length == 0) { //se o tamanho for zerado
			head = null; //cabeça será null
			tail = null; //cauda será null
		}
		return temp; //retorna o elemento que foi removido
	}
	
	//inserindo no inicio da lista (prepend)
	public void prepend (String data) { //o método terá um parametro do tipo String
		Node newNode = new Node(data); //adicionando o nó
		 if (length == 0) { //se o tamanho da lista for igual a 0 (lista vazia)
			 head = newNode;
			 tail = newNode;
		 } else { //senão
			 newNode.next = head; //o next elemento do newNode será o head
			 head = newNode; //o head será o newNode
		 }
		length++; //incrementar o tamanho atual
	}
	
	//removendo do inicio
	public Node removeFirst() {
		if (length == 0) return null; //se a lista estiver vazia, retorna null
		Node temp = head; //nó leitor que inicia na Cabeça
		head = head.next; //segundo elemento se torna o primeiro elemento
		temp.next = null; //removendo o ex primeiro elemento
		length--; //diminuindo o tamanho da lista
		if (length == 0) { //se o tamanho da lista for igual a 0 (lista vazia)
			head = null;
			tail = null;
		}
		return temp;
	}
	
	//ler de uma posição qualquer (get)
	public Node get(int index) {
		if (index < 0 || index >= length) return null; //se a posição for menor que 0 ou maior que o tamanho da lista, retorna null
		Node temp = head; //nó leitor que inicia na Cabeça
		for (int i = 0; i < index; i++){ //controlando a posição
			temp = temp.next;
		}
		return temp;
	}
	
	//método set
	public boolean set(int index, String data) {
		Node temp = get(index);
		if (temp != null) {
			temp.data = data;
			return true;
		}
		return false;
	}

	//inserir em uma posição específica
	public boolean insert(int index, String data) {
		if (index < 0 || index >= length) return false; //se a posição for menor que 0 ou maior que o tamanho da lista, retorna false
		if (index == 0) { //se quer inserir na posição inicial
			prepend(data); //chama o método prepend
			return true;
		}
		if (index == length) { //se o index for igual ao tamanho da lista
			append(data); //vai inserir no final da lista
			return true;
		}
		Node newNode = new Node(data);
		Node temp = get(index-1); //pegando o elemento anterior
		newNode.next = temp.next;
		temp.next = newNode; //elemento anterior irá apontar para o novo nó, costura
		length++;
		return true;	
	}
	
	//remover de uma posição específica
	public Node remove(int index) {
		if (index == 0 || index >= length) return null; //se a posição for menor que 0 ou maior que o tamanho da lista, retorna false
		if (index == 0) return removeFirst(); //se o index for a primeira posição, utiliza o método removeFirst
		if (index == length) return removeLast();
		
		Node prev = get(index-1); //elemento anterior
		Node temp = prev.next;
		prev.next = temp.next;
		temp.next = null;
		length--;
		
		return temp;
	
	}
	
	public static void main(String[] args) { //método main
		LinkedList list = new LinkedList("elemento 1");
		
		//adicionando outros elementos
		list.append("elemento 2");
		list.append("elemento 3");
		
		//adicionando no inicio
		list.prepend("elemento 0"); //adicionando o elemento 0
		
		list.remove(2);
		
		/*
		//inserindo entre o elemento 2 e 3
		list.insert(3,"elemento 2.5"); //o elemento 2 (indice 3) será empurrado para frente
		
		//set
		list.set(1, "elemento 0.5");
		*/
		
		/** //imprimir o elemento de indice 2
		System.out.println(list.get(2).data);
		*/
		
		/** //removendo o primeiro
		System.out.println(list.removeFirst().data);
		list.print();
		*/
		
		/** //excluindo o ultimo elemento
		System.out.println(list.removeLast().data); //.data = retorna o elemento
		list.print(); //imprimi todos os elementos da lista
		*/
		
		/*
		//detalhes da lista
		list.getHead();
		list.getTail();
		list.getLength();
		*/
		list.print(); //imprimir todos os elementos da lista
		
		
	}	
}
