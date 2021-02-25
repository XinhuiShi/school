package week05;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class Week05JUnitTest {

	private static final int RUNS = 1000;
	private String MSG = "";

	@Test
	public void testMultipleDie() {

		Die one;
		Die two;
		Die three;
		Die four;

		// create multiple instances of Die class
		one = new Die(false);
		two = new Die(true); // force roll
		three = new Die(false);
		four = new Die(true); // force roll

		one.roll();
		three.roll();

		if (one.getNumber() == two.getNumber() && two.getNumber() == three.getNumber()
				&& three.getNumber() == four.getNumber()) {
			fail("Duplicated rolls indicates random roll isn't working");
		}

	}

	/*
	 * Die originally have a issue that it gave an output from 0 to 5. This test
	 * uses that as a "feature" and just roll with it. It makes the array size 1
	 * less
	 */
	@Test
	public void testRandomDie() {

		int runs = RUNS;
		int[] ary = new int[6];
		Die die = new Die(false);

		for (int i = 0; i < runs; i++) {
			die.roll();
			ary[die.getNumber()]++;
		}
		MSG += "Counts:";
		for (int count : ary)
			MSG += " " + count;
		MSG += "\nDistribution:";

		// calculating percentages
		double[] percentage = new double[6];
		for (int i = 0; i < percentage.length; i++) {
			double temp = ((double) ary[i] / runs);
			percentage[i] = round(temp, 2);
		}
		for (double per : percentage)
			MSG += " " + per;
		double mean = runs / 6;
		MSG += "\nmean: " + round(mean, 2);

		// calculating std.Deviation
		double preVar = 0;
		for (int i = 1; i < ary.length; i++) {
			double step2 = ary[i] - mean;
			double step3 = step2 * step2;
			preVar += step3;
		}
		double variance = preVar / 6;
		double stdDev = Math.sqrt(variance);

		MSG += ", std dev: " + round(stdDev, 2);

		System.out.println(MSG);

		for (int facet : ary) {
			if (facet == 0)
				fail("One of the die face has 0 rolls");
		}
	}

	/*
	 * This is for the corrected version. This uses Die2 that gives an output of
	 * 1-6. I moved the array to one size larger, because I can just simply skip
	 * over the first spot in the array when looping.
	 */
	@Test
	public void testRandomDie2() {

		int runs = RUNS;
		int[] ary = new int[7];
		Die2 die = new Die2(false);

		for (int i = 0; i < runs; i++) {
			die.roll();
			ary[die.getNumber()]++;
		}
		MSG += "Counts:";
		for (int i = 1; i < ary.length; i++)
			MSG += " " + ary[i];
		MSG += "\nDistribution:";

		// calculating percentages
		double[] percentage = new double[7];
		for (int i = 1; i < percentage.length; i++) {
			double temp = ((double) ary[i] / runs);
			percentage[i] = round(temp, 2);
		}
		for (int i = 1; i < percentage.length; i++)
			MSG += " " + percentage[i];
		double mean = runs / 6;
		MSG += "\nmean: " + round(mean, 2);

		// calculating std.Deviation
		double preVar = 0;
//		double[] varianceAry = new double[6];
		for (int i = 1; i < ary.length; i++) {
			double step2 = ary[i] - mean;
			double step3 = step2 * step2;
			preVar += step3;
		}
		double variance = preVar / 6;
		double stdDev = Math.sqrt(variance);

		MSG += ", std dev: " + round(stdDev, 2);

		System.out.println(MSG);

		for (int i = 1; i < ary.length; i++)
			if (ary[i] == 0)
				fail("One of the die face has 0 rolls");

	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
