/**
 * Cube superclass
 * defines variables for faces, orientations
 * defines basic methods done on cube array
 */

public class Cube {

	// cube array holds first letter of colors
	protected char[] cube = new char[54];
	protected int size = cube.length;
	
	// orientation (used to employ algorithms relative to current orientation)
	protected int orientation = 0;

	protected final static int GREEN = 0;
	protected final static int RED = 1;
	protected final static int BLUE = 2;
	protected final static int ORANGE = 3;
	protected final static int WHITE = 4;
	protected final static int YELLOW = 5;

	protected int FRONT = 0;
	protected int RIGHT = 1;
	protected int BACK = 2;
	protected int LEFT = 3;
	protected int UP = 4;
	protected int DOWN = 5;

	protected Cube(){
		reset();
	}
	
	//reset the cube to complete configuration
	protected void reset(){
		char[] newCube = { 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'R',
				'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'B', 'B', 'B', 'B', 'B',
				'B', 'B', 'B', 'B', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
				'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'Y', 'Y', 'Y', 'Y',
				'Y', 'Y', 'Y', 'Y', 'Y' };
		cube = newCube;
	}

	// gives string representation of cube
	// @param cubeFormat
	// true: @return a string representation in blocks
	// false: @return a string representation in lists
	public String toString(boolean format) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < size; i++) {
			buff.append(cube[i]);
			if (format) {
				buff.append(" ");
				if ((i + 1) % 3 == 0)
					buff.append("\n");
			} else {
				buff.append(", ");
			}
			if ((i + 1) % 9 == 0)
				buff.append("\n");
		}
		return buff.toString();
	}
	
	// changes orientation and relative values
	public void setOrientation(int orientation) {
		if (orientation<FRONT || orientation >DOWN)
			throw new RuntimeException("Impossible orientation");
		this.orientation = orientation;
		switch (orientation) {
		case GREEN:
			FRONT = GREEN;
			RIGHT = RED;
			BACK = BLUE;
			LEFT = ORANGE;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case BLUE:
			FRONT = BLUE;
			RIGHT = ORANGE;
			BACK = GREEN;
			LEFT = RED;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case RED:
			FRONT = RED;
			RIGHT = BLUE;
			BACK = ORANGE;
			LEFT = GREEN;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case ORANGE:
			FRONT = ORANGE;
			RIGHT = GREEN;
			BACK = RED;
			LEFT = BLUE;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case WHITE:
			FRONT = WHITE;
			RIGHT = RED;
			BACK = YELLOW;
			LEFT = ORANGE;
			UP = BLUE;
			DOWN = GREEN;
			break;
		case YELLOW:
			FRONT = YELLOW;
			RIGHT = RED;
			BACK = WHITE;
			LEFT = ORANGE;
			UP = GREEN;
			DOWN = BLUE;
			break;
		}
	}
}