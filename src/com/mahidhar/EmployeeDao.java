package com.mahidhar;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(Employee employee,int empId) throws SQLException;
    Employee getEmployeeById (int empId) throws SQLException;
    List<Employee> getEmployees() throws SQLException;
	
}

