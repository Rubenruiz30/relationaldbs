package relationaldbs.model;

public class Products {
private String name;
private String size;
public String price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;

}
public  Products(String name, String size, String price) {
	this.name = name;
	this.price = price;
	this.size = size;
	
}


}
