package ej3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class BezeroOrozco {

	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6030;

		System.setProperty("javax.net.ssl.trustStore", "ErabiltzaileOrozco");
		System.setProperty("javax.net.ssl.trustStorePassword", "pwdBezero");

		System.out.println("PROGRAMA CLIENTE INICIANDO");
		System.out.println("Introduce una cadena de caracteres:");
		String str = leeString();

		try {
			SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket cliente = (SSLSocket) sfact.createSocket(host, puerto);

			/////// Flujo de salida al servidor
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

			////// Envío del número entero al servidor
			flujoSalida.writeUTF(str);

			//// Creación del flujo de entrada al servidor
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

			////// El servidor envía un mensaje al cliente
			System.out.println("Recibiendo mensaje del servidor:");
			System.out.println("\tLa cadena  " + str + " convertida a minúsculas es: " + flujoEntrada.readUTF());

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

	public static String leeString() {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
