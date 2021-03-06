package laboration1a;

import javax.swing.JOptionPane;

public class Commodity {

	private String name;
	private double price;
	private int quantity;
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString(){
		String stringToReturn = getName()+": Pris="+ getPrice()+" kr Antal="+getQuantity();
		return stringToReturn;
	}
	
	public static void main(String[] args){
		Commodity com = new Commodity();
		String txt;
		com.setName("Standardmj�lk");
		com.setPrice(8.20);
		com.setQuantity(120);
		JOptionPane.showMessageDialog( null, com.toString());
		com.setName("7-v�xlad Crescent");
		txt = String.format( "%s:  Pris=%1.2f kr  Antal=%d", com.getName(), 
		                     com.getPrice(), com.getQuantity() );
		JOptionPane.showMessageDialog( null, txt );
	}
}
