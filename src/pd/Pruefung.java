package pd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pruefung {
	private Date datum;
	private double note;
	private boolean noteVorhanden;
	public Pruefung(String datum) {
		setDatum(datum);
	}
	public Pruefung(String datum, double note) {
		setDatum(datum);
		setNote(note);
	}
	public void setDatum(String datum) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			this.datum =  dateFormat.parse(datum);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Falsches Datum");
        }
	}
	public void setNote(double note) {
		if(!pruefeNote(note)) {
			throw new IllegalArgumentException("Falsche Note");
		}
		noteVorhanden = true;
		this.note = note;
	}
	public double getNote() {
		return note;
	}
	public String getDatum() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(datum);
	}
	public boolean getNoteVorhanden() {
		return noteVorhanden;
	}
	public String toString() {
		return "Pruefung:   " + getDatum() +
				"\n            Note: " + ((getNoteVorhanden()) ? getNote():"nicht vorhanden");
	}
	
	private boolean pruefeNote(double note) {
		return (note >= 1 && note <= 6);
	}
}
