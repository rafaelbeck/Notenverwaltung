package pd;

public class Referat extends Leistungsnachweis{
	private double noteVortrag; 
	private double noteHandout;
	private double gewichtHandout;
	public Referat(String datum, double gewichtHandout) {
		super(datum);
		setGewicht(gewichtHandout);
	}
	public Referat(String datum, double gewichtHandout, double noteVortrag, double noteHandout) {
		super(datum);
		setGewicht(gewichtHandout);
		setNoten(noteVortrag, noteHandout);
	}
	public void setNoten(double noteVortrag, double noteHandout) {
		if(!pruefeNote(noteVortrag) || !pruefeNote(noteHandout)) {
			throw new IllegalArgumentException("Falsche Note");
		}
		this.noteVortrag = noteVortrag;
		this.noteHandout = noteHandout;
		setNoteVorhanden();
	}
	public double getNote() {
		return noteVortrag*(1.0-gewichtHandout)+noteHandout*gewichtHandout;
	}
	public String toString() {
		return super.toString() + "vom Typ Referat";
	}
	private void setGewicht(double gewichtHandout) {
		if (pruefeGewicht(gewichtHandout)) {
			this.gewichtHandout = gewichtHandout;
		} else {
			throw new IllegalArgumentException("Falsches Gewicht");
		}
	}
	private boolean pruefeGewicht(double gewicht) {
		return gewicht > 0.0 && gewicht <= 1.0;
	}
}
