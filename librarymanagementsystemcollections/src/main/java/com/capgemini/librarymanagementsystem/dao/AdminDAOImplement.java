package com.capgemini.librarymanagementsystem.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.LibraryDB;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.UserBean;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class AdminDAOImplement implements AdminDAO{

	@Override
	public boolean registerAdmin(AdminBean admin) {
		for(AdminBean ad : LibraryDB.ADMIN) {
			if(ad.getEmail().equals(admin.getEmail())) {
				return false;
			}
		}
		LibraryDB.ADMIN.add(admin);
		return true;
	}

	@Override
	public AdminBean loginAdmin(String email, String password) {
		for(AdminBean admin : LibraryDB.ADMIN) {
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
				return admin;
			}
		}
		throw new LMSException("Invalid credentials");

	}

	@Override
	public boolean addBook(BookBean book) {
		for(BookBean b : LibraryDB.BOOKS) {
			if(b.getId()==book.getId()) {
				return false;
			}
		}
		LibraryDB.BOOKS.add(book);
		return true;
	}

	@Override
	public boolean removeBook(int id) {
		boolean removeStatus=false;
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBean retrievedBook=LibraryDB.BOOKS.get(i);
			int retrievedId=retrievedBook.getId();
			if(id==retrievedId)
			{
				removeStatus=true;
				LibraryDB.BOOKS.remove(i);
				break;
			}
		}
		return removeStatus;
	}

	@Override
	public boolean updateBook(int id) {
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBean retrievedBook=LibraryDB.BOOKS.get(i);
			int retrievedId=retrievedBook.getId();
			if(id==retrievedId)
			{
				break;
			}
		}
		throw new LMSException("Book not updated");
	}

	@Override
	public LinkedList<BookBean> searchBookByTitle(String bookName) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBean retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedBookName=retrievedBook.getBookName();
			if(bookName.equals(retrievedBookName))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}

	}

	@Override
	public LinkedList<BookBean> searchBookByAuthor(String author) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBean retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedBookAuthor=retrievedBook.getAuthor();
			if(author.equals(retrievedBookAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}		

	}

	@Override
	public LinkedList<BookBean> getBooksInfo() {
		return LibraryDB.BOOKS;
	}

	@Override
	public LinkedList<BookBean> searchBookByCategory(String category) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBean retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedCategory=retrievedBook.getCategory();
			if(category.equals(retrievedCategory))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}	
	}

	@Override
	public List<UserBean> showUsers() {
		List<UserBean> usersList = new LinkedList<UserBean>();
		for (UserBean userBean : LibraryDB.USER) {

			userBean.getId();
			userBean.getName();
			userBean.getEmail();
			userBean.getBooksBorrowed();
			usersList.add(userBean);

		}
		return usersList;
	}

	@Override
	public List<RequestBean> showRequests() {
		List<RequestBean> info = new LinkedList<RequestBean>();
		for (RequestBean requestInfo : LibraryDB.REQUEST) {
			requestInfo.getBookInfo();
			requestInfo.getUserInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			info.add(requestInfo);
		}
		return info;
	}

	@Override
	public boolean bookIssue(UserBean user, BookBean book) {
		boolean isValid = false;

		RequestBean requestInfo = new RequestBean();

		int noOfBooksBorrowed = user.getBooksBorrowed();
		for (RequestBean info : LibraryDB.REQUEST) {
			if (info.getUserInfo().getId() == user.getId()) {
				if (info.getBookInfo().getId() == book.getId()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)
		{
			for (BookBean info2 : LibraryDB.BOOKS) {
				if (info2.getId() == book.getId()) {
					book = info2;
				}
			}

			for (UserBean userInfo : LibraryDB.USER) {
				if (userInfo.getId() == user.getId()) {
					user = userInfo;
					noOfBooksBorrowed = user.getBooksBorrowed();

				}
			}

			if (noOfBooksBorrowed < 3) {

				boolean isRemoved = LibraryDB.BOOKS.remove(book);
				if (isRemoved) {

					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					user.setBooksBorrowed(noOfBooksBorrowed);
					// DataBase.REQUESTDB.remove(requestInfo);
					requestInfo.setIssued(true);
					return true;
				} else {
					throw new LMSException("Book can't be borrowed");
				}

			} else {
				throw new LMSException("Student Exceeds maximum limit");
			}

		} else {
			throw new LMSException("Book data or Student data is incorrect");
		}
	}

	@Override
	public boolean isBookReceived(UserBean user, BookBean book) {
		boolean isValid = false;
		RequestBean requestInfo1 = new RequestBean();
		for (RequestBean requestInfo : LibraryDB.REQUEST) {

			if (requestInfo.getBookInfo().getId() == book.getId()
					&& requestInfo.getUserInfo().getId() == user.getId() 
					&& requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
			}
		}
		if (isValid) {

			book.setAuthor(requestInfo1.getBookInfo().getAuthor());
			book.setBookName(requestInfo1.getBookInfo().getBookName());
			LibraryDB.BOOKS.add(book);
			LibraryDB.REQUEST.remove(requestInfo1);


			for (UserBean userInfo2 : LibraryDB.USER) {
				if (userInfo2.getId() == user.getId()) {
					user = userInfo2;
				}
			}
			int noOfBooksBorrowed = user.getBooksBorrowed();
			noOfBooksBorrowed--;
			user.setBooksBorrowed(noOfBooksBorrowed);
			return true;
		}
		return false;
	}
}


