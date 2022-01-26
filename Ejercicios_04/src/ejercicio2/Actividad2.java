package ejercicio2;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

public class Actividad2 {
	public static void main(String[] args) {
		try {
			FTPClient cliente = new FTPClient();
			String servFTP = "172.20.132.109";
			System.out.println("Nos conectamos a " + servFTP);
			cliente.connect(servFTP);

			System.out.println("Nos conectamos a " + servFTP);
			String usuario = "mario";
			String clave = "mario";
			boolean login = cliente.login(usuario, clave);

			if (login)
				System.out.println("Login correcto");
			else {
				System.out.println("Login incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}

			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());

			boolean directorioCreado = cliente.makeDirectory("aplicacionweborozco");
			boolean directoriosCreados = true;
			if (directorioCreado) {
				if (directorioCreado = cliente.makeDirectory("aplicacionweborozco/html")) {
					if (directorioCreado = cliente.makeDirectory("aplicacionweborozco/imagenes")) {
						if (!(directorioCreado = cliente.makeDirectory("aplicacionweborozco/css"))) {
							directoriosCreados = false;
						}
					} else {
						directoriosCreados = false;
					}
				} else {
					directoriosCreados = false;
				}
			} else {
				directoriosCreados = false;
			}
			
			if (directoriosCreados == true)
				System.out.println("Directorios creados...");
			else {
				System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
				cliente.disconnect();
				System.exit(1);
			}

			boolean logout = cliente.logout();
			String msg = logout ? "Logout del servidor FTP..." : "Error al hacer logout";
			System.out.println(msg);

			cliente.disconnect();
			System.out.println("Desconectado...");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}