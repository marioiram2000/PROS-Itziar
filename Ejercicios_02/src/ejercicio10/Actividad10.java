package ejercicio10;
public class Actividad10 {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		Hilo hilo0 = new Hilo();
		Hilo hilo1 = new Hilo();
		hilo0.setName("Thread-0");
		hilo1.setName("Thread-1");		
		hilo0.setPriority(3);
		hilo1.setPriority(7);
		hilo0.setMesage("Hilo-prioridad "+hilo0.getPriority());
		hilo1.setMesage("Hilo-prioridad "+hilo1.getPriority());		
		main.setPriority(5);		
		System.out.println(main.getName()+" tiene la prioridad "+main.getPriority());
		System.out.println(hilo0.getName()+" tiene la prioridad "+hilo0.getPriority());
		System.out.println(hilo1.getName()+" tiene la prioridad "+hilo1.getPriority());		
		hilo0.start();
		hilo1.start();		
		System.out.println("Fin programa");
	}
}