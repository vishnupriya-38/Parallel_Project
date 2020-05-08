package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.AdminServiceImplement;

public class AdminServiceTest {
	private AdminService service=new AdminServiceImplement();

	@Test
	public void testAddBookValid() {
		Book info = new Book();
		info.setId(12345);
		info.setBookName("javacolle");
		info.setAuthor("jamesgosling");
		info.setCategory("java");
		info.setBookName("sunmicrosystems");
		boolean status=service.addBook(info);
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
		boolean status=service.addBook(info);
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
		boolean status=service.registerAdmin(adn);
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
		boolean status=service.registerAdmin(adn);
		Assertions.assertFalse(status);
	}

	@Test
	public void testLoginAdminValid() {
		Admin info = service.loginAdmin("amulya@gmail.com", "Amulya@123");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testLoginAdminInvalid() {
		Admin info = service.loginAdmin("amulya@gmail.com", "Amulya123");
		Assertions.assertNull(info);
	}

	@Test
	public void testRemoveBookValid() {
		boolean status=service.removeBook(12345);
		Assertions.assertTrue(status);
	}

	@Test
	public void testRemoveBookInvalid() {
		boolean status=service.removeBook(12345);
		Assertions.assertFalse(status);
	}

	@Test
	public void testSearchBookByTitleValid() {
		List<Book> info = service.searchBookByTitle("javajdbc");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchBookByTitleInvalid() {
		List<Book> info = service.searchBookByTitle("RkNarayan");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchBookByAuthorValid() {
		List<Book> info = service.searchBookByAuthor("rknarayan");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchBookByAuthorInvalid() {
		List<Book> info = service.searchBookByAuthor("rknarayan");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchBookByCategoryValid() {
		List<Book> info = service.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}

	@Test
	public void testSearchByCategory1() {
		List<Book> info = service.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBookInfoValid() {
		List<Book> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testGetBookInfo1() {
		List<Book> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowUsersValid() {
		List<User> info = service.showUsers();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowUsersInvalid() {
		List<User> info = service.showUsers();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testShowRequestsValid() {
		List<RequestBean> info = service.showRequests();
		Assertions.assertNotNull(info);
	}


	@Test
	public void testShowRequests1() {
		List<RequestBean> info = service.showRequests();
		Assertions.assertNotNull(info);
	}

	@Test
	public void testBookIssueValid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = service.bookIssue(user, book);
		Assertions.assertTrue(check);

	}

	@Test
	public void testBookIssueInvalid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = service.bookIssue(user, book);
		Assertions.assertFalse(check);

	}

	@Test
	public void isBookReceivedValid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = service.isBookReceived(user, book);
		Assertions.assertTrue(check);

	}

	@Test
	public void isBookReceivedInvalid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		boolean check = service.isBookReceived(user, book);
		Assertions.assertFalse(check);

	}


}
