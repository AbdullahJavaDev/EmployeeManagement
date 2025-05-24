package org.abdullpractice.dto;

public class EmpDto {
//Instance variables
	int id;
	String name;
	String email;
	String passWord;
	String batch;

	
//constructors
	public EmpDto(int id,String name,String email,String passWord,String batch){
		this.id=id;
		this.name=name;
		this.email=email;
		this.passWord=passWord;
		this.batch=batch;	
	}
	
	
	
//setters 	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPassWord(String passWord) {
		this.passWord=passWord;
	}
	public void setBatch(String batch) {
		this.batch=batch;
	}
	
	
	
//Getters
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassWord() {
		return passWord;
	}
	public String getBatch() {
		return batch;
	}
	
//Extract the Information	
	public String toString() {
		
		return "Id: "+id+" Name: "+name+" Email: "+email+" PassWord: "+passWord;
		
	}
	
}
