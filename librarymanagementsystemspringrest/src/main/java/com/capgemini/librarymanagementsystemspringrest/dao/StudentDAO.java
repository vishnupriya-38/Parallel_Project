package com.capgemini.librarymanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemspringrest.dto.BorrowedBooksBean;

public interface StudentDAO {
	List<BorrowedBooksBean> borrowedBook(int uId);
	boolean request(int uId, int bId);
	boolean returnBook(int bId,int uId,String status);
}
