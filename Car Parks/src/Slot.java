
public class Slot {

	private Automobile auto;
	private boolean prenotato;

	public Slot() {
		auto=null;
	}
	
	public Automobile prelievo() {
		Automobile auto=this.auto;
		this.auto=null;
		return auto;
	}

	public void parcheggia(Automobile auto) {
		this.auto=auto;
	}
	
	public boolean libero() {
		return auto==null;
	}

	public boolean isPrenotato() {
		return prenotato;
	}

	public void setPrenotato(boolean prenotato) {
		this.prenotato = prenotato;
	}
	
	
}

