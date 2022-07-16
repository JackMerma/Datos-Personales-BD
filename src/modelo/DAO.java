package src.modelo;
import java.util.*;

public abstract class DAO<CLASS> {

	protected CLASS classNormal;

	// listar
	public abstract ArrayList<CLASS> listar();

	// agregar
	// retorna el stado, si fue correcto 1, si no 0
	public abstract int add(CLASS clase);

	// modificar
	// retorna el stado, si fue correcto 1, si no 0
	public abstract int modificar(CLASS clase);
}
