package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.UserBean;

public interface UserDAO {
	boolean registerUser(UserBean user);
	UserBean loginUser(String email,String password);
	public RequestBean bookRequest(UserBean user, BookBean book);
	public RequestBean bookReturn(UserBean user, BookBean book);
	//Book borrowBook(int id);
	LinkedList<BookBean> searchBookByTitle(String bookName);
	LinkedList<BookBean> searchBookByAuthor(String author);
	LinkedList<BookBean> searchBookByCategory(String category);
	LinkedList<BookBean> getBooksInfo();
	
}
