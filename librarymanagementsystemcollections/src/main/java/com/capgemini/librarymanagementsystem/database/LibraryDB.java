package com.capgemini.librarymanagementsystem.database;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.UserBean;

public class LibraryDB {
	public static final LinkedList<BookBean> BOOKS = new LinkedList<BookBean>(); 
	public static final LinkedList<AdminBean> ADMIN = new LinkedList<AdminBean>();
	public static final LinkedList<UserBean> USER = new LinkedList<UserBean>();
	public static final LinkedList<RequestBean> REQUEST = new LinkedList<RequestBean>();
}
