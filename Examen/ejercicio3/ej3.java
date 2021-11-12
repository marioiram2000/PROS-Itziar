public class Examen1Enunciado {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();	
		
		Byte comando = true;
				
		Process p;
		
		try {
			
			p = r.exec( comando );
		
		}
		catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}
	}

}