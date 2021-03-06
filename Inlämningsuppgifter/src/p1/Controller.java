package p1;

public class Controller {
	private Library library;
	private Viewer viewer;
	
	public Controller(Library library, Viewer viewer){
		this.library = library;
		this.viewer = viewer;
		
		// Visar till böcker i library i viewern
		Book[] books = library.list();
		for(int i=0; i<books.length; i++)
			viewer.addRow(books[i].toString());
	}
	
	public void newBook(String title, String author, String isbn){
		Book bookToAdd = new Book(title,author,isbn);
		library.add(bookToAdd);
		viewer.addRow(bookToAdd.toString());
	}
}
