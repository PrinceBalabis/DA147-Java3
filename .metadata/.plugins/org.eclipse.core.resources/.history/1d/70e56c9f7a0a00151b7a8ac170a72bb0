package p1;

public class Controller {
	private Library library;
	private Viewer viewer;
	
	public Controller(Library library, Viewer viewer){
		this.library = library;
		this.viewer = viewer;
	}
	
	public void newBook(String title, String author, String isbn){
		library.add(new Book(title,author,isbn));
	}
}
