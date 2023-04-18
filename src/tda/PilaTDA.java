package tda;

/***
 * La pila es una estructura que permite almacenar conjuntos de valores, eliminarlos y recuperarlos, 
 * con la particularidad de que el elemento que se recupera o elimina es el ultimo que ingreso.
 * @author marialuzshin
 *
 */
public interface PilaTDA {

	/***
	 * Inicializa la pila
	 */
	void inicializarPila();
	
	/***
	 * permite agregar un elemento a la pila. 
	 * Se supone que la pila esta inicializada
	 * @param x
	 */
	void apilar(int x);
	
	/***
	 * Permite eliminar el ultimo elemento
	 * Se supone que la pila esta inicializada
	 * @return
	 */
	void desapilar();
	
	/***
	 *  permite obtener el ultimo elemento ingresado a la pila. 
	 *  Se supone que la pila no esta vacıa.
	 * @return
	 */
	int tope();
	
	/***
	 *  Indica si la pila contiene elementos o no. 
	 *  Se supone que la pila esta inicializada
	 * @return
	 */
	boolean pilaVacia();
	
	
}
