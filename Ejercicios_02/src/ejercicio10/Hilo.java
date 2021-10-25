package ejercicio10;
public class Hilo extends Thread{
	String mesage;	
	public void setMesage(String str) {
		mesage = str;
	}
	public void run() {
			System.out.println("Ejecutando "+mesage);		
	}
}
