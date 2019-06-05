
public class Automobile {

	private String targa;

	public Automobile(String targa) {
		this.targa = targa;
	}

	public String getTarga() {
		return targa;
	}

	@Override
	public String toString() {
		return targa;
	}
}
