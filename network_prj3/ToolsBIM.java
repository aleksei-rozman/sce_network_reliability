
public class ToolsBIM {

	static private int[][] connections = {
			//*****0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
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
	
	static private int[][] connectionNames = {
			//      0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19
			/*00*/{ 0,  1,  0,  0,  5,  0,  0, 26,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*01*/{ 1,  0,  2,  0,  0,  0,  0,  0,  0, 27,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*02*/{ 0,  2,  0,  3,  0,  0,  0,  0,  0,  0,  0, 28,  0,  0,  0,  0,  0,  0,  0,  0},
			/*03*/{ 0,  0,  3,  0,  4,  0,  0,  0,  0,  0,  0,  0,  0, 29,  0,  0,  0,  0,  0,  0},
			/*04*/{ 5,  0,  0,  4,  0, 30,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*05*/{ 0,  0,  0,  0, 30,  0,  6,  0,  0,  0,  0,  0,  0,  0, 15,  0,  0,  0,  0,  0},
			/*06*/{ 0,  0,  0,  0,  0,  6,  0,  7,  0,  0,  0,  0,  0,  0,  0,  0, 22,  0,  0,  0},
			/*07*/{26,  0,  0,  0,  0,  0,  7,  0,  8,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*08*/{ 0,  0,  0,  0,  0,  0,  0,  8,  0,  9,  0,  0,  0,  0,  0,  0,  0, 23,  0,  0},
			/*09*/{ 0, 27,  0,  0,  0,  0,  0,  0,  9,  0, 10,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*10*/{ 0,  0,  0,  0,  0,  0,  0,  0,  0, 10,  0, 11,  0,  0,  0,  0,  0,  0, 24,  0},
			/*11*/{ 0,  0, 28,  0,  0,  0,  0,  0,  0,  0, 11,  0, 12,  0,  0,  0,  0,  0,  0,  0},
			/*12*/{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 12,  0, 13,  0,  0,  0,  0,  0, 25},
			/*13*/{ 0,  0,  0, 29,  0,  0,  0,  0,  0,  0,  0,  0, 13,  0, 14,  0,  0,  0,  0,  0},
			/*14*/{ 0,  0,  0,  0,  0, 15,  0,  0,  0,  0,  0,  0,  0, 14,  0, 21,  0,  0,  0,  0},
			/*15*/{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0, 16,  0,  0, 20},
			/*16*/{ 0,  0,  0,  0,  0,  0, 22,  0,  0,  0,  0,  0,  0,  0,  0, 16,  0, 17,  0,  0},
			/*17*/{ 0,  0,  0,  0,  0,  0,  0,  0, 23,  0,  0,  0,  0,  0,  0,  0, 17,  0, 18,  0},
			/*18*/{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 24,  0,  0,  0,  0,  0,  0, 18,  0, 19},
			/*19*/{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 25,  0,  0, 20,  0,  0, 19,  0}
	};
	
	static private int[][] stateVector = new int[20][20];
	static private int[] ar = new int[30];
	static private double[] s = new double[ar.length];
	static private int[] facts = new int[ar.length];
	static private int[] edgesList = new int[30];
	static private int currentNum = 0;
	static private int[][] bim = new int[30][30];
	static private double[][] bimP = new double[30][30];
	
	static public void buildDS(int[] terminals, int m) {
		for (int i = 0; i < ar.length; i++) {
			ar[i] = 0;
			s[i] = 0;
		}
		
		
		for (int i = 0; i < m; i++) {
			ar[getAnchor(terminals) - 1]++;
		}
		
		for (int i = 0; i < ar.length; i++) {
			s[i] = (double)ar[i] / m;
			if (i > 0)
				s[i] += s[i - 1];
		}
	}
	
	static public void buildCS(int[] terminals, int m) {
		for (int i = 0; i < ar.length; i++) {
			ar[i] = 0;
			s[i] = 0;
			edgesList[i] = 0;
		}
		
		for (int i = 0; i < bim.length; i++)
			for (int j = 0; j < bim[0].length; j++)
				bim[i][j] = 0;
		
		for (int i = 0; i < m; i++) {
			int anchor = getAnchorCS(terminals);
			ar[anchor - 1]++;
			
			for (int num = 0; num < anchor; num++) {
				bim[anchor - 1][edgesList[num] - 1]++;
				edgesList[num] = 0;
			}
			
			currentNum = 0;
		}
		
		for (int i = 0; i < bim[0].length; i++)
			for (int j = 1; j < bim.length; j++)
				bim[j][i] += bim[j - 1][i];
		
		for (int i = 0; i < bim.length; i++)
			for (int j = 0; j < bim[0].length; j++)
				bimP[i][j] = (double)bim[i][j] / m;
	}
	
	static public double[] getDS() {
		double[] ds = new double[s.length];
		for (int i = 0; i < s.length; i++)
			ds[i] = s[i];
		
		return ds;
	}
	
	static public double[] getColumnBIM(int num) {
		double[] col = new double[bimP.length];
		for (int i = 0; i < bimP.length; i++)
			col[i] = bimP[i][num - 1];
		
		return col;
	}
	
	static public void setDS(double[] ds) {
		for (int i = 0; i < s.length; i++)
			s[i] = ds[i];
	}
	
	static public void showCS() {
		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
		System.out.println(sum);
		
		for (int i = 0; i < bim.length; i++)
			System.out.print("\t" + (i + 1));
		System.out.println("\n");
		for (int i = 0; i < bim.length; i++) {
			System.out.print(i + 1 + ")\t");
			for (int j = 0; j < bim[0].length; j++)
				System.out.printf("%.3f\t", bimP[i][j]);
			System.out.println();
		}		
			
	}
	
	static public void calculateBIM() {
		
	}
	
	static private double getCoefficient(int n, int m) {//combo. form.
		double k = 1;
		int x = m > n - m ? m : n - m;
		int y = 1;
		
		for (int i = x + 1; i <= n; i++)
			k = k * i / y++;
		
		return k;
	}
	
	static private int getAnchorCS(int[] terminals) {

		for (int i = 0; i < stateVector.length; i++)
			for (int j = 0; j < stateVector.length; j++)
				stateVector[i][j] = 0;
		
		int anchor = 0;
	
		while (!checkTerminalsConnection(terminals)) {
			addRandomEdge(stateVector);
			anchor++;
		}
		
		return anchor;
	}
	
	static private int getAnchor(int[] terminals) {

		for (int i = 0; i < stateVector.length; i++)
			for (int j = 0; j < stateVector.length; j++)
				stateVector[i][j] = connections[i][j];
		
		int anchor = 0;
	
		while (checkTerminalsConnection(terminals)) {
			deleteRandomEdge(stateVector);
			anchor++;
		}
		
		return anchor;
	}
	
	static private void addRandomEdge(int[][] conn) {
		int row = (int)(Math.random() * 20);
		int col = (int)(Math.random() * 20);
		int counter = 0;
		
		while ((connections[row][col] == 0 || conn[row][col] == 1) && counter++ < 400) {
			col++;
			if (col == 20) {
				row++;
				if (row == 20)
					row = 0;
				col = 0;
			}
		}
		
		conn[row][col] = 1;
		conn[col][row] = 1;
		edgesList[currentNum++] = connectionNames[col][row];
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
		
		//System.out.println("true\n"); //true - network is UP (for tests)
		return true;
	}
	
}
