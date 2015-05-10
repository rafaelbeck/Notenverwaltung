package pd;

import java.util.ArrayList;

public class Fach {
	private String bezeichnung;
	private int gewicht;
	private ArrayList<Pruefung> pruefungen;
	public Fach(String bezeichnung, int gewicht) {
		if(!pruefeGewicht(gewicht)) {
			throw new IllegalArgumentException("Falsches Gewicht");
		}
		this.bezeichnung = bezeichnung;
		this.gewicht = gewicht;
		this.pruefungen = new ArrayList<Pruefung>();
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
	//Lösung mit Java 7
	//public double getFachnote() {
	// 	double notenSumme = 0.0;
	// 	int notenAnzahl = 0;
	//	for(Pruefung p : pruefungen) {
	//		if (p.getNoteVorhanden()) {
	//			notenSumme += p.getNote();
	//			notenAnzahl += 1;
	//		}
	//	}
	//	return (notenAnzahl==0) ? 0.0:(notenSumme/notenAnzahl);
	//}
	public double getFachnote() {
		return pruefungen
				.stream()
				.filter(Pruefung::getNoteVorhanden)
				.mapToDouble(Pruefung::getNote)
	            .average().orElse(0.0);
	}
	public ArrayList<Pruefung> getPruefungen() {
		return pruefungen;
	}
	public Pruefung getPruefung(String datum) {
		for(Pruefung p : pruefungen) {
			if (p.getDatum().equals(datum)) {
				return p;
			}
		}
		return null;
	}
	public void neuePruefungHinzufügen(String datum) {
		this.pruefungen.add(new Pruefung(datum));
	}
	public void neuePruefungHinzufügen(String datum, double note) {
		this.pruefungen.add(new Pruefung(datum, note));
	}
	public int getAnzahlPruefungen() {
		return pruefungen.size();
	}
	public String toString() {
		return "Fach:   " + getBezeichnung() +
				"\n        Gewicht: " + getGewicht() +
				"\n        Pruefungen:" + getPruefungen() +
				"\n        Fachnote:" + getFachnote();
	}
}
