package impl;

import tda.ABBTDA;

public class ABB implements ABBTDA {

	class NodoABB {
		int info;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	NodoABB nodo;
	
	@Override
	public int raiz() {
		return nodo.info;
	}

	@Override
	public ABBTDA hijoIzq() {
		return nodo.hijoIzq;
	}

	@Override
	public ABBTDA hijoDer() {
		return nodo.hijoDer;
	}

	@Override
	public boolean arbolVacio() {
		return nodo == null;
	}

	@Override
	public void inicializarArbol() {
		nodo = null;
	}

	@Override
	public void agregarElem(int x) {
		if(nodo == null) {
			nodo = new NodoABB();
			nodo.info = x;
			nodo.hijoIzq = new ABB();
			nodo.hijoIzq.inicializarArbol();
			nodo.hijoDer = new ABB();
			nodo.hijoDer.inicializarArbol();
		} else if(nodo.info > x) {
			nodo.hijoIzq.agregarElem(x);
		} else if(nodo.info < x) {
		nodo.hijoDer.agregarElem(x);
		}
	}

	@Override
	public void eliminar(int x) {
		if (nodo != null) {
			if (nodo.info == x) {
				if (nodo.hijoDer.arbolVacio() 
						&& nodo.hijoIzq.arbolVacio()) { // Es una hoja
					nodo = null;
				} else { 
					// Si no es una hoja buscamos el mayor de los menores 
					// o el menor de los mayores
					if (!nodo.hijoIzq.arbolVacio()) { 
						nodo.info = this.mayor(nodo.hijoIzq);
						nodo.hijoIzq.eliminar(nodo.info);
					} else {
						nodo.info = this.menor(nodo.hijoDer);
						nodo.hijoDer.eliminar(nodo.info);
					}
				}
			} else {
				if (nodo.info < x) {
					nodo.hijoDer.eliminar(x);
				} else {
					nodo.hijoIzq.eliminar(x);
				}
			}
		}	
	}

	private int mayor(ABBTDA a) {
		
		if(a.hijoDer().arbolVacio()) {
			return a.raiz();
		} else {
			return mayor(a.hijoDer());
		}
		
	}
	
	private int menor(ABBTDA a) {
		int retorno;
		
		if (a.hijoIzq().arbolVacio()) {
			retorno = a.raiz();
		} else {
			retorno = menor(a.hijoIzq());
		}
		
		return retorno;
	}
}
