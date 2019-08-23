package edu.escuelaing.arep;

/**
 * Esta clase implementa una liked list con sus funciones basicas
 *
 */
public class LinkedList {
	private int length;
	private Node head;
	
	public LinkedList() {
		length = 0;
		head = null;
	}
	
	/**
	 * ingresa un valor a la cabeza de la lista
	 * @param val el entero a ingresar a la lista
	 */
	public void addAtHead(double val)
	{
		if(head != null) {
			Node temp = head;
			head = new Node(val);
			head.setNext(temp);
		}else {
			head = new Node(val);
		}		
		length++;
	}
	
	/**
	 * ingresa un valor a la cola de la lista
	 * @param val el entero a ingresar a la lista
	 */
	public void addAtTail(double val)
	{
		if(head != null) {
			Node temp = head;
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}		
			temp.setNext(new Node(val));
		}else {
			head = new Node(val);
		}
		length++;
	}
	
	/**
	 * remueve un valor a la cabeza de la lista
	 * @return el nodo a extrer
	 */
	public Node pop() {
		Node temp = head;
		head = head.getNext();
		length--;
		return temp;
		
	}
	
	/**
	 * devuelve el valor del nodo
	 * @return un entero con el valor del nodo
	 */
	public int getLength() {
		return length;
	}
}
