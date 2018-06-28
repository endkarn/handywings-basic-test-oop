package employee;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CompensationTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transcationId;
	private double calculateResult;
	private Timestamp dateTime;
	
	@ManyToOne
	private Employee employee;


	public Integer getTranscationId() {
		return transcationId;
	}


	public void setTranscationId(Integer transcationId) {
		this.transcationId = transcationId;
	}


	public double getCalculateResult() {
		return calculateResult;
	}


	public void setCalculateResult(double calculateResult) {
		this.calculateResult = calculateResult;
	}


	public Timestamp getDateTime() {
		return dateTime;
	}


	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	

}
