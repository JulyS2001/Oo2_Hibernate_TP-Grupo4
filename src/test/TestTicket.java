package test;

import datos.Ticket;
import datos.Estado;
import datos.Prioridad;
import datos.Categoria;
import negocio.EstadoAbm;
import negocio.PrioridadAbm;
import negocio.CategoriaAbm;
import negocio.TicketAbm;
import dao.TicketDao;

import java.time.LocalDateTime;
import java.util.List;

public class TestTicket {

    public static void main(String[] args) {
        try {
            // Crear Estado, Prioridad y Categoría
            EstadoAbm estadoAbm = new EstadoAbm();
            int idEstado = estadoAbm.crearEstado("Nuevo");

            PrioridadAbm prioridadAbm = new PrioridadAbm();
            int idPrioridad = prioridadAbm.agregarPrioridad("Alta");

            CategoriaAbm categoriaAbm = new CategoriaAbm();
            int idCategoria = categoriaAbm.agregarCategoria("Bug");
            
            // Crear el ticket solo con título y descripción
            TicketAbm ticketAbm = new TicketAbm();
            int idTicket = ticketAbm.agregarTicket(
                "Error en login",
                "No puedo iniciar sesión con mis credenciales.", idCategoria, idEstado, idPrioridad);
            System.out.println("Ticket creado con ID: " + idTicket);

            // Recuperar y asignar estado, prioridad y categoría
            Ticket ticket = ticketAbm.traerTicket(idTicket);
            ticket.setEstado(estadoAbm.traerEstado(idEstado));
            ticket.setPrioridad(prioridadAbm.traerPrioridad(idPrioridad));
            ticket.setCategoria(categoriaAbm.traerCategoria(idCategoria));
            ticketAbm.actualizarTicket(ticket);

            System.out.println("Ticket actualizado con asociaciones: " + ticketAbm.traerTicket(idTicket));

            // Mostrar todos
            List<Ticket> todos = ticketAbm.traerTodos();
            System.out.println("Lista de todos los tickets:");
            for (Ticket t : todos) {
                System.out.println(t);
            }

            // Eliminar el ticket
            ticketAbm.eliminarTicket(idTicket);
            System.out.println("Ticket con ID " + idTicket + " eliminado.");

        } catch (Exception e) {
            System.err.println("Error durante las pruebas de TicketAbm: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
