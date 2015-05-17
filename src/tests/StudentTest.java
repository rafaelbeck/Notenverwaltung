package tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import pd.Fach;
import pd.Student;

public class StudentTest {
	
	private Student s;
	
	@Before
	public void setUp() {
		s = new Student("Karl", "Wissbegierig", "01.01.1980");
	}
	
	@Test
	public void testGanzerNameAendern() {
		s.setVorname("Franz Karl");
		s.setName("Wissbegierig Vergesslich");
	}
	
	@Test
	public void testOhneFach() {
		assertEquals(0, s.getAnzahlFaecher());
	}
	
	@Test
	public void testMitEinemFach() {
		s.neuesFachHinzufügen("Psychologie", 1);
		assertEquals(1, s.getAnzahlFaecher());
	}
	
	@Test
	public void testSucheFach() {
		s.neuesFachHinzufügen("Psychologie", 1);
		Fach f = s.getFach("Psychologie");
		assertThat(f, instanceOf(Fach.class));
	}
	
	@Test
	public void testNotendurchschnitt() {
		s.neuesFachHinzufügen("Psychologie", 1);
		s.neuesFachHinzufügen("Informatik", 2);
		s.neuesFachHinzufügen("UCD", 1);
		
		Fach f1 = s.getFach("Psychologie");
		Fach f2 = s.getFach("Informatik");
		Fach f3 = s.getFach("UCD");
		
		f1.neuePruefungHinzufügen("01.05.2015", 5);
		f2.neuePruefungHinzufügen("02.05.2015", 6);
		f3.neuePruefungHinzufügen("03.05.2015", 5.5);
		
		assertEquals(5.625, s.getNotendurchschnitt(), 0.001);
	}
}