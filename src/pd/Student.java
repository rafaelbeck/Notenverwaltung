package pd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Student {
	private String name;
	private String vorname;
	private Date gebDatum;
	private ArrayList<Fach> faecher;
	public Student(String vorname, String name, String gebDatum) {
		this.name = name;
		this.vorname = vorname;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			this.gebDatum =  dateFormat.parse(gebDatum);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Falsches Datum");
        }
		this.faecher = new ArrayList<Fach>();
	}
	public void neuesFachHinzufügen(String bezeichnung, int gewicht) {
		this.faecher.add(new Fach(bezeichnung, gewicht));
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public String getVorname() {
		return vorname;
	}
	public String getVollerName() {
		return getVorname() + " " + getName();
	}
	public String getGebDatum() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(gebDatum);
	}
	public int getAnzahlFaecher() {
		return faecher.size();
	}
	public Fach getFach(String bezeichnung) {
		for(Fach f : faecher) {
			if (f.getBezeichnung().equals(bezeichnung)) {
				return f;
			}
		}
		return null;
	}
	public double getNotendurchschnitt() {
		double notenSumme = 0;
		double gewichtSumme = 0;
		int faecherAnzahl = 0;
		for(Fach f : faecher) {
			notenSumme += (f.getGewicht() * f.getFachnote());
			gewichtSumme += f.getGewicht();
			faecherAnzahl++;
		}
		return (faecherAnzahl == 0) ? 0.0:notenSumme/gewichtSumme;
	}
	public String toString() {
		return "Stundent:   " + getVollerName() +
				"\n            Geburtsdatum: " + getGebDatum() +
				"\n            Anzahl Fächer: " + getAnzahlFaecher();
	}
}
