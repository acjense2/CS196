public class ScanSecondLayer extends Scanner {

	private static int[] pairs = { 1, 4, 10, 13, 19, 22, 28, 31 };

	private static int[] topEdges = { 43, 41, 37, 39 };

	private static int[] centerPieces = { 4, 13, 22, 31 };
	
	private static int[][] secondLayer = {{3,5},{12,14},{21,23},{30,32}};
	
	private static int[][] forceOut = {{5,12},{14,12},{23,30},{32,3}};



	// contains whether pairs are equal for each face g, r, b, o
	private static boolean[] flags = new boolean[4];

	public static void run(){
		if (sameFacesSecondLayer()) {
			new Message("All faces aligned!");
			return;
		}
		
		int runCount = 0;
		do {
			setFlags();
		alignTop();
		Cube.setOrientation(orient());
		runCount++;
		if (runCount==4)//there are 4 white pieces!
			TextIO.putln(runCount);
		} while (isWhite(topEdges[Cube.FRONT])); //if the corresponding top edge cube is white, try again
		
		if (isRight())
			Algorithms.secondLayer(1);
		else
			Algorithms.secondLayer(2);
		
		run();
		
	}

	private static void setFlags() {
		for (int i = 0, j = 0; i < pairs.length - 1; i += 2, j++) {
			flags[j] = equals(pairs[i], pairs[i + 1]);
		}
	}

	private static int sameFaces() {
		setFlags();
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				count++;
		}
		return count;
	}

	private static void alignTop() {
		do  {
			Algorithms.secondLayer(4);
		} while (sameFaces() < 1);
		setFlags();
	}

	// orients front face to the face that has the pair
	private static int orient() {
		setFlags();
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	// ryanheise case1 is true, ryanheise case2 is false
	private static boolean isRight() {
		setFlags();
		return Cube.getColor(centerPieces[Cube.RIGHT]) == Cube.getColor(topEdges[Cube.FRONT]);
	}
	
	private static boolean isWhite(int i) {
		setFlags();
		return Cube.getColor(i)=='W';
	}
	
	private static boolean sameFacesSecondLayer(){
		setFlags();
		for (int i = 0; i<secondLayer.length; i++){
			if (Cube.getColor(secondLayer[i][0])!=Cube.getColor(secondLayer[i][1]))
			return false;
	}
		return true;
	}
	
	private static int forceOut(){
		setFlags();
		for (int i = 0; i<forceOut.length; i++){
			if (Cube.getColor(forceOut[i][0])== centerPieces[(i+1)%4]      &&
					Cube.getColor(forceOut[i][1])==       )
			return false;
	}
		return true;
	}
}
