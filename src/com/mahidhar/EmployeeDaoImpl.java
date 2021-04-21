package com.mahidhar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    private static Statement statement = null;
    private Connection conn;

    public EmployeeDaoImpl() throws SQLException {
        conn = ConnectionFactory.getConnection();
        statement = conn.createStatement();
    }

   
    public void addEmployee(Employee employee) throws SQLException {
    	
    	String sql="insert into employee values (" +employee.getEmpId()+", '"+employee.getName()+"', '" +employee.getEmail()+"')";
    	int count=0;
    	count=statement.executeUpdate(sql);
    	if(count>0) {
    		System.out.println("Employee is saved... ");
    	}
    	else {
    		System.out.println("Not saved...");
    		
    	}

    }

    public void updateEmployee(Employee employee) throws SQLException {
    	 
        String sql = "update employee set name='"+employee.getName()+"', email='"+employee.getEmail()+"' where empId="+ employee.getEmpId();
        int count = 0;
        count = statement.executeUpdate(sql);

        if (count > 0) {
            System.out.println("Employee is saved...");
        } else {
            System.out.println("Not saved...");
        }

    }

   
    public void deleteEmployee(Employee employee, int empId) throws SQLException {
    	
    	String sql = "delete from employee where empId= "+ empId;
        int count = 0;
        count = statement.executeUpdate(sql);

        if (count > 0) {
            System.out.println("Deleted...");
        } else {
            System.out.println("Not deleted...");
        }

    }

   
    public Employee getEmployeeById(int id) throws SQLException {
    	Employee employee = null;
        String sql = "select * from employee where id = "+ id;
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            int empId = rs.getInt("empId");
            String name = rs.getString("name");
            String email = rs.getString("email");
            employee = new Employee(empId, name, email);
        }
        return employee;
    }

    
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> list=new ArrayList<>();
        String sql="select * from employee";
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()) {
        	int id=rs.getInt("empId");
        	String name=rs.getString("name");
        	String email=rs.getString("email");
        	Employee emp=new Employee(id,name,email);
        	list.add(emp);
        	
        }
    	return list;
    }



	

	


	}

