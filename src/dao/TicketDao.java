package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Prioridad;
import datos.Ticket;

public class TicketDao {
	
	 private static Session session;
	    private Transaction tx;

	    private void iniciaOperacion() throws HibernateException {
	        session = HibernateUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();
	    }
	    
	    private void manejaExcepcion(HibernateException he) throws HibernateException {
	        tx.rollback();
	        throw new HibernateException("ERROR en la capa de acceso a datos (CategoriaDao)", he);
	    }
	    
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

	    
	
	

}
