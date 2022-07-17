package src.modelo.procedencia;

public class Procedencia {
	public int cod;
	public String pais;
	public String departamento;
	public String provincia;
	public String distrito;
	public char estadoRegistro;

	public Procedencia(int cod, String pais, String depa, String pro, String dist){
		this.cod = cod;
		this.pais = pais;
		this.departamento = depa;
		this.provincia = pro;
		this.distrito = dist;
		this.estadoRegistro = 'A';
	}

	public Procedencia(){
		this(-1, "", "", "", "");
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public void setPais(String pais){
		this.pais = pais;
	}

	public void setDepartamento(String depa){
		this.departamento = depa;
	}

	public void setProvincia(String pro){
		this.provincia = pro;
	}

	public void setDistrito(String distrito){
		this.distrito = distrito;
	}

	public void setEstadoRegistro(char s){
		this.estadoRegistro = s;
	}

	public int getCod(){
		return this.cod;
	}

	public String getPais(){
		return this.pais;
	}

	public String getDepartamento(){
		return this.departamento;
	}
	
	public String getProvincia(){
		return this.provincia;
	}

	public String getDistrito(){
		return this.distrito;
	}

	public char getEstadoRegistro(){
		return this.estadoRegistro;
	}
}
