
public class ToolsDS {

	static private int[][] connections = {
			/*00*/{0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			/*01*/{1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			/*02*/{0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			/*03*/{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			/*04*/{1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			/*05*/{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			/*06*/{0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			/*07*/{1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			/*08*/{0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			/*09*/{0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			/*10*/{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
			/*11*/{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			/*12*/{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			/*13*/{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
			/*14*/{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			/*15*/{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
			/*16*/{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
			/*17*/{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
			/*18*/{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			/*19*/{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0}
	};
	
	static private int[][] stateVector = new int[20][20];
	static private int[] ar = new int[30];
	static private double[] s = new double[ar.length];
	static private int[] facts = new int[ar.length];
	
	static public double simulationAlgorithm(/*int[] terminals, int m, */double p) {

		
		
		double fs = 0;
		double ftmp = 0;
		int n = s.length;
		
		for (int i = 1; i <= n; i++) {
			ftmp += s[i - 1];
			fs = fs + ftmp * getCoefficient(n, i) * Math.pow(1 - p, i) * Math.pow(p, n - i);
		}/*
		
		for (int i = n; i >= 1; i--) {
			if (s[i - 1] != 0) {
				ftmp += getCoefficient(n, i) * Math.pow(1 - p, i) * Math.pow(p, n - i == 0 ? 1 : n - i);
				fs = fs + s[i - 1] * ftmp;
			}
		}*/
		
		
//		for (int i = 1; i <= facts.length; i++)
//			facts[i] = fact(i);
		/*int i = 1;
		for(int x : facts)
			System.out.println(i++ + " " + x);
		
		
		
		double fs = 0;
		
		for (int i = s.length; i > 0; i--) 
			fs += 0;
		
		*/
//		double sum = 0;
//		
//		for (int x : ar)
//			System.out.print(x + " ");
//		System.out.println();
//		for (double x : s) {
//			System.out.printf("%.3f ", x);
//			sum += x;
//		}
//		System.out.println();
//		System.out.println(sum);
		
		return 1 - fs;
	}
	
	static public void buildDS(int[] terminals, int m) {
		for (int i = 0; i < ar.length; i++) {
			ar[i] = 0;
			s[i] = 0;
		}
		
		for (int i = 0; i < m; i++)
			ar[getAnchor(terminals)]++;
		
		for (int i = 0; i < ar.length; i++)
			s[i] = (double)ar[i] / m;
	}
	
	static public double[] getDS() {
		double[] ds = new double[s.length];
		for (int i = 0; i < s.length; i++)
			ds[i] = s[i];
		
		return ds;
	}
	
	static public void setDS(double[] ds) {
		for (int i = 0; i < s.length; i++)
			s[i] = ds[i];
	}
	
	static private double getCoefficient(int n, int m) {
		double k = 1;
		int x = m > n - m ? m : n - m;
		int y = 1;
		
		for (int i = x + 1; i <= n; i++)
			k = k * i / y++;
		
		return k;
	}
	
	static private int getAnchor(int[] terminals) {
//		for (int i = 0; i < ar.length; i++)
//			ar[i] = 0;
		
		//stateVector = null;
		for (int i = 0; i < stateVector.length; i++)
			for (int j = 0; j < stateVector.length; j++)
				stateVector[i][j] = connections[i][j];
				
		int anchor = 0;
	
		while (checkTerminalsConnection(terminals)) {
			anchor++;
			deleteRandomEdge(stateVector);
		}
		
		return anchor;
	}
	
	static private void deleteRandomEdge(int[][] conn) {
		int row = (int)(Math.random() * 20);
		int col = (int)(Math.random() * 20);
		int counter = 0;
		
		while (conn[row][col] == 0 && counter++ < 400) {
			col++;
			if (col == 20) {
				row++;
				if (row == 20)
					row = 0;
				col = 0;
			}
		}
		
		//System.out.println(row + "\t" + col);
		conn[row][col] = 0;
		conn[col][row] = 0;
	}
	
	static private boolean checkRoute(int x, int y) {
		if (x > y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		return checkRoute(x, y, " " + x + " ");
	}
	
	static private boolean checkRoute(int x, int y, String route) {
		
		if (x == y) {
			//System.out.println(route.substring(1)); //print route if exists (for tests)
			return true;
		}
		
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[x][i] == 1 
					&& !route.contains(" " + i + " ") 
					&& checkRoute(i, y, route + i + " "))
				return true;
		}
		
		return false;
	}
	
	static private boolean checkTerminalsConnection(int[] terminals) {	
		for (int i = 0; i < terminals.length; i++)
			for (int j = i + 1; j < terminals.length; j++)
				if (!checkRoute(terminals[i], terminals[j]))
					return false;
		
		//System.out.println("true"); //true - network is UP (for tests)
		return true;
	}
}
