package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAOImplement;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public class AdminDAOTest {
	
	private AdminDAO dao = new AdminDAOImplement();
	
	@Test
	public void testAddBookValid() {
		BookBean bean = new BookBean();
		bean.setBId(105);
		bean.setBookName("Java");
		bean.setAuthor("James");
		bean.setCategory("Programing");
		bean.setPublisher("Arihent");
		boolean check = dao.addBook(bean);
		Assertions.assertTrue(check);
	}
	@Test
	public void testAddBookInvalid() {
		BookBean bean = new BookBean();
		bean.setBId(105);
		bean.setBookName("Java");
		bean.setAuthor("James");
		bean.setCategory("Programing");
		bean.setPublisher("Arihent");
		boolean check = dao.addBook(bean);
		Assertions.assertFalse(check);	
	} 
	
	@Test
	public void testRemoveBookValid() {
		boolean check = dao.removeBook(105);
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testRemoveBookInvalid() {
		boolean check = dao.removeBook(107);
		Assertions.assertFalse(check);
	}
	
	@Test
	public void testUpdateBookValid() {
		BookBean book = new BookBean();
		book.setBId(104);
		book.setBookName("Maths");
		boolean check = dao.updateBook(book);
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testUpdateBookInvalid() {
		BookBean book = new BookBean();
		book.setBId(109);
		book.setBookName("Maths");
		boolean check = dao.updateBook(book);
		Assertions.assertFalse(check);
	}
	
	@Test
	public void testIssueBookValid() {
		boolean check = dao.issueBook(105, 100002);
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testIssueBookInvalid() {
		boolean check = dao.issueBook(109, 100002);
		Assertions.assertFalse(check);
	}
	
	@Test
	public void testBookHistoryDetailsValid() {
		List<BookIssueDetails> info = dao.bookHistoryDetails(100002);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testBookHistoryDetailsInvalid() {
		List<BookIssueDetails> info = dao.bookHistoryDetails(100003);
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(0, info.size());		
	}
	
	@Test
	public void testShowRequestsValid() {
		List<RequestDetails> info = dao.showRequests();
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testShowRequestsInvalid() {
		List<RequestDetails> info = dao.showRequests();
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(2, info.size());		
	}
	
	@Test
	public void testShowIssuedBooksValid() {
		List<BookIssueDetails> info = dao.showIssuedBooks();
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testShowIssuedBooksInvalid() {
		List<BookIssueDetails> info = dao.showIssuedBooks();
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(2, info.size());		
	}
	
	@Test
	public void testShowUsersValid() {
		List<UsersBean> info = dao.showUsers();
		Assertions.assertNotNull(info);
		Assertions.assertEquals(4, info.size());		
	}
	
	@Test
	public void testShowUsersInvalid() {
		List<UsersBean> info = dao.showUsers();
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(2, info.size());		
	}
}
