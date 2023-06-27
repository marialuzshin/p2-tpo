package usr;

import tda.ABBTDA;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;
import tda.DiccionarioSimpleTDA;
import tda.GrafoTDA;
import tda.PilaTDA;
import impl.Cola;
import impl.Pila;
import impl.Conjunto;
import impl.DiccionarioSimple;

public class Principal {

	public static void main(String[] args) {
		/* 4) */
		//Verificar.verificarCuatro();
		
		//5)
		//Verificar.verificarCinco();
		
//		6)
		Verificar.verificarSeis();
		
//		7)
		Verificar.verificarSiete();
		
//		8)
		Verificar.verificarOcho();
		
//		9)
		Verificar.verificarNueve();
		
//		10)
		Verificar.verificarDiez();
		
//		11)
		Verificar.verificarOnce();
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
		
		pasarCola(colaAux, cola);
		
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
		pilaAux2.inicializarPila();
		
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
		
		pasarCola(colaAux, cola);
		pasarPila(pilaAux2, pila);
		
		return conjuntoComun;
		
	}
	
	/***
	 * @Consigna
	 * 6. Se define un método que reciba una PilaTDA y devuelva un 
	 * DiccionarioSimpleTDA, en el cual se guardarán los elementos 
	 * de la pila como claves, y la cantidad de apariciones de dicho 
	 * elemento en la pila, como valores.
	 * 
	 * @Tarea Creamos un diccionario que almacene los valores como se indica en la consigna
	 * y una pilaAux para almacenar los valores y poder dejar intacta la pila que recibimos 
	 * como parametro.
	 * 
	 * Luego recorremos la pila preservando su valor en una pila auxiliar 
	 * y buscando cada elemento de la pila en el diccionario.
	 * Si esta, le sumamos 1 al valor que recuperamos del diccionario.
	 * Si el valor que recuperamos del diccionario es menor a 0, significa que 
	 * el valor no habia sido guardado todavia. 
	 * 
	 * En ese caso guardamos el valor de la pila en el diccionario con
	 * la clave = valor del elemento de la pila y valor=1.
	 * 
	 * @Parametros PilaTDA con n elementos enteros positivos.
	 * @Devuelve Un DiccionarioSimple con los elementos de la pila como claves y 
	 * la cantidad de ocurrencias en la pila como valores del diccionario.
	 * @Precondiciones todos los elementos de la pila deveran ser enteros positivos
	 * ya que el diccionario, al no encontrar un valor en el metodo recuperar, 
	 * devolvera -1.
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 * El costo será polinomico: (p * p) + p
	 * 
	 * Por cada elemento de la pila, buscaremos si existe en el diccionario 
	 * antes de agregarlo. 
	 *  
	 * Y en el metodo recuperar, el diccionario simple recorrera sus claves
	 * hasta encontrar la buscada. Entonces el costo de hacerlo sera d, 
	 * donde d es la cantidad de elementos del diccionario. Entonces el costo seria p * d.
	 *   
	 * Pero como d, esta relacionado a la cantidad de elementos de la pila, asumiremos el 
	 * peor caso, que seria que los elementos de la pila sean todos diferentes. Siendo
	 * entonces el costo p * p.
	 * 
	 * A este costo se le suma otra p, ya que debemos mantener el valor de la pila 
	 * tal como lo recibimos. 
	 */
	public static DiccionarioSimpleTDA contarElementosPila(PilaTDA pila) {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		PilaTDA pilaAux2 = new Pila();
		pilaAux2.inicializarPila();
		
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
		
		return diccionarioSimple;
		
	}
	
