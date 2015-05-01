package pd;

public class Fach {
	private String bezeichnung;
	private int gewicht;
	public Fach(String bezeichnung, int gewicht) {
		if(!pruefeGewicht(gewicht)) {
			throw new IllegalArgumentException("Falsches Gewicht");
		}
		this.bezeichnung = bezeichnung;
		this.gewicht = gewicht;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	private boolean pruefeGewicht(int gewicht) {
		return gewicht > 0;
	}
	public int getGewicht() {
		return gewicht;
	}
	public String toString() {
		return "Fach:   " + getBezeichnung() +
				"\n        Gewicht: " + getGewicht();
	}
}
