public class ScanBottomCorners extends Scanner {
	// contains any possible [positions of the yellow corners
	private static int[] index = { 0, 2, 9, 11, 18, 20, 27, 29, 36, 38, 42, 44,
			6, 8, 15, 17, 24, 26, 33, 35, 45, 47, 51, 53 };

	// contains flags checking whether corners are correct gr, rb, bo, og
	private static boolean[] yellowCorners = new boolean[4];

	public static void run() {
		setFlags();
		if (correctCorners()) {
			new Message("All corners aligned!");
			return;
		}
		checkBottomCorners();
		setFlags();
		placeCorner();
	}

	public static void setFlags() {
		// sets corner flag to true if that corner is correct
		if (Cube.getColor(45) == 'Y' && Cube.getColor(6) == 'G'
				&& Cube.getColor(35) == 'O')
			yellowCorners[3] = true;
		else
			yellowCorners[3] = false;

		if (Cube.getColor(47) == 'Y' && Cube.getColor(8) == 'G'
				&& Cube.getColor(15) == 'R')
			yellowCorners[0] = true;
		else
			yellowCorners[0] = false;

		if (Cube.getColor(53) == 'Y' && Cube.getColor(17) == 'R'
				&& Cube.getColor(24) == 'B')
			yellowCorners[1] = true;
		else
			yellowCorners[1] = false;

		if (Cube.getColor(51) == 'Y' && Cube.getColor(26) == 'B'
				&& Cube.getColor(33) == 'O')
			yellowCorners[1] = true;
		else
			yellowCorners[1] = false;

	}

	public static boolean correctCorners() {
		int count = 0;
		for (int i = 0; i < yellowCorners.length; i++)
			if (yellowCorners[i])
				count++;
		return (count == 4);
	}

	public static void checkBottomCorners() {
		// checks if any yellow pieces are located in bottom corners

		for (int i = 12; i < index.length; i++) {
			boolean rotate = false;
			if (Cube.getColor(index[i]) == 'Y') {
				if (index[i] == 35 || index[i] == 6) {
					Cube.setOrientation(3);
					rotate = true;
				} else if (index[i] == 8 || index[i] == 15) {
					Cube.setOrientation(0);
					rotate = true;
				} else if (index[i] == 17 || index[i] == 24) {
					Cube.setOrientation(1);
					rotate = true;
				} else if (index[i] == 26 || index[i] == 33) {
					Cube.setOrientation(2);
					rotate = true;
				} else if (index[i] == 45
						&& (Cube.getColor(6) != 'G' || Cube.getColor(35) != 'O')) {
					Cube.setOrientation(3);
					rotate = true;
				} else if (index[i] == 47
						&& (Cube.getColor(8) != 'G' || Cube.getColor(15) != 'R')) {
					Cube.setOrientation(0);
					rotate = true;
				} else if (index[i] == 51
						&& (Cube.getColor(26) != 'B' || Cube.getColor(33) != 'O')) {
					Cube.setOrientation(1);
					rotate = true;
				} else if (index[i] == 53
						&& (Cube.getColor(17) != 'R' || Cube.getColor(24) != 'B')) {
					Cube.setOrientation(2);
					rotate = true;
				}

				// if rotate == false, no yellows found
				if (rotate == true) {
					Algorithms.insertBottomCorners(1);
					i = 12; // look thru again because a yellow might have moved
							// into our spot we just found!
				}
			}

		}
	}

	public static boolean checkColumn(int i) {
		if (index[i] == 0 || index[i] == 29 || index[i] == 42) {
			if (Cube.getColor(0) == 'Y' || Cube.getColor(29) == 'Y'
					|| Cube.getColor(42) == 'Y') {
				if (Cube.getColor(0) == 'G' || Cube.getColor(29) == 'G'
						|| Cube.getColor(42) == 'G') {
					if (Cube.getColor(0) == 'O' || Cube.getColor(29) == 'O'
							|| Cube.getColor(42) == 'O') {
						return true;
					}
				}
			}
		} else if (index[i] == 2 || index[i] == 9 || index[i] == 44) {
			if (Cube.getColor(2) == 'Y' || Cube.getColor(9) == 'Y'
					|| Cube.getColor(44) == 'Y') {
				if (Cube.getColor(2) == 'G' || Cube.getColor(9) == 'G'
						|| Cube.getColor(44) == 'G') {
					if (Cube.getColor(2) == 'R' || Cube.getColor(9) == 'R'
							|| Cube.getColor(44) == 'R') {
						return true;
					}
				}
			}
		} else if (index[i] == 11 || index[i] == 18 || index[i] == 38) {
			if (Cube.getColor(11) == 'Y' || Cube.getColor(18) == 'Y'
					|| Cube.getColor(38) == 'Y') {
				if (Cube.getColor(11) == 'B' || Cube.getColor(18) == 'B'
						|| Cube.getColor(38) == 'B') {
					if (Cube.getColor(11) == 'R' || Cube.getColor(18) == 'R'
							|| Cube.getColor(38) == 'R') {
						return true;
					}
				}
			}
		} else if (index[i] == 20 || index[i] == 27 || index[i] == 36) {
			if (Cube.getColor(20) == 'Y' || Cube.getColor(27) == 'Y'
					|| Cube.getColor(36) == 'Y') {
				if (Cube.getColor(20) == 'B' || Cube.getColor(27) == 'B'
						|| Cube.getColor(36) == 'B') {
					if (Cube.getColor(20) == 'O' || Cube.getColor(27) == 'O'
							|| Cube.getColor(36) == 'O') {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void placeCorner() {
		for (int i = 0; i < 12; i++) {
			if (Cube.getColor(index[i]) == 'Y') {
				setFlags();
				if (correctCorners()) {
					new Message("All corners aligned!");
					return;
				}

				if (index[i] == 0 || index[i] == 29 || index[i] == 42) {
					Cube.setOrientation(3);
				} else if (index[i] == 2 || index[i] == 9 || index[i] == 44) {
					Cube.setOrientation(0);
				} else if (index[i] == 11 || index[i] == 18 || index[i] == 38) {
					Cube.setOrientation(1);
				} else if (index[i] == 20 || index[i] == 27 || index[i] == 36) {
					Cube.setOrientation(2);
				} else
					return;

				while (!checkColumn(i)) {
					Algorithms.insertBottomCorners(2);
				}

				if (index[i] == 29 || index[i] == 2 || index[i] == 11
						|| index[i] == 20) {
					Algorithms.insertBottomCorners(3);
					i = 0;
				} else if (index[i] == 0 || index[i] == 9 || index[i] == 18
						|| index[i] == 27) {
					Algorithms.insertBottomCorners(4);
					i = 0;
				} else if (index[i] == 36 || index[i] == 38 || index[i] == 42
						|| index[i] == 44) {
					Algorithms.insertBottomCorners(5);
					i = 0;
				}
			}
		}
	}
}