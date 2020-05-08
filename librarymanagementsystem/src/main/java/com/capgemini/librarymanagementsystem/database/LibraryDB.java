package com.capgemini.librarymanagementsystem.database;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public class LibraryDB {
	public static final LinkedList<Book> BOOKS = new LinkedList<Book>(); 
	public static final LinkedList<Admin> ADMIN = new LinkedList<Admin>();
	public static final LinkedList<User> USER = new LinkedList<User>();
	public static final LinkedList<RequestBean> REQUEST = new LinkedList<RequestBean>();

	public static void addToDB() {

		ADMIN.add(new Admin(111111,"Amulya","Ammu@123","ammu@gmail.com",785963147));

		//USER.add(new User(111111,"ramya","ramya@gmail.com","Ramya@123","cse",7788997788,07/08/2020,02/02/2020);
		
		BOOKS.add(new Book(101010,"java","james","gosling","coding"));
		BOOKS.add(new Book(101011,"history","tom","henry feild","world"));
		BOOKS.add(new Book(101012,"angular","misko","adam","js"));
		BOOKS.add(new Book(101013,"computers","charles","aborns","programing"));

	}


}


