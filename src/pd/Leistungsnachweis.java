package pd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Leistungsnachweis {
	private Date datum;
	private boolean noteVorhanden;
	public Leistungsnachweis(String datum) {
		setDatum(datum);
		this.noteVorhanden = false;
	}
	abstract public double getNote();
	public String getDatum() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(datum);
	}
	public boolean getNoteVorhanden() {
		return noteVorhanden;
	}
	protected void setNoteVorhanden() {
		this.noteVorhanden = true;
	}
	protected void setDatum(String datum) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			this.datum =  dateFormat.parse(datum);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Falsches Datum");
        }
	}
	public boolean pruefeNote(double note) {
		return (note >= 1 && note <= 6);
	}
	public String toString() {
		if (noteVorhanden) {
			return "Leistungsnachweis vom " + getDatum() + " mit Note " + getNote();
		} else {
			return "Leistungsnachweis vom " + getDatum() + " ohne Note ";
		}
	}
}
