package impl;

import tda.ColaTDA;

public class Cola implements ColaTDA {

	int[] arr;
	int indice;
	
	@Override
	public void inicializarCola() {
		arr = new int[100];
		indice = 0;
	}

	@Override
	public void acolar(int x) {
		arr[indice] = x;
		indice++;
	}

	@Override
	public void desacolar() {
		for (int i = 0; i < indice-1; i++){
			int elementoSiguiente = arr[i+1];
			arr[i] = elementoSiguiente;
		} 
		indice--;
	}

	@Override
	public boolean colaVacia() {
		return indice == 0;
	}

	@Override
	public int primero() {
		return arr[0];
	}

}
