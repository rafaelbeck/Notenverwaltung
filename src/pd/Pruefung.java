package pd;

public class Pruefung {
	private String datum;
	private double note;
	public Pruefung(String datum) {
		this.datum = datum;
	}
	public Pruefung(String datum, double note) {
		this.datum = datum;
		setNote(note);
	}
	public String getDatum() {
		return datum;
	}
	public void setNote(double note) {
		if(!pruefeNote(note)) {
			throw new IllegalArgumentException("Falsche Note");
		}
		this.note = note;
	}
	public double getNote() {
		return note;
	}
	public String toString() {
		return "Pruefung:   " + getDatum() + 
				"\n            Note: " + getNote();
	}
	private boolean pruefeNote(double note) {
		return (note >= 1 && note <= 6);
	}
}
