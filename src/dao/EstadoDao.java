package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Categoria;
import datos.Estado;


public class EstadoDao {
	
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
	
	  public Estado traerEstado(int idEstado) {
	        Estado objeto = null;
	        try {
	            iniciaOperacion();
	            objeto = (Estado) session.get(Estado.class, idEstado);
	        } finally {
	            session.close();
	        }
	        return objeto;
	    }
	

}
