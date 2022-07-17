package src.modelo.datosGenerales;

public class DatosGenerales {
	public int cod;
	public String primerNombre;
	public String segundoNombre;
	public String primerApellido;
	public String segundoApellido;
	public String fechaNacimiento;
	public char estadoRegistro;

	public DatosGenerales(int cod, String pn, String sn, String pa, String sa, String fn){
		this.cod = cod;
		this.primerNombre = pn;
		this.segundoNombre = sn;
		this.primerApellido = pa;
		this.segundoApellido = sa;
		this.fechaNacimiento = fn;
		this.estadoRegistro = 'A';
	}

	public DatosGenerales(){
		this(-1, "", "", "", "", "");
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setPrimerNombre(String pn){
		this.primerNombre = pn;
	}

	public void setSegundoNombre(String sn){
		this.segundoNombre = sn;
	}

	public void setPrimerApellido(String pa){
		this.primerApellido = pa;
	}

	public void setSegundoApellido(String sa){
		this.segundoApellido = sa;
	}

	public void setFechaNacimiento(String fn){
		this.fechaNacimiento = fn;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getCod(){
		return this.cod;
	}

	public String getPrimerNombre(){
		return this.primerNombre;
	}

	public String getSegundoNombre(){
		return this.segundoNombre;
	}

	public String getPrimerApellido(){
		return this.primerApellido;
	}

	public String getSegundoApellido(){
		return this.segundoApellido;
	}

	public String getFechaNacimiento(){
		return this.fechaNacimiento;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
