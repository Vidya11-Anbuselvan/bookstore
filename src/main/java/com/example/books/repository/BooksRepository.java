package com.example.books.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.books.model.Books;  
   
@Repository
public interface BooksRepository extends JpaRepository<Books,Integer>
{
	
	//jpa derived queries
	List<Books> findByBooknameStartingWith(String prefix);
	List<Books> findByBooknameEndingWith(String suffix);
	List<Books> findByAuthor(String author);
	
	
 //positional parameter,order should match
@Query("select s from Books s where s.author=?1 and s.bookname=?2" )
public List<Books> getBooksByAuthor(String author,String bookname);

//named parameter
@Query("select s from Books s where s.author=:author")
public List<Books>getBooksByAuthor(String author);

//DML
@Modifying
@Query("delete from Books s where s.bookname=?1")
public int deleteBooksByBookname(String bookname);

@Modifying
@Query("update Books s set s.author=?1 where s.bookname=?2")
public int updateBooksByBookname(String author,String bookname);

@Query(value="select * from Student s where s.dept=?",nativeQuery=true)
public List<Books>fetchBooksByAuthor(String author);
}
