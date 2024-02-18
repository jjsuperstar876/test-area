import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) throws IOException {
		Staff staff= new Staff();
		Scanner in= new Scanner(System.in);
		
		String user, pass;
		int access,tries=0;
		
		//staff.addStaff(1);
		
				System.out.println("Hello Weolcome please enter \n 1 if you are a Staff \n 2 if you are ...");
				access=in.nextInt();
				
				if(access==1) {
					System.out.println("Please enter your username");					
					user=in.nextLine();//system ignoring this into be resolved
					user=in.nextLine();
					System.out.println("Please enter your password");
					pass=in.nextLine();
					
					
					
					
					access=staff.login(user, pass);
					
					while(access!=2)
					{
						tries++;
						if(tries==3) {
							System.out.println("You have exceeded the amount of attempts try again later");
							break;
						}
						System.out.println("Incorrect Credientials Please try again");
						user=in.nextLine();
						pass=in.nextLine();
						
						access=staff.login(user, pass);
					}
					
						if(access==2) 
						{
							System.out.println("Welcome "+ user +" Please select what you would like to do from the list below");
							System.out.println("1 - add New Staff \n2-");
							access=in.nextInt();
							if(access==1) {
								staff.addStaff(2);
							}
							
						}
						
									
					
				}
		
		
		
		
		in.close();

	}

}


public class Staff{
	
	private	String fname, lname,address1, address2, postOffice, parish;
	private String telephone, email, position, status,staffId;
	private String password,username;
	
	public Staff() {
		fname="test";
		lname="test";
		address1="test";
		address2="test";
		postOffice="test";
		parish="test";
		telephone="test";
		email="test";
		position="test";
		status="test";
		password="test";
		username="test";
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Staff(String fname, String lname, String address1, String address2, String postOffice, String parish,
			String telephone, String email, String position, String status, String staffId, String password,String username) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address1 = address1;
		this.address2 = address2;
		this.postOffice = postOffice;
		this.parish = parish;
		this.telephone = telephone;
		this.email = email;
		this.position = position;
		this.status = status;
		this.staffId = staffId;
		this.password=password;
		this.username=username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getParish() {
		return parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	
	
	public int login(String user, String pass) {
		
		int count=1;
		String line;
		try {
		      BufferedReader reader = new BufferedReader( new FileReader("staff.txt" ));

		      
		      while((line = reader.readLine()) != null) {
		    	  
		    	  
		    	  String[] parts = line.split(" ."); 
	                String storedUsername = parts[0];
	                String storedPassword = parts[1];
	                
	                System.out.println(storedUsername + " " + storedPassword );

	                
	                if(storedUsername.equals(user)&& storedPassword.equals(pass)) {
	                	System.out.println("It worked");
	                	count=count+1;
	                	
	                }
	                
		      }
		      //System.out.println(reader.readLine() +count);
		      reader.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		
		return count;
	}
	
	public void addStaff( int count) throws IOException {
		
		Scanner input= new Scanner(System.in);
		
		
		System.out.println("Please enter USername");
		username=input.nextLine();
		
		System.out.println("Please enter Password");
		password=input.nextLine();
		
		System.out.println("Please enter First Name");
		fname=input.nextLine();
		
		System.out.println("Please enter Last name");
		lname=input.nextLine();
		
		System.out.println("Please enter Address 1");
		address1=input.nextLine();
		
		System.out.println("Please enter Address 2");
		address2=input.nextLine();
		
		System.out.println("Please enter the Post Office ");
		postOffice=input.nextLine();
		
		System.out.println("Please enter the Parish");
		parish=input.nextLine();
		
		System.out.println("Please enter Telephone number");
		telephone=input.nextLine();
		
		System.out.println("Please enter Email");
		email=input.nextLine();
		
		System.out.println("Please enter the Position ");
		position=input.nextLine();
		
		System.out.println("Please enter Status ");
		status=input.nextLine();
		
		input.close();
		
		if (count==1) {
		    try {
		      BufferedWriter writer = new BufferedWriter(new FileWriter("staff.txt"));
		      writer.write(username +" ."+ password + " ." + fname + " ." + lname + " ." + address1 + " ." + address2 + " ." + postOffice + " ." + parish + " ." + telephone + " ." + email + " ." + position + " ." + status + "\n");
		      
		      writer.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    
		    try {
		      BufferedReader reader = new BufferedReader(new FileReader("staff.txt"));
		      String line;
		      while((line=reader.readLine()) != null) {
		        System.out.println("Read file"+" "+line);
		      }
		      reader.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		}
		else {
			try {
			      BufferedWriter writer = new BufferedWriter(new FileWriter("staff.txt", true));
			      writer.write(username +" ."+ password + " ." + fname + " ." + lname + " ." + address1 + " ." + address2 + " ." + postOffice + " ." + parish + " ." + telephone + " ." + email + " ." + position + " ." + status + "\n");

			      
			      writer.close();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
			    
			    try {
			      BufferedReader reader = new BufferedReader(new FileReader("staff.txt"));
			      String line;
			      while((line=reader.readLine()) != null) {
			    	  System.out.println("Read file"+" "+line);
			      }
			      reader.close();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
			
		}
		  }
            
	
	public void addCustomer() {
		
	}
	
	public void addRoute() {
		
	}
	
	public void addRates() {
		
	}
	
	public void addHaul(){
		
	}
	
	
	
	
	
}

