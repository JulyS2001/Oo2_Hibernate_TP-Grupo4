package datos;

import java.util.HashSet;
import java.util.Set;

public class Sistema {

	private int idSistema;
	private Set<Ticket> lstTickets;
	private Set<User> lstUsers;

	public Sistema() {
		super();
		this.lstTickets = new HashSet<Ticket>();
		this.lstUsers = new HashSet<User>();
	}

	public int getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	public Set<Ticket> getLstTickets() {
		return lstTickets;
	}

	public void setLstTickets(Set<Ticket> lstTickets) {
		this.lstTickets = lstTickets;
	}

	public Set<User> getLstUsers() {
		return lstUsers;
	}

	public void setLstUsers(Set<User> lstUsers) {
		this.lstUsers = lstUsers;
	}

	@Override
	public String toString() {
		return "Sistema [idSistema=" + idSistema + ", lstTickets=" + lstTickets + ", lstUsers=" + lstUsers + "]";
	}

}
