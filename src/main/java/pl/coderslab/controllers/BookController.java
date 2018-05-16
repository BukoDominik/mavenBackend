package pl.coderslab.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.classes.Book;
import pl.coderslab.classes.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private MemoryBookService memoryBookService;
	private long id = 3;
	@Autowired
	public BookController(MemoryBookService mem) {
		this.memoryBookService = mem;
	}

	@RequestMapping("/hello")
	public String hello() {
		return "{hello: World}";
	}
	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L,"9788324631766","Thinking in Java","Bruce Eckel","Helion","programming");
	}
	@GetMapping
	public ArrayList<Book> allBooks() {
		return memoryBookService.getAllBooks();
	}
	@GetMapping("/{id}")
	public Book getBook(@PathVariable int id) {
		
		Book book = memoryBookService.getBookById(id);
		return book;	
	}
	@PostMapping
	public Book addBook(@RequestBody Book ksiazka) {
		System.out.println(ksiazka);
		id++;
		ksiazka.setId(id);
//		new Book(id, isbn, title, author, publisher, type);
		memoryBookService.addBook(ksiazka);
		return ksiazka;
	}
	@PutMapping("/{id}")
	public Book editBook(@RequestBody Book ksiazka, @PathVariable int id) {
		System.out.println(ksiazka);
		memoryBookService.editBook(ksiazka, id);
		return ksiazka;
	}
	@DeleteMapping("/{id}")
	public Book deleteBook(@PathVariable int id) {
		Book book = memoryBookService.deleteBook(id);
		System.out.println(id);
		return book;
	}
}
