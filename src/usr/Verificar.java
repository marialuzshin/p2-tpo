package usr;

import impl.ABB;
import impl.Cola;
import impl.DiccionarioMultiple;
import impl.Grafo;
import impl.Pila;
import tda.ABBTDA;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;
import tda.DiccionarioSimpleTDA;
import tda.GrafoTDA;

public class Verificar {

	public static void verificarCuatro () {
		ColaTDA colaConRepetidos = new Cola();
		colaConRepetidos.inicializarCola();
		colaConRepetidos.acolar(1);
		colaConRepetidos.acolar(1);
		colaConRepetidos.acolar(2);
		colaConRepetidos.acolar(3);
		colaConRepetidos.acolar(4);
		colaConRepetidos.acolar(2);
		colaConRepetidos.acolar(3);
		colaConRepetidos.acolar(3);
		colaConRepetidos.acolar(5);
		
		ColaTDA cola = Principal.eliminarRepetidos(colaConRepetidos);
		System.out.println("Cola con repetidos");
		while(!colaConRepetidos.colaVacia()) {
			System.out.print(colaConRepetidos.primero());
			colaConRepetidos.desacolar();
			System.out.print("-");
		}
		System.out.println("");
		System.out.println("4) Cola sin repetidos");
		while(!cola.colaVacia()) {
			System.out.print(cola.primero());
			cola.desacolar();
			System.out.print("-");
		}
	}

	public static void verificarCinco() {
		ColaTDA cola1 = new Cola();
		cola1.inicializarCola();
		cola1.acolar(1);
		cola1.acolar(2);
		cola1.acolar(3);
		cola1.acolar(4);
		cola1.acolar(5);

		Pila pila = new Pila();
		pila.inicializarPila();
		pila.apilar(4);
		pila.apilar(5);
		pila.apilar(6);
		pila.apilar(7);
		pila.apilar(8);
		
		System.out.println("5) ObtenerComune");
		ConjuntoTDA conjunto = Principal.obtenerComunes(pila, cola1);
		while (!conjunto.conjuntoVacio()){
			int valor = conjunto.elegir();
			System.out.print(valor);
			System.out.print("-");
			conjunto.sacar(valor);
		}
	}
	
	/***
	 * 6. Se define un método que reciba una PilaTDA y devuelva un 
	 * DiccionarioSimpleTDA, en el cual se guardarán los elementos 
	 * de la pila como claves, y la cantidad de apariciones de dicho 
	 * elemento en la pila, como valores.
	 */
	public static void verificarSeis() {
		Pila pila = new Pila();
		pila.inicializarPila();
		pila.apilar(4);
		pila.apilar(5);
		pila.apilar(6);
		pila.apilar(7);
		pila.apilar(8);
		pila.apilar(6);
		pila.apilar(7);
		pila.apilar(8);
		pila.apilar(6);
		pila.apilar(7);
		pila.apilar(6);
		pila.apilar(7);
		pila.apilar(8);
		pila.apilar(1);
		pila.apilar(2);
		
		System.out.println("6) ContarElementosPila");
		System.out.println("");
		DiccionarioSimpleTDA diccionario = Principal.contarElementosPila(pila);
		ConjuntoTDA conjunto = diccionario.claves();
		while(!conjunto.conjuntoVacio()) {
			int clave = conjunto.elegir();
			System.out.print("[");
			System.out.print(clave + ": ");
			System.out.print(diccionario.recuperar(clave));
			System.out.print("] ,");
			conjunto.sacar(clave);
		}
		System.out.println("");
		System.out.println("--");
	}
	
	/***
	 * 7. Se define un método que reciba un DiccionarioMultipleTDA 
	 * y devuelva una ColaTDA con todos los valores del diccionario, 
	 * sin ninguna repetición.
	 */
	public static void verificarSiete() {
		
		DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultiple();
		diccionarioMultiple.inicializarDiccionario();
		diccionarioMultiple.agregar(1, 1);
		diccionarioMultiple.agregar(1, 2);
		diccionarioMultiple.agregar(2, 1);
		diccionarioMultiple.agregar(2, 3);
		diccionarioMultiple.agregar(3, 2);
		diccionarioMultiple.agregar(3, 1);
		diccionarioMultiple.agregar(4, 4);
		
		System.out.println("");
		System.out.println("7) contarElementosDM: ");
		ColaTDA cola = Principal.eliminarRepetidosDM(diccionarioMultiple);
		while(!cola.colaVacia()) {
			System.out.print(cola.primero());
			cola.desacolar();
			System.out.print(".");
		}
		System.out.println("");
		System.out.println("--");	
	}
	
