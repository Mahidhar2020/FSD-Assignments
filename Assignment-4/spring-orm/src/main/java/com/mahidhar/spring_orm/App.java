package com.mahidhar.spring_orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mahidhar.spring_orm.dao.EmployeeDao;
import com.mahidhar.spring_orm.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args) throws NumberFormatException, IOException 
    {
       ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
       EmployeeDao dao=(EmployeeDao)context.getBean("employeeDao",EmployeeDao.class);
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
       
       //Employee emp=new Employee();
       //emp.setEmpId(23);
       //emp.setName("Mahidhar");
       //emp.setEmail("Mahid@gmail.com");
       boolean b=true;
       
        while(b) {
        	System.out.println("-------Select any option---------");
        	System.out.println(" Press 1:Add");
        	System.out.println(" Press 2:List");
        	System.out.println(" Press 3:Get Employee by Id");
        	System.out.println(" Press 4:Update");
        	System.out.println(" Press 5:Delete");
        	System.out.println("----------------------------------");
        	
        
     
       
       Scanner sc=new Scanner(System.in);
       int option=sc.nextInt();
       switch(option) {
       case 1:{
    	   System.out.println("Enter Id");
    	   Integer.parseInt(br.readLine());
    	   System.out.println("Enter name");
    	   String name=br.readLine();
    	   System.out.println("Enter email");
    	  String email=br.readLine();

           Employee emp=new Employee();
           emp.setEmpId(23);
           emp.setName("Mahidhar");
           emp.setEmail("Mahid@gmail.com");
           
           dao.addEmployee(emp);
           System.out.println("Inserted...");
    	   break;
       }
       
       case 2:{
    	   List<Employee> list=dao.getallEmployees();

           for (Employee emp:list) {
               System.out.println(emp.toString());
           }
           System.out.println("Obtained In List...");
            break;
       }
       
       case 3:
       {
    	   System.out.println("Enter employee ID");
    	   int Id=Integer.parseInt(br.readLine());
   	     
    	  System.out.println(dao.getEmployeebyId(Id));
    	   break;
    	  
       }
       case 4:{
    	   System.out.println("Enter Employee Id");
    	   int Id=Integer.parseInt(br.readLine());
    	   dao.DeleteEmployee(Id);
    	   break;
    	   
       }
       case 5:
       {
    	   System.out.println("Enter Id");
    	   Integer.parseInt(br.readLine());
    	   System.out.println("Enter name");
    	   String name=br.readLine();
    	   System.out.println("Enter email");
    	  String email=br.readLine();

           Employee emp=new Employee();
           emp.setEmpId(23);
           emp.setName("Mahidhar");
           emp.setEmail("Mahid@gmail.com");
           
          dao.UpdateEmployee(emp);
           System.out.println("Updated...");
    	   break;
    	   
       }
       }
        }
       
       
    }
}
