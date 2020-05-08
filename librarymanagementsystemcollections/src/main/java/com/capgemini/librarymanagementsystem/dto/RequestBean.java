package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class RequestBean implements Serializable{
	private BookBean bookInfo;
	private UserBean userInfo;
	private boolean isIssued;
	private boolean isReturned;
	private LocalDate issuedDate;
	private LocalDate returnedDate;
	public BookBean getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookBean bookInfo) {
		this.bookInfo = bookInfo;
	}
	public UserBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserBean userInfo) {
		this.userInfo = userInfo;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	public LocalDate getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

}
