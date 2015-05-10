package tests;

import org.junit.Test;

import pd.Pruefung;

public class PruefungTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void testNoteZuGross() {
		Pruefung p = new Pruefung("24.04.2015");
		p.setNote(7);
	}
	
	@Test  (expected = IllegalArgumentException.class)
	public void testNoteZuKlein() {
		new Pruefung("24.04.2015", 0.5);
	}
	
	@Test
	public void testNote() {
		Pruefung p = new Pruefung("24.04.2015");
		p.setNote(5);
	}
}
