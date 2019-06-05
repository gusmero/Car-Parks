
public class Ticket {

	private int codice;
	private int idSlot;
	
	public Ticket(int codice, int idSlot) {
		this.codice = codice;
		this.idSlot = idSlot;
	}

	public int getCodice() {
		return codice;
	}

	public int getIdSlot() {
		return idSlot;
	}
	
	@Override
	public String toString() {
		return "Ticket [codice=" + codice + ", idSlot=" + idSlot + "]";
	}
	
}
