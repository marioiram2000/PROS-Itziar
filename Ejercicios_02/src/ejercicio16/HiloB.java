package ejercicio16;

public class HiloB extends Thread {
	private Contador contador;

	public HiloB(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int j = 0; j < 300; j++) {
				contador.decrementa();
			}
			System.out.println(getName() + " contador vale" + contador.getValor());
		}
	}

}
