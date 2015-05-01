package pd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private String name;
	private String vorname;
	private Date gebDatum;
	public Student(String vorname, String name, String gebDatum) {
		this.name = name;
		this.vorname = vorname;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			this.gebDatum =  dateFormat.parse(gebDatum);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Falsches Datum");
        }
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
	public String toString() {
		return "Stundent:   " + getVollerName() +
				"\n            Geburtsdatum: " + getGebDatum();
	}
}
