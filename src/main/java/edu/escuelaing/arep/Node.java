package edu.escuelaing.arep;

/**
 * Esta clase implementa cada nodo de una linked list
 *
 */

public class Node
{
	private Node next;
	private double valor;
	
	public Node(double val)
	{
		valor = val;
	}
	
	/**
	 * devuelve el valor contenido en el nodo
	 * @return un entero con el valor del nodo
	 */
	public double getValor()
	{
		return valor;
	}
	
	/**
	 * asigna como siguiente a un nodo
	 * @param n nodo siguiene
	 */
	public void setNext(Node n) {
		next = n;
	}
	
	/**
	 * obtiene el siguiente nodo de la lista
	 * @return un nodo
	 */
	public Node getNext() {
		return next;
	}
}
