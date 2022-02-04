package ej1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorCoche {
	public static void main(String[] args) {
		try {
			// Abrmos el servidor que escuchará por el puerto 12300
			int puerto = 12300;
			byte bufferRecibo[] = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(bufferRecibo, bufferRecibo.length);
			DatagramSocket socket = new DatagramSocket(puerto);

			//Recivimos y leemos el coche
			System.out.println("Esperando datagrama.......");
			socket.receive(recibo);

			ByteArrayInputStream bais = new ByteArrayInputStream(bufferRecibo);
			ObjectInputStream ois = new ObjectInputStream(bais);
			Coche coche = (Coche) ois.readObject();
			bais.close();
			ois.close();
			System.out.println("Recibo el objeto: " + coche.toString());

			System.out.println("IP de origen: " + recibo.getAddress());
			System.out.println("Puerto de origen: " + recibo.getPort());

			//Comporbamos si la matricula es válida
			boolean aceptado = false;
			
			if (coche.getNumsMatricula() % 2 == 0) {
				aceptado = true;
				
			}

			//Enviamos la respuesta
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(aceptado);
			byte bufferEnvio[] = baos.toByteArray();
			baos.close();
			oos.close();

			DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length, InetAddress.getLocalHost(),34567);
			socket.send(envio);

			socket.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
