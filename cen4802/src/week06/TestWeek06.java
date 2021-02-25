package week06;

public class TestWeek06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] Sensor = new String[] { "S1", "S2", "S3", "S4", "S5" };

		String[] Weapon = new String[] { "W1", "W2", "W3", "W4" };
		String[] External = new String[] { "Yes", "No" };
		String[] Target = new String[] { "T1", "T2", "T3", "T4", "T5" };
		String[] Platform = new String[] { "P1", "P2", "P3" };

		int count = 0;
		for (String s : Sensor) {
			for (String w : Weapon) {
				for (String e : External) {
					for (String t : Target) {
						for (String p : Platform) {
							count++;
							System.out.println(s + ", " + w + ", " + e + ", " + t + ", " + p);
						}
					}
				}
			}
		}
		System.out.println(count);

	}

}
