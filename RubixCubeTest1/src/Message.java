
public class Message {
	private String message;
	
	public Message (String msg){
		message = msg;
		print();
		TextIO.getln();
	}
	
	public String print(){
		TextIO.putln(message);
		return message;
	}
	
	public String getMessage(){
		return message;
	}
}
