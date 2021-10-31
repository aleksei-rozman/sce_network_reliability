

public class Main {

	public static void main(String[] args) {
		double[] p = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.95};
		int m1 = 1000;
		int m2 = 10000;
		int m3 = 50000;
		int[] terminals = {16, 12, 0};
		
		//System.out.println(1 - ToolsDS.simulationAlgorithm(terminals, m1, 0.9));
		double[] dsM1 = new double[30];
		double[] dsM2 = new double[30];
		double[] dsM3 = new double[30];
		ToolsDS.buildDS(terminals, m1);
		dsM1 = ToolsDS.getDS();
		ToolsDS.buildDS(terminals, m2);
		dsM2 = ToolsDS.getDS();
		ToolsDS.buildDS(terminals, m3);
		dsM3 = ToolsDS.getDS();
		
		double sum1 = 0, sum2 = 0, sum3 = 0;
		for (int i = 0; i < 30; i++) {
			sum1 += dsM1[i];
			sum2 += dsM2[i];
			sum3 += dsM3[i];
		}
		System.out.printf("sum1 = %.4f\tsum2 = %.4f\tsum3 = %.4f\n\n", sum1, sum2, sum3);
		
		System.out.println("Table 1");
		System.out.println("i\tM=1000\tM=10000\tM=50000");
		for (int i = 0; i < dsM1.length; i++) {
			System.out.print(i + 1 + "\t");
			System.out.printf("%.4f\t%.4f\t%.4f", dsM1[i], dsM2[i], dsM3[i]);
			System.out.println();
		}
		
		System.out.println("\nTable 2");
		System.out.println("p\tM=1000\tM=10000\tM=50000");
		for (double pi : p) {
			System.out.print(pi + "\t");
			ToolsDS.setDS(dsM1);
			System.out.printf("%.4f\t", ToolsDS.simulationAlgorithm(pi));
			ToolsDS.setDS(dsM2);
			System.out.printf("%.4f\t", ToolsDS.simulationAlgorithm(pi));
			ToolsDS.setDS(dsM3);
			System.out.printf("%.4f\t", ToolsDS.simulationAlgorithm(pi));
			System.out.println();
		}
		
		System.out.println("\nTable 3");
		System.out.println("p\tM=1000\tM=10000\tM=50000");
		for (double pi : p) {
			System.out.print(pi + "\t");
			System.out.printf("%.4f\t", Tools.calculateNetworkReliability(terminals, m1, pi));
			System.out.printf("%.4f\t", Tools.calculateNetworkReliability(terminals, m2, pi));
			System.out.printf("%.4f\t", Tools.calculateNetworkReliability(terminals, m3, pi));
			System.out.println();
		}
		
		System.out.println("\nTable 4");
		System.out.println("i\tDS\tCMC");
		int count = 10;
		double ptmp = 0.95;
		double[] dsArr = new double[count];
		double[] cmcArr = new double[count];
		for (int i = 0; i < count; i++) {
			ToolsDS.buildDS(terminals, m1);
			dsArr[i] = ToolsDS.simulationAlgorithm(ptmp);
			cmcArr[i] = Tools.calculateNetworkReliability(terminals, m1, ptmp);
			System.out.printf("%d\t%.4f\t%.4f\n", i + 1, dsArr[i], cmcArr[i]);
		}
		
		System.out.println();
		double avgDS = 0;
		double avgCMC = 0;
		for (int i = 0; i < count; i++) {
			avgDS += dsArr[i];
			avgCMC += cmcArr[i];
		}
		avgDS = avgDS / count;
		avgCMC = avgCMC / count;
		System.out.printf("Avg Val\t%.4f\t%.4f\n", avgDS, avgCMC);
		
		double sDS = 0;
		double sCMC = 0;
		for (int i = 0; i < count; i++) {
			sDS += Math.pow(dsArr[i] - avgDS, 2);
			sCMC += Math.pow(cmcArr[i] - avgCMC, 2);
		}
		sDS = Math.sqrt(sDS / (count - 1));
		sCMC = Math.sqrt(sCMC / (count - 1));
		System.out.printf("St Dev\t%.4f\t%.4f\n", sDS, sCMC);
		
		double reDS = sDS / avgDS;
		double reCMC = sCMC / avgCMC;
		System.out.printf("RE\t%.4f\t%.4f\n", reDS, reCMC);
	}
	
	public void part1() {
		//double p = 0.5;
		double[] p = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.95, 0.99};
		int m1 = 1000;
		int m2 = 10000;
		int[] terminals = {16, 12, 0};
		
		System.out.println("p\tM=1000\tM=10000");
		for (double pi : p) {
			System.out.print(pi + "\t");
			System.out.printf("%.4f\t", Tools.calculateNetworkReliability(terminals, m1, pi));
			System.out.printf("%.4f\t", Tools.calculateNetworkReliability(terminals, m2, pi));
			System.out.println();
		}
	}

}
