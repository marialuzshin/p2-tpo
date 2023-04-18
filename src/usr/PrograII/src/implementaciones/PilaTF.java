package implementaciones;

import apis.PilaTDA;

public class PilaTF implements PilaTDA {

	int [] a ; // arreglo en donde se guarda la informaci´on
	int indice; // variable entera en donde se guarda la cantidad
		//de elementos que se tienen guardados
	
	@Override
	public void InicializarPila() {
		a = new int [100];
		indice = 0;

	}

	@Override
	public void Apilar(int x) {
		a[ indice] = x;
		indice++;

	}

	@Override
	public void Desapilar() {
		indice --;
	}

	@Override
	public boolean PilaVacia() {
		return (indice == 0);
	}

	@Override
	public int Tope() {
		return a [indice -1];
	}

}
