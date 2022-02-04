package ej1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteCoche {
	public static void main(String[] args) {
		try {
			int puerto = 12300;
			InetAddress destino = InetAddress.getLocalHost();

			//Creamos el coche y lo ponemos en unbuffer para enviarlo
			Coche coche = new Coche("5776", "Citroën", "C4");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(coche);
			byte bufferEnvio[] = baos.toByteArray();
			baos.close();
			oos.close();
			
			//Enviamos el coche
			DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length, destino, puerto);
			DatagramSocket socket = new DatagramSocket(34567);
			socket.send(envio);
			System.out.println("Envío el objeto: " + coche.toString());

			//Recivimos la respuesta
			byte bufferRecibo[] = new byte[bufferEnvio.length];
			DatagramPacket recibo = new DatagramPacket(bufferRecibo, bufferRecibo.length);
			System.out.println("Esperando respuesta.......");
			socket.receive(recibo);

			ByteArrayInputStream bais = new ByteArrayInputStream(bufferRecibo);
			ObjectInputStream ois = new ObjectInputStream(bais);
			boolean aceptada = (boolean) ois.readObject();
			bais.close();
			ois.close();

			if (aceptada) {
				System.out.println("Nos dicen de la policía que tu encrada es ACEPTADA");
			} else {
				System.out.println("Nos dicen de la policía que tu encrada es RECHAZADA");
			}

			socket.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
