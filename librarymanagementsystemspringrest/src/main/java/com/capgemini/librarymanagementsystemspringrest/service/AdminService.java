package com.capgemini.librarymanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookIssueBean;
import com.capgemini.librarymanagementsystemspringrest.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UsersBean;

public interface AdminService {
	boolean addBook(BookBean book);
	boolean removeBook(int bId);
	boolean updateBook(BookBean book);
	boolean issueBook(int bId,int uId);
	List<Integer> bookHistoryDetails(int uId);
	List<RequestDetailsBean> showRequests();
	List<BookIssueBean> showIssuedBooks();
	List<UsersBean> showUsers();

}
