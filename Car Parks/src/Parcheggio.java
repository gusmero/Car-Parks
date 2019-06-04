import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Parcheggio {

	private Slot[] slots;
	private ArrayList<Parcheggiatore> parcheggiatoriLiberi;
	private ArrayBlockingQueue<Ticket> coda;
	
	public Parcheggio(int nSlot, int nParcheggiatori) {
		slots = new Slot[nSlot];
		parcheggiatoriLiberi = new ArrayList<>(nParcheggiatori);
		coda = new ArrayBlockingQueue<>(Integer.MAX_INT);
		
		for (int i = 0; i < slots.length; i++)
			slots[i] = new Slot();
	}
	
	
	public boolean disponibile () {
		boolean disponibile = false;
		for (int i = 0; !disponibile && i < slots.length; i++)
			if (!slots[i].isOccupato())
				disponibile = true;
		
		return disponibile;
	}
	
}
