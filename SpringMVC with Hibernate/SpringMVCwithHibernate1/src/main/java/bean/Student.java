package bean;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String branch;
	@Column
	private BigInteger mobile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public BigInteger getMobile() {
		return mobile;
	}
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", mobile=" + mobile + "]";
	}

}
