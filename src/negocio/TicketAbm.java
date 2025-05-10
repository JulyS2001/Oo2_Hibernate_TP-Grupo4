package negocio;

import java.util.List;
import java.time.LocalDateTime;

import dao.TicketDao;
import datos.Ticket;

public class TicketAbm {
	
	private TicketDao ticketDao = new TicketDao();
	
	public int agregarTicket(String titulo, String descripcion) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new Exception("El título del ticket no puede estar vacío.");
		}
		
		Ticket ticket = new Ticket();
		ticket.setTitulo(titulo);
		ticket.setDescripcion(descripcion);
		ticket.setFechaCreacion(LocalDateTime.now());
		
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