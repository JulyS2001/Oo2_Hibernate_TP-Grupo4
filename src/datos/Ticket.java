package datos;

import java.util.Date;

public class Ticket {

	private int idTicket;

	private String titulo;

	private String descripcion;

	private Date fecha_Creacion;

	private Date fecha_Cierre;

	private Categoria categoria;

	private Estado estado;

	private Prioridad prioridad;

	public Ticket() {
	}

	public Ticket(String titulo, String descripcion, Date fecha_Creacion, Date fecha_Cierre) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha_Creacion = fecha_Creacion;
		this.fecha_Cierre = fecha_Cierre;
	}

	// Getters y Setters

	public int getIdTicket() {
		return idTicket;
	}

	protected void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_Creacion() {
		return fecha_Creacion;
	}

	public void setFecha_Creacion(Date fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}

	public Date getFecha_Cierre() {
		return fecha_Cierre;
	}

	public void setFecha_Cierre(Date fecha_Cierre) {
		this.fecha_Cierre = fecha_Cierre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", fecha_Creacion=" + fecha_Creacion + ", fecha_Cierre=" + fecha_Cierre + ", categoria=" + categoria
				+ ", estado=" + estado + ", prioridad=" + prioridad + "]";
	}

	

}