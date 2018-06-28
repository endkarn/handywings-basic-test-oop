package employee;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private Date birthday;
	private double empWage;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private EmployeeType employeeType;
	

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public double getEmpWage() {
		return empWage;
	}

	public void setEmpWage(double empWage) {
		this.empWage = empWage;
	}

	public long getAge(Date birthday) {
		LocalDate start = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(birthday) );
		LocalDate end = LocalDate.now();
		long years = ChronoUnit.YEARS.between(start, end);
		//System.out.println(years); // 17
		
		return years;
		
	}



}
