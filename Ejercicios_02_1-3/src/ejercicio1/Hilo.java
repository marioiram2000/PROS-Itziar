package ejercicio1;

public class Hilo extends Thread{//Tiene que extender de Thread

	public void run() {//Metodo que se va a ejecutar
		for (int i=1;i<50;i++) {//Bucle (es de 50 para que no sea demasiado largo
			System.out.println(getName()+"\t" + i);//Obtengo el nombre del hilo y lo concateno con el indice del bucle
		}
	}
}
