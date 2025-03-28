package com.shopping;

public class Item {
 String itemname;
 int quantity;
 String units;
public String getItemname() {
	return itemname;
}
public void setItemname(String itemname) {
	this.itemname = itemname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getUnits() {
	return units;
}
public void setUnits(String units) {
	this.units = units;
}
@Override
public String toString() {
	return "item [itemname=" + itemname + ", quantity=" + quantity + ", units=" + units + "]";
}
 
}

