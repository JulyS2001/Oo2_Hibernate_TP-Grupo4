package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Estado;


public class EstadoDao {
	
	private static Session session; 
	private Transaction tx; 
	private static EstadoDao instancia = null; 
	
	protected EstadoDao() {}
	
	public static EstadoDao getInstance() {
		if(instancia == null)
			instancia = new EstadoDao();
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}
	
	public int crearEstado(Estado e) {
		int id = 0; 
		try {
			iniciaOperacion();
			id = (int)session.save(e);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizarEstado(Estado e) {
		try {
			iniciaOperacion();
			session.update(e);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he; 
		}finally {
			session.close();
		}
	}
	

}
