package usr;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;
import impl.Cola;
import impl.Pila;
import impl.Conjunto;
import impl.DiccionarioSimple;

public class Principal {

	public static void main(String[] args) {
		
		TestPila testPila = new TestPila();
		testPila.test();
		
		TestCola testCola = new TestCola();
		testCola.test();
		
	}
	
	/***
	 * @Consigna
	 * 4) Se define un método que reciba una ColaTDA y devuelva una nueva 
	 * ColaTDA con los elementos de la original, sin ninguna repetición. 
	 * Se debe dejar el primer representante de cada uno de los repetidos, 
	 * respetando el orden en que aparecen todos los elementos en la original.
	 * 
	 * @Tarea 
	 * Para obtener una colaTDA sin repeticion utilizaremos un conjunto
	 * para guardar y verificar que los valores solo se ingresen a la cola
	 * la primera vez.
	 * 
	 * 
	 * @Parametros 
	 * @Devuelve una colaTDA con los elementos sin repetir
	 * @Precondiciones 
	 * @Postcondiciones 
	 * @Costo El costo es constante ya que siempre sera el mismo
	 *  y no variara segun la cantidad de elementos del conjunto
	 */
	public static ColaTDA eliminarRepetidos(ColaTDA cola) {
		ColaTDA colaSinRepetidos = new Cola();
		colaSinRepetidos.inicializarCola();
		
		ColaTDA colaAux = new Cola();
		colaAux.inicializarCola();
		
		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();
		
		while (!cola.colaVacia()) {
			int valor = cola.primero();
			colaAux.acolar(valor);
			if(!conjunto.pertenece(valor)) {
				colaSinRepetidos.acolar(valor);
				conjunto.agregar(valor);
			}
			cola.desacolar();
		}
		cola = colaAux;
		return colaSinRepetidos;
	}
	
	/***
	 * @Consigna
	 * 5. Se define un método que reciba una PilaTDA y una ColaTDA 
	 * y devuelva un ConjuntoTDA con los elementos comunes 
	 * de la pila y de la cola.
	 * 
	 * @Tarea 
	 * Recorremos la pila y agregamos los valores a un conjunto y
	 * a otra pila (para preservar la pila que recibimos como parametro, 
	 * como el orden queda invertido, usamos dos auxiliares).
	 *   
	 * Luego tambien recorremos la cola y agregamos los valores a 
	 * una cola auxiliar (para preservar los valores que recibimos como parametro)
	 * 
	 * Una vez que tenemos ambos conjuntos, con todos los valores
	 * recorremos la pila auxiliar, que tiene los valores invertidos.
	 * 
	 * Al recorrerla verificamos si existen en ambos conjuntos 
	 * y si existen en ambos, agregamos el valor al conjunto final.
	 * 
	 * A su vez, mientras recorremos la pila invertida, agregamos los 
	 * valores a una nueva pila 
	 * (que sera la que tiene los valores y el orden inicial)
	 * 
	 * Una vez que recorrimos toda la pila, asignamos de vuelta  
	 * a la pila y a la cola los valores originales 
	 * y devolvemos el conjunto que tendra todos los elementos que
	 * se encuentran en ambos parametros.
	 * 
	 * @Parametros Una pila y una cola
	 * @Devuelve un conjunto con los elementos que se encuentran en la cola y 
	 * en la pila que recibimos como parametro.
	 * @Precondiciones 
	 * @Postcondiciones 
	 * Si un valor se encuentra mas de una vez en cualquiera de las dos,
	 * pila o cola, solo se devolvera en el conjunto una sola vez,
	 * por la naturaleza de los conjuntos (que cada elemento es unico)
	 * 
	 * @Costo El costo es lineal ya que siempre dependera de los elementos
	 * que reciba como parametro.
	 * En este caso, dependera de los elementos p (de la pila) y c de la cola
	 * de la siguiente forma
	 * L(p + c + p*c)
	 * p: por el primer recorrido de la pila 
	 * (que realizamos para preservar los valores que recibimos como parametro)
	 * c: por el recorrido de la cola
	 * p * c: ya que vamos a recorrer todos los elementos de la pila (p)
	 * y ademas, dentro de ese recorrido (*) 
	 * verificaremos si el valor se encuentra en el conjunto de la cola 
	 * y para eso recorreremos cada elemento del conjunto (c);
	 */
	public static ConjuntoTDA obtenerComunes(PilaTDA pila, ColaTDA cola) {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		PilaTDA pilaAux2 = new Pila();
		pilaAux.inicializarPila();
		
		Cola colaAux = new Cola();
		colaAux.inicializarCola();
		
		ConjuntoTDA conjuntoCola = new Conjunto();
		conjuntoCola.inicializarConjunto();
		
		ConjuntoTDA conjuntoComun = new Conjunto();
		conjuntoComun.inicializarConjunto();
		
		while (!pila.pilaVacia()) {
			int valor = pila.tope();
			pilaAux.apilar(valor);
			pila.desapilar();
		}
		
		while (!cola.colaVacia()) {
			int valor = cola.primero();
			conjuntoCola.agregar(valor);
			colaAux.acolar(valor);
			cola.desacolar();
		}
		
		while (!pilaAux.pilaVacia()) {
			int valor = pilaAux.tope();
			if(conjuntoCola.pertenece(valor)) {
				conjuntoComun.agregar(valor);
			}
			pilaAux2.apilar(valor);
			pilaAux.desapilar();
		}
		
		cola = colaAux;
		pila = pilaAux2;
		
		return conjuntoComun;
		
	}
	
