package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dao.UserDAOImplement;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public class UserDAOTest {

	private UserDAO dao=new UserDAOImplement();
	

	@Test
	public void testRegisterStudentValid() {
		User info=new User();
		info.setId(78965);
		info.setName("shiva");
		info.setEmail("shiva@gmail.com");
		info.setPassword("Shiva@123");
		info.setDepartment("ECE");
		info.setPhone(987582645);
		boolean status=dao.registerUser(info);
		Assertions.assertTrue(status);
	}

	@Test
	public void testRegisterStudentInvalid() {
		User info=new User();
		info.setId(78965);
		info.setName("shiva");
		info.setEmail("shiva@gmail.com");
		info.setPassword("Shiva@123");
		info.setDepartment("ECE");
		info.setPhone(987582645);
		boolean status=dao.registerUser(info);
		Assertions.assertFalse(status);
	}
	@Test
	public void testLoginUserValid() {
		User status = dao.loginUser("shiva@gmail.com", "Shiva@123");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testLoginUserInvalid() {
		User status = dao.loginUser("shiva@gmail.com", "Shiva123");
		Assertions.assertNull(status);
	}

	@Test
	public void testRequestBookValid() {

		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		RequestBean info = dao.bookRequest(user, book);
		Assertions.assertNotNull(info);

	}

	@Test
	public void testRequestBookInvalid() {

		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		RequestBean info = dao.bookRequest(user, book);
		Assertions.assertNull(info);

	}

	@Test
	public void testBookReturnValid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		RequestBean info = dao.bookReturn(user, book);
		Assertions.assertNotNull(info);

	}

	@Test
	public void testBookReturnInvalid() {
		User user = new User();
		user.setId(222222);
		Book book = new Book();
		book.setId(100002);
		RequestBean info = dao.bookReturn(user, book);
		Assertions.assertNull(info);

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
}
