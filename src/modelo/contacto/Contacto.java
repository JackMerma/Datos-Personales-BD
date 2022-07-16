package src.modelo.Contacto;

public class Contacto {
	public int cod;
	public int contactoElectronico;
	public int numero;
	public String direccion;
	public char estadoRegistro;

	public Contacto(int cod, int contactoElectronico, int numero, String direccion){
		this.cod = cod;
		this.contactoElectronico = contactoElectronico;
		this.numero = numero;
		this.direccion = direccion;
		this.estadoRegistro = 'A';
	}

	public Contacto(){
		this(-1, -1, -1, "");
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setContactoElectronico(int contactoElectronico){
		this.contactoElectronico = contactoElectronico;
	}

	public void setNumero(int numero){
		this.numero = numero;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getCod(){
		return this.cod;
	}

	public int getContactoElectronico(){
		return this.contactoElectronico;
	}

	public int getNumero(){
		return this.numero;
	}

	public String getDireccion(){
		return this.direccion;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
