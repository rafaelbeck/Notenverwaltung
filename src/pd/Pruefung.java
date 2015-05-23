package pd;

public class Pruefung extends Leistungsnachweis{
	private double note;
	public Pruefung(String datum) {
		super(datum);
		setDatum(datum);
	}
	public Pruefung(String datum, double note) {
		super(datum);
		setDatum(datum);
		setNote(note);
	}
	public void setNote(double note) {
		if(!pruefeNote(note)) {
			throw new IllegalArgumentException("Falsche Note");
		}
		this.note = note;
		setNoteVorhanden();
	}
	@Override
	public double getNote() {
		return note;
	}
	public String toString() {
		return super.toString() + "vom Typ Pruefung";
	}
}
