package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.UserBean;

public interface AdminService {
	boolean registerAdmin(AdminBean admin);
	AdminBean loginAdmin(String email,String password);
	boolean addBook(BookBean book);
	boolean removeBook(int id);
	boolean updateBook(int id);
	LinkedList<BookBean> searchBookByTitle(String bookName);
	LinkedList<BookBean> searchBookByAuthor(String author);
	LinkedList<BookBean> searchBookByCategory(String category);
	LinkedList<BookBean> getBooksInfo();

	List<UserBean> showUsers();
	List<RequestBean> showRequests();
	boolean bookIssue(UserBean user,BookBean book);
	boolean isBookReceived(UserBean user,BookBean book);
}
