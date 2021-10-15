package ejercicio2;

public class Actividad2 {

	private final static int n = 4;
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < n; i++) {
			Hilo h = new Hilo();//Creo un hilo
			h.setName("Hilo "+i);//Defino su nombre
			h.start();//Lo ejecuto
			h.join();//Espero a que termine
		}
		System.out.println("Fin programa");
	}
}
