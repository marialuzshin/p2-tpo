package impl;

import tda.MultiPilaTDA;
import tda.PilaTDA;
import tda.ColaTDA;

public class MultiPila implements MultiPilaTDA {

	private int[] pila;
	private int indice;
	
	@Override
	public void inicializarPila() {
		pila = new int[100];
		indice = 0;
		
	}

	@Override
	/***
	 * @Tarea 
	 * Recorremos la pila valores desapilandola y apilandola
	 * en una nueva pila, de esta manera quedara de forma inversa
	 * y en el orden que necesitamos para apilarla.
	 * Una vez apilados todos los valores con el orden que necesitamos
	 * Recorremos la pila con el nuevo orden agregando uno a uno
	 * los valores a la pila original, aumentando tambien el indice 
	 * por cada elemento que agreguemos.
	 * 
	 * Como al desapilar los valores la pila se destruye, 
	 * a su vez utilizaremos una nueva pila para preservar los valores 
	 * de la variable que recibimos por parametro.
	 * @Parametros PilaTDA de valores a agregar
	 * @Devuelve void (vacio)
	 * @Precondiciones
	 * @Postcondiciones 
	 * @Costo Como la pila se recorre dos veces forma secuencial, el costo sera 
	 * lineal ya que su costo dependera de la cantidad de elementos que existan 
	 * dentro de la cola.
	 * En este caso al ser dos veces, 
	 * sera lineal pero de 2n (siendo n la cantidad de elementos)
	 */
	public void apilar(PilaTDA valores) {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		PilaTDA valores2 = new Pila();
		valores2.inicializarPila();
		
		while (!valores.pilaVacia()) {
			int valor = valores.tope();
			valores.desapilar();
			pilaAux.apilar(valor);
		}
		
		while (!pilaAux.pilaVacia()) {
			int valor = pilaAux.tope();
			pilaAux.desapilar();
			pila[indice] = valor;
			valores2.apilar(valor);
			indice++;
		}
		
		valores = valores2;
	}

	@Override
	public boolean pilaVacia() {
		return indice == 0;
	}

	@Override
	/***
	 * @Tarea 
	 * Recorremos la pila valores desapilandola y apilandola
	 * en una nueva pila, de esta manera quedara de forma inversa
	 * y en el orden que necesitamos para desapilar.
	 * Una vez apilados todos los valores con el orden que necesitamos
	 * Recorremos la pila con el nuevo orden verificando uno a uno
	 * si los valores a eliminar son los mismos que en la pila original.
	 * 
	 * Si al final del recorrido, los elementos de la pila eran los mismos
	 * y en el mismo orden que en la original, entonces disminuimos el indice
	 * por cada elemento a eliminar (borrado logico)
	 * 
	 * 
	 * Como al desapilar los valores la pila se destruyen, 
	 * a su vez utilizaremos una nueva pila para preservar los valores 
	 * de la variable que recibimos por parametro.
	 * @Parametros PilaTDA de valores a eliminar
	 * @Devuelve void (vacio)
	 * @Precondiciones
	 * @Postcondiciones 
	 * @Costo Como la pila se recorre dos veces forma secuencial, el costo sera 
	 * lineal ya que su costo dependera de la cantidad de elementos que 
	 * se tratan de eliminar dentro de la cola.
	 * En este caso al ser dos veces, sera lineal pero de 2n 
	 * (siendo n la cantidad de elementos a eliminar)
	 */
	public void desapilar(PilaTDA valores) {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		ColaTDA cola = new Cola();
		cola.inicializarCola();
		boolean coinciden = true;
		
		int i = indice;
		int cantValores = 0;
		while (!valores.pilaVacia()) {
			int valor = valores.tope();
			valores.desapilar();
			cola.acolar(valor);
			cantValores++;
			if (pila[i] != valor) {
				coinciden = false;
			} 
		}
		
		if(coinciden) {
			indice -= cantValores;
		}
		
		while (!cola.colaVacia()) {
			pilaAux.apilar(cola.primero());
			cola.desacolar();
		}
		valores = pilaAux;
	}

	@Override
	public PilaTDA tope(int cantidad) {
		PilaTDA valoresADevolver = new Pila();
		valoresADevolver.inicializarPila();
		
		for (int i=0; i < cantidad; i++) {
			valoresADevolver.apilar(pila[indice-i]);
		}
		return valoresADevolver;
	}

}
