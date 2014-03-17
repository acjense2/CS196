//class Cube
/*
 * using Ryan Heise's beginner method
 * http://www.ryanheise.com/cube/beginner.html
 * 
 * front = green
 * back = blue
 * right = red
 * left = orange
 * up = white
 * down = yellow
 */

class Cube {

	static int FRONT = 0; // green
	static int BACK = 1; // blue
	static int RIGHT = 2; // red
	static int LEFT = 3; // orange
	static int UP = 4; // white
	static int DOWN = 5; // yellow

	// 6 faces, 3 rows, 3 columns
	private char faces[][][] = new char[6][3][3];

	// public static char completeCube[][][] = new char[6][3][3];

	// Cube constructor
	// initializes faces to a scrambled or completed cube
	Cube(boolean scrambled) {
		if (scrambled)
			faces = Cube.scrambledCube();
		else
			faces = Cube.completeCube();
	}

	// gets input from console for each row of face
	public void setFace(int side) {
		String str = "";
		for (int row = 0; row < 3; row++) {
			TextIO.putln("Enter row " + (row + 1) + " of cube colors for face "
					+ (side + 1) + " as G,B,R,O,W, or Y\nSuch as \"GBR\"");
			str = TextIO.getln();
			for (int col = 0; col < 3; col++) {
				faces[side][row][col] = str.toLowerCase().charAt(col);
			}
		}
	}

	//gets input from console for all faces
	public void setAllFaces() {
		for (int i = 0; i < 6; i++) {
			setFace(i);
		}
	}

	// points faces[][][] to a new cube array
	public void setAllFaces(char[][][] array) {
		faces = array;
	}

