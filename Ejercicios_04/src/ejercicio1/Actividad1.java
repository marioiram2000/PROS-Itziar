package ejercicio1;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

public class Actividad1 {
	public static void main(String[] args) {

		try {
			FTPClient client = new FTPClient();
			String servFTP = "ftp.rediris.es";
			client.connect(servFTP);
			System.out.println("Nos conectamos a " + servFTP);

			String user = "anonymous";
			String password = "dm2";
			boolean login = client.login(user, password);

			if (login)
				System.out.println("Login correcto");
			else {
				System.out.println("Login INCORRECTO...");
				client.disconnect();
				System.exit(1);
			}

			System.out.println("Directorio actual: " + client.printWorkingDirectory());

			boolean created = client.makeDirectory("DM2PROS");
			String msg = created ? "Directorio creado...." : "NO SE HA PODIDO CREAR EL DIRECTORIO";
			System.out.println(msg);
			
			msg = client.logout() ? "Logout del servidor FTP..." : "ERROR al hacer un Logout...";
			System.out.println(msg);

			client.disconnect();
			System.out.println("Desconectado...");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}