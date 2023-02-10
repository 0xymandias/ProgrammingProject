import java.util.Date;

public class SearchResult_18114733 {

  private String memberID;
  private String memberName;
  private String memberAddress;
  private String memberPhone;
  private String bookID;
  private String bookTitle;
  private String bookAuthor;
  private String bookAisle;
  private String bookShelf;
  private Date checkedOutDate;
  private Date dueDate;
  private boolean isReturned;
  private Date returnedDate;
  private long daysOverdue;


  public void setMemberID(String memberID) {
    this.memberID = memberID;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public void setMemberAddress(String memberAddress) {
    this.memberAddress = memberAddress;
  }

  public void setMemberPhone(String memberPhone) {
    this.memberPhone = memberPhone;
  }

  public void setBookID(String bookID) {
    this.bookID = bookID;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public void setBookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
  }

  public void setBookAisle(String bookAisle) {
    this.bookAisle = bookAisle;
  }

  public void setBookShelf(String bookShelf) {
    this.bookShelf = bookShelf;
  }

  public void setCheckOutDate(Date checkOut) {
    this.checkedOutDate = checkOut;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnedDate = returnDate;
  }

  public void setDaysOverdue(long daysOverdue) {
    this.daysOverdue = daysOverdue;
  }

  public void returnBook() {
    isReturned = true;
  }

  public void checkOutBook() {
    isReturned = false;
  }

  //getters
  public String getMemberID() {
    return memberID;
  }

  public String getMemberName() {
    return memberName;
  }

  public String getMemberAddress() {
    return memberAddress;
  }

  public String getMemberPhone() {
    return memberPhone;
  }

  public String getBookID() {
    return bookID;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public String getBookAuthor() {
    return bookAuthor;
  }

  public String getBookAisle() {
    return bookAisle;
  }

  public String getBookShelf() {
    return bookShelf;
  }

  public Date getCheckOutDate() {
    return this.checkedOutDate;
  }

  public Date getDueDate() {
    return this.dueDate;
  }

  public long getDaysOverdue() {
    return this.daysOverdue;
  }

  public boolean getReturnStatus() {
    return this.isReturned;
  }

  public Date getReturnDate() {
    return this.returnedDate;
  }

  /**
   * Search result for when a book is not available for the searchBook() method
   *
   * @param bookID - the ID of the Book
   * @param bookTitle - the Title of the Book
   * @param bookAuthor - the Author of the Book
   * @param bookAisle - the Aisle the Book is in
   * @param bookShelf - the Shelf the book is on
   * @param dueDate - the Date the book is due
   * @param isReturned - whether the book has been returned or not
   */
  public SearchResult_18114733(String bookID, String bookTitle, String bookAuthor, String bookAisle,
      String bookShelf, Date dueDate, boolean isReturned) {
    this.bookID = bookID;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.bookAisle = bookAisle;
    this.bookShelf = bookShelf;
    this.dueDate = dueDate;
    this.isReturned = isReturned;
  }


  /**
   * Constructor for when a book is available for the searchBook() method
   *
   * @param bookID - the ID of the Book
   * @param bookTitle - the Title of the Book
   * @param bookAuthor - the Author of the Book
   * @param bookAisle - the Aisle the Book is in
   * @param bookShelf - the Shelf the book is on
   * @param isReturned - whether the book has been returned or not
   */
  public SearchResult_18114733(String bookID, String bookTitle, String bookAuthor, String bookAisle,
      String bookShelf, boolean isReturned) {
    this.bookID = bookID;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.bookAisle = bookAisle;
    this.bookShelf = bookShelf;
    this.isReturned = isReturned;
  }


  /**
   * Constructor for findOverdueBook() method
   *
   * @param bookID - the overdue book's bookID
   * @param bookTitle - the overdue book's title
   * @param bookAuthor - the overdue book's author
   * @param memberID - the member id of the overdue books borrower
   * @param memberName - the name of the overdue books borrower
   * @param memberPhone - the phone number of the overdue books borrower
   * @param dueDate - the date the book was due
   * @param daysOverdue - the days that book is overdue
   */
  public SearchResult_18114733(String bookID, String bookTitle, String bookAuthor, String memberID,
      String memberName, String memberPhone, Date dueDate, long daysOverdue) {
    this.bookID = bookID;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.memberID = memberID;
    this.memberName = memberName;
    this.memberPhone = memberPhone;
    this.dueDate = dueDate;
    this.daysOverdue = daysOverdue;
  }



}
