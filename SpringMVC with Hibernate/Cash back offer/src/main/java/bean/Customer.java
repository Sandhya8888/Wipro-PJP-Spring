package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	private String CustomerID;
	@Column
	private String Password;
	@Column 
	private int Balance;
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", Password=" + Password + ", Balance=" + Balance + "]";
	}
}
