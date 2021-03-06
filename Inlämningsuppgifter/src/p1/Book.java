package p1;

/**
 * Book class som används för att skapa book-objects.
 * En Book har en titel, författare och ISBN-nummer
 * @author Prince
 *
 */
public class Book implements Comparable <Book>  {
	private String title;
	private String author;
	private String isbn;

	/**
	 * 
	 * Konstruktor som tar emot titel, författare och ISBN-nummer
	 * till en bok
	 * 
	 * @param title Titel för boken
	 * @param author Författare till boken
	 * @param isbn Bokens ISBN-nummer
	 */
	public Book(String title, String author, String isbn){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	/**
	 * Returnerar bokens titel
	 * @return titel till boken
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Returnerar bokens författare
	 * @return författare till boken
	 */
	public String getAuthor(){
		return author;
	}
	
	/**
	 * Returnerar bokens ISBN-nummer
	 * @return ISBN-nummer till boken
	 */
	public String getIsbn(){
		return isbn;
	}

	/**
	 * Returnerar sträng med bokens titel, författare och ISBN-nummer
	 * @return titel, författare och ISBN-nummer
	 */
	public String toString(){
		String stringToReturn = title+", "+author+", ISBN: "+isbn;
		return stringToReturn;
	}

	/**
	 * Jämför en boks ISBN-nummer mottagen i parametern med denna boken
	 * och returnerar resultatet. Används för sortering av böcker.
	 * @return titel, författare och ISBN-nummer
	 */
	public int compareTo(Book otherBook){
		return Double.compare(Double.parseDouble(this.isbn), Double.parseDouble(otherBook.getIsbn()));
	}

	// main metod för prövning av klassen
	public static void main(String[] args) {
		Book book1 = new Book("En oväntad semester", "Keyes", "9176436314");
		Book book2 = new Book("How to Program", "Deitel", "0131290142");
		System.out.println(book1.getTitle());
		System.out.println(book1.getAuthor());
		System.out.println(book1.getIsbn());
		System.out.println(book2.toString());
	}

}
