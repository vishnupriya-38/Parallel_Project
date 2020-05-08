package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface UserDAO {
	boolean registerUser(User user);
	User loginUser(String email,String password);
	public RequestBean bookRequest(User user, Book book);
	public RequestBean bookReturn(User user, Book book);
	List<Book> searchBookByTitle(String bookName);
	List<Book> searchBookByAuthor(String author);
	List<Book> searchBookByCategory(String category);
	List<Book> getBooksInfo();
	
}
