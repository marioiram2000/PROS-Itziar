package ej1;

import java.io.Serializable;

public class Coche implements Serializable {

	private static final long serialVersionUID = 1L;

	private String matricula;
	private String marca;
	private String modelo;

	public Coche(String matricula, String marca, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}

	//Función para devolver la parte numérica de la matrícula
	public int getNumsMatricula() {
		String[] aux = matricula.split(" ");
		String numStr = aux[0];
		int num = Integer.parseInt(numStr);
		return num;
	}

	//Generamos los getter y setters
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return matricula + " " + marca + " " + modelo;
	}

}
