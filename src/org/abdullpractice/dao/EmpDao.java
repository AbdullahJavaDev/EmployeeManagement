package org.abdullpractice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.abdullpractice.connectionfactory.*;
import org.abdullpractice.dto.EmpDto;
public class EmpDao implements EmpDaoInterface {
	static ArrayList<EmpDto>ar=new ArrayList<>();
//--------------------------------------------------------------
	@Override
	public List getAllEmployees() {
		
		//Get the connection
		Connection con=ConnectionFactory.requestConnection();
		//Fetching the details from the database
		String query1="Select*from emp";
		try {
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(query1);
			while(res.next()) {
				int id=res.getInt(1);
				String name=res.getString(2);
				String email=res.getString(3);
				String passWord=res.getString(4);
				String batch=res.getString(5);
				EmpDto obj1=new EmpDto(id,name,email,passWord,batch);
				ar.add(obj1);
			}
		}
		catch(SQLException ae) {
			System.err.println("Oops!Error,Something Went wrong");
		}
		
		return ar;
		
	}

	
//----------------------------------------------------------------	
	@Override
	public EmpDto getEmployee(int id) {
		EmpDto obj1=null;
		ResultSet res=null;
		//Get the Connection
		Connection con=ConnectionFactory.requestConnection();
		//fetching the Details from the  database
		String query="select*from emp where id=?";
		//setting the Details
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			if(res.next()) {
				obj1=new EmpDto(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
			else {
				System.out.println("Sorry!..Employee Not found");
			}
			
		} catch (SQLException e) {
			System.err.println("Oops!Error, Something went wrong");
			e.printStackTrace();
		}
		
		return obj1;
	}
	
//------------------------------------------------------------	

	@Override
	public boolean insertEmployee(EmpDto e) {
		//Get the Connection
		Connection con=ConnectionFactory.requestConnection();
		//Query for insert the record
		String query="insert into emp values(?,?,?,?,?)";
		//set the details
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,e.getId());
			pstmt.setString(2,e.getName());
			pstmt.setString(3,e.getEmail());
			pstmt.setString(4,e.getPassWord());
			pstmt.setString(5,e.getBatch());
			int i=pstmt.executeUpdate();
			if(i==1) {
				return true;
			}
			
		} catch (SQLException e1) {
			System.out.println("Oops!Error,Something Went wrong");
			e1.printStackTrace();
		}
		return false;
	}
	
//------------------------------------------------------------	

	@Override
	public boolean updateEmployee(int id) {
		//Get the Connection
		Connection con=ConnectionFactory.requestConnection();
		//fetching the details
		String Query="Select * from emp where id=?";
		//set the details
		try {
			PreparedStatement pstmt=con.prepareStatement(Query);
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				System.out.println("Enter the update name: ");
				Scanner sc=new Scanner(System.in);
				String name=sc.nextLine();
				System.out.println("Enter the updated email:");
				String email=sc.nextLine();
				System.out.println("Enter the updated passWord:");
				String passWord=sc.nextLine();
				System.out.println("Enter the updated Batch: ");
				String bacth=sc.nextLine();
				
				//updating query
				String update="update emp set Name=?, Email=? ,passWord=? ,Batch=? where Id=?";
				PreparedStatement pstmtupdate=con.prepareStatement(update);
				//set the details of the statement
				pstmtupdate.setString(1,name);
				pstmtupdate.setString(2,email);
				pstmtupdate.setString(3,passWord);
				pstmtupdate.setString(4,bacth);
				pstmtupdate.setInt(5,id);
				int result=pstmtupdate.executeUpdate();
				if(result>=1) {
					return true;
				}
				
			}
			else {
				System.out.println("Sorry Employee is Not Found");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

//--------------------------------------------------------------	
	@Override
	public boolean deleteEmployee(int id) {
		//Get the connection
		Connection con=ConnectionFactory.requestConnection();
		//Query
		String delete="delete from emp where id=?";
		//setting the placeholders
		try {
			PreparedStatement pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, id);
			int result=pstmt.executeUpdate();
			if(result>=1) {
				return true;
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return false;
		
	}

}
