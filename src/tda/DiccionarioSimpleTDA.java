package tda;

public interface DiccionarioSimpleTDA {
	void inicializarDiccionario();
	
	// siempre que el diccionario esté inicializado
	void agregar(int clave, int valor);
	
	// siempre que el diccionario esté inicializado
	void eliminar(int clave);
	
	// siempre que el diccionario esté inicializado y la clave exista en el mismo
	int recuperar(int clave);
	
	// siempre que el diccionario esté inicializado
	ConjuntoTDA claves();
}
