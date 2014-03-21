public class solveCube extends Cube {

	/**
	 * employ whatever algorithms (and perms if you want) here. Need scanner
	 * class to know what algorithms to use here!!! Ideas Jordan? Use the
	 * ryanheise.com/cube/beginner.html website for ideas on scanner
	 * **/
	public static void main(String[] args) {

		Algorithms cube = new Algorithms();

		TextIO.putln(cube.toString(false));
		cube.rotateCW(1);
		cube.rotateCW(4);
		cube.rotateCCW(1);
		TextIO.putln(cube.toString(true));

		cube.reset();

		TextIO.putln(cube.toString(false));
		cube.setOrientation(RED);
		cube.swapCrossPieces(1);
		TextIO.putln(cube.toString(true));
		cube.swapCrossPieces(1);
		TextIO.putln(cube.toString(true));

	}

}
