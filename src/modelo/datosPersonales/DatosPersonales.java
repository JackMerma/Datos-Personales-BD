package src.modelo.datosPersonales;

public class DatosPersonales {
	public int cod;
	public int datGenCod;
	public int datImpCod;
	public char estadoRegistro;

	public DatosPersonales(int cod, int dgc, int dic){
		this.cod = cod;
		this.datGenCod = dgc;
		this.datImpCod = dic;
		this.estadoRegistro = 'A';
	}

	public DatosPersonales(){
		this(-1, -1, -1);
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setDatosGeneralesCodigo(int dgc){
		this.datGenCod = dgc;
	}

	public void setDatosImportantesCodigo(int dic){
		this.datImpCod = dic;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getCod(){
		return this.cod;
	}

	public int getDatosGeneralesCodigo(){
		return this.datGenCod;
	}

	public int getDatosImportantesCodigo(){
		return this.datImpCod;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
