package negocio;

import dao.ActualizacionDao;
import datos.Actualizacion;

import java.time.LocalDateTime;

public class ActualizacionAbm {

    private ActualizacionDao dao = new ActualizacionDao();

	public int agregarActualizacion(String contenido) throws Exception {
		if (contenido == null || contenido.trim().isEmpty()) {
			throw new Exception("El contenido de la actualizacion no puede estar vacío.");
		}
		
		Actualizacion actualizacion = new Actualizacion();
		actualizacion.setContenido(contenido);
		actualizacion.setFechaActualizacion(LocalDateTime.now());
		
		return dao.crearActualizacion(actualizacion);
	}

    public Actualizacion traerActualizacion(int idActualizacion) {
        return dao.traer(idActualizacion);
    }

    public void actualizarActualizacion(Actualizacion actualizacion) {
        if (!dao.estaAsociadaATickets(actualizacion.getIdActualizacion())) {
            throw new RuntimeException("No se puede modificar la prioridad porque no está asociada a tickets.");
        }
        dao.actualizar(actualizacion);
    }

    public void eliminarActualizacion(int idActualizacion) throws Exception {
    	if (dao.estaAsociadaATickets(idActualizacion)) {
            throw new Exception("No se puede eliminar la Actualizacion porque está asociada a tickets.");
        }
        Actualizacion actualizacion = dao.traer(idActualizacion);
        if (actualizacion == null) {
            throw new Exception("Actualizacion no encontrada.");
        }
        dao.eliminarActualizacion(actualizacion);
    }

}
