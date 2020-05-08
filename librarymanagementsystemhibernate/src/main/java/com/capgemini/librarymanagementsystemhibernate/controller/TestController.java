package com.capgemini.librarymanagementsystemhibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssueBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.exception.LMSException;
import com.capgemini.librarymanagementsystemhibernate.factory.LibraryFactory;
import com.capgemini.librarymanagementsystemhibernate.service.AdminService;
import com.capgemini.librarymanagementsystemhibernate.service.StudentService;
import com.capgemini.librarymanagementsystemhibernate.service.UsersService;
import com.capgemini.librarymanagementsystemhibernate.validation.Validation;


public class TestController {
	public static void doReg() {
		boolean flag = false;

		String regFirstName = null; 
		String regLastName = null; 
		long regMobile = 0;
		String regEmail = null;
		String regPassword = null;
		
		String addAuthor = null; 
		String addName = null;
		String addCategory = null;
		String addPublisher = null;


		boolean loginStatus = true;
		Validation validation = new Validation();
		do {
			try(Scanner scanner = new Scanner(System.in);){
				System.out.println("**LIBRARY MANAGEMENT SYSTEM**");
				System.out.println("Press 1 to Register");
				System.out.println("Press 2 to Login");
				System.out.println("Press 3 to EXIT");
				do {
					try {
						UsersService service1= LibraryFactory.getUsersService();
						AdminService service2 = LibraryFactory.getAdminService();
						StudentService service3 = LibraryFactory.getStudentService();
						int choice = scanner.nextInt();
						switch(choice) {
						case 1:
							
							do {
								try {
									System.out.println("Enter First Name :");
									regFirstName = scanner.next();
									validation.validatedName(regFirstName);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Name should contains only Alphabates");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							do {
								try {
									System.out.println("Enter Last Name :");
									regLastName = scanner.next();
									validation.validatedName(regLastName);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Name should contains only Alphabates");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);

							do {
								try {
									System.out.println("Enter Email :");
									regEmail = scanner.next();
									validation.validatedEmail(regEmail);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Email should be proper ");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);

							do {
								try {
									System.out.println("Enter Password :");
									regPassword = scanner.next();
									validation.validatedPassword(regPassword);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Enter correct Password ");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);

							do {
								try {
									System.out.println("Enter Mobile :");
									regMobile = scanner.nextLong();
									validation.validatedMobile(regMobile);
									flag = true;
								} catch (InputMismatchException e) {
									flag = false;
									System.err.println("Mobile Number  should contains only numbers");
								} catch (LMSException e) {
									flag = false;
									System.err.println(e.getMessage());
								}
							} while (!flag);
							System.out.println("Enter the role");
							String regRole = scanner.next();
							UsersBean ai = new UsersBean();
							ai.setFirstName(regFirstName);
							ai.setLastName(regLastName);
							ai.setEmail(regEmail);
							ai.setPassword(regPassword);
							ai.setMobile(regMobile);
							ai.setRole(regRole);
							try {
								boolean check=service1.register(ai);
								if(check) {
									System.out.println("Registered");
								}else {
									System.out.println("Already user is registered");
								}
							}catch (LMSException e) {
								System.err.println(e.getMessage());
							}
							break;
						case 2:
							System.out.println("enter email");
							String email=scanner.next();
							System.out.println("enter password");
							String password=scanner.next();
							try {
								UsersBean loginInfo=service1.login(email, password);
								if(loginInfo.getEmail().equals(email) && loginInfo.getPassword().equals(password)) {
									System.out.println("Logged In");
								}
								if(loginInfo.getRole().equals("admin")) {
									do {
										try {
											System.out.println("-----------------------------------------------");
											System.out.println("Press 1 to add book");
											System.out.println("Press 2 to remove book");
											System.out.println("Press 3 to issue book");
											System.out.println("Press 4 to Search the Book by Author");
											System.out.println("Press 5 to Search the Book by Title");
											System.out.println("Press 6 to Get the Book Information");
											System.out.println("Press 7 to Search the book by Id");
											System.out.println("Press 8 to update the book");
											System.out.println("Press 9 to check student book history");
											System.out.println("Press 10 to check requests");
											System.out.println("Press 11 to check issued books");
											System.out.println("Press 12 to view users");
											System.out.println("Press 13 to update Password");
											System.out.println("Press 14 to logout");

											int choice1 = scanner.nextInt();
											switch (choice1) {
											case 1:


												do {
													try {
														System.out.println("Enter Book Name :");
														addName = scanner.next();
														validation.validatedName(addName);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Book-Name should contains only Alphabets");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);


												do {
													try {
														System.out.println("Enter Author :");
														addAuthor = scanner.next();
														validation.validatedName(addAuthor);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Author Name should contains only Alphabates");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);


												do {
													try {
														System.out.println("Enter Category :");
														addCategory = scanner.next();
														validation.validatedName(addCategory);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Book-Category should contains only Alphabates");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);


												do {
													try {
														System.out.println("Enter PublisherName :");
														addPublisher = scanner.next();
														validation.validatedName(addPublisher);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Book-PublisherName should contains only Alphabates");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bi =new BookBean();
												bi.setBookName(addName);
												bi.setAuthor(addAuthor);
												bi.setCategory(addCategory);
												bi.setPublisher(addPublisher);
												try {
													boolean check2=service2.addBook(bi);
													if(check2) {
														System.out.println("-----------------------------------------------");
														System.out.println("Added Book");
													}else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book not added");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}

												break;	
											case 2:
												System.out.println("enter id");
												int removeId=scanner.nextInt();
												try {
													boolean check3=service2.removeBook(removeId);
													if(check3) {
														System.out.println("-----------------------------------------------");
														System.out.println("Removed Book");
													}else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book not removed");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 3:
												System.out.println("enter Book Id");
												int issueId=scanner.nextInt();
												System.out.println("Enter User Id");
												int userId = scanner.nextInt();
												try {
													boolean check4=service2.issueBook(issueId,userId);
													if(check4) {
														System.out.println("-----------------------------------------------");
														System.out.println("Book Issued");
													}else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book not issued");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 4:
												System.out.println("Search the book by the Author Name:");
												String author = scanner.next();
												try {
													List<BookBean> bookauthor = service1.searchBookByAuthor(author);
													if(!bookauthor.isEmpty() && bookauthor != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));

														for (BookBean bookBean : bookauthor) {

															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));
															}
														}
													}else {
														System.out.println("-----------------------------------------------");
														System.err.println("No books are available written by this author");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 5:
												System.out.println("Search the book by the Book_Title :");
												String btitle = scanner.next();
												try {
													List<BookBean> booktitle = service1.searchBookByTitle(btitle);
													if(!booktitle.isEmpty() && booktitle != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));
														for (BookBean bookBean : booktitle) {	
															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));

															} 
														}
													}else {
														System.out.println("-----------------------------------------------");
														System.err.println("No books are available with this title.");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 6:
												try {
													List<BookBean> info = service1.getBooksInfo();
													if(!info.isEmpty() && info != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));
														for (BookBean bookBean : info) {

															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));

															}
														}
													} else {
														System.out.println("-----------------------------------------------");
														System.err.println("Books info is not present");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 7:
												System.out.println("  Search the book by the Book_ID :");
												int book_Id = scanner.nextInt();
												try {
													List<BookBean> bId = service1.searchBookById(book_Id);
													if(!bId.isEmpty() && bId != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));
														for (BookBean bookBean : bId) {	
															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));

															} 
														}
													} else {
														System.out.println("-----------------------------------------------");
														System.err.println("No books are available with this ID.");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 8:
												System.out.println("Enter the updated id :");
												int bid= scanner.nextInt();
												System.out.println("Enter bookName to be updtaed");
												String updatedBookName =scanner.next();
												BookBean bean2 = new BookBean();
												bean2.setBId(bid);
												bean2.setBookName(updatedBookName);
												try {
													boolean updated = service2.updateBook(bean2);
													if (updated) {
														System.out.println("-----------------------------------------------");
														System.out.println("Book is updated");
													} else {
														System.out.println("-----------------------------------------------");
														System.out.println("Book is not updated");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 9:
												System.out.println("Enter the User Id");
												int user_Id = scanner.nextInt();
												try {
													List<Integer> uid = service2.bookHistoryDetails(user_Id);
													for (Integer issueDetails : uid) {
														if(issueDetails != null) {
															System.out.println("-----------------------------------------------");
															System.out.println("No of books Borrowed :"+issueDetails);
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Respective user hasn't borrowed any books");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 10:
												System.out.println(" Requests received are:");
												try {
													List<RequestDetailsBean> requests = service2.showRequests();
													System.out.println(String.format("%10s %-10s %-10s %-25s %s","id","User_Id", "Book_Id","User_Email", "BookName"));
													for (RequestDetailsBean requestBean : requests) {	
														if (requestBean != null) {
															System.out.println(String.format("%-10s %-10s %-10s %-25s %s",requestBean.getId(),requestBean.getUId(), requestBean.getBId(),requestBean.getEmail(),requestBean.getBookName()));

														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No Requests are received");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 11:
												System.out.println("Issued Books are:");
												try {
													List<BookIssueBean> issuedBooks = service2.showIssuedBooks();
													System.out.println(String.format("%-10s %-10s %-10s %25s %s","Id","User_Id","Book_Id","Issue_Date","Return_Date"));
													for (BookIssueBean issueBean : issuedBooks) {	
														if (issueBean != null) {
															System.out.println(String.format("%-10s %-10s %-10s %25s %s",issueBean.getId(),issueBean.getUId(),issueBean.getBId(),issueBean.getIssueDate(),issueBean.getReturnDate()));

														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No book has been issued");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 12:
												System.out.println("Users are:");
												try {

													List<UsersBean> users = service2.showUsers();
													System.out.println(String.format("%-10s %-15s %-15s %-15s %-10s %-10s %s",
															"UserId", "FirstName", "LastName", "Email", "Password", "Mobile",
															"Role"));
													for (UsersBean bean : users) {	
														if (bean != null) {
															System.out.println(String.format(
																	"%-10s %-15s %-15s %-15s %-10s %-10s %s", bean.getUId(),
																	bean.getFirstName(), bean.getLastName(), bean.getEmail(),
																	bean.getPassword(), bean.getMobile(), bean.getRole()));

														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("No Users are present");
														}
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 13:
												System.out.println("Enter the Id :");
												int id= scanner.nextInt();
												System.out.println("Enter the Old password");
												String old_Password =scanner.next();
												System.out.println("Enter the new password");
												String new_Password =scanner.next();
												String user_Role = loginInfo.getRole();
												try {
													boolean updated = service1.updatePassword(id, old_Password, new_Password, user_Role);
													if (updated) {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is updated");
													} else {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is not updated");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;


											case 14:
												doReg();

											default:
												System.out.println("-----------------------------------------------");
												System.out.println("Invalid Choice");
												break;
											}
										}catch (InputMismatchException ex) {
											System.out.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										}
									}while(true);
								}
								else if(loginInfo.getRole().equals("student")) {
									do {
										try {
											System.out.println("-----------------------------------------------");
											System.out.println("Press 1 to request book");
											System.out.println("Press 2 to view the books borrowed");
											System.out.println("Press 3 to search book by author");
											System.out.println("Press 4 to search book by title");
											System.out.println("Press 5 to search book by Id");
											System.out.println("Press 6 to get books info");
											System.out.println("Press 7 to return book");
											System.out.println("Press 8 to update password");
											System.out.println("Press 9 to main");


											int choice2 = scanner.nextInt();
											switch (choice2) {
											case 1:
												System.out.println("Enter the Book Id:");
												int reqBookId= scanner.nextInt();
												System.out.println("Enter the user Id:");
												int reqUserId = scanner.nextInt();
												try {
													if(loginInfo.getUId()==reqUserId) {
														boolean requested = service3.request(reqUserId,reqBookId);
														if (requested != false) {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is Requested");
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is not Requested");
														}	
													}else {
														System.out.println("Enter the correct UserId");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 2:
												System.out.println("Enter the user Id");
												int user_Id = scanner.nextInt();
												try {
													if(loginInfo.getUId()==user_Id) {
														List<BorrowedBooksBean> borrowedBookList = service3.borrowedBook(user_Id);
														System.out.println(String.format("%-5s %-5s %-5s %s", "Id",
																"User-Id", "Book-Id", "BookName"));
														for (BorrowedBooksBean bookBean : borrowedBookList) {

															if (bookBean != null) {
																System.out.println(String.format("%-5s %-5s %-5s %s", bookBean.getId(),
																		bookBean.getUId(), bookBean.getBId(),bookBean.getBookName()));

															} else {
																System.out.println("-----------------------------------------------");
																System.out.println("No books are borrowed by the user");
															}
														}
													}else {
														System.err.println("Incorrect user_Id");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 3:
												System.out.println("Search the book by the Author Name:");
												String author = scanner.next();
												try {
													List<BookBean> bookauthor = service1.searchBookByAuthor(author);
													if(!bookauthor.isEmpty() && bookauthor != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));

														for (BookBean bookBean : bookauthor) {

															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));
															}
														}
													}else {
														System.out.println("-----------------------------------------------");
														System.err.println("No books are available written by this author");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 4:
												System.out.println("Search the book by the Book_Title :");
												String btitle = scanner.next();
												try {
													List<BookBean> booktitle = service1.searchBookByTitle(btitle);
													if(!booktitle.isEmpty() && booktitle != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));
														for (BookBean bookBean : booktitle) {	
															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));

															} 
														}
													}else {
														System.out.println("-----------------------------------------------");
														System.err.println("No books are available with this title.");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 5:
												System.out.println("  Search the book by the Book_ID :");
												int book_Id = scanner.nextInt();
												try {
													List<BookBean> bId = service1.searchBookById(book_Id);
													if(!bId.isEmpty() && bId != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));
														for (BookBean bookBean : bId) {	
															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));

															} 
														}
													} else {
														System.out.println("-----------------------------------------------");
														System.err.println("No books are available with this ID.");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 6:
												try {
													List<BookBean> info = service1.getBooksInfo();
													if(!info.isEmpty() && info != null) {
														System.out.println(String.format("%-10s %-25s %-25s %-20s %s", "Book-Id",
																"Book-Name", "Author", "Category", "Publisher"));
														for (BookBean bookBean : info) {

															if (bookBean != null) {
																System.out.println(String.format("%-10s %-25s %-25s %-20s %s",
																		bookBean.getBId(), bookBean.getBookName(), bookBean.getAuthor(),
																		bookBean.getCategory(), bookBean.getPublisher()));

															}
														}
													} else {
														System.out.println("-----------------------------------------------");
														System.err.println("Books info is not present");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 7:
												System.out.println("Enter the Book id to return :");
												int returnId= scanner.nextInt();
												System.out.println("Enter userId");
												int userId = scanner.nextInt();	
												System.out.println("Enter the status of the book");
												String status = scanner.next();
												try {
													if(loginInfo.getUId()==userId) {
														boolean returned = service3.returnBook(returnId,userId,status);
														if (returned != false) {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is Returned");
														} else {
															System.out.println("-----------------------------------------------");
															System.out.println("Book is not Returned");
														}	
													}else {
														System.out.println("Invalid userId");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 8:
												System.out.println("Enter the Id :");
												int id= scanner.nextInt();
												System.out.println("Enter the Old password");
												String old_Password =scanner.next();
												System.out.println("Enter the new password");
												String new_Password =scanner.next();
												String user_Role = loginInfo.getRole();
												try {
													boolean updated = service1.updatePassword(id, old_Password, new_Password, user_Role);
													if (updated) {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is updated");
													} else {
														System.out.println("-----------------------------------------------");
														System.out.println("Password is not updated");
													}
												}catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;

											case 9:
												doReg();
											default:
												break;
											}
										}catch (InputMismatchException ex) {
											System.out.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										}
									}while(true);
								}
							}catch(Exception e) {
								System.out.println("Invalid Credentials");
								System.out.println("Try logging in again,Press 2 to login");
							}
							break;

						case 3: 
							System.out.println("EXIT");
							System.exit(0);

						default:
							break;
						}
					}catch(InputMismatchException ex) {
						System.out.println("Incorrect entry. Please input only a positive integer.");
						scanner.nextLine();
					}
				}while(true);
			}
		}while(loginStatus);
	}


}