	// returns pointer to array of completed cube
	public static char[][][] completeCube() {
		char[][][] cube = new char[6][3][3];
		String str = "GGGGGGGGGBBBBBBBBBRRRRRRRRROOOOOOOOOWWWWWWWWWYYYYYYYYY";
		// String str =
		// "rrbggyggybbwbbwgggwoorrbrrbrryoooooowwwwwwggryybyybyyo";
		int nextChar = 0;
		for (int face = 0; face < 6; face++) {
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					cube[face][row][col] = str.toUpperCase().charAt(nextChar++);
				}
			}
		}
		return cube;
	}

	// returns pointer to array of scrambled cube
	public static char[][][] scrambledCube() {
		char[][][] cube = new char[6][3][3];
		for (int face = 0; face < 6; face++) {
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					cube[face][row][col] = randomColor();
				}
			}
		}
		return cube;
	}

	//returns a random color as a character
	public static char randomColor() {
		int randInt = (int) (Math.random() * 6);
		char randChar;
		switch (randInt) {
		case 1:
			randChar = 'G';
			break;
		case 2:
			randChar = 'B';
			break;
		case 3:
			randChar = 'R';
			break;
		case 4:
			randChar = 'O';
			break;
		case 5:
			randChar = 'W';
			break;
		case 6:
			randChar = 'Y';
			break;
		default:
			randChar = 'G';
			break;
		}
		return randChar;
	}

	// prints the face to console
	public void printFace(int side) {
		String str = "";
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				str += faces[side][row][col] + " ";
			}
			TextIO.putln(str);
			str = "";
		}
		TextIO.putln();
	}

	//prints all faces to console
	public void printAllFaces() {
		for (int i = 0; i < 6; i++) {
			printFace(i);
		}
	}

	//returns the color at specified position
	public char colorAt(int side, int row, int col) {
		return faces[side][row][col];
	}

	//algorithm one
	public boolean algOne() {
		// search cube for wanted colors
		// when colors are found, employ combinations of basic
		// movement methods on the array faces. (still need to be written)
		return true; // should return false if method is completed successfully,
						// true if error
	}

	//turns the face to the right of the current orientation clockwise
	//orientation is the face that is facing you currently
	public char[][][] RightRotationCW(int orientation) {

		char temp1, temp2, temp3;

		if (orientation == FRONT || orientation == BACK || orientation == UP
				|| orientation == DOWN) {
			temp1 = faces[4][1 - 1][3 - 1];
			temp2 = faces[4][2 - 1][3 - 1];
			temp3 = faces[4][3 - 1][3 - 1];

			faces[4][1 - 1][3 - 1] = faces[0][1 - 1][3 - 1];
			faces[4][2 - 1][3 - 1] = faces[0][2 - 1][3 - 1];
			faces[4][3 - 1][3 - 1] = faces[0][3 - 1][3 - 1];

			faces[0][1 - 1][3 - 1] = faces[5][1 - 1][3 - 1];
			faces[0][2 - 1][3 - 1] = faces[5][2 - 1][3 - 1];
			faces[0][3 - 1][3 - 1] = faces[5][3 - 1][3 - 1];

			faces[5][1 - 1][3 - 1] = faces[1][1 - 1][3 - 1];
			faces[5][2 - 1][3 - 1] = faces[1][2 - 1][3 - 1];
			faces[5][3 - 1][3 - 1] = faces[1][3 - 1][3 - 1];

			faces[1][1 - 1][3 - 1] = temp1;
			faces[1][2 - 1][3 - 1] = temp2;
			faces[1][3 - 1][3 - 1] = temp3;
			// Rotates right column of chosen face and changes value for each
			// part of that column

			temp1 = faces[2][1 - 1][2 - 1];
			faces[2][1 - 1][2 - 1] = faces[2][2 - 1][1 - 1];
			faces[2][2 - 1][1 - 1] = faces[2][3 - 1][2 - 1];
			faces[2][3 - 1][2 - 1] = faces[2][2 - 1][3 - 1];
			faces[2][2 - 1][3 - 1] = temp1;

			temp2 = faces[2][1 - 1][1 - 1];
			faces[2][1 - 1][1 - 1] = faces[2][3 - 1][1 - 1];
			faces[2][3 - 1][1 - 1] = faces[2][3 - 1][3 - 1];
			faces[2][3 - 1][3 - 1] = faces[2][1 - 1][3 - 1];
			faces[2][1 - 1][3 - 1] = temp2;
			// Rotates face adjacent to right column
		} else if (orientation == RIGHT || orientation == LEFT) {
			temp1 = faces[2][1 - 1][3 - 1];
			temp2 = faces[2][2 - 1][3 - 1];
			temp3 = faces[2][3 - 1][3 - 1];

			faces[2][1 - 1][3 - 1] = faces[1][1 - 1][3 - 1];
			faces[2][2 - 1][3 - 1] = faces[1][2 - 1][3 - 1];
			faces[2][3 - 1][3 - 1] = faces[1][3 - 1][3 - 1];

			faces[1][1 - 1][3 - 1] = faces[3][1 - 1][3 - 1];
			faces[1][2 - 1][3 - 1] = faces[3][2 - 1][3 - 1];
			faces[1][3 - 1][3 - 1] = faces[3][3 - 1][3 - 1];

			faces[3][1 - 1][3 - 1] = faces[0][1 - 1][3 - 1];
			faces[3][2 - 1][3 - 1] = faces[0][2 - 1][3 - 1];
			faces[3][3 - 1][3 - 1] = faces[0][3 - 1][3 - 1];

			faces[0][1 - 1][3 - 1] = temp1;
			faces[0][2 - 1][3 - 1] = temp2;
			faces[0][3 - 1][3 - 1] = temp3;
			// Rotates right column of chosen face and changes value for each
			// part of that column

			temp1 = faces[4][1 - 1][2 - 1];
			faces[4][1 - 1][2 - 1] = faces[4][2 - 1][1 - 1];
			faces[4][2 - 1][1 - 1] = faces[4][3 - 1][2 - 1];
			faces[4][3 - 1][2 - 1] = faces[4][2 - 1][3 - 1];
			faces[4][2 - 1][3 - 1] = temp1;

			temp2 = faces[4][1 - 1][1 - 1];
			faces[4][1 - 1][1 - 1] = faces[4][3 - 1][1 - 1];
			faces[4][3 - 1][1 - 1] = faces[4][3 - 1][3 - 1];
			faces[4][3 - 1][3 - 1] = faces[4][1 - 1][3 - 1];
			faces[4][1 - 1][3 - 1] = temp2;
			// Rotates face adjacent to right column
		}
		return faces;// Returns new rubik's cube
	}
}
