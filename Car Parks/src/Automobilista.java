
public class Automobilista {

	private Automobile automobile;
	private Ticket ticket;
	
	public Automobilista(Automobile automobile) {
		this.automobile = automobile;
		ticket = null;
	}

	public void ritiraTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public Automobile lasciaAutomobile() {
		Automobile auto = automobile;
		automobile=null;
		return auto;
	}
	
	public void ritira (Automobile auto) {
		automobile = auto;
	}
}