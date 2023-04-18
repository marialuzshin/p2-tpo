package implementaciones;

import apis.PilaTDA;

public class PilaTI implements PilaTDA {
	
	int [] a ; // arreglo en donde se guarda la informaci´on
	int indice; // variable entera en donde se guarda la cantidad
				//	de elementos que se tienen guardados

	@Override
	public void InicializarPila() {
		a = new int [100];
		indice = 0;
	}

	@Override
	public void Apilar(int x) {
		for ( int i = indice -1; i >=0; i --)
		a[i +1] = a[i ];
		a [0] = x;
		indice++;
	}

	@Override
	public void Desapilar() {
		for ( int i = 0; i < indice; i ++)
		a[i] = a[i +1];
		indice --;

	}

	@Override
	public boolean PilaVacia() {
		return ( indice == 0) ;
	}

	@Override
	public int Tope() {
		return a [0];
	}

}
