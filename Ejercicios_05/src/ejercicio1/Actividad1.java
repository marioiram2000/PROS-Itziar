package ejercicio1;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;

public class Actividad1 {

	public static void main(String[] args) {
		Provider[] providers = Security.getProviders();
		for (Provider provider : providers) {
			mostrarAlgoritmos(provider, MessageDigest.class);
		}
	}

	private static final void mostrarAlgoritmos(Provider provider, Class<?> messageDigestClass) {

		java.util.ArrayList<Service> algos = new java.util.ArrayList<>();
		java.util.Set<Service> services = provider.getServices();

		for (Service service : services) {
			if (service.getType().equalsIgnoreCase(messageDigestClass.getSimpleName())) {
				algos.add(service);
			}
		}

		if (!algos.isEmpty()) {
			System.out.println("** Proveedor " + provider.getName() + ", versión " + provider.getVersionStr() + " **");
			for (Service service : algos) {
				String algo = service.getAlgorithm();
				System.out.println("\t Nombre del algoritmo: \"" + algo + "\"");
			}
		}
	}
}