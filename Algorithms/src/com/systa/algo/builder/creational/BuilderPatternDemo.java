package com.systa.algo.builder.creational;


/*
 * Builder Pattern
 */
class Employee {

	private String firstName;    //required
    private String lastName;    //required
    private int age;    //required
    private int personalId; // required
    private String phone;    //optional
    private String address;    //optional
    private String mail;    //optional
    
    
    
    private Employee(String firstName, String lastName, int age, int personalId, String phone, String address,
			String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.personalId = personalId;
		this.phone = phone;
		this.address = address;
		this.mail = mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public int getPersonalId() {
		return personalId;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getMail() {
		return mail;
	}
	
	

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", personalId="
				+ personalId + ", phone=" + phone + ", address=" + address + ", mail=" + mail + "]";
	}



	public static class builder{
    
    	private String firstName;    //required
        private String lastName;    //required
        private int age;    //required
        private int personalId; // required
        private String phone;    //optional
        private String address;    //optional
        private String mail;    //optional
        
        public builder() {
        	
        }
        
        public builder firstName(String firstName) {
        	this.firstName = firstName;
        	return this;
        }
        
        public builder lastName(String lastName) {
        	this.lastName = lastName;
        	return this;
        }
        
        public builder age(int age) {
        	this.age = age;
        	return this;
        }
        
        
        public builder personalId(int personalId) {
        	this.personalId = personalId;
        	return this;
        }
        
        
        public builder phone(String phone) {
        	this.phone = phone;
        	return this;
        }
        
        
        public builder address(String address) {
        	this.address = address;
        	return this;
        }
        
        
        public builder mail(String mail) {
        	this.mail = mail;
        	return this;
        }
        
        public Employee build() {
        	return new Employee(firstName, lastName, age, personalId, phone, address, mail); 
        }        
    }    
}

public class BuilderPatternDemo{
	
	public static void main(String args[]) {
		Employee employee = new Employee.builder().mail("abc@gmail.com").address("Hyderabad")
				.age(10).firstName("Mohsin").lastName("Murtuza").personalId(1).phone("9032563079").build();
		
		System.out.println(employee);
	}
}