package com.capgemini.librarymanagementsystemspringrest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystemspringrest.dao.UsersDAO;
import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UsersBean;

public class UserDAOTest {
	@Autowired
	private UsersDAO dao;
	
	@Test
	public void testRegisterValid() {
		UsersBean bean = new UsersBean();
		bean.setFirstName("Sridhar");
		bean.setLastName("Bendhi");
		bean.setEmail("sridhar@gmail.com");
		bean.setPassword("Sridhar@123");
		bean.setRole("student");
		boolean check = dao.register(bean);
		Assertions.assertTrue(check);		
	}
	
	@Test
	public void testRegisterInvalid() {
		UsersBean bean = new UsersBean();
		bean.setFirstName("Sridhar");
		bean.setLastName("Bendhi");
		bean.setEmail("sridhar@gmail.com");
		bean.setPassword("Sridhar@123");
		bean.setRole("student");
		boolean check = dao.register(bean);
		Assertions.assertFalse(check);
	}

	@Test
	public void testLoginValid() {
		UsersBean info = dao.login("ammu@gmail.com", "ammU@123");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testLoginInvalid() {
		UsersBean info = dao.login("ammu@gmail.com", "ammU123");
		Assertions.assertNull(info);
	}
	
	@Test
	public void testSearchBookByIdValid() {
		List<BookBean> info = dao.searchBookById(101);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
		
	}
	
	@Test
	public void testSearchBookByIdInvalid() {
		List<BookBean> info = dao.searchBookById(109);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleValid() {
		List<BookBean> info = dao.searchBookByTitle("MM");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleInvalid() {
		List<BookBean> info = dao.searchBookByTitle("Maths");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorValid() {
		List<BookBean> info = dao.searchBookByAuthor("sharma");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorInvalid() {
		List<BookBean> info = dao.searchBookByAuthor("Jain");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());	
	}
	
	@Test
	public void testBooksInfoValid() {
		List<BookBean> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertEquals(5, info.size());
	}
	
	@Test
	public void testBooksInfoInvalid() {
		List<BookBean> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(6, info.size());
	}
	
	@Test
	public void testUpdatePasswordValid() {
		boolean check = dao.updatePassword(100102, "ammU@123", "Admin@123", "admin");
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testUpdatePasswordInvalid() {
		boolean check = dao.updatePassword(100102, "ammU@123", "Admin@123", "student");
		Assertions.assertFalse(check);
	}
	
}
