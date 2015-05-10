package tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import pd.Fach;
import pd.Pruefung;

public class FachTest {

	private Fach f;
	
	@Before
	public void setUp() {
		f = new Fach("Informatik", 1);
	}
	
	@Test
	public void testOhnePruefung() {
		assertEquals(0, f.getAnzahlPruefungen());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMitNegativemGewicht() {
		f = new Fach("Informatik", -3);
	}
	
	@Test
	public void testMitEinerPrüfung() {
		f.neuePruefungHinzufügen("09.05.2015", 5.5);
		assertEquals(1, f.getAnzahlPruefungen());
	}
	
	@Test
	public void testNotendurchschnitt() {
		f.neuePruefungHinzufügen("09.05.2015", 4.5);
		f.neuePruefungHinzufügen("10.05.2015", 5.5);
		assertEquals(5, f.getFachnote(), 0.001);
	}
	
	@Test
	public void testSuchePruefungSetzeNote() {
		f.neuePruefungHinzufügen("18.02.2000");
		Pruefung p = f.getPruefung("18.02.2000");
		if (p!=null) {
			p.setNote(5.8);
		}
		assertEquals(5.8, f.getFachnote(), 0.001);
	}
}