package datos;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

private int idSistema;
private List<Ticket> lstTickets;
private List<User> lstUsers;

/*
public Sistema() {
}
*/

public Sistema() {
	super();
	this.lstTickets = new ArrayList<Ticket>();
	this.lstUsers = new ArrayList<User>();
}

public int getIdSistema() {
	return idSistema;
}

protected void setIdSistema(int idSistema) {
	this.idSistema = idSistema;
}

public List<Ticket> getLstTickets() {
	return lstTickets;
}

public void setLstTickets(List<Ticket> lstTickets) {
	this.lstTickets = lstTickets;
}

public List<User> getLstUsers() {
	return lstUsers;
}

public void setLstUsers(List<User> lstUsers) {
	this.lstUsers = lstUsers;
}

@Override
public String toString() {
	return "Sistema [idSistema=" + idSistema + ", lstTickets=" + lstTickets + ", lstUsers=" + lstUsers + "]";
}

}
