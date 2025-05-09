package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.SistemaDao;
import datos.Ticket;
import datos.User;

public class SistemaAbm {
	
	private SistemaDao sisDAO= new SistemaDao();
	
	public List<User> traerUsuarios(){
		List<User> lstAux = new ArrayList<User>();
		lstAux = sisDAO.traerUsuarios();
		return lstAux;
	}
	
	public List<Ticket> traerTickets(){
		List<Ticket> lstAux = new ArrayList<Ticket>();
		lstAux = sisDAO.traerTickets();
		return lstAux;
	}
	
}
