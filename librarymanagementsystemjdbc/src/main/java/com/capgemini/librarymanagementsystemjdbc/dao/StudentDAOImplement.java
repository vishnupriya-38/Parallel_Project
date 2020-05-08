package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.JdbcUtility;
import com.mysql.jdbc.Statement;

public class StudentDAOImplement implements StudentDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;


	@Override
	public boolean request(int uId,int bId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pst = conn.prepareStatement(pro.getProperty("requestBookQuery1"));) {
				pst.setInt(1, bId);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					try(PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("requestBookQuery2"));){
						pstmt.setInt(1, uId);
						pstmt.setInt(2, bId);
						pstmt.setInt(3, uId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							int isBookExists = rs.getInt("uId");
							if(isBookExists==0) {
								try(PreparedStatement pstmt1 = conn.prepareStatement(pro.getProperty("requestBookQuery3"));) {
									pstmt1.setInt(1, uId);
									rs=pstmt1.executeQuery();
									if(rs.next()) {
										int noOfBooksBorrowed = rs.getInt("uId");
										if(noOfBooksBorrowed<3) {
											try(PreparedStatement pstmt2 = conn.prepareStatement(pro.getProperty("requestBookQuery4"));){
												pstmt2.setInt(1,uId);
												pstmt2.setInt(2, uId);
												pstmt2.setInt(3, bId);
												pstmt2.setInt(4, bId);
												pstmt2.setInt(5, uId);
												int count = pstmt2.executeUpdate();
												if(count != 0) {
													return true;
												}else {
													return false;
												}
											}				 
										}else {
											throw new LMSException("no Of books limit has crossed");
										}
									}else {
										throw new LMSException("no of books limit has crossed");
									}		
								}				
							}else{
								throw new LMSException("You have already borrowed the requested book");
							}		
						}else {
							throw new LMSException("You have already borrowed the requested book");
						}			
					}

				}else {
					throw new LMSException("The book with requested id is not present");
				}
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("borrowedBookQuery"));) {
				pstmt.setInt(1, uId);
				rs=pstmt.executeQuery();
				LinkedList<BorrowedBooks> beans = new LinkedList<BorrowedBooks>();
				while(rs.next()) {
					BorrowedBooks listOfbooksBorrowed = new BorrowedBooks();
					listOfbooksBorrowed.setuId(rs.getInt("uId"));
					listOfbooksBorrowed.setbId(rs.getInt("bId"));
					listOfbooksBorrowed.setEmail(rs.getString("email"));
					beans.add(listOfbooksBorrowed);
				} 
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean returnBook(int bId,int uId,String status) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pst = conn.prepareStatement(pro.getProperty("returnBookQuery1"));) {
				pst.setInt(1, bId);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					try(PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("returnBookQuery2"));){
						pstmt.setInt(1, bId);
						pstmt.setInt(2, uId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							Date issueDate = rs.getDate("issueDate");
							Calendar cal = Calendar.getInstance();
							Date returnDate = cal.getTime();
							long difference = issueDate.getTime() - returnDate.getTime();
							float daysBetween = (difference / (1000*60*60*24));
							if(daysBetween>7) {
								float fine = daysBetween*5;
								System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
								if(status=="yes") {
									try(PreparedStatement pstmt1 = conn.prepareStatement(pro.getProperty("returnBookQuery3"));) {
										pstmt1.setInt(1,bId);
										pstmt1.setInt(2,uId);
										int count =  pstmt1.executeUpdate();
										if(count != 0) {
											try(PreparedStatement pstmt2 = conn.prepareStatement(pro.getProperty("returnBookQuery4"));) {
												pstmt2.setInt(1, bId);
												pstmt2.setInt(2, uId);
												int isReturned = pstmt2.executeUpdate();
												if(isReturned != 0 ) {
													try(PreparedStatement pstmt3 = conn.prepareStatement(pro.getProperty("returnBookQuery5"));){
														pstmt3.setInt(1, bId);
														pstmt3.setInt(2, uId);
														int isRequestDeleted = pstmt3.executeUpdate();
														if(isRequestDeleted != 0) {
															return true;
														}else {
															return false;
														}
													}
												}else {
													return false;
												}
											}
										} else {
											return false;
										}
									}
								} else {
									throw new LMSException("The User has to pay fine for delaying book return");
								}
							}else {
								try(PreparedStatement pstmt1 = conn.prepareStatement(pro.getProperty("returnBookQuery3"));) {
									pstmt1.setInt(1,bId);
									pstmt1.setInt(2,uId);
									int count =  pstmt1.executeUpdate();
									if(count != 0) {
										try(PreparedStatement pstmt2 = conn.prepareStatement(pro.getProperty("returnBookQuery4"));) {
											pstmt2.setInt(1, bId);
											pstmt2.setInt(2, uId);
											int isReturned = pstmt2.executeUpdate();
											if(isReturned != 0 ) {
												try(PreparedStatement pstmt3 = conn.prepareStatement(pro.getProperty("returnBookQuery5"));){
													pstmt3.setInt(1, bId);
													pstmt3.setInt(2, uId);
													int isRequestDeleted = pstmt3.executeUpdate();
													if(isRequestDeleted != 0) {
														return true;
													}else {
														return false;
													}
												}
											}else {
												return false;
											}
										}
									} else {
										return false;
									}
								}
							}
						}else {
							throw new LMSException("This respective user hasn't borrowed any book");
						}
					}

				}else {
					throw new LMSException("No book exist with bookId"+bId);
				}

			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	

}
