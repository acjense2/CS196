//class Cube
/*
 * acjense2
 * 
 * using Ryan Heise's beginner method
 * http://www.ryanheise.com/cube/beginner.html
 * 
 * for any algorithm references:
 * front = green
 * back = blue
 * right = red
 * left = orange
 * up = white
 * down = yellow
 */

class Cube {

	int FRONT = 0;
	int BACK = 1;
	int RIGHT = 2;
	int LEFT = 3;
	int UP = 4;
	int DOWN = 5;
	
	/*
	int GREEN = 1;
	int BLUE = 2;
	int RED = 3;
	int ORANGE = 4;
	int WHITE = 5;
	int YELLOW = 6;
	*/
	
	//get input from console for each row of face
	public static void setFace(int side, char face[][][]) {

		String str = "";

		for (int row = 0; row < 3; row++) {
			TextIO.putln("Enter row " + (row+1) + " of cube colors for face "
					+ side + "as G,B,R,O,W, or Y");
			str = TextIO.getln();
			for (int col = 0; col < 3; col++) {
				face[side][row][col] = str.toLowerCase().charAt(col);
			}
		}

	}
	
	//print the face to console
	public static void printFace( int side,char face[][][]) {
		
		String str = "";
		for ( int row = 0; row < 3; row++){
		for ( int col = 0; col < 3; col++){
			str += face[side][row][col] + " ";
		}
		TextIO.putln(str);
		str = "";
		}
		TextIO.putln();
		
	}
	
	
	
	public static void main(String[] args) {
		
		char faces[][][] = new char[6][3][3];
		
		setFace(2,faces);	
		printFace(2,faces);

	}
}
