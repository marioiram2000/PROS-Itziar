package ejercicio02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {

	public static void main(String[] args) {
		String direccion = "wwwa.moodle.org";
		InetAddress address[];
		try {
			address = InetAddress.getAllByName(direccion);
			System.out.println("Direcciones asociadas a "+direccion+" son:");

			for (int i = 0; i < address.length; i++) {
				System.out.println(address[i]);
			}

		} catch (UnknownHostException e) {
			System.out.println("Se necesita una URL para obtener su dirección");
		}
	}
}
