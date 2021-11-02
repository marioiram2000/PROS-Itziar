package ejercicio14;

public class Actividad14 extends Thread {

	public static void main(String args[]) {
		//Creamos los recuros
		Recurso a = new Recurso();
		Recurso b = new Recurso();
		//Creamos los hilos, el orden de recursos tiene que ser el mismo para que no suceda el ABRAZO DE LA MUERTE
		Hilo h1 = new Hilo(a, b, "uno");
		Hilo h2 = new Hilo(a, b, "dos");
		//Hacemos start a los hilos
		h1.start();
		h2.start();
	}
}
