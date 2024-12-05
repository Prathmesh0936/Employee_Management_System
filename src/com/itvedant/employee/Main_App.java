package com.itvedant.employee;

import java.util.List;
import java.util.Scanner;

public class Main_App {
	

		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			Employee_Services eservices = new Employee_Services();
			
			System.out.println("Welcome to Employee Management System");
			
			while(true) {
				
				System.out.println();
				System.out.println("Kindly Enter your Choice ");
				System.out.println("1. Add New Employee");
				System.out.println("2. View All Employee");
				System.out.println("3. Update Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. Search Employee");
				System.out.println("6. Exist");
				
				int userInput = sc.nextInt();
				
				if(userInput == 6) {
					
					System.out.println("GoodByee!!!");
					break;
					
				}else {
					
					int id;
					String name;
					int age;
					int salary;
					
					
					switch(userInput) {
					
					case 1: System.out.print("Enter ID : ");
					       id = sc.nextInt();
					       
					       System.out.print("Enter Name : ");
					       name = sc.next();
					       
					       System.out.print("Enter Age : ");
					       age = sc.nextInt();
					       
					       System.out.print("Enter Salary : ");
					       salary= sc.nextInt();
					       
					       Boolean b = eservices.insertRecord(id, name, age, salary);
					       
					       if(b) {
					    	   
					    	   System.out.println("Data Inserted Successfully");
					    	   
					       }else {
					    	   
					    	   System.out.println("Data not Inserted");
					    	   
					       }
					       
					       break;
					
					
					case 2: List<Employee> employees = eservices.readRecord();
					
					for(Employee x : employees) {
						
						System.out.println(x);
						
					}
					
					break;
					
					case 3: System.out.println("Enter ID : ");
					       
					       id = sc.nextInt();
					       
					       Employee emp = eservices.searchRecords(id);
					       
					       System.out.println(emp);
					       
					       System.out.println();
					       
					       System.out.println("Enter the Choice for Field which you want to update");
					       
					       System.out.println("a.Update Name");
					       System.out.println("b.Update Age");
					       System.out.println("c.Update Salary");
					       
					       char c = sc.next().charAt(0);
					       
					       switch(c) {
					       
					       case 'a' : System.out.println("Enter  Name  : ");
					                 name = sc.next();
					                 emp.setName(name);
					                 break;
					       
					       
					       case 'b': System.out.println("Enter Age : ");
					                age = sc.nextInt();
					                emp.setAge(age);
					                break;
					               
					       case 'c': System.out.println("Enter Salary : ");
					                salary = sc.nextInt();
					                emp.setSalary(salary);
					                break;
					                
					       default : System.out.println("Invalid Input");
					       
					       
					       }
					       
					       b = eservices.updateRecord(emp);
					       
					       if(b) {
					    	   
					    	   System.out.println("Record Updated");
					    	   
					       }else {
					    	   
					    	   System.out.println("Record Not Updated");
					    	   
					       }
					       
					       
					       break;
					       
					
					case 4: System.out.println("Enter ID : ");
					       
					       id = sc.nextInt();
					       
					       b = eservices.deleteRecord(id);
					       
					       if(b) {
					    	   
					    	   System.out.println("Record Deleted Successfully");
					    	   
					       }else {
					    	   
					    	   System.out.println("Record Not Deleted");
					    	   
					       }
					       
					       break;
					
					case 5: System.out.println("Enter ID : ");
					       id = sc.nextInt();
					       
					       Employee e = eservices.searchRecords(id);
					       
					       System.out.println(e);
					       
					       break;
					
					default : System.out.println("Invalid Input");
					
					}
					
				}
				
			}
			
		}

	}



