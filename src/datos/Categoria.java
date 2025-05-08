package datos;

public class Categoria {
private long idCategoria;
private String nombre;


public Categoria() {}

public Categoria (String nombre) {
	this.nombre = nombre;
}

public String getNombre() {
	return nombre;
}

public void SetNombre (String nombre) {
	this.nombre = nombre;
}

@Override
public String toString() {
	return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
}


}