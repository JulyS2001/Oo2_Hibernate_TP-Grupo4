package negocio;

import dao.ContactoDao;
import datos.Contacto;

public class ContactoAbm {

    private static ContactoAbm instancia = null;
    private ContactoDao dao;

    protected ContactoAbm() {
        dao = ContactoDao.getInstance();
    }

    public static ContactoAbm getInstance() {
        if (instancia == null)
            instancia = new ContactoAbm();
        return instancia;
    }

    public int crear(Contacto c) {
        return dao.crear(c);
    }

    public void eliminar(int idContacto) {
        Contacto c = dao.traer(idContacto);
        if (c == null) {
            throw new RuntimeException("Contacto no encontrado.");
        }
        dao.eliminar(c);
    }

    public void modificar(Contacto c) {
        Contacto existe = dao.traer(c.getIdContacto());
        if (existe == null) {
            throw new RuntimeException("Contacto no encontrado.");
        }
        dao.modificar(c);
    }

    public Contacto traer(int idContacto) {
        return dao.traer(idContacto);
    }
}
