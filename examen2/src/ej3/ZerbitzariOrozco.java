package ej3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class ZerbitzariOrozco {
	public static void main(String[] args) throws IOException {
		int puerto = 6030;
		
		System.setProperty("javax.net.ssl.keyStore", "BiltegiOrozco");
		System.setProperty("javax.net.ssl.keyStorePassword", "pwdZerbitzari");
		
		
		SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		SSLServerSocket servidor = (SSLServerSocket) sfact.createServerSocket(puerto);

		System.out.println("Esperando a que el cliente se conecte...");
		SSLSocket clienteConectado = (SSLSocket) servidor.accept();

		// Creación del flujo de entrada del cliente
		DataInputStream flujoEntrada = new DataInputStream(clienteConectado.getInputStream());

		// El cliente envía un mensaje al servidor
		String mensaje = flujoEntrada.readUTF();

		// Flujo de salida hacia el cliente
		OutputStream salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);

		// Envio un saludo al SocketClienteSeguro
		flujoSalida.writeUTF(mensaje.toLowerCase());

		////// Cerrar streams y sockets
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();

		clienteConectado.close();
		servidor.close();
	}
}
