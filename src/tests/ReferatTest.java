package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pd.Referat;

public class ReferatTest {

	@Test
	public void testNoten() {
		Referat r = new Referat("24.04.2015", 1);
		r.setNoten(5.0, 5.0);
		assertEquals(5.0, r.getNote(), 0.001);
	}
	
	@Test
	public void testNotenMitNoten() {
		Referat r = new Referat("24.04.2015", 1, 4.5, 5.0);
		assertEquals(5.0, r.getNote(), 0.001);
	}
}