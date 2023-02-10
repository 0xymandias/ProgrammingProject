import java.util.Date;

public class Loan_18114733 {
  
  private String bookID;
  private String memberID;
  private Date checkedOut;
  private Date dueDate;
  private boolean isReturned;
  private Date returnedDate;

  public void setBookID(String bookID) {
    this.bookID = bookID;
  }

  public void setMemberID(String memberID) {
    this.memberID = memberID;
  }

  public void setCheckOutDate(Date checkOut) {
    this.checkedOut = checkOut;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnedDate = returnDate;
  }

  public void returnBook() {
    isReturned = true;
  }

  public void checkOutBook() {
    isReturned = false;
  }

  public String getBookID() {
    return this.bookID;
  }

  public String getMemberID() {
    return this.memberID;
  }

  public Date getCheckOutDate() {
    return this.checkedOut;
  }

  public Date getDueDate() {
    return this.dueDate;
  }

  public boolean getReturnStatus() {
    return this.isReturned;
  }

  public Date getReturnDate() {
    return this.returnedDate;
  }

  /**
   * Constructor for creating Loan_18114733 objects that have not been returned when reading from
   * file and borrowing a book
   * 
   * @param bookID - The ID of the Book that has been borrowed
   * @param memberID - The ID of the Member that borrowed the Book
   * @param checkedOut - The Date the Book was borrowed
   * @param dueDate - The Date the Book is due to be returned
   * @param isReturned - Whether the Book has been returned or not
   */
  public Loan_18114733(String bookID, String memberID, Date checkedOut, Date dueDate,
      boolean isReturned) {
    this.bookID = bookID;
    this.memberID = memberID;
    this.checkedOut = checkedOut;
    this.dueDate = dueDate;
    this.isReturned = isReturned;
  }

  /**
   * Constructor for creating Loan_18114733 objects that have been returned when reading from file
   * 
   * @param bookID - The ID of the Book that has been borrowed
   * @param memberID - The ID of the Member that borrowed the Book
   * @param checkedOut - The Date the Book was borrowed
   * @param dueDate - The Date the Book is due to be returned
   * @param isReturned - Whether the Book has been returned or not
   * @param returnedDate - The Date the Book was returned
   */
  public Loan_18114733(String bookID, String memberID, Date checkedOut, Date dueDate,
      boolean isReturned, Date returnedDate) {
    this.bookID = bookID;
    this.memberID = memberID;
    this.checkedOut = checkedOut;
    this.dueDate = dueDate;
    this.isReturned = isReturned;
    this.returnedDate = returnedDate;
  }

  @Override
  public String toString() {
    return this.getBookID() + "," + this.getMemberID() + "," + this.getCheckOutDate() + ","
        + this.getDueDate() + "," + this.getReturnStatus() + "," + this.getReturnDate() + "\n";
  }

}
