package ej2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPBezeroa {

	public static void main(String[] args) {
		
		// Nos conectamos al servidor
		FTPClient cliente = new FTPClient();
		String servFTP = "172.20.132.109";
		System.out.println("Nos conectamos a " + servFTP);
		try {
			cliente.connect(servFTP);
		} catch (IOException e) {
			System.out.println("No nos hemos podido conectar al servidor");
		}

		// Nos autenticamos
		String usuario = "mario";
		String clave = "mario";
		boolean login = false;
		try {
			login = cliente.login(usuario, clave);
		} catch (IOException e) {
			System.out.println("Login incorrecto");
		}

		if (login)
			System.out.println("Login correcto");
		else {
			System.out.println("Login incorrecto...");
			try {
				cliente.disconnect();
			} catch (IOException e) {
				System.out.println("Error al desconectarnos del servidor");
			}
			System.exit(1);
		}

		// Creamos los directorios
		try {
			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
			boolean dirSige = cliente.makeDirectory("SIGE");
			boolean dirDein = cliente.makeDirectory("DEIN");
			boolean dirPros = cliente.makeDirectory("PROS");
			boolean dirProm = cliente.makeDirectory("PROM");
			
			if (dirSige && dirDein && dirPros && dirProm) {
				System.out.println("Los directorios se han creado correctamente");
			} else {
				System.out.println("Ha ocurrido algún error al crear los direcorios");
			}
		} catch (IOException e) {
			System.out.println("Ha ocurrido algún error al crear los direcorios");
		}

		//Subimos el fichero mario.txt
		try {
			cliente.changeWorkingDirectory("./PROS");
			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
			String fichOrigen = "/home/dm2/Escritorio/PROS-Itziar/PROS-Itziar/examen2/src/ej2/mario.txt";
			String fichDestino = "mario.txt";
			BufferedInputStream bisOrigen = new BufferedInputStream(new FileInputStream(fichOrigen));
			cliente.storeFile(fichDestino, bisOrigen);
			System.out.println("Fichero subido");
		} catch (IOException e) {
			System.out.println("Ha ocurrido algún error al subir el fichero");
		}
		
		//Renombramos el fichero
		try {
			cliente.rename("mario.txt", "mario2.txt");
			System.out.println("Fichero renombredo");
		} catch (IOException e) {
			System.out.println("Ha ocurrido algún error al renombrar el fichero");
		}
		
		BufferedOutputStream out;
		try {
			out = new BufferedOutputStream (new FileOutputStream ("/home/dm2/Escritorio/PROS-Itziar/PROS-Itziar/examen2/src/ej2/mario2.txt"));
			if (cliente.retrieveFile("mario2.txt", out)) {
				System.out.println("Fichero descargado..");
			} else {
				System.out.println("No se ha podido descargar el fichero");
			}
		} catch (FileNotFoundException e1) {
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
				
		//Hacemos logout del servidor
		boolean logout;
		try {
			logout = cliente.logout();
			System.out.println(logout ? "Logout del servidor FTP..." : "Error al hacer logout");
		} catch (IOException e) {
			System.out.println("Error al hacer logout");
		}

		//Nos desconectamos del servidor
		try {
			cliente.disconnect();
			System.out.println("Desconectado...");
		} catch (IOException e) {
			System.out.println("Error al hacer la desconexión");
		}
		
	}
}
