package src.modelo.datosImportantes;

public class DatosImportantes {
	public int cod;
	public int dni;
	public int estadoCivil;
	public int procedencia;
	public char estadoRegistro;

	public DatosImportantes(int cod, int dni, int ec, int pro){
		this.cod = cod;
		this.dni = dni;
		this.estadoCivil = ec;
		this.procedencia = pro;
		this.estadoRegistro = 'A';
	}

	public DatosImportantes(){
		this(-1, -1, -1, -1);
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setDni(int dni){
		this.dni = dni;
	}

	public void setEstadoCivil(int ec){
		this.estadoCivil = ec;
	}

	public void setProcedencia(int pro){
		this.procedencia = pro;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getCod(){
		return this.cod;
	}

	public int getDni(){
		return this.dni;
	}

	public int getEstadoCivil(){
		return estadoCivil;
	}

	public int getProcedencia(){
		return this.procedencia;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
