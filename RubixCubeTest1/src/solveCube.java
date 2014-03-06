public class solveCube {
	
	public static void main(String[] args) {
	
		Cube Cube = new Cube();

		for (int i = 0; i < 6; i++) {
			Cube.setFace(i);
		}
		for (int i = 0; i < 6; i++) {
			Cube.printFace(i);
		}
		
		boolean error = false;
		while (!error){
			/*
			 * call algorithm methods from class Cube here, in order.
			 * set them equal to the variable error. have algorithm methods return true 
			 * if there is an error (i.e. it can't find the color it is looking for)
			 * */
		}
		
		
	}

public static char[][][] RightRotationCW(int orientation, char[][][] colorMatrix){
		
		char temp1, temp2, temp3;
		
		if (orientation == 0 || orientation == 1 || orientation == 4 || orientation == 5){
			temp1 = colorMatrix[4][1][3];
			temp2 = colorMatrix[4][2][3];
			temp3 = colorMatrix[4][3][3];
		
			colorMatrix[4][1][3] = colorMatrix[0][1][3];
			colorMatrix[4][2][3] = colorMatrix[0][2][3];
			colorMatrix[4][3][3] = colorMatrix[0][3][3];
			
			colorMatrix[0][1][3] = colorMatrix[5][1][3];
			colorMatrix[0][2][3] = colorMatrix[5][2][3];
			colorMatrix[0][3][3] = colorMatrix[5][3][3];
			
			colorMatrix[5][1][3] = colorMatrix[1][1][3];
			colorMatrix[5][2][3] = colorMatrix[1][2][3];
			colorMatrix[5][3][3] = colorMatrix[1][3][3];
			
			colorMatrix[1][1][3] = temp1;
			colorMatrix[1][2][3] = temp2;
			colorMatrix[1][3][3] = temp3;
			//Rotates right column of chosen face and changes value for each part of that column
			
			temp1 = colorMatrix[2][1][2];
			colorMatrix[2][1][2] = colorMatrix[2][2][1];
			colorMatrix[2][2][1] = colorMatrix[2][3][2];
			colorMatrix[2][3][2] = colorMatrix[2][2][3];
			colorMatrix[2][2][3] = temp1;
			
			temp2 = colorMatrix[2][1][1];
			colorMatrix[2][1][1] = colorMatrix[2][3][1];
			colorMatrix[2][3][1] = colorMatrix[2][3][3];
			colorMatrix[2][3][3] = colorMatrix[2][1][3];
			colorMatrix[2][1][3] = temp2;
			//Rotates face adjacent to right column
		}
		else if(orientation == 2 || orientation == 3){
			temp1 = colorMatrix[2][1][3];
			temp2 = colorMatrix[2][2][3];
			temp3 = colorMatrix[2][3][3];
		
			colorMatrix[2][1][3] = colorMatrix[1][1][3];
			colorMatrix[2][2][3] = colorMatrix[1][2][3];
			colorMatrix[2][3][3] = colorMatrix[1][3][3];
			
			colorMatrix[1][1][3] = colorMatrix[3][1][3];
			colorMatrix[1][2][3] = colorMatrix[3][2][3];
			colorMatrix[1][3][3] = colorMatrix[3][3][3];
			
			colorMatrix[3][1][3] = colorMatrix[0][1][3];
			colorMatrix[3][2][3] = colorMatrix[0][2][3];
			colorMatrix[3][3][3] = colorMatrix[0][3][3];
			
			colorMatrix[0][1][3] = temp1;
			colorMatrix[0][2][3] = temp2;
			colorMatrix[0][3][3] = temp3;
			//Rotates right column of chosen face and changes value for each part of that column
			
			temp1 = colorMatrix[4][1][2];
			colorMatrix[4][1][2] = colorMatrix[4][2][1];
			colorMatrix[4][2][1] = colorMatrix[4][3][2];
			colorMatrix[4][3][2] = colorMatrix[4][2][3];
			colorMatrix[4][2][3] = temp1;
			
			temp2 = colorMatrix[4][1][1];
			colorMatrix[4][1][1] = colorMatrix[4][3][1];
			colorMatrix[4][3][1] = colorMatrix[4][3][3];
			colorMatrix[4][3][3] = colorMatrix[4][1][3];
			colorMatrix[4][1][3] = temp2;
			//Rotates face adjacent to right column
		}
		return colorMatrix;//Returns new rubik's cube
	}
}
