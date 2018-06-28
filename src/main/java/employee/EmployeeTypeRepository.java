package employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Integer> {
	EmployeeType findOneByTypeId(Integer typeId);
	//@Query(value = "SELECT * From employee_type WHERE type = ?",nativeQuery =true)

}
