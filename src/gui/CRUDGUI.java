package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.abdullpractice.dao.EmpDao;
import org.abdullpractice.dto.EmpDto;;

public class CRUDGUI extends JFrame implements ActionListener{

//instance variables
	JLabel desc;
	JButton getAllEmp,getEmp,insertEmp,updateEmp,deleteEmp;
	
	
//constructor
	public CRUDGUI(){
		setLayout(null);
		setTitle("CRUD OPERATIONS USIND DAO");
		setSize(800,500);
		setLocation(250,100);
		getContentPane().setBackground(Color.BLACK);
		

		//logic for desc
		desc=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		desc.setBounds(220,80,700,30);
		desc.setFont(new Font("Tahoma",Font.BOLD,18));
		desc.setForeground(Color.WHITE);
		add(desc);
		
		//logic for Button1
		getAllEmp=new JButton("GetAllEmployees");
		getAllEmp.setBounds(120,160,250,30);
		getAllEmp.setFont(new Font("Tahoma",Font.BOLD,18));
		getAllEmp.setBackground(Color.CYAN);
		getAllEmp.setForeground(Color.BLACK);
		add(getAllEmp);
		
		//logic for Button2
		getEmp=new JButton("GetEmployee");
		getEmp.setBounds(400,160,250,30);
		getEmp.setFont(new Font("Tahoma",Font.BOLD,18));
		getEmp.setBackground(Color.ORANGE);
		getEmp.setForeground(Color.BLACK);
		add(getEmp);
		
		//logic for Button3
		insertEmp=new JButton("Insert Employee");
		insertEmp.setBounds(120,220,250,30);
		insertEmp.setFont(new Font("Tahoma",Font.BOLD,18));
		insertEmp.setBackground(Color.BLUE);
		insertEmp.setForeground(Color.BLACK);
		add(insertEmp);
		
		//logic for Button4
		updateEmp=new JButton("Update Employee");
		updateEmp.setBounds(400,220,250,30);
		updateEmp.setFont(new Font("Tahoma",Font.BOLD,18));
		updateEmp.setBackground(Color.GREEN);
		updateEmp.setForeground(Color.BLACK);
		add(updateEmp);
		
		//logic for Button5
		deleteEmp=new JButton("deleteEmployee");
		deleteEmp.setBounds(300,280,250,30);
		deleteEmp.setFont(new Font("Tahoma",Font.BOLD,18));
		deleteEmp.setBackground(Color.RED);
		deleteEmp.setForeground(Color.BLACK);
		add(deleteEmp);
		setVisible(true);
		
		//attaching the actionListeners
		getAllEmp.addActionListener(this);
		getEmp.addActionListener(this);
		insertEmp.addActionListener(this);
		updateEmp.addActionListener(this);
		deleteEmp.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Scanner sc=new Scanner(System.in);
		if(e.getSource()==getAllEmp) {
			setVisible(false);
			System.out.println("Get the All the employees");
			EmpDao obj1=new EmpDao();
			List<EmpDto> ar1=obj1.getAllEmployees();
			
			for(EmpDto emp:ar1) {
				System.out.println(emp.toString());
			}
			setVisible(true);
			//System.out.println("---------------------------");
			
		}
		else if(e.getSource()==getEmp) {
			setVisible(false);
			System.out.println("Get the a Particular Employee");
			System.out.println("Enter the Id");
			//Scanner sc=new Scanner(System.in);
			int id=sc.nextInt();
					
			EmpDao obj11=new EmpDao();
			EmpDto obj12=obj11.getEmployee(id);
			System.out.println(obj12.toString());
			setVisible(true);
			
		}
		else if(e.getSource()==insertEmp) {
			setVisible(false);
			System.out.println("Insert the Employee");
			System.out.println("Enter the Id:");
			int id1=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Name");
			String name=sc.nextLine();
			System.out.println("Enter the Email");
			String email=sc.nextLine();
			System.out.println("Enter the passWord");
			String passWord=sc.nextLine();
			System.out.println("Enter the Batch");
			String batch=sc.nextLine();
					
			EmpDto obj21=new EmpDto(id1,name,email,passWord,batch);
			EmpDao obj22=new EmpDao();
			boolean result=obj22.insertEmployee(obj21);
			System.out.println(result);
			setVisible(true);
			
		}
		else if(e.getSource()==updateEmp) {
			setVisible(false);
			System.out.println("Update the employee");
			System.out.println("Enter the Id:");
			int id2=sc.nextInt();
			sc.nextLine();
			EmpDao obj31=new EmpDao();
			boolean result1=obj31.updateEmployee(id2);
			System.out.println(result1);
			setVisible(true);
			
		}
		else if(e.getSource()==deleteEmp) {
			setVisible(false);
			System.out.println("Deleting the Employee");
			System.out.println("Enter the employee id:");
			//Scanner sc=new Scanner(System.in);
			int id=sc.nextInt();
			EmpDao obj1=new EmpDao();
			System.out.println(obj1.deleteEmployee(id));
			setVisible(true);
		}
		
	}
	
	public static void main(String args[]) {
		CRUDGUI obj1=new CRUDGUI();
	}

}
