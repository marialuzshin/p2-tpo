package tda;

public interface ColaPrioridadTDA {

	void inicializarCola();
	
	// siempre que la cola esté inicializada
	void acolarPrioridad(int prioridad, int valor);
	
	// siempre que la cola esté inicializada y no esté vacía
	void desacolar();
	
	// siempre que la cola esté inicializada y no esté vacía
	int primero();
	
	// siempre que la cola esté inicializada
	boolean colaVacia();
	
	// siempre que la cola esté inicializada y no esté vacía 
	int prioridad();
}