	/***
	 * @Consigna
	 * 7. Se define un método que reciba un DiccionarioMultipleTDA 
	 * y devuelva una ColaTDA con todos los valores del diccionario, 
	 * sin ninguna repetición.
	 * 
	 * @Tarea 
	 * Creamos una cola para armar el resultado del metodo.
	 * 
	 * Creamos un conjuntoVerificador para verificar la unicidad de cada elemento.
	 * 
	 * Recorremos el diccionario utilizando el conjunto de claves
	 * que obtenemos con el metodo claves()
	 * 
	 * Con cada clave, buscamos su respectivo valor en el diccionario
	 * que al ser multiple, sera un conjuntoTDA.
	 * 
	 * Recorreremos buscando cada elemento del conjunto relacionado a esa clave y 
	 * verificamos si existe llamando al metodo pertenece del conjuntoVerificador
	 * y si no existe entonces lo agregamos a la cola y al conjuntoVerificador. 
	 * 
	 * Tambien eliminamos la clave del conjunto 
	 * para poder obtener otros elementos del conjunto 
	 * que no hayamos obtenido todavia. 
	 * 
	 * @Parametros Un DiccionarioMultipleTDA con elementos
	 * @Devuelve Una ColaTDA con los elementos del diccionario, sin repetir
	 * @Precondiciones 
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 * 
	 * El costo sera lineal, de la siguiente forma: d + (d + e) * c
	 * 
	 * Siendo:
	 * 
	 * d: la cantidad de claves del diccionario
	 * e: la cantidad de elementos en los conjuntos del diccionario.
	 * c: la cantidad de elementos en la cola 
	 * 
	 * La primera d, por el armado del conjunto de claves del diccionario
	 * 
	 * (d + e), por el recorrido de esas claves buscando los 
	 * conjuntos en el diccionario y luego e, recorriendo los elementos del conjunto.
	 * 
	 * (* c), por que por cada nuevo valor, recorremos los elementos
	 * del conjunto para verificar si ya se encuentra en la cola. 
	 * 
	 */
	public static ColaTDA eliminarRepetidosDM(DiccionarioMultipleTDA diccionarioMultiple) {
		ColaTDA cola = new Cola();
		cola.inicializarCola();
		
		ConjuntoTDA conjuntoVerificador = new Conjunto();
		conjuntoVerificador.inicializarConjunto();
		
		ConjuntoTDA conjuntoClaves = diccionarioMultiple.claves();
		while (!conjuntoClaves.conjuntoVacio()){
			int claveDelDiccionario = conjuntoClaves.elegir();
			conjuntoClaves.sacar(claveDelDiccionario);
			 
			ConjuntoTDA conjuntoElementos = diccionarioMultiple.recuperar(claveDelDiccionario);
			int elementoDelDiccionario = conjuntoElementos.elegir();
			conjuntoElementos.sacar(elementoDelDiccionario);
			
			if(!conjuntoVerificador.pertenece(elementoDelDiccionario)) {
				cola.acolar(elementoDelDiccionario);
				conjuntoVerificador.agregar(elementoDelDiccionario);
			}
		}
		
		return cola;
	}
	
	/***
	 * @Consigna
	 * 8. Se define un método que calcule la suma de los elementos 
	 * con un valor impar de un ABB.
	 * 
	 * @Tarea 
	 * Para obtener la suma de los elementos impares realizaremos 
	 * el recorrido del arbol utilizando la recursividad para recorrer las hojas
	 * 
	 * Primero verificamos que el arbol no se encuentre vacio.
	 * Luego verificamos el valor de la raiz con el modulo, si es impar lo sumamos.
	 * 
	 * Luego analizaremos a los hijos, comenzando por el izquierdo,
	 * si no es un arbol vacio (no es hoja), entonces volveremos a llamar
	 * al metodo calcularSumaImpares, que analizara la raiz y volvera
	 * a llamarse recursivamente hasta llegar a la hoja.
	 * 
	 * Una vez que llegue a la hoja devolvera el valor de los impares que 
	 * resultan en el subarbol izquierdo.
	 * 
	 * Luego haremos lo mismo con el lado derecho.
	 * 
	 * @Parametros ABBTDA 
	 * @Devuelve un entero que corresponde a la suma de todos los valores impares del arbol
	 * @Precondiciones 
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 * El costo sera lineal, siendo n la cantidad de elementos del arbol.
	 */
	public static int calcularSumaImpares(ABBTDA abb) {
		int suma = 0;
		
		if(!abb.arbolVacio()) {
			if((abb.raiz() % 2) == 1) {
				suma += abb.raiz();
			}
			
			if (!abb.hijoIzq().arbolVacio()) {
				suma += calcularSumaImpares(abb.hijoIzq());
			}
			
			if (!abb.hijoDer().arbolVacio()) {
				suma += calcularSumaImpares(abb.hijoDer());
			}
		}
		return suma;
	}
	
	/***
	 * @Consigna
	 * 9. Se define un método que calcule la cantidad de hojas 
	 * con un valor par de un ABB.
	 * 
	 * @Tarea 
	 * Para obtener las hojas pares realizaremos 
	 * el recorrido del arbol utilizando la recursividad para recorrer las hojas.
	 * 
	 * Primero verificamos que el arbol no se encuentre vacio.
	 * Luego identificaremos si es hoja o raiz, llamaremos al metodo
	 * recursivamente hasta llegar a una hoja.
	 * 
	 * Una vez que encontremos una hoja, verificaremos que sea par utilizando
	 * la operacion de modulo.
	 * 
	 * Si es par, sumaremos 1 al contador.
	 * 
	 * 
	 * 
	 * @Parametros 
	 * @Devuelve 
	 * @Precondiciones 
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 * El costo sera linea, siendo n la cantidad de elementos del arbol.
	 */
	public static int calcularCantHojasPares(ABBTDA abb) {
		int cantHojasPares = 0;
		
		if(!abb.arbolVacio()) {
			if (abb.hijoIzq().arbolVacio() 
					&& abb.hijoDer().arbolVacio()) { //Es una hoja
				if((abb.raiz() % 2) == 0) {
					cantHojasPares ++;
				}
			} else {
				if (!abb.hijoIzq().arbolVacio()) {
					cantHojasPares += calcularCantHojasPares(abb.hijoIzq());
				}
				if (!abb.hijoDer().arbolVacio()) {
					cantHojasPares += calcularCantHojasPares(abb.hijoDer());
				}
			}
		}
		return cantHojasPares;
	}
	
