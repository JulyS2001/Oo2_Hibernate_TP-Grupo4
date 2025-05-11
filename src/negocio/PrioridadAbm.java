package negocio;

import dao.PrioridadDao;
import datos.Prioridad;

public class PrioridadAbm {
    private PrioridadDao dao = new PrioridadDao();

    public int agregarPrioridad(String tipo) {
    	Prioridad existente = dao.traerPorTipo(tipo);
        if (existente != null) {
            System.out.println("Ya existe una prioridad con tipo '" + tipo + "' con ID: " + existente.getIdPrioridad());
            return existente.getIdPrioridad();
        }
    	Prioridad prioridad = new Prioridad();
    	prioridad.setTipo(tipo);
        return dao.agregar(prioridad);
    }

    public Prioridad traerPrioridad(int idPrioridad) {
        return dao.traer(idPrioridad);
    }

    public void modificarPrioridad(Prioridad prioridad) {
    	if (dao.traer(prioridad.getIdPrioridad()) == null) {
            throw new RuntimeException("Prioridad no encontrada.");
        }
        if (dao.estaAsociadaATickets(prioridad.getIdPrioridad())) {
            throw new RuntimeException("No se puede modificar la prioridad porque está asociada a tickets.");
        }
        dao.actualizar(prioridad);
    }

    public void eliminarPrioridad(int idPrioridad) throws Exception {
        if (dao.estaAsociadaATickets(idPrioridad)) {
            throw new Exception("No se puede eliminar la prioridad porque está asociada a tickets.");
        }
        Prioridad prioridad = dao.traer(idPrioridad);
        if (prioridad == null) {
            throw new Exception("Prioridad no encontrada.");
        }
        dao.eliminar(prioridad);
    }
}
