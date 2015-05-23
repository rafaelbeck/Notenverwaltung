package tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import pd.Fach;
import pd.Pruefung;
import pd.Referat;

public class FachTest {

	private Fach f;
	
	@Before
	public void setUp() {
		f = new Fach("Informatik", 1);
	}
	
	@Test
	public void testOhnePruefung() {
		assertEquals(0, f.getAnzahlLeistungsnachweise());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMitNegativemGewicht() {
		f = new Fach("Informatik", -3);
	}
	
	@Test
	public void testMitEinerPrüfung() {
		f.neuePruefungHinzufügen("09.05.2015", 5.5);
		assertEquals(1, f.getAnzahlLeistungsnachweise());
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
		Pruefung p = (Pruefung) f.getPruefung("18.02.2000");
		if (p!=null) {
			p.setNote(5.8);
		}
		assertEquals(5.8, f.getFachnote(), 0.001);
	}
	
	@Test
	public void testSuchReferatSetzeNote() {
		f.neuesReferatHinzufügen("23.05.2015", 0.2);
		Referat r = (Referat) f.getReferat("23.05.2015");
		if (r!=null) {
			r.setNoten(5, 4.5);
		}
		assertEquals(4.9, f.getFachnote(), 0.001);
	}
}