	/***
	 * @Consigna
	 * 6. Se define un método que reciba una PilaTDA y devuelva un 
	 * DiccionarioSimpleTDA, en el cual se guardarán los elementos 
	 * de la pila como claves, y la cantidad de apariciones de dicho 
	 * elemento en la pila, como valores.
	 * 
	 * @Tarea 
	 * 
	 * @Parametros 
	 * @Devuelve 
	 * @Precondiciones 
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 */
	public static DiccionarioSimpleTDA contarElementosPila(PilaTDA pila) {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		PilaTDA pilaAux2 = new Pila();
		pilaAux.inicializarPila();
		
		DiccionarioSimpleTDA diccionarioSimple = new DiccionarioSimple();
		diccionarioSimple.inicializarDiccionario();
		
		while (!pila.pilaVacia()) {
			int valorPila = pila.tope();
			pilaAux.apilar(valorPila);
			int cantidadPila = diccionarioSimple.recuperar(valorPila);
			if (cantidadPila > 0) {
				cantidadPila++;
				diccionarioSimple.agregar(valorPila, cantidadPila);
			} else {
				diccionarioSimple.agregar(valorPila, 1);
			}
			pila.desapilar();
		}
		
		while (!pilaAux.pilaVacia()) {
			int valor = pilaAux.tope();
			pilaAux2.apilar(valor);
			pilaAux.desapilar();
		}
		
		pila = pilaAux2;
		
		return diccionarioSimple;
		
	}
	
	/***
	 * @Consigna
	 * 7. Se define un método que reciba un DiccionarioMultipleTDA 
	 * y devuelva una ColaTDA con todos los valores del diccionario, 
	 * sin ninguna repetición.
	 * 
	 * @Tarea 
	 * 
	 * @Parametros 
	 * @Devuelve 
	 * @Precondiciones 
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 */
	public static DiccionarioSimpleTDA contarElementosPila(DiccionarioMultipleTDA diccionarioMultiple) {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		PilaTDA pilaAux2 = new Pila();
		pilaAux.inicializarPila();
		
		DiccionarioSimpleTDA diccionarioSimple = new DiccionarioSimple();
		diccionarioSimple.inicializarDiccionario();
		
		while (!pila.pilaVacia()) {
			int valorPila = pila.tope();
			pilaAux.apilar(valorPila);
			int cantidadPila = diccionarioSimple.recuperar(valorPila);
			if (cantidadPila > 0) {
				cantidadPila++;
				diccionarioSimple.agregar(valorPila, cantidadPila);
			} else {
				diccionarioSimple.agregar(valorPila, 1);
			}
			pila.desapilar();
		}
		
		while (!pilaAux.pilaVacia()) {
			int valor = pilaAux.tope();
			pilaAux2.apilar(valor);
			pilaAux.desapilar();
		}
		
		pila = pilaAux2;
		
		return diccionarioSimple;
		
	}

}
