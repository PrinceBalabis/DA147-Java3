package laboration1a;

import javax.swing.JOptionPane;

public class Book {

	private String name;
	private String author;
	private int nbrOfPages;

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public int getNbrOfPages() {
		return nbrOfPages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setNbrOfPages(int nbrOfPages) {
		this.nbrOfPages = nbrOfPages;
	}

	public String toString(){
		String stringToReturn = getName() +" - "+getAuthor()+", contains "+getNbrOfPages()+" pages";
		return stringToReturn;
	}

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.setName("book1");
		book1.setAuthor("author1");
		book1.setNbrOfPages(100);
		JOptionPane.showMessageDialog(null, book1.toString());
		
		Book book2 = new Book();
		book2.setName("book2");
		book2.setAuthor("author2");
		book2.setNbrOfPages(200);
		JOptionPane.showMessageDialog(null, book2.toString());

	}

}
