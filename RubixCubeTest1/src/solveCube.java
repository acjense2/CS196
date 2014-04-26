public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		new Message("Solving this cube:");

		String stringCube = "YWYOGOGGBOGRGRBYRWBWWRBGRBGBBOWOWOOYOBWOWRGRBRYRYYYWYG";
		Cube.setTo(stringCube.toCharArray());
		TextIO.putln(Cube.toString(true));
		
		ErrorCheck.errorCheck();

		new Message("STEP 2: SCANNING FOR CROSS PIECES");
		ScanCrossPieces.run();
		new Message("STEP 2: done");

		new Message("STEP 3: SCANNING FOR BOTTOM CORNERS");
		ScanBottomCorners.run();
		new Message("STEP 3: done");

		new Message("STEP 4: SCANNING FOR SECOND LAYER");
		ScanSecondLayer.run();
		new Message("STEP 4: done");

		new Message("STEP 5: SCANNING FOR TOP CROSSPIECES");
		ScanTopCross.run();
		new Message("STEP 5: DONE");

		new Message("STEP 6: SCANNING FOR TOP CORNERS");
		ScanTopCornersUp.run();
		new Message("STEP 6: DONE");

		new Message("STEP 7: SCANNING SIDES OF TOP CORNERS");
		ScanTopCornerSides.run();
		new Message("STEP 7: DONE");

		new Message("STEP 8: SCANNING FOR TOP EDGES");
		ScanTopEdges.run();
		new Message("STEP 8: DONE");

		TextIO.putln(Cube.toString(true));
		if (Cube.equals(stringCube))
			new Message("CUBE SOLVED!");
		else
			new Message("Failed");
	}

}
