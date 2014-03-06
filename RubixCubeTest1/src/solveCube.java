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

}
