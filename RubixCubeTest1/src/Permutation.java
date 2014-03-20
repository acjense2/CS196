/*
 * { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
	16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
	33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
	50, 51, 52, 53 }
 */

public class Permutation {

	public char[] cube = { 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'R',
			'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'B', 'B', 'B', 'B', 'B',
			'B', 'B', 'B', 'B', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
			'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'Y', 'Y', 'Y', 'Y',
			'Y', 'Y', 'Y', 'Y', 'Y' };
	public int size = cube.length;

	public final int[][] perm = {
			// 0. green
			{ 6, 3, 0, 7, 4, 1, 8, 5, 2, 42, 10, 11, 43, 13, 14, 44, 16, 17,
					18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 45, 30, 31, 46,
					33, 34, 47, 36, 37, 38, 39, 40, 41, 35, 32, 29, 15, 12, 9,
					48, 49, 50, 51, 52, 53 },
			// 1. red
			{ 0, 1, 47, 3, 4, 50, 6, 7, 53, 15, 12, 9, 16, 13, 10, 17, 14, 11,
					44, 19, 20, 41, 22, 23, 38, 25, 26, 27, 28, 29, 30, 31, 32,
					33, 34, 35, 36, 37, 2, 39, 40, 5, 42, 43, 8, 45, 46, 24,
					48, 49, 21, 51, 52, 18 } };
	public int numFaces = perm.length;

	public Permutation() {
		String failMsg = "";
		for (int i = 0; i < numFaces; i++) {
			int fail = checkPerms();
			if (fail != -1)
				failMsg += fail + ", ";
		}
		if (failMsg.length() > 0)
		TextIO.putln("perm duplicate at: " + failMsg);
	}

	public void rotate(int face) {
		char[] newCube = new char[size];
		for (int i = 0; i < size; i++) {
			// value in cube goes new address stated in perm
			newCube[perm[face][i]] = cube[i];
		}
		cube = newCube;
	}

	public String toString(boolean cubeFormat) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < size; i++) {
			buff.append(cube[i]);
			if (cubeFormat) {
				buff.append(" ");
				if ((i + 1) % 3 == 0)
					buff.append("\n");
			} else {
				buff.append(", ");
			}
			if ((i + 1) % 9 == 0)
				buff.append("\n");
		}
		return buff.toString();
	}

	// finds duplicate permutation values
	// @return -1 if no duplicates, else index of first duplicate
	public int checkPerms() {
		for (int i = 0; i < numFaces; i++) {
			for (int j = 0; j < size; j++) {
				int compare = perm[i][j];
				for (int k = 0; k < size; k++) {
					if (j != k) {
						if (compare == perm[i][k])
							return k;
					}
				}
			}
		}
		return -1;
	}
}
