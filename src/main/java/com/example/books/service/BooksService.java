package com.example.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.books.model.Books;
import com.example.books.repository.BooksRepository;

import jakarta.transaction.Transactional;

@Service 
public class BooksService {

@Autowired
BooksRepository booksRepository;  

public List<Books> getAllBooks()   
{  
List<Books>bookList = (List<Books>) booksRepository.findAll();  

return bookList;  
}    
  
public Books saveBooks(Books u)   
{  
return booksRepository.save(u);  
}  
  
public  Books updateBook(Books s,int bookid) {
	Optional<Books> optional=booksRepository.findById(bookid);
	Books obj=null;
	if(optional.isPresent())
	{
		obj=optional.get();
		obj.setBookid(s.getBookid());
		obj.setBookname(s.getBookname());
		obj.setAuthor(s.getAuthor());
		obj.setPrice(s.getPrice());
		obj.setGenre(s.getGenre());
		obj.setGenreId(s.getGenreId());
		obj.setPublisherId(s.getPublisherId());
		obj.setPublisherName(s.getPublisherName());
		obj.setAuthorId(s.getAuthorId());
		obj.setRating(s.getRating());
		
	booksRepository.saveAndFlush(s);
	}
	return obj;	
}

public void delete(int id)   
{  
booksRepository.deleteById(id);  
}  
public Books getBooksById(int id)   
{  

return booksRepository.findById(id).get();  
}
public List<Books>sortBooks(String field)
{
	  // return studRepo.findAll(Sort.by(field));
	   return booksRepository.findAll(Sort.by(Direction.DESC,field));
}


public List<Books> pagingBooks(int num, int size) {
	Page<Books> obj= booksRepository.findAll(PageRequest.of(num, size));
	return obj.getContent();
}

public List<Books> paginate(int num, int size, String price) 
{
	Page<Books> obj=booksRepository.findAll(PageRequest.of(num, size,Sort.by(price).descending()));
	return obj.getContent();
}

public List<Books> fetchBooksByBooknamePrefix(String prefix)
{
	  return booksRepository.findByBooknameStartingWith(prefix);
}

public List<Books> fetchBooksByBooknameSuffix(String suffix)
{
	  return booksRepository.findByBooknameEndingWith(suffix);
}

public List<Books> findByAuthor(String author)
{
	  return booksRepository.findByAuthor(author);
}

public List<Books> getBooksByAuthor(String author,String bookname)
{
	  return booksRepository.getBooksByAuthor(author, bookname);
}


public List<Books> getBooksByAuthor(String author) {

	return booksRepository.getBooksByAuthor(author);
}

@Transactional
public int deleteBooksByBookname(String bookname)
{
	return booksRepository.deleteBooksByBookname(bookname);
}

@Transactional
public int updateBooksByBookname(String author,String bookname)
{
	//LOGGER 
	return booksRepository.updateBooksByBookname(author, bookname);
}

public List<Books> fetchBooksByAuthor(String author)
{
	  return booksRepository.getBooksByAuthor(author);
}
}
