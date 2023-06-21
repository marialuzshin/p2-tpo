package usr;

import tda.ConjuntoTDA;
import impl.Conjunto;

public class TestConjuntoTDA {
	public static boolean sonIguales(ConjuntoTDA a, ConjuntoTDA b) {
		Conjunto aux1 = new Conjunto();
		aux1.inicializarConjunto();
		
		Conjunto aux2 = new Conjunto();
		aux2.inicializarConjunto();
		
		
		
		boolean iguales=true;
		int elemento;
		while (!aux1.conjuntoVacio() && !aux2.conjuntoVacio() && iguales ) {
		
		elemento=aux1.elegir();
		
		if (!aux2.pertenece(elemento)) {
			iguales=false;
		} else {
			aux1.sacar(elemento);
			aux2.sacar(elemento);
			}
		}
		return (aux1.conjuntoVacio() && aux2.conjuntoVacio());
	}
}
