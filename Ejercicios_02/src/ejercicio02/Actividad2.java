package ejercicio02;

public class Actividad2 {

	
	public static void main(String[] args) throws InterruptedException {
		int n = Integer.parseInt(args['n']);
		for (int i = 0; i < n; i++) {
			Hilo h = new Hilo();//Creo un hilo
			h.setName("Hilo "+i);//Defino su nombre
			h.start();//Lo ejecuto
			h.join();//Espero a que termine
		}
		System.out.println("Fin programa");
	}
}
