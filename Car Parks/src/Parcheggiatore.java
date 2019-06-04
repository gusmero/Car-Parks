import java.util.ArrayList;

public class Parcheggiatore {

	private String nome;

	public Parcheggiatore(String nome) {
		this.nome = nome;
	}
	

	public String getNome() {
		return nome;
	}
	
	public void parcheggia(Automobile auto , Ticket ticket, Slot[] listaSlot){
		listaSlot[ticket.getIdSlot()].parcheggia(auto);
	}
	
	public Automobile restituire(Ticket ticket , Slot[] listaSlot) {
		return listaSlot[ticket.getIdSlot()].prelievo();
	}
	
	
	
}
