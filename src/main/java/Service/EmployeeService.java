package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.EmployeeDAO;
import Model.Employee;

@Service
@Transactional
public class EmployeeService {
 
	@Autowired
	private EmployeeDAO employeeDao;
	
	public boolean saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

	public Employee getEmployeeByID(int employee_Id) {
		return employeeDao.getEmployeeByID(employee_Id);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	public boolean deleteEmployee(Employee employee) {
		return employeeDao.deleteEmployee(employee);
	}

	public boolean deleteAllEmployees() {
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		for(Employee employee: allEmployees) {
			employeeDao.deleteEmployee(employee);
		}
		return true;
	}

	public Employee getEmployeeById(int id) {
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		for(Employee employee: allEmployees) {
			if(employee.getEmployee_Id() == id)
				return employee;
		}
		return null;
	} 
}
