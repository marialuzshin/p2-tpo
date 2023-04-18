package metodos;

import apis.PilaTDA;
import implementaciones.PilaTF;

public class Ejercicios {
	
	public static void PasarPila(PilaTDA o, PilaTDA d){
		
		while (!o.PilaVacia()){// Mientras pila origen no este vacia
			d.Apilar(o.Tope());
			o.Desapilar();
				}
     }
	
public static void CopiarPila(PilaTDA o, PilaTDA d){
	PilaTF aux= new PilaTF();	
	aux.InicializarPila();
	while (!o.PilaVacia()){// Mientras pila origen no este vacia
		aux.Apilar(o.Tope());
		o.Desapilar();
			}
	while (!aux.PilaVacia()){// Mientras pila origen no este vacia
		o.Apilar(aux.Tope());
		d.Apilar(aux.Tope());
		aux.Desapilar();
			}
}
public static void MostrarPila(PilaTDA o){
		
		while (!o.PilaVacia()){// Mientras pila origen no este vacia
			
			o.Desapilar();
				}
     }
	

	
	
	
	
		
}
	
	

