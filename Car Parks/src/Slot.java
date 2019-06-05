
public class Slot {

	private Automobile auto;
	//provare a valutare di inserire un unico campo libero (che implica che non sia prenotato e occupato ).
	private boolean prenotato;

	public Slot() {
		auto = null;
		prenotato = false;
	}
	
	public Automobile ritiraAuto() {
		prenotato = false;
		Automobile auto=this.auto;
		this.auto=null;
		return auto;
	}

	public void parcheggia(Automobile auto) {
		prenotato = true;
		this.auto = auto;
	}
	
	public boolean isLibero() {
		return auto==null;
	}

	public boolean isPrenotato() {
		return prenotato;
	}

	public void setPrenotato(boolean prenotato) {
		this.prenotato = prenotato;
	}
}

