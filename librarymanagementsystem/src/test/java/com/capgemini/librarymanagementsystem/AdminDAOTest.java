package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.AdminDAOImplement;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public class AdminDAOTest {

	private AdminDAO dao=new AdminDAOImplement();
	
	@Test
	public void testAddBookValid() {
		Book info = new Book();
		info.setId(12345);
		info.setBookName("javacolle");
		info.setAuthor("jamesgosling");
		info.setCategory("java");
		info.setBookName("sunmicrosystems");
		boolean status=dao.addBook(info);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testAddBookInvalid() {
		Book info = new Book();
		info.setId(12345);
		info.setBookName("javacolle");
		info.setAuthor("jamesgosling");
		info.setCategory("java");
		info.setBookName("sunmicrosystems");
		boolean status=dao.addBook(info);
		Assertions.assertFalse(status);
	}
	@Test
	public void testRegisterAdminValid() {
		Admin adn=new Admin();
		adn.setId(123445);
		adn.setName("amulya");
		adn.setMobile(994920634);
		adn.setEmail("amulya@gmail.com");
		adn.setPassword("Amulya@123");
		boolean status=dao.registerAdmin(adn);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRegisterAdminInvalid() {
		Admin adn=new Admin();
		adn.setId(123445);
		adn.setName("amulya");
		adn.setMobile(994920634);
		adn.setEmail("amulya@gmail.com");
		adn.setPassword("Amulya@123");
		boolean status=dao.registerAdmin(adn);
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testLoginAdminValid() {
		Admin info = dao.loginAdmin("amulya@gmail.com", "Amulya@123");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testLoginAdminInvalid() {
		Admin info = dao.loginAdmin("amulya@gmail.com", "Amulya123");
		Assertions.assertNull(info);
	}
	
	@Test
	public void testRemoveBookValid() {
		boolean status=dao.removeBook(12345);
		Assertions.assertTrue(status);
	}
	
	@Test
	public void testRemoveBookInvalid() {
		boolean status=dao.removeBook(12345);
		Assertions.assertFalse(status);
	}
	
	@Test
	public void testSearchBookByTitleValid() {
		List<Book> info = dao.searchBookByTitle("javajdbc");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testSearchBookByTitleInvalid() {
		List<Book> info = dao.searchBookByTitle("RkNarayan");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchBookByAuthorValid() {
		List<Book> info = dao.searchBookByAuthor("rknarayan");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testSearchBookByAuthorInvalid() {
		List<Book> info = dao.searchBookByAuthor("rknarayan");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testSearchBookByCategoryValid() {
		List<Book> info = dao.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testSearchBookByCategoryInvalid() {
		List<Book> info = dao.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBookInfoValid() {
		List<Book> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testGetBookInfoInvalid() {
		List<Book> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testShowUsersValid() {
		List<User> info = dao.showUsers();
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testShowUsersInvalid() {
		List<User> info = dao.showUsers();
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testShowRequestsValid() {
		List<RequestBean> info = dao.showRequests();
		Assertions.assertNotNull(info);
	}
	

	@Test
	public void testShowRequests1() {
		List<RequestBean> info = dao.showRequests();
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testBookIssueValid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = dao.bookIssue(user, book);
		Assertions.assertTrue(check);
		
	}

	@Test
	public void testBookIssueInvalid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = dao.bookIssue(user, book);
		Assertions.assertFalse(check);
		
	}
	
	@Test
	public void isBookReceivedValid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = dao.isBookReceived(user, book);
		Assertions.assertTrue(check);
		
	}
	
	@Test
	public void isBookReceivedInvalid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = dao.isBookReceived(user, book);
		Assertions.assertFalse(check);
		
	}
}
	
