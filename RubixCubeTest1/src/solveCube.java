public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		new Message("ready to go!");

		/* CROSS PIECES */
		char[] testCube = new char[] { 
				'W', 'W', 'W', 'W', 'G', 'W', 'W', 'G', 'W',
				'W', 'W', 'W', 'W', 'R', 'W', 'W', 'R', 'W',
				'W', 'W', 'W', 'W', 'B', 'W', 'W', 'B', 'W',
				'W', 'W', 'W', 'W', 'O', 'W', 'W', 'O', 'W',
				'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W',
				'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'};
		Cube.setTo(testCube);
		//TextIO.putln(Cube.toString(false));
		new Message("STEP 2: SCANNING FOR CROSS PIECES");
		ScanCrossPieces.run();
		TextIO.putln(Cube.toString(true));

	}

}
