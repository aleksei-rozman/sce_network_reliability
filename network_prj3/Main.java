

public class Main {

	public static void main(String[] args) {
		double[] p = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.95};
		int m1 = 1000;//1000;
		int m2 = 10000;//10000;
		int m3 = 10000000;//50000;
		int[] terminals = {16, 12, 0};
		
		int a = 4, b = 26, c = 12, d = 21;
		
		double[] ds1 = new double[30];
		double[] ds2 = new double[30];
		double[] bimA1 = new double[30];
		double[] bimA2 = new double[30];
		double[] bimB1 = new double[30];
		double[] bimB2 = new double[30];
		double[] bimC1 = new double[30];
		double[] bimC2 = new double[30];
		double[] bimD1 = new double[30];
		double[] bimD2 = new double[30];
		
		ToolsBIM.buildDS(terminals, m1);
		ds1 = ToolsBIM.getDS();
		ToolsBIM.buildDS(terminals, m2);
		ds2 = ToolsBIM.getDS();
		
		System.out.println("Table 1");
		System.out.println("i\tM=1000\tM=10000");
		for (int i = 0; i < ds1.length; i++) {
			System.out.printf("%d\t%.3f\t%.3f\n", i + 1, ds1[i], ds2[i]);
		}
		
		ToolsBIM.buildCS(terminals, m1);
		//ToolsBIM.showCS();
		bimA1 = ToolsBIM.getColumnBIM(a);
		bimB1 = ToolsBIM.getColumnBIM(b);
		bimC1 = ToolsBIM.getColumnBIM(c);
		bimD1 = ToolsBIM.getColumnBIM(d);
		
		ToolsBIM.buildCS(terminals, m2);
		bimA2 = ToolsBIM.getColumnBIM(a);
		bimB2 = ToolsBIM.getColumnBIM(b);
		bimC2 = ToolsBIM.getColumnBIM(c);
		bimD2 = ToolsBIM.getColumnBIM(d);
		
		System.out.println("\nTable 2");
		System.out.println("\tEdge A\t\tEdge B\t\tEdge C\t\tEdge D");
		System.out.println("i\tM=1000\tM=10000\tM=1000\tM=10000\tM=1000\tM=10000\tM=1000\tM=10000");
		for (int i = 0; i < bimA1.length; i++) {
			System.out.printf("%d\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\n", i + 1, bimA1[i], bimA2[i], bimB1[i], bimB2[i], bimC1[i], bimC2[i], bimD1[i], bimD2[i]);
		}
		
		double[] pcmc = {0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
		int num = 0;
		System.out.println("\nTable 3");
		for (double pi : pcmc) {
			double tmp = Tools.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn1();
			double tmp1 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn2();
			double tmp2 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn3();
			double tmp3 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn4();
			double tmp4 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			System.out.printf("%.1f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\n", pi, bimA2[num], tmp - tmp1, bimB2[num], tmp - tmp2, bimC2[num], tmp - tmp3, bimD2[num], tmp - tmp4);
			num += 3;
		}
//		for (int i = 0; i < bimA1.length; i++) {
//			System.out.printf("%d\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\t%.3f\n", i + 1, bimA2[i], 1 - bimA2[i], bimB2[i], 1 - bimB2[i], bimC2[i], 1 - bimC2[i], bimD2[i], 1 - bimD2[i]);
//		}
		
		System.out.println("\nTable 4");
		System.out.println("p\tEdge A\t\tEdge B\t\tEdge C\t\tEdge D");
		for (double pi : pcmc) {
			double tmp = Tools.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn1();
			double tmp1 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn2();
			double tmp2 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn3();
			double tmp3 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			ToolsCMC.setConn4();
			double tmp4 = ToolsCMC.calculateNetworkReliability(terminals, m2, pi);
			System.out.printf("%.1f\t%.3f\t\t%.3f\t\t%.3f\t\t%.3f\n", pi, tmp - tmp1, tmp - tmp2, tmp - tmp3, tmp - tmp4);
		}
		
		//		for (int i = 0; i < 10; i++)
//			System.out.println(ToolsH.calculateNetworkReliability(terminals, m3));
		
		//System.out.println(ToolsBIM.getCoefficient(30, 15));
	}

}
