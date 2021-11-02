package ejercicio14;

class Hilo extends Thread {//tiene que extender de thread
	Recurso a;
	Recurso b;

	public Hilo(Recurso a, Recurso b, String nombre) {
		super(nombre);
		this.a = a;
		this.b = b;
	}

	public void run() {
		System.out.println("Hilo " + this.getName() + " comienza");//Escribimos un mensaje
		synchronized (a) {//si el recurso es a
			try {
				Thread.sleep(100);//Esperamos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (b) {//si el recurso es b
			}
			System.out.println("Hilo " + this.getName() + " ha terminado");//Escribimos un mensaje
		}
	}
}
//Creamos la clase recurso
class Recurso {
}