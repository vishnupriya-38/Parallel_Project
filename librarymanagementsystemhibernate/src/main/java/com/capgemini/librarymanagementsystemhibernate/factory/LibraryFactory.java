package com.capgemini.librarymanagementsystemhibernate.factory;

import com.capgemini.librarymanagementsystemhibernate.dao.AdminDAO;
import com.capgemini.librarymanagementsystemhibernate.dao.AdminDAOImplement;
import com.capgemini.librarymanagementsystemhibernate.dao.StudentDAO;
import com.capgemini.librarymanagementsystemhibernate.dao.StudentDAOImplement;
import com.capgemini.librarymanagementsystemhibernate.dao.UsersDAO;
import com.capgemini.librarymanagementsystemhibernate.dao.UsersDAOImplement;
import com.capgemini.librarymanagementsystemhibernate.service.AdminService;
import com.capgemini.librarymanagementsystemhibernate.service.AdminServiceImplement;
import com.capgemini.librarymanagementsystemhibernate.service.StudentService;
import com.capgemini.librarymanagementsystemhibernate.service.StudentServiceImplement;
import com.capgemini.librarymanagementsystemhibernate.service.UsersService;
import com.capgemini.librarymanagementsystemhibernate.service.UsersServiceImplement;

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
