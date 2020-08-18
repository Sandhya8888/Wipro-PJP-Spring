package bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class User {
	@Column(nullable=false,unique=true,name="username")
	private String username;
	@Column(nullable=false,name="password")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
