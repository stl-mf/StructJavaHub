package br.com.java.dataStructure;

	public class Queue {

		private Node first; //nó para representar o primeiro da fila
		private Node last; //nó para representar o ultimo da fila
		private int length; //tamanho		
		
		//classe Nó
		public class Node {
			int value;
			Node next; // referencia o próximo nó
			
			//construtor
			Node(int value){
				this.value = value;
			}
		}
		
		public Queue(int value) {
			Node newNode = new Node(value);
			first = newNode;
			last = newNode;
			length++;
		}
		
		//metodo imprimir primeiro elemento
		public void getFirst() {
			if (first != null) {
				System.out.println("First: "+first.value);
			} else {
				System.out.println("Fila esta vazia.");
			}
		}
		
		//metodo imprimir ultimo elemento
		public void getLast() {
			if (last != null) {
				System.out.println("Last: "+last.value);
			} else {
				System.out.println("Fila esta vazia.");
			}
		}
		
		//imprimir o tamanho da fila
		public void getLength() {
			System.out.println("Lenght: "+length);	
		}
		
		//imprimir os elementos da fila
		public void print() {
			System.out.println("################################");
			Node temp = first;
			while (temp != null) { //enquanto a tempo for diferente de null
				System.out.println(temp.value); //armazenar o elemento
				temp = temp.next;
				
			}
			System.out.println("################################");
			
		}
		
		//enfileirar
		public void enqueue(int value) {
			Node newNode = new Node(value);
			
			//se a fila estiver vazia
			if (length == 0) {
				first = newNode; //irá representar quanto o primeiro
				//quanto
			} else {
				last.next = newNode;
				last = newNode;
			}
			length++;
		}
		
		//desinfileirar
		
		
		
		
		
		
		
		//método main
		public static void main(String[] args) {
			Queue myQueue = new Queue(1);
			
			/*
			myQueue.getFirst();
			myQueue.getLast();
			myQueue.getLength();
			
			myQueue.print();
			*/
			
			myQueue.enqueue(2);
			myQueue.enqueue(3);
			
			/*
			myQueue.getFirst();
			myQueue.getLast();
			myQueue.getLength();
			
			myQueue.print();
			*/
			System.out.println(myQueue.dequeue().value);
			System.out.println(myQueue.dequeue().value);
			System.out.println(myQueue.dequeue().value);
			
		}
		
		
		//método que retira o nó da fila
		public Node dequeue() {
			if (length == 0) return null;
			Node temp = first;
			if (length == 1) {
				first = null;
				last = null;
			} else {
				first = first.next;
				temp.next = null;
			}
			length++;
			return temp;
		}
		
	}
	
	
