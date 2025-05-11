package test;

import datos.Ticket;
import datos.Estado;
import datos.Prioridad;
import datos.Categoria;
import datos.Cliente;
import datos.Usuario;
import negocio.EstadoAbm;
import negocio.PrioridadAbm;
import negocio.CategoriaAbm;
import negocio.TicketAbm;
import dao.TicketDao;
import negocio.UsuarioAbm;

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
            
            UsuarioAbm usuarioAbm = UsuarioAbm.getInstance();
            Usuario clienteRecuperado = usuarioAbm.traerUsuario(4);
            // Crear el ticket solo con título y descripción
            TicketAbm ticketAbm = new TicketAbm();
            Ticket nuevoTicket = ticketAbm.crearTicket(
                "Error en login",
                "No puedo iniciar sesión con mis credenciales.",  clienteRecuperado, categoriaAbm, estadoAbm, prioridadAbm);
            System.out.println("Ticket creado con ID: " + nuevoTicket.getIdTicket());

            // Recuperar y asignar estado, prioridad y categoría
            Ticket ticket = ticketAbm.traerTicket(nuevoTicket.getIdTicket());
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
