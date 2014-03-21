/**
 * Algorithms class
 * contains algorithms: sets of permutations
 * DONT FORGET TO SET CUBE ORIENTATION BEFORE DOING ALGS
 */
public class Algorithms extends Permutation {

	// an algorithm - see ryanheise.com/cube/beginner.html ->
	// "Swap the incorrect cross pieces"
	public void swapCrossPieces(int caseNum) {
		if (caseNum < 1 || caseNum > 2)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1:
			rotate180(RIGHT);
			rotateCW(UP);
			rotate180(FRONT);
			rotateCCW(UP);
			rotate180(RIGHT);
			break;
		case 2:
			rotate180(RIGHT);
			rotate180(UP);
			rotate180(FRONT);
			rotate180(UP);
			rotate180(RIGHT);
		}
	}

	//more algorithms will be written out here...
}
