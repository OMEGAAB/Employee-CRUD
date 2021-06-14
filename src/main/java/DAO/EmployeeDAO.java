package DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean saveEmployee(Employee employee) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(employee);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

    public List<Employee> getAllEmployees() {
        Session currentSession = sessionFactory.getCurrentSession();
		Query<Employee> query=currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list=query.getResultList();
		return list;
    }

    public Employee getEmployeeByID(int employee_Id) {
        Session currentSession = sessionFactory.getCurrentSession();
		Query<Employee> query=currentSession.createQuery("from Employee where employee_Id=:employee_Id", Employee.class);
		query.setParameter("employee_Id", employee_Id);
		Employee emp = query.getSingleResult();
		return emp;
    }

	public boolean updateEmployee(Employee employee) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(employee);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteEmployee(Employee employee) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(employee);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
