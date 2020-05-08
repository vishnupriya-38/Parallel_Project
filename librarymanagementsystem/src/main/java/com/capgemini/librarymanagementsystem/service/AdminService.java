package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface AdminService {
	boolean registerAdmin(Admin admin);
	Admin loginAdmin(String email,String password);
	boolean addBook(Book book);
	boolean removeBook(int id);
	List<Book> searchBookByTitle(String bookName);
	List<Book> searchBookByAuthor(String author);
	List<Book> searchBookByCategory(String category);
	List<Book> getBooksInfo();

	List<User> showUsers();
	List<RequestBean> showRequests();
	boolean bookIssue(User user,Book book);
	boolean isBookReceived(User user,Book book);
}
