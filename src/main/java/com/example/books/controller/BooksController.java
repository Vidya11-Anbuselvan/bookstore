package com.example.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.model.Books;

import com.example.books.service.BooksService;

@RestController
public class BooksController {

	@Autowired  
	BooksService booksService;  
	  
	@GetMapping(value="/book")  
	public List<Books> getAllBooks()   
	{ 
		List<Books>bookList=booksService.getAllBooks();
	return bookList;  
	}  
	 
	@GetMapping(value="/book/{bookid}")  
	public Books getBooks(@PathVariable("bookid") int bookid)   
	{  
	return booksService.getBooksById(bookid);  
	}  
  
	@DeleteMapping(value="/book/{bookid}")  
	public void deleteBook(@PathVariable("bookid") int bookid)   
	{  
	booksService.delete(bookid);  
	}  
	 
	@PostMapping(value="/books")  
	public Books saveBooks(@RequestBody Books u)   
	{  
	
	return booksService.saveBooks(u);  
	}  
	   
	@PutMapping(value="/updateBooks/{bookid}")
	public  Books updateBook(@RequestBody Books u, @PathVariable int bookid)
	{
		return booksService.updateBook(u,bookid);
	} 
	
	    //http://localhost:8080/sortbooks/bookname
		@GetMapping("/sortbooks/{field}")
		public List<Books>sortBooks(@PathVariable String field)
		{
			return booksService.sortBooks(field);
		}
		
		
		//http://localhost:8080/pagingBooks/1/2
		@GetMapping("/pagingBooks/{offset}/{pageSize}")
		public List<Books>pagingBooks(@PathVariable("offset") int num,@PathVariable("pageSize") int size)
		{
			return booksService.pagingBooks(num,size);
		}
		
		
		//http://localhost:8080/pagination/2/3/bookname
		@GetMapping("pagination/{nm}/{sp}/{inr}")
		public List<Books> paginate(@PathVariable("nm") int num,@PathVariable("sp") int size,@PathVariable("inr") String name)
		{
			return booksService.paginate(num,size,name);
		}
		
		//http://localhost:8080/fetchBooksByBooknamePrefix?prefix=p
		@GetMapping("/fetchBooksByBooknamePrefix")
		public List<Books> fetchBooksByBooknamePrefix(@RequestParam String prefix)
		{
			  return booksService.fetchBooksByBooknamePrefix(prefix);
		}
		
		//http://localhost:8080/fetchBooksByBooknameSuffix?suffix=a
		@GetMapping("/fetchBooksByBooknameSuffix")
		public List<Books> fetchBooksByBooknameSuffix(@RequestParam String suffix)
		{
	     	 return booksService.fetchBooksByBooknameSuffix(suffix);
	    }
		
		//http://localhost:8080/findBooksByAuthor?author=Kalki
		@GetMapping("/findBooksByAuthor")
		public List<Books> findByAuthor(@RequestParam String author)
		{
	    	 return booksService.findByAuthor(author);
	    }
		
		//http://localhost:8080/fetchBooksByAuthor/Kalki/Ponniyin Selvan
		@GetMapping("/fetchBooksByAuthor/{author}/{bookname}")
		public List<Books> getBooksByAuthor(@PathVariable 
				String author,@PathVariable String bookname)
		{
			return booksService.getBooksByAuthor(author, bookname);
		}
		
		
		//http://localhost:8080/fetchBooksByAuthor?author=Kalki
		@GetMapping("/fetchBooksByAuthor")
		public List<Books>getBooksByAuthor(@RequestParam String author)
		{
			return booksService.getBooksByAuthor(author);
		}
		
		//http://localhost:8080/deleteBooksByBookname?bookname=aaa
		@DeleteMapping("/deleteBooksByBookname")
		public String deleteBooksByBookname(String bookname)
		{
			int result=booksService.deleteBooksByBookname(bookname);
			if(result>0)
				
				return "Book record deleted";
			
			else
				
				return "Problem occured while deleting";
		}
		
		//http://localhost:8080/updateBooksByBookname/Kalki/Ponniyin Selvan
		@PutMapping("/updateBooksByBookname/{author}/{bookname}")
	    public int updateBooksByBookname(@PathVariable String author,@PathVariable String bookname)
	    {
	 		    return booksService.updateBooksByBookname(author,bookname);
	    }
		
		//http://localhost:8080/fetchBooksByAuthor/Kalki
		@GetMapping("/fetchBooksByAuthor/{author}")
		public List<Books>fetchBooksByAuthor(@PathVariable String author)
		{
			return booksService.fetchBooksByAuthor(author);
		}
}