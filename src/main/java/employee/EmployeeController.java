package employee;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;

@Controller
//@RequestMapping(path = "/demo")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	@Autowired
	private CompensationTransactionRepository compensationTransactionRepository;

	@GetMapping(path="/add")
	public String addNewEmployee (@RequestParam Integer typeemployee,
			@RequestParam String firstname,
			@RequestParam String lastname,
			@RequestParam Date birthday,
			@RequestParam Double wage) {
		

		
		EmployeeType employeeType = employeeTypeRepository.findOneByTypeId(typeemployee);
		employeeType.setTypeId(typeemployee);
		
		
		Employee n = new Employee();
		n.setEmployeeType(employeeType);
		n.setFirstName(firstname);
		n.setLastName(lastname);
		n.setBirthday(birthday);
		n.setEmpWage(wage);
		
		employeeRepository.save(n);
		return "redirect:/insertemployee.html";
	}
	
	@GetMapping(path="/all")
	public String getAllEmp(Model model){
		Iterable<Employee> employeeList = employeeRepository.findAll();
		//System.out.println(employeeList);
		
		model.addAttribute("employeeList",employeeList);
		return "allemployee";
	}
	
	@GetMapping(path="/cal")
	public String CalTransaction(Model model, @RequestParam Integer empId) {
		Employee employee = employeeRepository.findOneByEmployeeId(empId);
		model.addAttribute("employee",employee);
		return "cal";
	}
	
	@GetMapping(path="/caltransactionparttime")
	public @ResponseBody String CalTransactionForParttime(Model model, @RequestParam Integer employeeId, @RequestParam Integer workhours) {
		Employee employee = employeeRepository.findOneByEmployeeId(employeeId);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		CompensationTransaction transaction = new CompensationTransaction();
		transaction.setEmployee(employee);
		transaction.setDateTime(timestamp);
		transaction.setCalculateResult((employee.getEmpWage() * workhours));
		compensationTransactionRepository.save(transaction);
		return "calculated resule = "+transaction.getCalculateResult()+" Baht";
	}
	
	@GetMapping(path="/caltransactionfulltime")
	public @ResponseBody String CalTransactionForFulltime(Model model, @RequestParam Integer employeeId) {
		Employee employee = employeeRepository.findOneByEmployeeId(employeeId);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		CompensationTransaction transaction = new CompensationTransaction();
		transaction.setEmployee(employee);
		transaction.setDateTime(timestamp);
		transaction.setCalculateResult((employee.getEmpWage() * 0.97));
		compensationTransactionRepository.save(transaction);
		return "calculated result = "+transaction.getCalculateResult()+" Baht";
	}
	
	@GetMapping(path="/showtransactions")
	public String getAllTransactions(Model model){
		Iterable<CompensationTransaction> compensationTransactionList = compensationTransactionRepository.findAll();
		model.addAttribute("compensationTransactionList",compensationTransactionList);
		return "showtransactions";
	}
	
	@GetMapping(path="/insertemployee")
	public String InsertEmployee(){
		return "redirect:/insertemployee.html";
	}

	

}
