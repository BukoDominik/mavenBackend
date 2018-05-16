package pl.coderslab.classes;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService {
	private ArrayList<Book> list = new ArrayList<Book>();
	public ArrayList<Book> getAllBooks(){
		return this.list;
		
	}
	public Book getBookById(int id) {
		for (Book book : list) {
			if(id == book.getId()) {
				return book;
			}
		}
		return null;
		
	}
	public void editBook (Book ksiazka, int id) {
		Book book = getBookById(id);
		book.setAuthor(ksiazka.getAuthor());
		book.setIsbn(ksiazka.getIsbn());
		book.setPublisher(ksiazka.getPublisher());
		book.setTitle(ksiazka.getTitle());
		book.setType(ksiazka.getType());
	}
	public Book deleteBook (int id) {
		for (Book book : this.list) {
			if(id == book.getId()) {
				System.out.println(book);
				list.remove(book);
				return book;
			}
		}
		return null;
	}
	public Book addBook (Book book) {
		this.list.add(book);
		return null;
	}

	public MemoryBookService() {
		this.list.add(new Book(1L,"9788324631766","Thinking in Java","Bruce Eckel","Helion","programming"));
		this.list.add(new Book(2L,"9788324627738","Rusz glowa, Java.","Sierra Kathy, Bates Bert","Helion","programming"));
		this.list.add(new Book(3L,"9780130819338","Java 2. Podstawy","Cay Horstmann, Gary Cornell","Helion","programming"));
	}
	
}
