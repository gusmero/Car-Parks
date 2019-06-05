
public class Parcheggiatore extends Thread {

	private Parcheggio parcheggio;
	
	public Parcheggiatore(String nome, Parcheggio parcheggio) {
		super(nome);
		this.parcheggio = parcheggio;
	}
	
	public void run() {
		while (true) {
			Automobilista automob = parcheggio.rimuovi();
			
			if(automob != null) {
				int idSlot = automob.getTicket().getIdSlot();
				
				if (parcheggio.slotLibero(idSlot))
					parcheggio.parcheggia(automob.lasciaAutomobile(), idSlot);
				else
					automob.ritira(parcheggio.ritiraAuto(idSlot));
			}
		}
	}
	
}
