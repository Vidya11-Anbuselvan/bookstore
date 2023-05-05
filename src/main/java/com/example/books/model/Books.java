package com.example.books.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity


public class Books  
{    
@Id  
@Column  
private int bookid; 
@Column  
private String bookname;  
@Column  
private String author;  
@Column  
private int price;
@Column  
private String genre;
@Column  
private int genreId;
@Column  
private int publisherId;
@Column  
private String publisherName;
@Column  
private int authorId;
@Column  
private int rating;

@Override
public String toString() {
	return "Books [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", price=" + price + ", genre="
			+ genre + ", genreId=" + genreId + ", publisherId=" + publisherId + ", publisherName=" + publisherName
			+ ", authorId=" + authorId + ", rating=" + rating + "]";
}
public Books() {
	super();
}
public Books(int bookid, String bookname, String author, int price, String genre, int genreId, int publisherId,
		String publisherName, int authorId, int rating) {
	super();
	this.bookid = bookid;
	this.bookname = bookname;
	this.author = author;
	this.price = price;
	this.genre = genre;
	this.genreId = genreId;
	this.publisherId = publisherId;
	this.publisherName = publisherName;
	this.authorId = authorId;
	this.rating = rating;
}

public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public int getGenreId() {
	return genreId;
}
public void setGenreId(int genreId) {
	this.genreId = genreId;
}
public int getPublisherId() {
	return publisherId;
}
public void setPublisherId(int publisherId) {
	this.publisherId = publisherId;
}
public String getPublisherName() {
	return publisherName;
}
public void setPublisherName(String publisherName) {
	this.publisherName = publisherName;
}
public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}

} 
