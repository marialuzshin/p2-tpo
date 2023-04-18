package usr;

import impl.Pila;
import tda.PilaTDA;

public class TestPila {

	public void test() {
		System.out.println("Crear una pila e imprimirla");
		imprimirPila(crearPila(5));
		System.out.println("---------------------------------------------");
		
		System.out.println("a) Pasar una Pila a otra (dejándola en orden inverso)");
		PilaTDA origen = crearPila(5);
		PilaTDA destino = crearPila(0);
		pasarPila(origen, destino);
		imprimirPila(destino);
		System.out.println("---------------------------------------------");
		
		System.out.println("b) Copiar una Pila en otra (dejándola en el mismo orden que la original)");
		PilaTDA original = crearPila(5);
		PilaTDA copia = copiarPila(original);
		imprimirPila(copia);
		System.out.println("---------------------------------------------");
		
		System.out.println("c) Invertir el contenido de una Pila.");
		PilaTDA pila = crearPila(5);
		PilaTDA pilaInvertida = invertirPila(pila);
		imprimirPila(pilaInvertida);
		System.out.println("---------------------------------------------");
		
		System.out.println("d) Contar los elementos de una Pila");
		PilaTDA pila2 = crearPila(5);
		System.out.println("Cantidad de Elementos: " + contarElementosPila(pila2));
		System.out.println("---------------------------------------------");
		
		System.out.println("e) Sumar los elementos de una Pila");
		PilaTDA pila3 = crearPila(5);
		System.out.println("Elementos: " + sumarElementosPila(pila3));
		System.out.println("---------------------------------------------");
		
		System.out.println("f) Calcular el promedio de los elementos de una Pila");
		PilaTDA pila4 = crearPila(5);
		System.out.println("Promedio: " + promedioElementosPila(pila4));
		System.out.println("---------------------------------------------");
	}
	
	private PilaTDA crearPila(int cantidadElementos) {
		PilaTDA pilaTDA = new Pila();
		pilaTDA.inicializarPila();
		int valorElemento = 1;
		while (cantidadElementos != 0) {
			pilaTDA.apilar(valorElemento);
			valorElemento++;
			cantidadElementos--;
		}
		
		return pilaTDA;
	}
	
	private void imprimirPila(PilaTDA pila) {
		while (!pila.pilaVacia()) {
			System.out.println("Pila: " + pila.tope());
			pila.desapilar();
		}
	}
	
	/***
	 * a) Pasar una Pila a otra (dejándola en orden inverso)
	 * @param origen
	 * @return
	 */
	private void pasarPila(PilaTDA origen, PilaTDA destino){
		while (!origen.pilaVacia()) {
			destino.apilar(origen.tope());
			origen.desapilar() ;
		}
	}
	
	/***
	 * b) Copiar una Pila en otra (dejándola en el mismo orden que la original)
	 * @param origen
	 * @return
	 */
	private PilaTDA copiarPila(PilaTDA origen){
		PilaTDA destino = invertirPila(origen);		
		return invertirPila(destino);
	}
	
	/***
	 * c) Invertir el contenido de una Pila.
	 * @param origen
	 * @return
	 */
	private PilaTDA invertirPila(PilaTDA origen){
		PilaTDA destino = new Pila();
		destino.inicializarPila();
		
		while (!origen.pilaVacia()) {
			destino.apilar(origen.tope());
			origen.desapilar() ;
		}
		
		return destino;
	}
	
	/***
	 * d) Contar los elementos de una Pila
	 * @param p
	 * @return
	 */
	private int contarElementosPila(PilaTDA p){
		int elementos = 0;
		while (!p.pilaVacia()){
			elementos++;
			p.desapilar() ;
		}
		return elementos;
	}
	
	/***
	 * e) Sumar los elementos de una Pila
	 * @param p
	 * @return
	 */
	private int sumarElementosPila(PilaTDA p){
		int suma = 0;
		while (!p.pilaVacia()){
			suma = suma + p.tope();
			p.desapilar() ;
		}
		return suma;
	}
	
	/***
	 * f) Calcular el promedio de los elementos de una Pila
	 * @param p
	 * @return
	 */
	private int promedioElementosPila(PilaTDA p){
		int suma = 0;
		int elementos = 0;
		while (!p.pilaVacia()){
			suma = suma + p.tope();
			elementos++;
			p.desapilar() ;
		}
		return suma/elementos;
	}
}

