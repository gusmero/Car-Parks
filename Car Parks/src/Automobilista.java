
public class Automobilista {

	private String nome;
	private Automobile automobile;
	
	
	public Automobilista(String nome, Automobile automobile) {
		this.nome = nome;
		this.automobile = automobile;
	}


	public String getNome() {
		return nome;
	}


	public Automobile lasciaAutomobile() {
		Automobile auto =automobile;
		automobile=null;
		return auto;
	}
	
	public void ritira (Automobile auto) {
		automobile =auto;
	}
	
}
