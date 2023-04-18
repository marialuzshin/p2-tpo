package usr;

import impl.Cola;
import impl.Pila;
import tda.ColaTDA;
import tda.PilaTDA;

public class TestCola {

	public void test() {
		System.out.println("a) Pasar una Cola a otra.");
		ColaTDA cola = crearCola(5);
		ColaTDA colaDestino = crearCola(5);
		pasarCola(cola, colaDestino);
		imprimirCola(colaDestino);
		System.out.println("---------------------------------------------");
		
		
		System.out.println("b) Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)");
		ColaTDA cola1 = crearCola(5);
		invertirColaConPilaAux(cola1);
		imprimirCola(cola1);
		System.out.println("---------------------------------------------");
		
		System.out.println("c) Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)");
		ColaTDA cola2 = crearCola(5);
		invertirColaSinPilaAux(cola2);
		imprimirCola(cola2);
		System.out.println("---------------------------------------------");
		
		System.out.println("d) Determinar si el final de la Cola C1 coincide o no con la Cola C2.");
		ColaTDA cola3 = crearCola(5);
		ColaTDA cola4 = crearCola(6);
		System.out.println("Coincide (false): " + coincideElFinal(cola3, cola4));
		ColaTDA cola5 = crearCola(2);
		cola5.acolar(7);
		ColaTDA cola6 = crearCola(7);
		System.out.println("Coincide (true): " + coincideElFinal(cola5, cola6));
		System.out.println("---------------------------------------------");
		
		System.out.println("e) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir"
				+ " que el primer elemento es igual al último, el segundo igual al penúltimo, etc.");
		
		System.out.println("Capicua (false): " + esCapicua(crearCola(4)));
		ColaTDA cola7 = crearCola(4);
		cola7.acolar(3);
		cola7.acolar(2);
		cola7.acolar(1);
		System.out.println("Capicua (true): " + esCapicua(cola7));
		ColaTDA cola8 = crearCola(3);
		cola7.acolar(3);
		cola7.acolar(2);
		cola7.acolar(1);
		System.out.println("Capicua (true): " + esCapicua(cola8));
		System.out.println("---------------------------------------------");
		
		System.out.println("f) Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán"
				+ " inversas, si tienen los mismos elementos pero en orden inverso");
		System.out.println("---------------------------------------------");
				
		
	}
	
	

	private ColaTDA crearCola(int cantidadElementos) {
		ColaTDA cola = new Cola();
		cola.incializarCola();
		int valorElemento = 1;
		while (cantidadElementos != 0) {
			cola.acolar(valorElemento);
			valorElemento++;
			cantidadElementos--;
		}
		return cola;
	}
	
	private void imprimirCola(ColaTDA cola) {
		while (!cola.colaVacia()) {
			System.out.println("Cola: " + cola.primero());
			cola.desacolar();
		}
	}
	
	private void pasarCola(ColaTDA origen, ColaTDA destino){
		 while (!origen.colaVacia() ){
			 destino.acolar(origen.primero());
			 origen.desacolar() ;
		 }
	}
	
	private void invertirColaConPilaAux(ColaTDA cola) {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		while(!cola.colaVacia()) {
			pilaAux.apilar(cola.primero());
			cola.desacolar();	
		}
		
		while(!pilaAux.pilaVacia()) {
			cola.acolar(pilaAux.tope());
			pilaAux.desapilar();
		}
		
	}
	
	private void invertirColaSinPilaAux(ColaTDA cola) {
		
		while(!cola.colaVacia()) {
			cola.primero();
			cola.desacolar();	
		}
		
	}
	
	private boolean coincideElFinal(ColaTDA cola1, ColaTDA cola2) {
		int ultimoElementoCola1 = 0;
		int ultimoElementoCola2 = 0;
		while (!cola1.colaVacia()) {
			ultimoElementoCola1 = cola1.primero();
			cola1.desacolar();
		}
		while (!cola2.colaVacia()) {
			ultimoElementoCola2 = cola2.primero();
			cola2.desacolar();
		}
		return (ultimoElementoCola1 == ultimoElementoCola2);
	}
	
	private boolean esCapicua(ColaTDA cola) {
		boolean esCapicua = true;
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		ColaTDA colaAux = crearCola(0);
		int cantidadElementos = 0;
		
		while(!cola.colaVacia()) {
			pilaAux.apilar(cola.primero());
			colaAux.acolar(cola.primero());
			cantidadElementos++;
			cola.desacolar();	
		}
		
		while(!colaAux.colaVacia() && esCapicua) {
			if (cola.primero() != pilaAux.tope()) {
				esCapicua = false;
			} 
			colaAux.desacolar();
			pilaAux.desapilar();
		}
		return esCapicua;
	}
}

