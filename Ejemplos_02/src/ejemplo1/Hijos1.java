package ejemplo1;

public class Hijos1 {
	public static void main(String arg[]) {
		Primero p = new Primero();
		Segundo s = new Segundo();
		p.start();
		s.start();
		System.out.print("Fin programa");
	}
}
