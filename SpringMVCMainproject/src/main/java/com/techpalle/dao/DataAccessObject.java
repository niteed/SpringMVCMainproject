package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Student;

public class DataAccessObject 
{
	public ArrayList<Student> getStudents()
	{
		ArrayList<Student> all = new ArrayList<Student>();
		//write jdbc connection code
		//read all students
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/palle",
					"root","Techpalle");
			String query = "select * from student";
			Statement ps = con.createStatement();			
			ResultSet r = ps.executeQuery(query);
			while(r.next() == true)
			{
				//read each row from result set
				String name = r.getString(1);
				String email = r.getString(2);
				String pw = r.getString(3);
				String mobile = r.getString(4);
				//create a student object with values
				Student s = new Student();
				s.setEmail(email);
				s.setName(name);
				s.setPw(pw);
				s.setMobile(mobile);
				//add to arraylist
				all.add(s);
			}
			ps.close();
			con.close();
			System.out.println("row is inserted..");
		} catch (ClassNotFoundException e) 
		{
			System.out.println("driver problem.."+e);
			e.printStackTrace();
		}	
		catch (SQLException e) 
		{
			System.out.println("sql problem.."+e);
			e.printStackTrace();
		}
		return all;
	}
	public void insertStudent(Student s)
	{
		//write jdbc connection code
		//insert the student object into table
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/palle",
					"root","Techpalle");
			String query = "insert into student(name, email, pw, mobile) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPw());
			ps.setString(4, s.getMobile());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("row is inserted..");
		} catch (ClassNotFoundException e) 
		{
			System.out.println("driver problem.."+e);
			e.printStackTrace();
		}	
		catch (SQLException e) 
		{
			System.out.println("sql problem.."+e);
			e.printStackTrace();
		}
	}
}
