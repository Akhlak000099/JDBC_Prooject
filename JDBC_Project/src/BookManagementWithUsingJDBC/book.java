package BookManagementWithUsingJDBC;

public class book {
// here used protected access modifyer for variables
protected static String title;
protected static String author;
protected static String category;
protected static float price;

// here have get or setter method start
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
// end os get or setter method

// we used constuctor with perameterized
public book(String title, String author, String category, float price) {
	super();
	this.title = title;
	this.author = author;
	this.category = category;
	this.price = price;
}
}
