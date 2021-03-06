package p1;

import java.util.Arrays;

public class Library {
	private Book[] books;
	private int size; // antal Book-objekt som lagras i books-arrayen

	public Library(int capacity) {
		books = new Book[capacity];
		size = 0;
	}

	public void add(Book bookToAdd){
		books[size] = bookToAdd;
		size++;
		Arrays.sort(books, 0, size);
	}
	
	public int size(){
		return size;
	}
	
	public Book[] list(){
		Book[] bookList = new Book[size];
		for (int i = 0; i < size; i++) {
			bookList[i] = books[i];
		}
		return bookList;
	}
	
	public String toString(){
		String stringToReturn = "Bibliotek med "+size+" böcker";
		return stringToReturn;
	}
	
	public static void main(String[] args) {
		String res="";
		Library library = new Library(100); // Max 100 böcker kan lagras
		library.add(new Book("En oväntad semester", "Keyes", "9176436314"));
		library.add(new Book("How to Program", "Deitel", "0131290142"));
		library.add(new Book("Testamentet", "Grisham", "9176437175"));
		library.add(new Book("Legionärerna", "Enquist", "9174483463"));
		res += "Antal lagrade böcker: " + library.size();
		res += "\n" + library.toString();
		Book[] books = library.list();
		res += "\nKapacitet på böcker: " + books.length;
		for(int i=0; i<books.length; i++)
			res += "\n" + books[i].toString();
		javax.swing.JOptionPane.showMessageDialog(null, res);
	}
}
