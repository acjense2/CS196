public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		new Message("ready to go!");

		/*
		 * crosspieces//TEST1// char[] testCube = new char[] { 'Y', 'R', 'B',
		 * 'R', 'G', 'B', 'W', 'G', 'W', 'Y', 'W', 'G', 'O', 'R', 'W', 'R', 'R',
		 * 'O', 'O', 'W', 'B', 'O', 'B', 'B', 'W', 'B', 'B', 'R', 'O', 'G', 'R',
		 * 'O', 'G', 'W', 'O', 'R', 'Y', 'G', 'Y', 'G', 'W', 'B', 'R', 'W', 'O',
		 * 'B', 'Y', 'G', 'Y', 'Y', 'Y', 'O', 'Y', 'G'};
		 */

		// bottomcorners//TEST1//String stringCube =
		// "YOWOGGGGGOWYRROWRYBRRBBBGBWBWBWOWOOOWBRGWROGGYYRYYYBYR";
		// secondlayer//TEST1//String stringCube =
		// "BBRGGBGGGWGWRRWRRRROGRBWBBBWWWBOOOOOOWBGWROOGYYYYYYYYY";
		// secondlayer//TEST2//String stringCube =
		// "RBRGGGGGGWWGRRRRRRWGWBBOBBBBOWBOOOOOOWOWWRBWGYYYYYYYYY";
		String stringCube = "RBRGGGGGGWWGRRRRRRWGWBBOBBBBOWBOOOOOOWOWWRBWGYYYYYYYYY";
		char[] testCube = stringCube.toCharArray();
		Cube.setTo(testCube);
		TextIO.putln(Cube.toString(true));

		/*
		 * new Message("STEP 2: SCANNING FOR CROSS PIECES");
		 * ScanCrossPieces.run(); new Message("STEP 2: done");
		 * TextIO.putln(Cube.toString(true));
		 * 
		 * new Message("STEP 3: SCANNING FOR BOTTOM CORNERS");
		 * ScanBottomCorners.run(); new Message("STEP 3: done");
		 * TextIO.putln(Cube.toString(true));
		 */

		new Message("STEP 4: SCANNING FOR SECOND LAYER");
		ScanSecondLayer.run();
		new Message("STEP 4; done");
		TextIO.putln(Cube.toString(true));
		
	}

}
