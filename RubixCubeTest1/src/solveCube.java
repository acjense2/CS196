public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		new Message("ready to go!");

		String stringCube = "GRGGGGGGGRGRRRRRRRBOBBBBBBBOBOOOOOOOWWWWWWWWWYYYYYYYYY";
		Cube.setTo(stringCube.toCharArray());
		TextIO.putln(Cube.toString(true));

		/**
		 * new Message("STEP 2: SCANNING FOR CROSS PIECES");
		 * ScanCrossPieces.run(); new Message("STEP 2: done");
		 * TextIO.putln(Cube.toString(true));
		 * 
		 * new Message("STEP 3: SCANNING FOR BOTTOM CORNERS");
		 * ScanBottomCorners.run(); new Message("STEP 3: done");
		 * TextIO.putln(Cube.toString(true));
		 * 
		 * new Message("STEP 4: SCANNING FOR SECOND LAYER");
		 * ScanSecondLayer.run(); new Message("STEP 4: done");
		 * 
		 * new Message("STEP 5: SCANNING FOR TOP CROSSPIECES");
		 * ScanTopCross.run(); new Message("STEP 5: DONE");
		 * 
		 * new Message("STEP 6: SCANNING FOR TOP CORNERS");
		 * ScanTopCornersUp.run(); new Message("STEP 6: DONE");
		 */
		
		//STEP 7
		
		new Message("STEP 8: SCANNING FOR TOP EDGES");
		ScanTopEdges.run();
		new Message("STEP 8: DONE");
		
		TextIO.putln(Cube.toString(true));
		if (Cube.equals(stringCube))
			new Message("CUBE SOLVED!");
	}

}
