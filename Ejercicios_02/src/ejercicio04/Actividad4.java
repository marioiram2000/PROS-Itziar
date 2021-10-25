package ejercicio04;

public class Actividad4 {
	public static void main(String arg[]) {
		Thread primero = new Thread(new Posicion(), "Primero");
		Thread segundo = new Thread(new Posicion(), "Segundo");

		primero.start();
		segundo.start();
		
		System.out.println("Fin programa");
	}
}
