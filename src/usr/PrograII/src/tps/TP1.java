package tps;

import implementaciones.PilaTF;
import metodos.Ejercicios;

public class TP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PilaTF po=new PilaTF();
		po.InicializarPila();
		po.Apilar(1);
		po.Apilar(2);
		po.Apilar(3);
		PilaTF pd=new PilaTF();
		pd.InicializarPila();
		Ejercicios.PasarPila(po, pd);
		PilaTF aux=new PilaTF();
		aux.InicializarPila();
		Ejercicios.CopiarPila(pd, aux);
		
		
		

	}

}
