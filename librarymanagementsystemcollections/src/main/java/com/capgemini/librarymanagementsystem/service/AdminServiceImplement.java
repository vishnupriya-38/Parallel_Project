package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.UserBean;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;

public class AdminServiceImplement implements AdminService{
	private AdminDAO dao = LibraryFactory.getAdminDao();

	@Override
	public boolean registerAdmin(AdminBean admin) {
		return dao.registerAdmin(admin);
	}

	@Override
	public AdminBean loginAdmin(String email, String password) {
		return dao.loginAdmin(email, password);
	}

	@Override
	public boolean addBook(BookBean book) {
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int id) {
		return dao.removeBook(id);
	}

	@Override
	public boolean updateBook(int id) {
		return dao.updateBook(id);
	}

	@Override
	public LinkedList<BookBean> searchBookByTitle(String bookName) {
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public LinkedList<BookBean> searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public LinkedList<BookBean> searchBookByCategory(String category) {
		return dao.searchBookByCategory(category);
	}

	@Override
	public LinkedList<BookBean> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public List<UserBean> showUsers() {
		return dao.showUsers();
	}

	@Override
	public List<RequestBean> showRequests() {
		return dao.showRequests();
	}

	@Override
	public boolean bookIssue(UserBean user, BookBean book) {
		return dao.bookIssue(user, book);
	}

	@Override
	public boolean isBookReceived(UserBean user, BookBean book) {
		return dao.isBookReceived(user, book);
	}

	
	
}
