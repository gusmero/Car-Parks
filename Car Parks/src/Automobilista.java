
public class Automobilista {

	private String nome;
	private Automobile automobile;
	private Ticket ticket;
	
	
	public Automobilista(String nome, Automobile automobile) {
		this.nome = nome;
		this.automobile = automobile;
		ticket = null;
	}

	public void ritiraTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public String getNome() {
		return nome;
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
