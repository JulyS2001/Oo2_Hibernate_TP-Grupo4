package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Actualizacion;

public class ActualizacionDao {

    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos (ActualizacionDao)", he);
    }
    
    public int crearActualizacion(Actualizacion objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    } 
    
    public Actualizacion traer(int idActualizacion) {
        Actualizacion objeto = null;
        try {
            iniciaOperacion();
            objeto = (Actualizacion) session.get(Actualizacion.class, idActualizacion);
        } finally {
            session.close();
        }
        return objeto;
    }
    
    public void actualizar(Actualizacion objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void eliminarActualizacion(Actualizacion objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    public boolean estaAsociadaATickets(int idActualizacion) {
        boolean asociada = false;
        try {
            iniciaOperacion();
            Long cantidad = session.createQuery(
                "select count(t) from Ticket t where t.actualizacion.id = :idActualizacion", Long.class)
                .setParameter("idActualizacion", idActualizacion)
                .uniqueResult();
            asociada = cantidad > 0;
        } finally {
            session.close();
        }
        return asociada;
    }
}
