package adminlogin;

public class User {
	
	private int id;  
	private String name,email,number,password,address,file,message;  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}  
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}  

}
