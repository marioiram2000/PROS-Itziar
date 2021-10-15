package ejercicio3;

import ejercicio1.Hilo;

public class Actividad3 {
	public static void main(String[] args) {
		
		Hilo h = new Hilo();// Creo el hilo
		h.setName("Thread-0");//Le pongo el nombre		
		h.setPriority(5);//Defino su prioridad

		System.out.println("El nombre del hilo es "+h.getName()+" y tiene la prioridad " + h.getPriority());//Obtengo el nombre del hilo y su prioridad
		
		h.setPriority(6);//Le cambio la prioridad
		h.setName("SUPER-HILO-DM2");//Le cambio el mobre
		System.out.println("Ahora el nombre del hilo es "+h.getName()+" y tiene la prioridad " + h.getPriority());//Vuelvo a obtener el nombre del hilo y su prioridad

		System.out.println("Fin programa");
	}
}
