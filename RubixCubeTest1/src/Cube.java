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

	//not used as of now
	int FRONT = 0;
	int BACK = 1;
	int RIGHT = 2;
	int LEFT = 3;
	int UP = 4;
	int DOWN = 5;

	//6 faces, 3 rows, 3 columns
	static char faces[][][] = new char[6][3][3];

	// gets input from console for each row of face
	public void setFace(int side) {

		String str = "";
		for (int row = 0; row < 3; row++) {
			TextIO.putln("Enter row " + (row + 1) + " of cube colors for face "
					+ (side+1) + " as G,B,R,O,W, or Y\nSuch as \"GBR\"");
			str = TextIO.getln();
			for (int col = 0; col < 3; col++) {
				faces[side][row][col] = str.toLowerCase().charAt(col);
			}
		}
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

	public char colorAt(int side, int row, int col) {
		return faces[side][row][col];
	}
	
	public boolean algOne(){
		//search cube for wanted colors
		//when colors are found, employ combinations of basic
		//movement methods on the array faces. (still need to be written)
		return true; //should return false if method is completed successfully, true if error
	}

}
