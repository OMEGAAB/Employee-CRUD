package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Model.Employee;
import Service.EmployeeService;

@RestController
public class Controller {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	private int saveEmployee(@RequestBody Employee employee) 
	{
		employeeService.saveEmployee(employee);
		return employee.getEmployee_Id();
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		 return employeeService.getAllEmployees();
	}

	@GetMapping("employees/{employee_Id}")
	public Employee employeeByID(@PathVariable("employee_Id") int employee_Id) {
		 return employeeService.getEmployeeByID(employee_Id);	
	}

	@PutMapping("employees/{employee_Id}")
	public boolean updateEmployee(@RequestBody Employee employee,@PathVariable("employee_Id") int employee_Id) {
		employee.setEmployee_Id(employee_Id);
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("employees/{employee_Id}")
	public boolean deleteEmployee(@PathVariable("employee_Id") int employee_Id) {
		Employee employee = employeeService.getEmployeeById(employee_Id);
		return employeeService.deleteEmployee(employee);
	}

	@DeleteMapping("/employees")
	public boolean deleteAllEmployee() {
		return employeeService.deleteAllEmployees();
	}
}
