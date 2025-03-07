package com.book.jdbc.model.vo;

public class Book {

	private int bookNo;
	private String bookTitle;
	private String bookAuthor;
	private int bookNum;
	private int bookPrice;
	private String bookPubNo; //출판사 전화번호
	
	public Book() {
		super();
	}

	public Book(int bookNo, String bookTitle, String bookAuthor, int bookNum, int bookPrice, String bookPubNo) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookNum = bookNum;
		this.bookPrice = bookPrice;
		this.bookPubNo = bookPubNo;
	}

	public Book(String bookTitle, String bookAuthor, int bookNum, int bookPrice, String bookPubNo) {
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookNum = bookNum;
		this.bookPrice = bookPrice;
		this.bookPubNo = bookPubNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPubNo() {
		return bookPubNo;
	}

	public void setBookPubNo(String bookPubNo) {
		this.bookPubNo = bookPubNo;
	}

	@Override
	public String toString() {
		return "Book [" + bookNo + ", " + bookTitle + ", " + bookAuthor + ", "
				+ bookNum + ", " + bookPrice + ", " + bookPubNo + "]";
	}

	
	

	
	
	
}
