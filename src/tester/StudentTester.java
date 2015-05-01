package tester;

import pd.Student;

public class StudentTester {
	
	public static void main(String[] args) {
		Student s1 = new Student("Karl", "Wissbegierig", "01.01.1980");
		System.out.println(s1);
		
		Student s2 = new Student("Karl", "Wissbegierig", "01.01.1980");
		s2.setVorname("Franz Karl");
		s2.setName("Wissbegierig Vergesslich");
		System.out.println(s2);
	}
}