	/***
	 * 8. Se define un método que calcule la suma de los elementos 
	 * con un valor impar de un ABB.
	 */
	public static void verificarOcho() {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		abb.agregarElem(1);
		abb.agregarElem(2);
		abb.agregarElem(3);
		abb.agregarElem(4);
		abb.agregarElem(5);
		
		System.out.println("");
		System.out.println("8) calcularSumaImpares: ");
		System.out.println(Principal.calcularSumaImpares(abb));
		System.out.println("");
		System.out.println("--");
	}
	
	/***
	 * 9. Se define un método que calcule la cantidad de hojas 
	 * con un valor par de un ABB.
	 */
	public static void verificarNueve() {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		abb.agregarElem(1);
		abb.agregarElem(2);
		abb.agregarElem(3);
		abb.agregarElem(4);
		abb.agregarElem(6);
		abb.agregarElem(7);
		abb.agregarElem(8);
		
		System.out.println("");
		System.out.println("9) calcularCantHojasPares: ");
		System.out.println(Principal.calcularCantHojasPares(abb));
		System.out.println("");
		System.out.println("--");
	}
	
	/***
	 * 10. Se define un método que reciba un GrafoTDA y dos 
	 * enteros que representen vértices, y devuelva un ConjuntoTDA 
	 * con todos los vértices puente entre los vértices 
	 * recibidos por parámetro.
	 * 
	 * Se define que un vértice p es puente entre dos vértices o y d, 
	 * si hay una arista que comienza en o y termina en p 
	 * y otra que comienza en p y termina en d.
	 */
	public static void verificarDiez() {
		GrafoTDA grafo = new Grafo();
		grafo.inicializarGrafo();
		grafo.agregarVertice(1);
		grafo.agregarVertice(3);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		
		grafo.agregarArista(1, 3, 2);
		grafo.agregarArista(3, 5, 1);
		grafo.agregarArista(1, 6, 1);
		grafo.agregarArista(1, 5, 1);
		grafo.agregarArista(6, 1, 1);
		grafo.agregarArista(5, 6, 1);
		grafo.agregarArista(1, 7, 1);
		grafo.agregarArista(5, 1, 1);
		System.out.println("");
		System.out.println("10) obtenerVerticesPuente: ");
		ConjuntoTDA conjuntoVerticesPuente = Principal.obtenerVerticesPuente(grafo, 1, 5);
		
		while(!conjuntoVerticesPuente.conjuntoVacio()) {
			int vertice = conjuntoVerticesPuente.elegir();
			System.out.print(vertice);
			System.out.print("-");
			conjuntoVerticesPuente.sacar(vertice);
		}
		System.out.println("");
		System.out.println("--");
	}
	
	/***
	 * 11. Se define un método que reciba un GrafoTDA 
	 * y un entero que represente un vértice, 
	 * y devuelva el grado del vértice recibido por parámetro. 
	 * Se define el grado de un vértice v 
	 * como el entero que es igual a la resta 
	 * entre la cantidad de aristas que salen de v 
	 * menos la cantidad de aristas que llegan a v.
	 */
	public static void verificarOnce() {
		GrafoTDA grafo = new Grafo();
		grafo.inicializarGrafo();
		grafo.agregarVertice(1);
		grafo.agregarVertice(3);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		
		grafo.agregarArista(1, 3, 2);
		grafo.agregarArista(3, 5, 1);
		grafo.agregarArista(1, 6, 1);
		grafo.agregarArista(1, 5, 1);
		grafo.agregarArista(6, 1, 1);
		grafo.agregarArista(5, 6, 1);
		grafo.agregarArista(1, 7, 1);
		
		System.out.println("");
		System.out.println("11) obtenerGradoDelVertice: ");
		int grado = Principal.obtenerGradoDelVertice(grafo, 1);
		System.out.print(grado);
		System.out.println("");
		System.out.println("--");
	}
	
}
