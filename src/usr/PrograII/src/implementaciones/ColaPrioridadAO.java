package implementaciones;

import apis.ColaPrioridadTDA;

public class ColaPrioridadAO implements ColaPrioridadTDA {

	class Elemento{ 
		int valor; 
		int prioridad; 
	}
	
	Elemento[] elementos; 
	int indice;

	@Override
	public void InicializarCola() {
		indice = 0; 
		elementos = new Elemento[100];
	}

	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		//desplaza a derecha los elementos de la cola mientras 
		//estos tengan mayor o igual prioridad que la de x 
		for (; j>0 && elementos[j-1]. prioridad>=prioridad; j--){ 
			elementos[j] = elementos[j-1]; 
		} 
		elementos[j]= new Elemento(); 
		elementos[j].valor=x; 
		elementos[j].prioridad = prioridad; 
		indice++;
	}

	@Override
	public void Desacolar() {
		elementos[indice - 1]= null; 
		indice --;

	}

	@Override
	public int Primero() {
		return elementos[indice -1]. valor;
	}

	@Override
	public boolean ColaVacia() {
		return (indice == 0);
	}

	@Override
	public int Prioridad() {
		return elementos[indice -1]. prioridad;
	}

}
