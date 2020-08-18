package assignment2;

public class ConstructorMessage {
	private String message=null;
	@Override
	public String toString() {
		return "ConstructorMessage [message=" + message + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	ConstructorMessage(String message){
		this.message=message;
	}
	public ConstructorMessage() {
		// TODO Auto-generated constructor stub
	}
	
}
