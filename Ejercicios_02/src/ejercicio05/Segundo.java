package ejercicio05;

class Segundo extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Segundo " + i);
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}