

public class Main {

	public static void main(String[] args) {
		
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
