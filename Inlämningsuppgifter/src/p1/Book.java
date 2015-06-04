package p1;

public class Book {
	private String title;
	private String author;
	private String isbn;

	public Book(String title, String author, String isbn){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String getIsbn(){
		return isbn;
	}

	public String toString(){
		String stringToReturn = title+", "+author+", ISBN: "+isbn;
		return stringToReturn;
	}

	public int compareTo(Book otherBook){
		return Integer.compare(Integer.parseInt(this.isbn), Integer.parseInt(otherBook.getIsbn()));
	}


	public static void main(String[] args) {
		Book book1 = new Book("En oväntad semester", "Keyes", "9176436314");
		Book book2 = new Book("How to Program", "Deitel", "0131290142");
		System.out.println(book1.getTitle());
		System.out.println(book1.getAuthor());
		System.out.println(book1.getIsbn());
		System.out.println(book2.toString());
	}

}
