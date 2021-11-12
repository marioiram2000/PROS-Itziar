package examen;

public class Pregunta5Hilo extends Thread{
	
	private String mensaje;
	
	public Pregunta5Hilo(String string) {
		this.mensaje = string;
	}

	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println(mensaje+" "+i);
		}
	}
}
