
public class Scanner extends Algorithms{
	
	protected char getColor(int index){
		return cube[index];
	}
	
	public boolean equals(int index1, int index2) {
		char top = getColor(index1);
		char bot = getColor(index2);
		return (top == bot);
	}
}
