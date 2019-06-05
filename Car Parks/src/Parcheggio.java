import java.util.concurrent.ArrayBlockingQueue;

public class Parcheggio {

	private Slot[] slots;
	private ArrayBlockingQueue<Automobilista> coda;
	
	public Parcheggio(int nSlot, int nParcheggiatori) {
		slots = new Slot[nSlot];
		coda = new ArrayBlockingQueue<>(Integer.MAX_VALUE);
		
		for (int i = 0; i < slots.length; i++)
			slots[i] = new Slot();
		
		for (int i = 0; i < nParcheggiatori; i++)
			new Parcheggiatore("Parcheggiatore" + i, this).start();
	}
	
	public synchronized void accoda(Automobilista automobilista) {
		coda.add(automobilista);
	}
	
	public synchronized Automobilista rimuovi() {
		return coda.poll();
	}
	
	public synchronized boolean slotLibero(int idSlot) {
		return slots[idSlot].isLibero();
	}
	
	public synchronized void parcheggia(Automobile auto, int idSlot) {
		slots[idSlot].parcheggia(auto);
	}
	
	public synchronized Automobile ritiraAuto(int idSlot) {
		return slots[idSlot].ritiraAuto();
	}
	
	public synchronized boolean disponibile() {
		boolean disponibile = false;
		for (int i = 0; !disponibile && i < slots.length; i++)
			if (!slots[i].isPrenotato())
				disponibile = true;
		return disponibile;
	}
	
	
}
