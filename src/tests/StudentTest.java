package tests;

import org.junit.Before;
import org.junit.Test;

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
}