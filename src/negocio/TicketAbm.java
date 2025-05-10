package negocio;

import java.util.List;
import java.time.LocalDateTime;

import dao.TicketDao;
import datos.Ticket;
import datos.Categoria;
import datos.Estado;
import datos.Prioridad;

public class TicketAbm {
	
	private TicketDao ticketDao = new TicketDao();
	
	public int agregarTicket(String titulo, String descripcion, int idCategoria, int idEstado, int idPrioridad) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new Exception("El título del ticket no puede estar vacío.");
		}
		
	    Categoria categoria = new CategoriaAbm().traerCategoria(idCategoria);
	    Estado estado = new EstadoAbm().traerEstado(idEstado);
	    Prioridad prioridad = new PrioridadAbm().traerPrioridad(idPrioridad);
	    
		Ticket ticket = new Ticket();
		ticket.setTitulo(titulo);
		ticket.setDescripcion(descripcion);
		ticket.setFechaCreacion(LocalDateTime.now());
		ticket.setFechaCierre(null);
		ticket.setCategoria(categoria);
	    ticket.setEstado(estado);
	    ticket.setPrioridad(prioridad);
	    
		return ticketDao.crearTicket(ticket);
	}
	
	public Ticket traerTicket(int idTicket) {
		// podrías agregar validaciones, logs, etc.
		return ticketDao.traerTicket(idTicket);
	}
	
	public List<Ticket> traerTodos() {
		return ticketDao.traerTodos();
	}
	
	public void actualizarTicket(Ticket ticket) throws Exception {
		if (ticket == null || ticket.getIdTicket() <= 0) {
			throw new Exception("Ticket inválido.");
		}
		ticketDao.actualizar(ticket);
	}
	
	public void eliminarTicket(int idTicket) throws Exception {
		Ticket ticket = ticketDao.traerTicket(idTicket);
		if (ticket == null) {
			throw new Exception("El ticket no existe.");
		}
		ticketDao.eliminar(ticket);
	}
}