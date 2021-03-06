package ejercicio4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SocketClienteSeguro {

	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6020;
		
		System.setProperty("javax.net.ssl.trustStore", "UsuarioAlmacenSeguroOrozco");
		System.setProperty("javax.net.ssl.trustStorePassword", "dm2client");
		
		System.out.println("PROGRAMA CLIENTE INICIANDO");
		System.out.println("Introduce un número:");
		int num = leeInt();

		try {
			SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket cliente = (SSLSocket) sfact.createSocket(host, puerto);

			/////// Flujo de salida al servidor
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

			////// Envío del número entero al servidor
			flujoSalida.write(num);

			//// Creación del flujo de entrada al servidor
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

			////// El servidor envía un mensaje al cliente
			System.out.println("Recibiendo mensaje del servidor:");
			System.out.println("\tEl cuadrado del número " + num + " es " + flujoEntrada.readUTF());

			////// Cerrar streams y sockets
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int leeInt() {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;
		try {
			x = Integer.valueOf(in.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;

	}
}
