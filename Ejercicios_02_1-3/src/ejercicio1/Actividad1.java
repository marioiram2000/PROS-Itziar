package ejercicio1;

public class Actividad1 {

	public static void main(String[] args) {
		// Creo los dos hijos
		Hilo h1 = new Hilo();
		Hilo h2 = new Hilo();
		// Defino el nombre de cada uno, para diferenciarlos correctamente a la hora de
		// que escriban el mensaje
		h1.setName("Primero");
		h2.setName("Segundo");
		// Ejecuto los dos hilos
		h1.start();
		h2.start();

	}
}
