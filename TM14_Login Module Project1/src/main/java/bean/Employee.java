package bean;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="EmployeeUser")
public class Employee {
	@Id 
	@Column(name="id")
	@Pattern(regexp="^[a-zA-Z0-9]{3}",message="fvg")
	String id;
	@Column(nullable=false,name="name")
	String name;
	@Column(nullable=false,name="gender")
	String gender;
	@Column(nullable=false,name="designation")
	String designation;
	@Column(nullable=false,name="salary")
	int salary;
	@Column(nullable=false,name="city")
	String city;
	@Column(nullable=false,name="email")
	@Email
	String email;
	@Column(nullable=false,name="mobile")
	BigInteger mobile;
	@Embedded
	private User u;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigInteger getMobile() {
		return mobile;
	}
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", designation=" + designation
				+ ", salary=" + salary + ", city=" + city + ", email=" + email + ", mobile=" + mobile + ", u=" + u
				+ "]";
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
}
