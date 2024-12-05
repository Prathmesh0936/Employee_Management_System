package com.itvedant.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Employee_Services {
	
	static Connection con = DB_Connection.getConnection();
		
		public List<Employee> readRecord(){
			
			List<Employee> employees = new ArrayList<Employee>();
		
			String query = "select * from employee;";
			
			try {
				
				Statement stats = con.createStatement();
			
				ResultSet rs = stats.executeQuery(query);
				
				while(rs.next()) {
					
					Employee e = new Employee();
					
					e.setId(rs.getInt("id"));
					e.setName(rs.getString("name"));
					e.setAge(rs.getInt("age"));
					e.setSalary(rs.getInt("salary"));
					
					employees.add(e);
					
				} 
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
			}
			
			return employees;
		}
		
		public boolean insertRecord(int id, String name, int age, int salary) {
			
			String query = "insert into employee values(?, ?, ?, ?);";
			
			try {
				
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, age);
				ps.setInt(4, salary);
				
				int i = ps.executeUpdate();
				
				if(i > 0) {
					return true;
				}
				
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
			}
			
			return false;
		}
		
		public Employee searchRecords(int id) {
			
			Employee e = new Employee();
			
			String query = "select * from employee where id = ?;";
			
			try {
				
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					e.setId(rs.getInt("id"));
					e.setName(rs.getString("name"));
					e.setAge(rs.getInt("age"));
					e.setSalary(rs.getInt("salary"));
					
				}
				
				
			} catch (Exception e2) {
				
				System.out.println(e2.getMessage());
				
			}
			
			return e;
			
		}
		
		public boolean deleteRecord(int id) {
			
			String query = "delete from employee where id  = ?;";
			
			try {
				
				PreparedStatement ps = con.prepareStatement(query);
					
				ps.setInt(1, id);
				
				int i = ps.executeUpdate();
				
				if(i > 0 ) {
					
					return true;
					
				}
				
				
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
			return false;
		}
		
		public boolean updateRecord(Employee emp) {
			
			String query = "Update employee set name = ? , age = ?, salary = ? where id = ?;";
			
			try {
				
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1,emp.getName());
				ps.setInt(2, emp.getAge());
				ps.setInt(3,emp.getSalary());
				ps.setInt(4, emp.getId());
				
				int i = ps.executeUpdate();
				
				if(i > 0) {
					
					return true;
					
				}
				
				
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());

			}
			
			return false;
		}
		
	}


