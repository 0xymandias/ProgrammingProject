public class Book_18114733 {

  private String bookID;
  private String bookTitle;
  private String bookAuthor;
  private String bookAisle;
  private String bookShelf;

  //setters
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



  //getters
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

  //constructor

  /**
   * @param bookID - where bookID is the bookID of the new Book_18114733 object
   * @param bookTitle - the title of the new Book_18114733 object
   * @param bookAuthor - the author of the new Book_18114733 object
   * @param bookAisle - the aisle of the new Book_18114733 object
   * @param bookShelf - the shelf of the new Book_18114733 object
   */
  public Book_18114733(String bookID, String bookTitle, String bookAuthor, String bookAisle,
      String bookShelf) {
    this.bookID = bookID;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.bookAisle = bookAisle;
    this.bookShelf = bookShelf;
  }


  @Override
  public String toString() {
    return this.getBookID() + "," + this.getBookTitle() + "," + this.getBookAuthor() + ","
        + this.getBookAisle() + "," + this.getBookShelf() + "\n";
  }

}
