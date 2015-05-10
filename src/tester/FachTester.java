package tester;

import pd.Fach;
import pd.Pruefung;

public class FachTester {

	public static void main(String[] args) {
		try {
			Fach f = new Fach("Mathe", 1);
			f.neuePruefungHinzufügen("01.01.2000", 5);
			f.neuePruefungHinzufügen("15.01.2000");
			Pruefung p = f.getPruefung("18.02.2000");
			if (p!=null) {
				p.setNote(5.8);
			}
			System.out.println(p);
		} catch ( IllegalArgumentException e) {
			System.out.println("Falsches Argument:" + e);
		}
		try {
			Fach f = new Fach("Mathe", -3);
			System.out.println(f);
		} catch ( IllegalArgumentException e) {
			System.out.println("Falsches Argument:" + e);
		}
	}

}