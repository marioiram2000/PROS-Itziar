package ejercicio04;

public class Posicion implements Runnable {
	public synchronized void run() {
		for (int y = 1; y < 15; y++) {
			System.out.println(Thread.currentThread().getName() + ": " + y);
		}
	}
}
