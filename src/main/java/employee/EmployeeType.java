package employee;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class EmployeeType {
	@Id
	private int typeId;
	private String typeName;
	private String typeDetail;
	
	public EmployeeType() {}
	
	
	public EmployeeType(int typeId, String typeName, String typeDetail) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeDetail = typeDetail;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDetail() {
		return typeDetail;
	}
	public void setTypeDetail(String typeDetail) {
		this.typeDetail = typeDetail;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	
	

}
