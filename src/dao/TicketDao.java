package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

import datos.Ticket;
//import hibernate.HibernateUtil;

public class TicketDao {

    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos (TicketDao)", he);
    }

    // Crear Ticket
    public int crearTicket(Ticket t) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(t).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    // Traer un Ticket por ID
    public Ticket traerTicket(int idTicket) {
        Ticket t = null;
        try {
            iniciaOperacion();
            t = session.get(Ticket.class, idTicket);
        } finally {
            session.close();
        }
        return t;
    }

    // Traer todos los tickets
    public List<Ticket> traerTodos() {
        List<Ticket> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Ticket", Ticket.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    // Actualizar Ticket
    public void actualizar(Ticket t) {
        try {
            iniciaOperacion();
            session.update(t);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // Eliminar Ticket
    public void eliminar(Ticket t) {
        try {
            iniciaOperacion();
            session.delete(t);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
}