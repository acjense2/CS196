public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		new Message("ready to go!");
		
		/* CROSS PIECES */
		TextIO.putln(Cube.toString(false));
		new Message("STEP 2: SCANNING FOR CROSS PIECES");
		ScanCrossPieces.run();
		TextIO.putln(Cube.toString(true));

	}

}
