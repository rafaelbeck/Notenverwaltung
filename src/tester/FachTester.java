package tester;

import pd.Fach;

public class FachTester {

	public static void main(String[] args) {
		try {
			Fach f = new Fach("Mathe", -3);
			System.out.println(f);
		} catch ( IllegalArgumentException e) {
			System.out.println("Falsches Argument:" + e);
		}
	}

}