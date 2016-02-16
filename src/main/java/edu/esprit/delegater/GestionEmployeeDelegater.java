package edu.esprit.delegater;

import java.util.List;

import edu.esprit.domain.Employee;
import edu.esprit.locator.ServiceLocator;
import edu.esprit.services.gestion.employee.GestionEmployeeRemote;


public class GestionEmployeeDelegater {
	private static final String jndi = "E-Goverment/GestionEmployee!edu.esprit.services.gestion.employee.GestionEmployeeRemote";

	private static GestionEmployeeRemote getProxy() {
		return (GestionEmployeeRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddEmployee(Employee employee){
		return getProxy().addEmployee(employee);
	}

	public static Boolean doDeleteEmployee(Employee employee) {
		return getProxy().deleteEmployee(employee);
	}

	public static Boolean doUpdateEmployee(Employee employee) {
		return getProxy().updateEmployee(employee);
	}
	public static List<Employee> doFindAllEmployee() {
		return getProxy().findAllEmployee();
	}
	public static Employee doFindAllEmployeeByCin(String cin) {
		return getProxy().findEmployeeByCin(cin);
	}
	public static Employee doFindAllEmployeeById(int id) {
		return getProxy().FindAllEmployeeById(id);
	}
	
}
