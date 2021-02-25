package week05;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PlaygroundWeek5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mes = "";
		int runs = 996;
		int[] ary = new int[6] ;
		
		ary[0] = 166;
		ary[1] = 174;
		ary[2] = 157;
		ary[3] = 175;
		ary[4] = 174;
		ary[5] = 154;

		mes += "Counts:";
		for (int count : ary)
			mes += " " + count;
		mes += "\nDistribution:";

		// calculating percentages
		double[] percentage = new double[6];
		for (int i = 0; i < percentage.length; i++) {
			double temp = ((double) ary[i] / runs);
			percentage[i] = round(temp, 2);
		}
		for (double per : percentage)
			mes += " " + per;
		double mean = runs / 6;
		mes += "\nmean: " + round(mean, 2);

		// calculating std.Deviation
		double preVar = 0;
//		double[] varianceAry = new double[6];
		for (int i = 0; i < ary.length; i++) {
			double step2 = ary[i] - mean;
			double step3 = step2 * step2;
			preVar += step3;
		}
		double variance = preVar/6;
		double stdDev = Math.sqrt(variance);



		mes += ", std dev: " + round(stdDev, 2);

		System.out.println(mes);

	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
