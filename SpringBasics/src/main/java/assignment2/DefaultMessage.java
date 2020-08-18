package assignment2;

public class DefaultMessage {
	private String message="Spring";

	public DefaultMessage(String string) {
		// TODO Auto-generated constructor stub
		this.message=string;
	}

	public DefaultMessage() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DefaultMessage [message=" + message + "]";
	}
}
