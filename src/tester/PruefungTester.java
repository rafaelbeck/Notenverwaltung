package tester;

import pd.Pruefung;

public class PruefungTester {
	public static void main(String[] args) {
		try {
			Pruefung p3 = new Pruefung("24.04.2015");
			System.out.println(p3);
			p3.setNote(5);
			System.out.println(p3);
		} catch ( IllegalArgumentException e) {
			System.out.println("Falsches Argument:" + e);
		}
		try {
			Pruefung p1 = new Pruefung("24.04.2015", 0.5);
			System.out.println(p1);
		} catch ( IllegalArgumentException e) {
			System.out.println("Falsches Argument:" + e);
		}
		try {
			Pruefung p2 = new Pruefung("24.04.2015");
			p2.setNote(7);
			System.out.println(p2);
		} catch ( IllegalArgumentException e) {
			System.out.println("Falsches Argument:" + e);
		}
	}
}
