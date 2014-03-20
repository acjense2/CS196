public class solveCube {

	public static void main(String[] args) {

		Permutation perms = new Permutation();

		TextIO.putln(perms.toString(false));
		perms.rotate(1);
		TextIO.putln(perms.toString(true));

		boolean error = false;
		while (!error) {
			/*
			 * call algorithm methods from class Cube here, in order. set them
			 * equal to the variable error. have algorithm methods return true
			 * if there is an error (i.e. it can't find the color it is looking
			 * for)
			 */
			error = true;
		}

	}

}
