public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		new Message("ready to go!");

		/* CROSS PIECES */
		char[] testCube = new char[] { 
				'Y', 'R', 'B', 'R', 'G', 'B', 'W', 'G', 'W',
				'Y', 'W', 'G', 'O', 'R', 'W', 'R', 'R', 'O',
				'O', 'W', 'B', 'O', 'B', 'B', 'W', 'B', 'B',
				'R', 'O', 'G', 'R', 'O', 'G', 'W', 'O', 'R',
				'Y', 'G', 'Y', 'G', 'W', 'B', 'R', 'W', 'O',
				'B', 'Y', 'G', 'Y', 'Y', 'Y', 'O', 'Y', 'G'};
		Cube.setTo(testCube);
		TextIO.putln(Cube.toString(true));
		
		/*
		new Message("STEP 2: SCANNING FOR CROSS PIECES");
		ScanCrossPieces.run();
		 */
		
		new Message("STEP 3254: SCANNING FOR CROSS PIECES");
		ScanBottomCorners.run();
		new Message("STEP 3254: done");
		TextIO.putln(Cube.toString(true));
	}

}
