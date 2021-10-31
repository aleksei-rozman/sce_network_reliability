
public class Tools {
	
	/*
	 *    01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20
	 * 01  0  1  0  0  1  0  0  1  0  0  0  0  0  0  0  0  0  0  0  0
	 * 02  1  0  1  0  0  0  0  0  0  1  0  0  0  0  0  0  0  0  0  0
	 * 03  0  1  0  1  0  0  0  0  0  0  0  1  0  0  0  0  0  0  0  0
	 * 04  0  0  1  0  1  0  0  0  0  0  0  0  0  1  0  0  0  0  0  0
	 * 05  1  0  0  1  0  1  0  0  0  0  0  0  0  0  0  0  0  0  0  0
	 * 06  0  0  0  0  1  0  1  0  0  0  0  0  0  0  1  0  0  0  0  0
	 * 07  0  0  0  0  0  1  0  1  0  0  0  0  0  0  0  0  1  0  0  0
	 * 08  1  0  0  0  0  0  1  0  1  0  0  0  0  0  0  0  0  0  0  0
	 * 09  0  0  0  0  0  0  0  1  0  1  0  0  0  0  0  0  0  1  0  0
	 * 10  0  1  0  0  0  0  0  0  1  0  1  0  0  0  0  0  0  0  0  0
	 * 11  0  0  0  0  0  0  0  0  0  1  0  1  0  0  0  0  0  0  1  0
	 * 12  0  0  1  0  0  0  0  0  0  0  1  0  1  0  0  0  0  0  0  0
	 * 13  0  0  0  0  0  0  0  0  0  0  0  1  0  1  0  0  0  0  0  1
	 * 14  0  0  0  1  0  0  0  0  0  0  0  0  1  0  1  0  0  0  0  0
	 * 15  0  0  0  0  0  1  0  0  0  0  0  0  0  1  0  1  0  0  0  0
	 * 16  0  0  0  0  0  0  0  0  0  0  0  0  0  0  1  0  1  0  0  1
	 * 17  0  0  0  0  0  0  1  0  0  0  0  0  0  0  0  1  0  1  0  0
	 * 18  0  0  0  0  0  0  0  0  1  0  0  0  0  0  0  0  1  0  1  0
	 * 19  0  0  0  0  0  0  0  0  0  0  1  0  0  0  0  0  0  1  0  1
	 * 20  0  0  0  0  0  0  0  0  0  0  0  0  1  0  0  1  0  0  1  0
	 */
	
	//static private double[] p = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.95, 0.99};
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
	static private int[][] stateVector = new int[connections.length][connections[0].length];

	static public double calculateNetworkReliability(int[] terminals, int m, double p) {
		
		double r = 0;
		
		for (int i = 0; i < m; i++) {
			calculateNetworkStateVector(p);
			if (checkTerminalsConnection(terminals))
				r++;
		}

		//System.out.println(r); //print count of "UP" results (for tests)
	
		return r / m;
	}
	
	static private void calculateNetworkStateVector(double p) {
		
		if (connections == null || connections.length <= 0 || connections[0].length != connections.length ) {
			System.out.println("Incorrect connections array");
			return;
		}
		
		int length = connections.length;
		//int[][] stateVector = new int[length][length];
		
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if (connections[i][j] == 1) 
					stateVector[i][j] = Math.random() <= p ? 1 : 0;
				else 
					stateVector[i][j] = 0;	
			}
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				stateVector[i][j] = stateVector[j][i];
			}
		}
			
		//print transition matrix (for tests)
		/*
		int r = 0;
		for (int i = 0; i < length; i++) {
			System.out.print((i < 10 ? "0" + i : i) + "|  ");
			for (int j = 0; j < length; j++) {
				if (stateVector[i][j] == 1 && i < j)
					r++;
				System.out.print(stateVector[i][j] + "  ");
			}
			System.out.println();
		}
		*/
		//System.out.println(r); //print count of "UP" results (for tests)
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