	/***
	 * @Consigna
	 * 10. Se define un método que reciba un GrafoTDA y dos 
	 * enteros que representen vértices, y devuelva un ConjuntoTDA 
	 * con todos los vértices puente entre los vértices 
	 * recibidos por parámetro.
	 * 
	 * Se define que un vértice p es puente entre dos vértices o y d, 
	 * si hay una arista que comienza en o y termina en p 
	 * y otra que comienza en p y termina en d.
	 * 
	 * @Tarea 
	 * Obtenemos el conjunto de vertices del grafo.
	 * 
	 * Luego recorremos el conjunto de vertices del grafo
	 * y por cada vertice verificamos si es un vertice puente 
	 * y para ello llamamos al metodo existe arista, buscando una arista que salga de 
	 * v1 y llegue al vertice y luego que salga del vertice y llegue a v2 o
	 * al reves. 
	 * 
	 * Si cumple las dos condiciones y es un vertice puente, lo agregamos al 
	 * conjunto de vertices puente.
	 * 
	 * @Parametros 
	 * @Devuelve 
	 * @Precondiciones 
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 * Sera: v (v * 8 a)
	 * Donde:
	 * v: cantidad de vertices.
	 * a: cantidad de aristas.
	 * 
	 * La primer v, refleja el costo del metodo vertices() del grafo,
	 * En donde para armar el conjunto de vertices se realiza un recorrido
	 * de todos los elementos del grafo.
	 * 
	 * Luego por cada metodo existeArista, se recorren dos veces los elementos
	 * arista.
	 */
	public static ConjuntoTDA obtenerVerticesPuente(GrafoTDA grafo, int v1, int v2) {
		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();
		
		ConjuntoTDA vertices = grafo.vertices();
		while (!vertices.conjuntoVacio()) {
			int vertice = vertices.elegir();
			vertices.sacar(vertice);
			if ((grafo.existeArista(v1, vertice) && grafo.existeArista(vertice, v2)) ||
				(grafo.existeArista(v2, vertice) && grafo.existeArista(vertice, v1))) {
				conjunto.agregar(vertice);
			}
		}
		
		return conjunto;
	}
	
	/***
	 * @Consigna
	 * 11. Se define un método que reciba un GrafoTDA 
	 * y un entero que represente un vértice, 
	 * y devuelva el grado del vértice recibido por parámetro. 
	 * Se define el grado de un vértice v 
	 * como el entero que es igual a la resta 
	 * entre la cantidad de aristas que salen de v 
	 * menos la cantidad de aristas que llegan a v.
	 * 
	 * @Tarea 
	 * Obtenemos el conjunto de vertices del grafo.
	 * 
	 * Luego recorremos el conjunto de vertices del grafo:
	 * por cada vertice verificamos si existe la arista saliente
	 * y la arista entrante.
	 * 
	 * Si existe le sumamos 1 al contador de salientes/entrantes segun corresponda.
	 * 
	 * Por ultimo realizamos la resta y devolvemos ese valor.
	 * 
	 * @Parametros Un GrafoTDA y un vertice.
	 * @Devuelve Un entero con el grado del vertice
	 * @Precondiciones 
	 * @Postcondiciones 
	 * 
	 * @Costo 
	 * Sera: v + (v * 4 a)
	 * Donde:
	 * v: cantidad de vertices.
	 * a: cantidad de aristas.
	 * 
	 * La primer v, refleja el costo del metodo vertices() del grafo,
	 * En donde para armar el conjunto de vertices se realiza un recorrido
	 * de todos los elementos del grafo.
	 * 
	 * Luego por cada elemento del vertice, 
	 * se realizan dos llamados al metodo existeArista, 
	 * se recorren dos veces los elementos
	 * arista, 1 por cada vertice recibido como parametro. 
	 * Como este metodo se llama dos veces dentro del recorrido de los vertices, 
	 * los costos se multiplican
	 */
	public static int obtenerGradoDelVertice(GrafoTDA grafo, int v) {
		int salientes = 0;
		int entrantes = 0;
		
		ConjuntoTDA vertices = grafo.vertices();
		while (!vertices.conjuntoVacio()) {
			int vertice = vertices.elegir();
			vertices.sacar(vertice);
			if (grafo.existeArista(v, vertice)){
				salientes++;
			}
			if (grafo.existeArista(vertice, v)){
				entrantes++;
			}
		}
		
		return (salientes - entrantes);
	}
	
	private static void pasarCola(ColaTDA origen, ColaTDA destino){
		 while (!origen.colaVacia() ){
			 destino.acolar(origen.primero());
			 origen.desacolar() ;
		 }
	}
	
	/***
	 * a) Pasar una Pila a otra (dejándola en orden inverso)
	 * @param origen
	 * @return
	 */
	private static void pasarPila(PilaTDA origen, PilaTDA destino){
		while (!origen.pilaVacia()) {
			destino.apilar(origen.tope());
			origen.desapilar() ;
		}
	}
	
}
