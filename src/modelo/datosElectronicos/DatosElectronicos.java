package src.modelo.datosElectronicos;

public class DatosElectronicos {
	public int cod;
	public String correo;
	public String paginaWeb;
	public char estadoRegistro;

	public DatosElectronicos(int cod, String correo, String paginaWeb){
		this.cod = cod;
		this.correo = correo;
		this.paginaWeb = paginaWeb;
		this.estadoRegistro = 'A';
	}

	public DatosElectronicos(){
		this(-1, "", "");
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setCorreo(String correo){
		this.correo = correo;
	}

	public void setPaginaWeb(String paginaWeb){
		this.paginaWeb = paginaWeb;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getCod(){
		return this.cod;
	}

	public String getCorreo(){
		return this.correo;
	}

	public String getPaginaWeb(){
		return this.paginaWeb;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
