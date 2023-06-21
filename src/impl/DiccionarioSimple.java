package impl;

import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	
	ColaPrioridadTDA colaPrioridad;

	@Override
	public void inicializarDiccionario() {
		colaPrioridad = new ColaPrioridad();
		colaPrioridad.inicializarCola();
	}

	@Override
	/***
	 * @Tarea 
	 * Recorrer la cola con prioridad que contiene los elementos del diccionario
	 * pasando los valores a una nueva cola y
	 * verificando si entre ellos ya existe la clave a agregar.
	 * En caso de que exista la clave al pasarlo a la nueva cola le cambiamos el valor
	 * y cambiamos un flag a true para indicar que encontramos la clave y que ya la
	 * agregamos a la cola aux.
	 * En caso de que no exista la clave todavia, al finalizar el recorrido de la cola
	 * verificaremos que el flag se encuentra en false, en ese caso agregaremos el valor
	 * al final de la cola aux y luego asignaremos a la cola principal
	 * la instancia de la cola aux.
	 * @Parametros
	 * claveAAgregar: la clave asignada a un valor, esta sera unica en el diccionario
	 * valorAAgregar: el valor que se guardara asociado a una clave unica
	 * @Devuelve void (vacio)
	 * @Precondiciones que ambos valores sean de tipo int (entero)
	 * @Postcondiciones 
	 * @Costo Como la cola se recorre una sola vez de forma secuencial, el costo sera 
	 * lineal ya que su costo dependera de la cantidad de elementos que existan 
	 * dentro de la cola.
	 */
	public void agregar(int claveAAgregar, int valorAAgregar) {
		
		ColaPrioridadTDA colaPrioridadAux = new ColaPrioridad();
		colaPrioridad.inicializarCola();
			
		boolean claveEncontrada = false;
		
		while(colaPrioridad.colaVacia()) {
			int clave = colaPrioridad.prioridad();
			int valor = colaPrioridad.primero();
			
			if(clave == claveAAgregar) {
				colaPrioridadAux.acolarPrioridad(clave, valorAAgregar);
				claveEncontrada = true;
			} else {
				colaPrioridadAux.acolarPrioridad(clave, valor);
			}
			
			colaPrioridad.desacolar();
				
		} 

		if (!claveEncontrada) {
			colaPrioridadAux.acolarPrioridad(claveAAgregar, valorAAgregar);
		} 
		colaPrioridad = colaPrioridadAux;
	}

	@Override
	/***
	 * @Tarea 
	 * Recorrer la cola con prioridad que contiene los elementos del diccionario
	 * pasando los valores a una nueva cola y
	 * buscando el valor a eliminar, si entre ellos ya existe lo encuentra no lo 
	 * agrega a la cola auxiliar.
	 * Cuando finaliza el recorrido de la cola, asigna la cola auxiliar a la 
	 * cola principal (sin la clave/valor de la clave eliminada)
	 * @Parametros
	 * claveAEliminar: la clave asociada a un valor, que se busca eliminar del diccionario
	 * @Devuelve void (vacio)
	 * @Precondiciones que el valor de la clave sea de tipo int (entero)
	 * @Postcondiciones 
	 * @Costo Como la cola se recorre una sola vez de forma secuencial, el costo sera 
	 * lineal ya que su costo dependera de la cantidad de elementos que existan 
	 * dentro de la cola.
	 */
	public void eliminar(int claveAEliminar) {
		ColaPrioridadTDA colaPrioridadAux = new ColaPrioridad();
		colaPrioridad.inicializarCola();
	
			
		while(colaPrioridad.colaVacia()) {
			int clave = colaPrioridad.prioridad();
			int valor = colaPrioridad.primero();
			
			if(clave != claveAEliminar) {
				colaPrioridadAux.acolarPrioridad(clave, valor);
			} 
			
			colaPrioridad.desacolar();
				
		} 

		colaPrioridad = colaPrioridadAux;
	}
	
	/***
	 * @Tarea 
	 * Recorrer la cola con prioridad que contiene los elementos del diccionario
	 * pasando los valores a una nueva cola y
	 * verificando si la clave es la buscada, de ser la buscada la guarda en
	 *  una variable auxiliar que despues se utilizara para devolver el valor
	 * Cuando finaliza el recorrido de la cola, asigna la cola auxiliar a la 
	 * cola principal y retorna el valor encontrado. 
	 * De no haber encontrado la clave devolvera -1
	 * @Parametros
	 * claveARecuperar: la clave asociada a un valor, que se desea recuperar
	 * @Devuelve el valor de la clave recuperada. caso contrario devuelve -1
	 * @Precondiciones que el valor de la clave sea de tipo int (entero), 
	 * que la clave exista, para evitar un problema de compilacion se le asigna el 
	 * valor -1.
	 * @Postcondiciones 
	 * @Costo Como la cola se recorre una sola vez de forma secuencial, el costo sera 
	 * lineal ya que su costo dependera de la cantidad de elementos que existan 
	 * dentro de la cola.
	 */
	@Override
	public int recuperar(int claveARecuperar) {
		int valorARecuperar = -1;
		ColaPrioridadTDA colaPrioridadAux = new ColaPrioridad();
		colaPrioridad.inicializarCola();
			
		while(colaPrioridad.colaVacia()) {
			int clave = colaPrioridad.prioridad();
			int valor = colaPrioridad.primero();
			
			if(clave != claveARecuperar) {
				valorARecuperar = valor;
			} 
			
			colaPrioridadAux.acolarPrioridad(clave, valor);
			colaPrioridad.desacolar();
				
		} 

		colaPrioridad = colaPrioridadAux;
		return valorARecuperar;
	}

	/***
	 * @Tarea 
	 * Recorrer la cola con prioridad que contiene los elementos del diccionario
	 * pasando los valores a una nueva cola y pasando ademas las claves a un
	 * nuevo conjunto. 
	 * Cuando finaliza el recorrido de la cola, asigna la cola auxiliar a la 
	 * cola principal y retorna el conjunto de claves. 
	 * @Parametros
	 * @Devuelve el conjunto de claves
	 * @Precondiciones
	 * @Postcondiciones 
	 * @Costo Como la cola se recorre una sola vez de forma secuencial, el costo sera 
	 * lineal ya que su costo dependera de la cantidad de elementos que existan 
	 * dentro de la cola.
	 */
	@Override
	public ConjuntoTDA claves() {
		Conjunto conjuntoClaves = new Conjunto();
		conjuntoClaves.inicializarConjunto();
		
		ColaPrioridadTDA colaPrioridadAux = new ColaPrioridad();
		colaPrioridad.inicializarCola();
			
		while(colaPrioridad.colaVacia()) {
			int clave = colaPrioridad.prioridad();
			int valor = colaPrioridad.primero();
			
			conjuntoClaves.agregar(clave);
			
			colaPrioridadAux.acolarPrioridad(clave, valor);
			colaPrioridad.desacolar();
				
		} 

		colaPrioridad = colaPrioridadAux;
		
		
		return conjuntoClaves;
	}

	
}
