package com.capgemini.librarymanagementsystemjdbc.factory;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAOImplement;
import com.capgemini.librarymanagementsystemjdbc.dao.StudentDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.StudentDAOImplement;
import com.capgemini.librarymanagementsystemjdbc.dao.UsersDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.UsersDAOImplement;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.AdminServiceImplement;
import com.capgemini.librarymanagementsystemjdbc.service.StudentService;
import com.capgemini.librarymanagementsystemjdbc.service.StudentServiceImplement;
import com.capgemini.librarymanagementsystemjdbc.service.UsersService;
import com.capgemini.librarymanagementsystemjdbc.service.UsersServiceImplement;

public class LibraryFactory {
	public static UsersDAO getUsersDao() {
		return new UsersDAOImplement();
	}
	public static UsersService getUsersService() {
		return new UsersServiceImplement();
	}
	
	public static AdminDAO getAdminDao() {
		return new AdminDAOImplement();
	}
	public static AdminService getAdminService() {
		return new AdminServiceImplement();
	}
	
	public static StudentDAO getStudentDao() {
		return new StudentDAOImplement();
	}
	public static StudentService getStudentService() {
		return new StudentServiceImplement();
	}
}
