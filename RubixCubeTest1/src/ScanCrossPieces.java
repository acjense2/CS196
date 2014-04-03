public class ScanCrossPieces extends Scanner {

	private static int[] pairs = { 4, 7, 13, 16, 22, 25, 31, 34 };

	// contains whether pairs are equal for each face g, r, b, o
	boolean[] flags = new boolean[4];

	// run the method
	public void run() {
		setFlags();
		alignBottom();
		if (isAdjacent()) {
			setOrientation(orientAdjacent());
			swapCrossPieces(1);
		} else {
			setOrientation(orientOpposite());
			swapCrossPieces(2);
		}
	}

	public void setFlags() {
		for (int i = 0, j = 0; i < pairs.length - 2; i += 2, j++) {
			flags[j] = equals(i, i + 1);
		}
	}

	// returns number of faces that have pairs
	public int sameFaces() {
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				count++;
		}
		return count;
	}

	public void alignBottom() {
		if (sameFaces() == 4)
			return; // faces are aligned
		while (sameFaces() < 2) {
			this.rotateCCW(YELLOW);
		}
	}

	// returns face that will set orientation
	public int orientAdjacent() {
		if (flags[0] && flags[3])
			return 3;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	public boolean isAdjacent() {
		for (int i = 0; i < flags.length - 1; i++) {
			if (flags[i] && flags[i + 1])
				return true;
		}
		return false;
	}

	public int orientOpposite() {
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}
}