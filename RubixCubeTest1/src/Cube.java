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

	enum Color {
		G, B, R, O, W, Y
	}

	//get input from console for each row of face
	public static void setFace(Color face[][]) {

		String str = "";

		for (int j = 0; j < 3; j++) {
			TextIO.putln("Enter row " + (j+1) + " of cube colors for face "
					+ "FACEHERE " + "as G,B,R,O,W, or Y");
			str = TextIO.getln();
			for (int k = 0; k < 3; k++) {
				face[j][k] = Color.valueOf(str.substring(k, k+1));
				//OPTIONAL
				//TextIO.putln("Color at green face at " + j + "," + k
				//		+ "is now: " + face[j][k].toString());
			}
		}

	}
	
	//print the face to console
	public static void printFace(Color face[][]) {
		
		String str = "";
		for ( int j = 0; j < 3; j++){
		for ( int k = 0; k < 3; k++){
			str += face[j][k].toString() + " ";
		}
		TextIO.putln(str);
		str = "";
		}
		TextIO.putln();
		
	}
	
	
	
	public static void main(String[] args) {
		
		Color greenFace[][] = new Color[3][3];
		Color blueFace[][] = new Color[3][3];
		//Color redFace[][] = new Color[3][3];
		//Color orangeFace[][] = new Color[3][3];
		//Color whiteFace[][] = new Color[3][3];
		//Color yellowFace[][] = new Color[3][3];
		
		setFace(greenFace);
		setFace(blueFace);
		//setFace(redFace);
		//setFace(orangeFace);
		//setFace(whiteFace);
		//setFace(yellowFace);
		
		printFace(greenFace);
		printFace(blueFace);

	}
}
