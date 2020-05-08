package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemjdbc.service.StudentService;
import com.capgemini.librarymanagementsystemjdbc.service.StudentServiceImplement;

public class StudentServiceTest {
private StudentService service = new StudentServiceImplement();
	
	@Test
	public void testRequestValid() {
		boolean check = service.request(100002, 105);
		Assertions.assertTrue(check);		
	}
	
	@Test
	public void testRequestInvalid() {
		boolean check = service.request(100002, 109);
		Assertions.assertFalse(check);		
	}
	
	@Test
	public void testBorrowedBooksValid() {
		List<BorrowedBooks> info = service.borrowedBook(100002);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
	}
	
	@Test
	public void testBorrowedBooksInvalid() {
		List<BorrowedBooks> info = service.borrowedBook(100002);
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(6, info.size());
	}
	
	@Test
	public void testReturnBookValid() {
		boolean check = service.returnBook(105, 100002, "yes");
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testReturnBookInvalid() {
		boolean check = service.returnBook(105, 100002, "yes");
		Assertions.assertFalse(check);
	}



}
