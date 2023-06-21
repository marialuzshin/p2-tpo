Trabajo Práctico 1 –TDAs: Conceptos Básicos. Definición, implementación y utilización. Cálculo de Costos.

TDA Pila

1)Definir el TDA Pila, listando las operaciones asociadas y establecer sus precondiciones.

2)A partir del TDA Pila definido, escribir distintos métodos que permitan
a)Pasar una Pila a otra (dejándola en orden inverso)
b)Copiar una Pila en otra (dejándola en el mismo orden que la original)
c)Invertir el contenido de una Pila.
d)Contar los elementos de una Pila
e)Sumar los elementos de una Pila
f)Calcular el promedio de los elementos de una Pila.

TDA Cola

3)Definir el TDA Cola, listando las operaciones asociadas y establecer sus precondiciones.

4)A partir del TDA Cola definido, escribir distintos métodos que permitan

a)Pasar una Cola a otra
b)Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
c)Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)
d)Determinar si el final de la Cola C1 coincide o no con la Cola C2.
e)Determinar  si  una  Cola  es  capicúa  o  no.  Para  ser  capicúa  debe  cumplir que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
f)Determinar  si  la  Cola C1 es la  inversa  de  la  Cola  C2.  Dos  Colas  serán inversas, si tienen los mismos elementos pero en orden inverso.

TDA Cola con Prioridades

5)Definir  el  TDA  Cola  con  prioridades,  listando  las  operaciones  asociadas  y  establecer  sus precondiciones.

6)A partir del TDA Cola con prioridades definido, escribir un método que permita
a)Combinar  dos  colas  con  prioridades  CP1  y  CP2,  generando  una  nueva cola  con  prioridades.  Considerar  que  a  igual  prioridad,  los  elementos  de  la  CP1 son más prioritarios que los de la CP2.
b)Determinar si dos Colas con prioridad son idénticas.Implementaciones y Costos

7)Escribir  al  menos  dos  implementaciones  distintas  (basadas  en  arreglos)  del  TDA  Pila definido en 1). Comparar los costos de cada una de las operaciones.

8)Escribir  al  menos  dos  implementaciones  distintas  (basadas  en  arreglos)  del  TDA  Cola definido en 3). Comparar los costos de cada una de las operaciones.

9)Escribir  al  menos  dos  implementaciones  distintas  (basadas  en  arreglos)  del  TDA  Cola  con prioridades definido en 5). Comparar los costos de cada una de las operaciones.

2Trabajo Práctico 2 –TDAs: Implementación utilizando estructuras dinámicas. Costos. TDA Conjunto. TDA Diccionario.

TDA Pila, TDA Cola y TDA Cola con Prioridades

1)Implementar los TDA Pila, TDA Cola y TDA Cola con Prioridades definidos en los ejercicios número 1), 3) y 5)  del TP1 (respectivamente) con listas dinámicas.

2)Calcular  y  comparar  los  costos  de  las  operaciones  típicas  de  cada  uno  de  los  TDAs anteriores  para  las  implementaciones  basadas  en  arreglos  del  TP1  y  la  propuesta  en  el ejercicio anterior.TDA Conjunto

3)Definir el TDA Conjunto, listando las operaciones asociadas.

4)Implementar el TDA Conjunto con las siguientes restriccionesa)Tamaño máximo acotadob)Tamaño máximo no acotadoc)Universo  acotado.  Considerar  por  ejemplo  el  Universo  de  los  números  enteros entre 0 y N.En  todos  los  casos,  dar  al  menos  dos  implementaciones  utilizando  arreglos  y  con  listas dinámicas.

5)Comparar   los   costos   de   las   operaciones   definidas   en   el   TDA   Conjunto   según   las implementaciones del ejercicio anterior.

6)Escribir los métodos externos al TDA que implementan las operaciones intersección, unión y diferencia.TDA Diccionario

7)Definir  el  TDA  Diccionario,  listando  las  operaciones  asociadas.  Considerar  los  dos  casos vistos en clase: a) cada clave está asociada a un único valor, y b) cada clave está asociada a un conjunto de valores.

8)Implementar el TDA Diccionario, considerando las dos alternativas del ejercicio anteriora)cada clave está asociada a un único valorb)cada clave está asociada a un conjunto de valores.En  ambos  casos,  dar  al  menos  una  implementación  utilizando  arreglos  y  una  con  listas dinámicas.9)Comparar  los  costos  de  las  operaciones  definidas  en  el  TDA  Diccionario  según  las implementaciones del ejercicio anterior.

3 Trabajo Práctico 3 –Utilización de TDAs. (En todos los ejercicios siguientes calcular el costo espacial y temporal de los métodos escritos)

