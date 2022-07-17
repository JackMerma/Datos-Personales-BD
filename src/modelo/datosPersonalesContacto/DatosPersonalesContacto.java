package src.modelo.datosPersonalesContacto;

public class DatosPersonalesContacto {
	public int cod;
	public int contactoCod;
	public char estadoRegistro;

	public DatosPersonalesContacto(int cod, int contactoCod){
		this.cod = cod;
		this.contactoCod = contactoCod;
		this.estadoRegistro = 'A';
	}

	public DatosPersonalesContacto(){
		this(-1, -1);
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setContactoCod(int contactoCod){
		this.contactoCod = contactoCod;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getCod(){
		return this.cod;
	}

	public int getContactoCod(){
		return this.contactoCod;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
