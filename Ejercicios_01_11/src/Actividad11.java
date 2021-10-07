import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Actividad11 {
	public static void main(String[] args){
		Runtime r=Runtime.getRuntime();
		String comando="java Ejemplo2";
		Process p=null;
		try {
			p = r.exec (comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			
			String linea;
			while((linea = br.readLine()) != null) // lee una linea
				System.out.println(linea);
			br.close();
			}
		catch (Exception e) {
				e.printStackTrace();
		}
		///// Comprobación error 0 bien - 1 mal
		int exitVal;
		try {
				exitVal=p.waitFor();
				System.out.println ("Valor de Salida"+exitVal);
		}  catch (InterruptedException e){
			e.printStackTrace();
			
		}
	}
}