1)A partir del TDA Pila, escribir distintos métodos externos que permitan:
a)Comprobar si una Pila P es capicúa (el elemento del tope es igual al de la base, el segundo igual al anteúltimo, etc.)
b)Eliminar de una Pila P las repeticiones de elementos,  dejando  un  representante de  cada  uno  de  los  elementos  presentes  originalmente.  Se  deberá  respetar  el orden  original  de  los  elementos,  y  en  el  caso  de  los  repetidos  se  conservará  el primero que haya ingresado en P.
c)Repartir  una  Pila  P  en  dos  mitades  M1y  M2  de  elementos  consecutivos, respetando el orden. Asumir que la Pila P contiene un número par de elementos.d)Generar el conjunto de elementos que se repiten en una Pila.

2)A partir del TDA Cola, escribir distintos métodos externos que permitan

a)Eliminar de una Cola C las repeticiones de elementos, dejando un representante de  cada  uno  de  los  elementos  presentes  originalmente.  Se  deberá  respetar  el orden  original  de  los  elementos,  y  en  el  caso  de  los  repetidos  se  conservará  el primero que haya ingresado en C.

b)Repartir  una  Cola  C  en  dos  mitades  M1  y  M2  de  elementos  consecutivos, respetando el orden. Asumir que la cantidad de elementos de Ces par.c)Generar el conjunto de elementos que se repiten en una Cola,3)A partir del TDA Conjunto, escribir distintos métodos externos que permitana)Calcular la diferencia simétrica entre dos conjuntos A y B (definido en clase).

b)Sin utilizar las operaciones unión, intersección y diferencia. 

c)Utilizando las operaciones unión, intersección y diferencia.

d)Determinar si dos conjuntosson iguales.e)Calcular la cardinalidad (cantidad de elementos) de un conjunto.

f)Generar el conjunto de elementos que están tanto en la Pila Pyen la Cola C.

g)Determinar si los elementos de una Pila P son los mismos que los de una Cola C. No interesa el orden ni si están repetidos o no.4)A partir del TDA ColaPrioridad

a)Escribir  un  método  externo  que  permita  generar  un  Diccionario  Múltiple  que permita,  para  cada  valor  presente  en la  ColaPrioridad  Crecuperar  todas  las prioridades que tiene asociadas en C.

5)A partir del TDA Diccionario, escribir distintos métodos externos que permitan

5.1) Dados  dos  DiccionarioMultipleTDA  D1  y  D2,  generar  un  DiccionarioMultipleTDA  que contenga:a) las claves presentes en D1 y D2, con todos los elementos asociados a cadaclave.

b)las  claves  presentes  en  D1  y  D2,  con  todos  los  elementos  comunes  a  las  claves coincidentes en ambos.

c)las claves comunes de D1 y D2, con todos los elementos asociadosa cada clave.

d)las  claves  comunes  de  D1  y  D2,con  todos  los  elementos  comunes  a  las claves coincidentes en ambos.

5.2)  Dado  un  Diccionario  Simple  D,  que  representa  el  concepto  clásico  de  diccionario:  la clave  representa  una  palabra  y  el  valor  su  significado.  Generar  un  Diccionario  Múltiple  DS que a partir de un significado s, vincule todas laspalabras que tienen dicho significado, es decir  que  son  sinónimos.  Cada  clave  s  será  un  significado  y  los  valores  asociados (sinónimos) aquellas claves de D que tenían asociado el valor s


4Trabajo Práctico 4 –TDA Árbol Binario de Búsqueda (ABB). Uso de la Recursión.(En todos los ejercicios siguientes calcular el costo espacial y temporal de los métodos escritos)TDA ABB

1)Definir el TDA ABB, con las siguientes operaciones asociadas (según lo visto en clase):

a)Raiz
b)HijoIzqc
)HijoDer
d)ArbolVacio
e)InicializarArbol
f)AgregarElem
g)EliminarElem

2)Implementar el TDA ABB definido en el ejercicio anterior, utilizando estructuras dinámicas.Utilización del TDA ABB / Uso de la Recursión.

3)A partir del TDA ABB, escribir métodos externos que resuelvan los siguientes problemas.En caso de ser posible, escribir la versión iterativa y la versión recursiva de los métodos.

a)Dado un elemento, determinar si está o no en un ABB.
b)Dado un elemento, determinar si es una hoja de un ABB.
c)Dado un elemento, calcular su profundidad en el ABB.
d)Obtener el valor del menor elemento de un ABB.
e)Calcular la cantidad de elementos que contiene un ABB.
f)Calcular la suma de los elementos que contiene un ABB.
g)Calcular el cantidad de hojas de un ABB
h)Calcular la altura de un ABB.
i)Comprobar si dosABBs tienen la misma forma.
j)Comprobar si dos ABBs son iguales.
k)Contar la cantidad de elementos que están en un cierto nivel N.
l)Mostrar por pantalla todos los elementos que contiene un ABBi.In-ordenii.Pre-ordeniii.Post-orden
m)Dado  un  valor  k,  arme  un  conjunto  contodos  los  elementos  del  ABB  que  son mayores que k.
n)Dado un elemento de valor v (que está presente en el ABB), obtener el elemento del árbol que es inmediatamente anterior (en valor).