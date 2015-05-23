package pd;

import java.util.ArrayList;

public class Fach {
	private String bezeichnung;
	private int gewicht;
	private ArrayList<Leistungsnachweis> leistungsnachweis;
	public Fach(String bezeichnung, int gewicht) {
		if(!pruefeGewicht(gewicht)) {
			throw new IllegalArgumentException("Falsches Gewicht");
		}
		this.bezeichnung = bezeichnung;
		this.gewicht = gewicht;
		this.leistungsnachweis = new ArrayList<Leistungsnachweis>();
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
	//	for(Leistungsnachweis l : leistungsnachweis) {
	//		if (l.getNoteVorhanden()) {
	//			notenSumme += l.getNote();
	//			notenAnzahl += 1;
	//		}
	//	}
	//	return (notenAnzahl==0) ? 0.0:(notenSumme/notenAnzahl);
	//}
	public double getFachnote() {
		return leistungsnachweis
				.stream()
				.filter(Leistungsnachweis::getNoteVorhanden)
				.mapToDouble(Leistungsnachweis::getNote)
	            .average().orElse(0.0);
	}
	public ArrayList<Leistungsnachweis> getPruefungen() {
		return leistungsnachweis;
	}
	public Leistungsnachweis getPruefung(String datum) {
		Pruefung p = null;
		for(Leistungsnachweis l : leistungsnachweis) {
			if (l.getDatum().equals(datum)) {
				try {
					p = (Pruefung)l;
					return p;
				} catch(ClassCastException e) {}
			}
		}
		return null;
	}
	public Leistungsnachweis getReferat(String datum) {
		Referat r = null;
		for(Leistungsnachweis l : leistungsnachweis) {
			if (l.getDatum().equals(datum)) {
				try {
					r= (Referat)l;
					return r;
				} catch(ClassCastException e) {}
			}
		}
		return null;
	}
	public void neuePruefungHinzufügen(String datum) {
		this.leistungsnachweis.add(new Pruefung(datum));
	}
	public void neuePruefungHinzufügen(String datum, double note) {
		this.leistungsnachweis.add(new Pruefung(datum, note));
	}
	public void neuesReferatHinzufügen(String datum, double gewichtHandout ) {
		this.leistungsnachweis.add(new Referat(datum, gewichtHandout));
	}
	public void neuesReferatHinzufügen(String datum, double gewichtHandout, double noteVortrag, double noteHandout) {
		this.leistungsnachweis.add(new Referat(datum, gewichtHandout, noteVortrag, noteHandout));
	}
	public int getAnzahlLeistungsnachweise() {
		return leistungsnachweis.size();
	}
	public String toString() {
		return "Fach:   " + getBezeichnung() +
				"\n        Gewicht: " + getGewicht() +
				"\n        Anzahl Leistungsnachweise:" + getAnzahlLeistungsnachweise() +
				"\n        Fachnote:" + getFachnote();
	}
}
