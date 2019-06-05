
public class Automobilista {

	private volatile Automobile automobile;
	private volatile Ticket ticket;
	
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
	
	public void strappaTicket() {
		ticket = null;
	}
	
	public Automobile lasciaAutomobile() {
		Automobile auto = automobile;
		automobile=null;
		return auto;
	}
	
	public void ritira(Automobile auto) {
		automobile = auto;
	}
	
	@Override
	public String toString() {
		return "Automobilista [automobile=" + automobile + ", ticket=" + ticket + "]";
	}
}