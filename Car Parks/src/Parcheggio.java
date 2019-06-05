import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Parcheggio {

	private Slot[] slots;
	private ArrayBlockingQueue<Automobilista> coda;
	private int idTicket;
	
	public Parcheggio(int nSlot, int nParcheggiatori) {
		idTicket = 0;
		slots = new Slot[nSlot];
		coda = new ArrayBlockingQueue<>(500);
		
		for (int i = 0; i < slots.length; i++)
			slots[i] = new Slot();
		
		for (int i = 0; i < nParcheggiatori; i++)
			new Parcheggiatore("Parcheggiatore" + i, this).start();
	}
	
	public synchronized void accoda(Automobilista automobilista) {
		int i;
		for (i = 0; i < slots.length && slots[i].isPrenotato(); i++);
		accoda(automobilista, i);
	}
	
	public synchronized void accoda(Automobilista automobilista, int idSlot) {
		automobilista.ritiraTicket(new Ticket(idTicket++, idSlot));
		slots[idSlot].setPrenotato(true);
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
	
	@Override
	public synchronized String toString() {
		return "Parcheggio [slots=" + Arrays.toString(slots) + ", coda=" + coda + "]";
	}
	
	public static void main(String[] args) {
		Parcheggio park = new Parcheggio(10, 3);
		Automobilista[] automobilisti = new Automobilista[10];
		Random r = new Random();
		
		for (int i = 0; i < automobilisti.length; i++) {
			automobilisti[i] = new Automobilista(new Automobile(""+i));
		}
		
		System.out.println(park);
		for (int i = 0; i < 200 && park.disponibile(); i++) {
			park.accoda(automobilisti[r.nextInt(automobilisti.length)]);
			System.out.println(park);
		}
	}
}
