package StudentProjectByUsingJDBC;

public class student {
protected static String name;
protected static String ph;
protected static String address;
protected static String email;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPh() {
	return ph;
}
public void setPh(String ph) {
	this.ph = ph;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public student(String name, String ph, String address, String email) {
	super();
	this.name = name;
	this.ph = ph;
	this.address = address;
	this.email = email;
}
	
}
