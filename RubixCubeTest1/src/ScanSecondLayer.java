
public class ScanSecondLayer extends Scanner {
	
	private static int[] pairs = {1,4,10,13,19,22,28,31};
	
	private static int[] topEdges = {43,41,37,39};
	
	private static int[] centerPieces = {4,13,22,31};
			
	// contains whether pairs are equal for each face g, r, b, o
	private static boolean[] flags = new boolean[4];
	
	public static void run(){
		setFlags();
		if (sameFaces() == 4) {
			new Message("All faces aligned!");
			return;
		}
		alignTop();
		Cube.setOrientation(orient());
		if (isRight()){
			Algorithms.secondLayer(1);
		}
		else {
			Algorithms.secondLayer(2);			
		}
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
		while (sameFaces() < 1) {
			Algorithms.swapCrossPieces(3);
		}
		setFlags();
	}
	
	//orients front face to the face that has the pair
	private static int orient(){
		setFlags();
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	//ryanheise case1 is true, ryanheise case2 is false
	private static boolean isRight(){
		setFlags();
		return centerPieces[Cube.RIGHT]==topEdges[Cube.FRONT];
	}
}
