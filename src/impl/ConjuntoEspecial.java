package impl;

import tda.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

	int[] elementos;
	int cant;
	
	@Override
	public void inicializarConjunto() {
		elementos = new int[100];
		cant = 0;
	}

	@Override
	/***
	 * @Tarea 
	 * Verifico con el metodo pertenece si el elemento 
	 * ya se encuentra agregado.
	 * Si no esta agregado la agrego y luego 
	 * le asigno false al error de la respuesta.
	 * si ya se encuentra agregado respondo con 
	 * error true y el valor que se quiso agregar
	 * 
	 * @Parametros elemento: el elemento que se intenta agregar
	 * @Devuelve Una Respuesta indicando si ocurrio un error 
	 * y el valor que se deseaba agregar
	 * @Precondiciones  para que la respuesta no indique error, el valor que 
	 * se desea agregar no debe pertenecer al conjunto
	 * @Postcondiciones 
	 * @Costo El costo es lineal ya que para verificar que el 
	 * elemento no pertenezca al conjunto se recorren todos los 
	 * elementos del conjunto. En ese caso el costo dependera de la 
	 * cantidad de elementos que tenga el conjunto.
	 */
	public Respuesta agregar(int elemento) {
		Respuesta respuesta = new Respuesta(true, elemento);
		if(!pertenece(elemento)) { 
			elementos[cant] = elemento;
			cant++;
			respuesta.error = false;
		} 
		return respuesta;
	}

	@Override
	/***
	 * @Tarea 
	 * Recorro el conjunto de elementos hasta encontrar el 
	 * buscado utilizando la variable cant, que contiene la
	 * cantidad de elementos del conjunto.
	 *  
	 * 
	 * Si encontre el elemento entonces en ese lugar del 
	 * arreglo de elementos asigno el ultimo elemento 
	 * y disminuyo en 1 la variable cant.
	 * 
	 * @Parametros elemento: el elemento que se intenta eliminar
	 * @Devuelve Una Respuesta indicando si ocurrio un error
	 * siendo un error, que el elemento que se haya buscado eliminar
	 * no estuviera dentro del conjunto. 
	 * y el valor que se deseaba eliminar
	 * @Precondiciones para que la respuesta no indique error, el valor que 
	 * se desea sacar debe pertenecer al conjunto
	 * @Postcondiciones 
	 * @Costo El costo es lineal ya que dependera de la 
	 * cantidad de elementos que tenga el conjunto.
	 */
	public Respuesta sacar(int valor) {
		Respuesta respuesta = new Respuesta(true, valor);
		int i = 0;// Busco el elemento
		while(i < cant && elementos[i] != valor) {
			i++;
		}
		if(i < cant) {
			// Si lo encuentra lo reemplazo por el ultimo y decremento el cant
			elementos[i] = elementos[ cant - 1 ];
			cant--;
			respuesta.error = false;
		} 
		return respuesta;
	}

	/***
	 * @Tarea 
	 * verifico que la cantidad de elementos del
	 * conjuntos sea mayor a sero y de ser asi
	 * obtengo un valor aleatorio del conjunto y 
	 * lo devuelvo en la respuesta con el valor de error en false
	 * 
	 * Si la cantidad de elementos del conjunto no 
	 * es mayor a cero (conjunto vacio) entonces
	 * devuelvo la respuesta con error = true y 
	 * con el valor en -1
	 * 
	 * @Parametros 
	 * @Devuelve Una Respuesta indicando si ocurrio un error
	 * siendo un error, que no existan elementos a elegir.
	 * @Precondiciones Para que no responda con error
	 *  debera haber elementos dentro del conjuntos
	 * @Postcondiciones 
	 * @Costo El costo es constante ya que siempre sera el mismo
	 *  y no variara segun la cantidad de elementos del conjunto
	 */
	@Override
	public Respuesta elegir() {
		Respuesta respuesta;
		if (cant > 0) {
			int x = (int) Math.random() * cant;
			respuesta = new Respuesta(false, elementos[x]);
		} else {
			respuesta = new Respuesta(true, -1);
		}
		
		
		return respuesta;
	}

	@Override
	public boolean pertenece(int valor) {
		int i = 0;
		while (i<cant && elementos[i] != valor) {
			i++;
		}
		return (i < cant);
	}

	@Override
	public boolean conjuntoVacio() {
		return (cant==0);
	}

}
