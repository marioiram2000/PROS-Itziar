package ejemplo1;

public class Primero extends Thread{
	public void run() {
		for (int i = 1; i < 100; i++)
			System.out.println("Primero " + i);
	}
}
