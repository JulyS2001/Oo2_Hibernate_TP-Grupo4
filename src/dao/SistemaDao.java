package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Sistema;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import datos.Ticket;
import datos.User;


public class SistemaDao {
	
	private static Session session;
    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }
    
    public List<User> traerUsuarios(){
    	List<User>lstAux = new ArrayList<User>();
    	try {
			iniciaOperacion();
			Query<User> consulta = session.createQuery("from User u order by u.nombre asc", User.class);
			lstAux = consulta.getResultList();
		} finally {
			session.close();
		}
		return lstAux;
    }
    
    public List<Ticket> traerTickets(){
    	List<Ticket>lstAux = new ArrayList<Ticket>();
    	try {
			iniciaOperacion();
			Query<Ticket> consulta = session.createQuery("from Ticket t order by t.Titulo asc, t.Fecha_Creacion asc", Ticket.class);
			lstAux = consulta.getResultList();
		} finally {
			session.close();
		}
		return lstAux;
    }
}
