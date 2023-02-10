import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Library_18114733 {

  static Scanner kb = new Scanner(System.in);
  static ArrayList<Loan_18114733> loanList = new ArrayList<>();
  static ArrayList<Book_18114733> bookList = new ArrayList<>();
  static ArrayList<Member_18114733> memberList = new ArrayList<>();
  static ArrayList<SearchResult_18114733> lateBooks = new ArrayList<>();
  static Date today = stringToDate("2022-05-27");
  static int exit = 0;
  static boolean savedToFile = true;

  //Here, we will load in our files. While our exit value is 0. We will continue to print the menu,
  //then allow the user to make their menu choice.

  public static void main(String[] args) {
    loadFiles();

    while (exit == 0) {
      printMenu();
      menuSelect();
    }
  }

  public static void printMenu() {
    System.out.println("Welcome to the Library. Choose one of the following options:");
    System.out.println("1. Add a Book.");
    System.out.println("2. Add a Member.");
    System.out.println("3. Find Book Information.");
    System.out.println("4. Overdue Book Report.");
    System.out.println("5. Borrow a Book.");
    System.out.println("6. Return a Book.");
    System.out.println("7. Save.");
    System.out.println("8. Exit.");
    System.out.println("Enter your choice:");
  }

  //the user is then prompted to enter and integer value corresponding to their
  // menu choice. The menu choice will then call upon the different methods created
  //for each task

  public static void menuSelect() {
    int menuChoice;
    //hasNextInt is used to ensure we do not throw a InputMismatchException and kill our program
    if (kb.hasNextInt()) {
      menuChoice = kb.nextInt();
      kb.nextLine();
      if (menuChoice == 1) {
        addBook();
      } else if (menuChoice == 2) {
        addMember();
      } else if (menuChoice == 3) {
        findBookInfo();
      } else if (menuChoice == 4) {
        printOverdueReport();
      } else if (menuChoice == 5) {
        borrowBook();
      } else if (menuChoice == 6) {
        returnBook();
      } else if (menuChoice == 7) {
        saveToFile();
      } else if (menuChoice == 8) {
        exitProgram();
      } else {
        System.out.println("Please enter a choice from 1 to 8.");
        returnToMenu();
      }
    } else {
      //in this instance, we avoid the InputMismatchException by resetting our
      //scanner with kb.nextLine, and then returning to Menu
      System.out.println("Please only enter a choice from 1 to 8.");
      kb.nextLine();
      returnToMenu();
    }
  }

  //basic method that:
  //prints an empty line for aesthetics
  //prints out the Menu
  //the calls the menuSelect() method
  public static void returnToMenu() {
    System.out.println();
    printMenu();
    menuSelect();
  }

  public static void addBook() {

    //here we know a book has 5 fields, so we create an array of 5 fields.

    String[] bookTemp = new String[5];
    System.out.println();
    System.out.println("1. Add a Book.");
    System.out.println("Please enter the ID of the Book you would like to add.");
    bookTemp[0] = kb.nextLine();
    /*
     * calls method that checks if the entered ID is: no more than 6 characters long not null, or
     * empty a numeric value does not match an existing bookID or an existing memberID
     */
    checkInputID(bookTemp[0]);
    //We have passed all our checks here, and are ready to enter our bookTitle
    System.out.println("Please enter the Title of the Book you would like to add.");
    bookTemp[1] = kb.nextLine();
    //Here we only need to ensure that the bookTitle is not null, or empty.
    while (bookTemp[1] == null || bookTemp[1].equals("")) {
      System.out.println("Error: Book Title cannot be empty.");
      bookTemp[1] = kb.nextLine();
    }
    //same with bookTitle, we only need to ensure that bookAuthor is not empty
    System.out.println("Please enter the Author of the Book you would like to add");
    bookTemp[2] = kb.nextLine();
    while (bookTemp[2] == null || bookTemp[2].equals("")) {
      System.out.println("Author can not be empty.");
      bookTemp[2] = kb.nextLine();
    }
    //check that bookAisle is not empty
    System.out.println("Please enter the Aisle of the Book you would like to add");
    bookTemp[3] = kb.nextLine();
    while (bookTemp[3] == null || bookTemp[3].equals("")) {
      System.out.println("Aisle can not be empty.");
      bookTemp[3] = kb.nextLine();
    }
    //check that bookShelf is not empty
    System.out.println("Please enter the Shelf of the Book you would like to add");
    bookTemp[4] = kb.nextLine();
    while (bookTemp[4] == null || bookTemp[4].equals("")) {
      System.out.println("Shelf can not be empty.");
      bookTemp[4] = kb.nextLine();
    }
    //create a new Book_18114733 object from our array, call it newUserBook
    Book_18114733 newUserBook =
        new Book_18114733(bookTemp[0], bookTemp[1], bookTemp[2], bookTemp[3], bookTemp[4]);
    //add newUserBook to our ArrayList bookList
    bookList.add(newUserBook);
    //savedToFile set to false as a new object has been made and it has not been written to books.txt
    savedToFile = false;
  }


  //our addMember method
  public static void addMember() {
    System.out.println();
    System.out.println("2. Add a Member.");
    //member objects are made up of 5 fields, so we create an array of size 5
    String[] newMember = new String[5];
    System.out.println("Please enter the ID of the Member you would like to add.");
    newMember[0] = kb.nextLine();
    checkInputID(newMember[0]);
    /*
     * calls method that checks if the entered ID is: no more than 6 characters long not null, or
     * empty a numeric value does not match an existing bookID or an existing memberID
     */
    System.out.println("Please enter the new Member's Name");
    newMember[1] = kb.nextLine();
    //check that the member name is not null or empty
    while (newMember[1] == null || newMember[1].equals("")) {
      System.out.println("Member Name can not be empty.");
      newMember[1] = kb.nextLine();
    }

    System.out.println("Please enter the new Member's Address");
    newMember[2] = kb.nextLine();
    //check that the member address is not null or empty
    while (newMember[2] == null || newMember[2].equals("")) {
      System.out.println("Member Address can not be empty.");
      newMember[2] = kb.nextLine();
    }
    //Unrequested, but we will check that the phone number is a number
    System.out.println("Please enter the new Member's Phone Number");
    newMember[3] = kb.nextLine();
    while (!isNumeric(newMember[3])) {
      System.out.println("Member Phone Number must be a number.");
      newMember[3] = kb.nextLine();
    }
    System.out.println("Please enter the new Member's email address");
    newMember[4] = kb.nextLine();
    //ensure that the member email address has the @ character
    while (!newMember[4].contains("@")) {
      System.out.println("Member email must have an @ character");
      newMember[4] = kb.nextLine();
    }
    //we have passed all our checks, we will now create a new Member_18114733 object
    //from our newMember Array
    Member_18114733 newUserMember =
        new Member_18114733(newMember[0], newMember[1], newMember[2], newMember[3], newMember[4]);
    //add newUserMember object to our ArrayList, memberList
    memberList.add(newUserMember);
    //savedToFile set to false as a new object has been made and it has not been written to members.txt
    savedToFile = false;
  }

  //our book search method
  //see searchBook for core functions and info
  public static void findBookInfo() {
    System.out.println();
    System.out.println("3. Find Book Information.");
    System.out.println("Please enter the Title of the book you would like to find.");
    String bookSearch = kb.nextLine();
    //take input from the user, insert it as a parameter in our searchBook method
    searchBook(bookSearch);
  }

  public static void printOverdueReport() {
    /*
     * because we have executed the findOverdueBook() method in our loadFiles() method, we only need
     * to iterate through our lateBooks list and print each item as per our System.out.format().
     */
    System.out.println();
    System.out.println("4. Overdue Book Report.");
    System.out.printf("%-20s %20s %20s %20s %20s %20s", "Book Title", "Book Author", "Member Name",
        "Member Phone", "Due Date", "Days Overdue" + "\n");
    System.out.println(
        "------------------------------------------------------------------------------------------------------------------------------");
    for (SearchResult_18114733 late : lateBooks) {
      System.out.format("%-24s %17s %20s %20s %20s %20s", late.getBookTitle(), late.getBookAuthor(),
          late.getMemberName(), late.getMemberPhone(), dateToString(late.getDueDate()),
          late.getDaysOverdue() + "\n");
    }
    System.out.println();
  }


  public static void returnBook() {
    System.out.println();
    System.out.println("6. Return a Book.");
    System.out.println("Enter the Book's ID: ");
    String bookID = kb.nextLine();
    for (int i = 0; i < loanList.size(); i++) {
      if (bookID.equals(loanList.get(i).getBookID())) {
        if (!loanList.get(i).getReturnStatus()) {
          for (int k = loanList.size() - 1; k >= 0; k--) {
            if (bookID.equals(loanList.get(k).getBookID())) {
              if (!loanList.get(k).getReturnStatus()) {
                loanList.get(k).returnBook();
                loanList.get(k).setReturnDate(today);
                savedToFile = false;
                returnToMenu();
              } else if (loanList.get(k).getReturnStatus()) {
                System.out.println("Error: The book is not checked out.");
              }
            }
          }
          loanList.get(i).returnBook();
          loanList.get(i).setReturnDate(today);
          returnToMenu();
        } else if (loanList.get(i).getReturnStatus()) {
          System.out.println("Error: The book is not checked out.");
          returnToMenu();
        }
      }
    }
  }

  public static void saveToFile() {
    try {
      PrintWriter bookWrite = new PrintWriter("books.txt");
      for (int i = 0; i < bookList.size(); i++) {
        Book_18114733 book = bookList.get(i);
        bookWrite.write(book.toString());
      }
      bookWrite.close();
    } catch (IOException e) {
      System.out.println("Error: Unable to locate book.txt");
    }
    try {
      PrintWriter bookWrite = new PrintWriter("members.txt");
      for (int i = 0; i < memberList.size(); i++) {
        Member_18114733 member = memberList.get(i);
        bookWrite.write(member.toString());
      }
      bookWrite.close();
    } catch (IOException e) {
      System.out.println("Error: Unable to locate book.txt");
    }
    try {
      PrintWriter loanWrite = new PrintWriter("loans.txt");
      for (int i = 0; i < loanList.size(); i++) {
        Loan_18114733 loan = loanList.get(i);
        String formattedDueDate = dateToString(loan.getDueDate());
        String formattedCheckOutDate = dateToString(loan.getCheckOutDate());
        if (!loan.getReturnStatus()) {
          String returnStatus = "no";
          loanWrite.write(loan.getBookID() + "," + loan.getMemberID() + "," + formattedCheckOutDate
              + "," + formattedDueDate + "," + returnStatus + "," + "\n");
        } else {
          String returnStatus = "yes";
          String formattedReturnDate = dateToString(loan.getReturnDate());
          loanWrite.write(loan.getBookID() + "," + loan.getMemberID() + "," + formattedCheckOutDate
              + "," + formattedDueDate + "," + returnStatus + "," + formattedReturnDate + "\n");
        }
      }
      loanWrite.close();
    } catch (IOException e) {
      System.out.println("Error: Unable to locate book.txt");
    }
    System.out.println("Saved!");
    savedToFile = true;
  }


  public static void exitProgram() {

    //Here we will check if savedToFile = true or false
    if (!savedToFile) {
      System.out.println("You have unsaved changes!!!");
      System.out.println("1. Return to Main Menu.");
      System.out.println("2. Exit without saving changes.");
      int exitChoice = kb.nextInt();
      if (exitChoice == 2) {
        System.out.println("Bye!");
        exit = 1;
      }
      if (exitChoice == 1) {
        returnToMenu();
      }
      while (exitChoice < 1 || exitChoice > 2) {
        System.out.println("Invalid input. Please enter 1 or 2");
        exitChoice = kb.nextInt();
      }
      //savedToFile is true, so we can safely exit our program by setting exit to 1.
    } else {
      exit = 1;
      System.out.println("Bye!");
    }
  }

  public static void loadFiles() {
    try {
      Scanner memberFile = new Scanner(new File("members.txt"));

      while (memberFile.hasNextLine()) {
        String[] line = memberFile.nextLine().split(",");
        Member_18114733 e = new Member_18114733(line[0], line[1], line[2], line[3], line[4]);
        memberList.add(e);
      }
      memberFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Unable to locate members.txt");
    }
    try {
      Scanner bookFile = new Scanner(new File("books.txt"));

      while (bookFile.hasNextLine()) {
        String[] line = bookFile.nextLine().split(",");
        Book_18114733 e = new Book_18114733(line[0], line[1], line[2], line[3], line[4]);
        bookList.add(e);
      }
      bookFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Unable to locate books.txt");
    }
    try {
      Scanner loansFile = new Scanner(new File("loans.txt"));
      Date returnedDate;
      while (loansFile.hasNextLine()) {
        String line = loansFile.nextLine();
        String[] fields = line.split(",", -1);
        Date checkedOut = stringToDate(fields[2]);
        checkedOut = formatDateToFile(checkedOut);
        Date dueDate = stringToDate(fields[3]);
        dueDate = formatDateToFile(dueDate);
        boolean returned = stringToBoolean(fields[4]);
        if (returned) {
          returnedDate = stringToDate(fields[5]);
          returnedDate = formatDateToFile(returnedDate);
          Loan_18114733 f =
              new Loan_18114733(fields[0], fields[1], checkedOut, dueDate, returned, returnedDate);
          loanList.add(f);
        } else {
          Loan_18114733 e = new Loan_18114733(fields[0], fields[1], checkedOut, dueDate, returned);
          loanList.add(e);
        }
      }
      loansFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Unable to locate loans.txt");
    }
    findOverdueBook();
  }

  public static void borrowBook() {
    Calendar c = Calendar.getInstance();
    System.out.println();
    System.out.println("5. Borrow a Book.");
    System.out.println("Enter the book's ID");
    String bookID = kb.nextLine();

    if (checkBookExist(bookID)) {
      if (checkBookAvailable(bookID)) {
        System.out.println("Enter the member's ID:");
        String memberID = kb.nextLine();
        if (checkMemberExist(memberID)) {
          if (!checkMemberLate(memberID)) {
            if (!checkMemberOverborrow(memberID)) {
              c.add(Calendar.DAY_OF_MONTH, 14);
              Date dueDate = c.getTime();
              Loan_18114733 e = new Loan_18114733(bookID, memberID, today, dueDate, false);
              loanList.add(e);
              savedToFile = false;
            } else
              System.out.println("Error: Member cannot borrow more than 3 Books.");
          } else
            System.out.println("Error: Member has an overdue book.");
        } else
          System.out.println("Error: Member ID does not exist.");
      } else
        System.out.println("Error: That book is currently checked out.");
    } else
      System.out.println("Error: Book ID entered does not exist.");
  }


  /**
   * @param searchTitle - here we take String input, where the input is the title, or close to the
   *        title, of the book the user would like to see information about
   */
  public static void searchBook(String searchTitle) {
    searchTitle = searchTitle.toLowerCase();

    //ArrayList to store our search results
    ArrayList<SearchResult_18114733> searchResult = new ArrayList<>();

    for (int i = 0; i < bookList.size(); i++) {
      Book_18114733 book = bookList.get(i);

      // If book title doesn't match query, skip it
      if (!book.getBookTitle().toLowerCase().contains(searchTitle)) {
        continue;
      }

      String bookID = bookList.get(i).getBookID();
      String bookTitle = bookList.get(i).getBookTitle();
      String bookAuthor = bookList.get(i).getBookAuthor();
      String bookAisle = bookList.get(i).getBookAisle();
      String bookShelf = bookList.get(i).getBookShelf();

      // assume all books are available, until they are not
      boolean loanedOut = false;
      //search through our loanList of loan objects
      for (int j = 0; j < loanList.size(); j++) {
        Loan_18114733 loan = loanList.get(j);

        //check if the bookID matches any in our loanList
        //if it does match, check if it has been returned
        if (loan.getBookID().equals(bookID) && !loan.getReturnStatus()) {
          // Loaned book found. Add to search results.
          SearchResult_18114733 e = new SearchResult_18114733(bookID, bookTitle, bookAuthor,
              bookAisle, bookShelf, loan.getDueDate(), false);
          searchResult.add(e);

          // Set flag to true if not available
          loanedOut = true;

        }
      }

      // If book wasn't loaned out, add it to search results as an available book.
      if (!loanedOut) {
        SearchResult_18114733 e =
            new SearchResult_18114733(bookID, bookTitle, bookAuthor, bookAisle, bookShelf, true);
        searchResult.add(e);
      }

      // Reset loanedOut flag
      loanedOut = false;
    }

    System.out.printf("%-20s %25s %20s %20s %20s %20s", "ID", "Title", "Author", "Aisle", "Shelf",
        "Status" + "\n");
    System.out.println(
        "------------------------------------------------------------------------------------------------------------------------------");
    for (SearchResult_18114733 search : searchResult) {
      //if our book status is true, we will print the book as available
      if (search.getReturnStatus()) {
        System.out.printf("%-20s %25s %20s %20s %20s %20s", search.getBookID(),
            search.getBookTitle(), search.getBookAuthor(), search.getBookAisle(),
            search.getBookShelf(), "Available" + "\n");
      } else {
        //our book status is false, so print it with the due date
        System.out.printf("%-20s %25s %20s %20s %20s %20s", search.getBookID(),
            search.getBookTitle(), search.getBookAuthor(), search.getBookAisle(),
            search.getBookShelf(), "Due " + dateToString(search.getDueDate()) + "\n");
      }
    }
    returnToMenu();
  }


  public static void findOverdueBook() {
    /*
     * loop through loanList ArrayList for every element in loanList, we will create the fields
     * necessary to make a SearchResult_181147433 object that is: String bookID - the ID of the book
     * that is overdue bookTitle - the title of the book that is overdue bookAuthor - the author of
     * the book that is overdue memberID - the ID of the member that has borrowed the book
     * memberName - the name of the member that has borrowed the book memberPhone - the phone number
     * of the member that has borrowed the book dueDate - the date the book was meant to be returned
     * daysOverdue - the amount of days that book is overdue
     */
    for (int i = 0; i < loanList.size(); i++) {
      String bookID = null, bookTitle = null, bookAuthor = null, memberID = null, memberName = null,
          memberPhone = null;
      Date dueDate;
      long daysOverdue;
      /*
       * here we will check if the book is overdue using .compareTo(Date anotherDate) from the date
       * class where anotherDate is the Date today which we declared at the beginning of this class
       * we compare today to the dueDate that we get from our loanList objects using .getDueDate()
       * if the value returned is less than zero, the book is overdue, and we progress to our next
       * loop else the book is not overdue, and we continue through our loop
       *
       * where i is the index of the loanList object that we are comparing to.
       */
      if (loanList.get(i).getDueDate().compareTo(today) < 0) {
        if (loanList.get(i).getReturnStatus()) {
          continue;
        }
        /*
         * j - the index of our book object in bookList i - the index of our loan object in loanList
         * loop through our bookList until the bookID in bookList matches to the bookID in loanList
         * when they match store the bookID, bookTitle and bookAuthor in the Strings initialised at
         * the beginning of the main for loop
         */
        for (int j = 0; j < bookList.size(); j++) {
          if (bookList.get(j).getBookID().equalsIgnoreCase(loanList.get(i).getBookID())) {
            bookID = bookList.get(j).getBookID();
            bookTitle = bookList.get(j).getBookTitle();
            bookAuthor = bookList.get(j).getBookAuthor();
          }
        }
        /*
         * k - the index of our member object in memberList i - the index of our loan object in
         * loanList loop through our memberList until the memberID matches the memberID in loanList
         * when they match store the memberID, memberName, and memberPhone in the Strings
         * initialised at the beginning of the main for loop
         */
        for (int k = 0; k < memberList.size(); k++) {
          if (memberList.get(k).getMemberID().equalsIgnoreCase(loanList.get(i).getMemberID())) {
            memberID = memberList.get(k).getMemberID();
            memberName = memberList.get(k).getMemberName();
            memberPhone = memberList.get(k).getMemberPhone();
          }
        }
        /*
         * we know now that the book is overdue, so we store the dueDate in our dueDate object
         * initialised at the beginning of the main for loop
         */
        dueDate = loanList.get(i).getDueDate();
        /*
         * daysOverdue is derived from our daysOverdue(Date date2, Date date2) method returns a long
         * value of the days overdue
         */
        daysOverdue = daysOverdue(loanList.get(i).getDueDate(), today);
        //create a new SearchResult_18114733 object from the values we have retrieved
        SearchResult_18114733 e = new SearchResult_18114733(bookID, bookTitle, bookAuthor, memberID,
            memberName, memberPhone, dueDate, daysOverdue);
        //add that new object to our lateBooks ArrayList
        lateBooks.add(e);
      }
    }
  }

  /**
   * @param input - string input from loans.txt
   * @return - true or false used as a pseudo parser, if the input parameter is: yes - return true,
   *         no - return false, true - return true, false - return false.
   */
  public static boolean stringToBoolean(String input) {
    input = input.toLowerCase();
    if (input.equalsIgnoreCase("yes"))
      return true;
    if (input.equalsIgnoreCase("no"))
      return false;
    if (input.equalsIgnoreCase("true"))
      return true;
    if (input.equalsIgnoreCase("false"))
      return false;
    throw new IllegalArgumentException(input + " is not a boolean.");
  }

  /**
   * @param input - String to be parsed as a Date
   * @return Date - a Date object to be used when creating Loan_18114733 objects
   */
  public static Date stringToDate(String input) {
    Date ourDateObject = new Date();
    SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      ourDateObject = stringFormat.parse(input);
      stringFormat.format(ourDateObject);
    } catch (ParseException e) {
      System.out.println("Error! Failed to cast String to Date.");
    }
    return ourDateObject;
  }

  /**
   * @param dueDate - the date a book is/was meant to be returned
   * @param currentDate - the date today
   * @return long value of the difference between dueDate and currentDate
   */
  public static long daysOverdue(Date dueDate, Date currentDate) {
    long diff = currentDate.getTime() - dueDate.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }


  /**
   * @param object - the date that is to be converted to String
   * @return a String variable that can be used when printing or writing to file
   */
  public static String dateToString(Date object) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String strDate = formatter.format(object);
    return strDate;
  }

  /**
   * @param oldDate - Date object to be reformatted
   * @return Reformatted date object Creates a SimpleDateFormat object, executes
   *         dateToString(oldDate), then parses the returned string to the SimpleDateFormat
   */
  public static Date formatDateToFile(Date oldDate) {
    SimpleDateFormat saveFileFormat = new SimpleDateFormat("yyyy-MM-dd");
    String date = dateToString(oldDate);
    try {
      oldDate = saveFileFormat.parse(date);
      saveFileFormat.format(oldDate);
    } catch (ParseException e) {
      System.out.println("Failed to cast.");
    }
    return oldDate;
  }

  /**
   * @param bookID - bookID to be checked
   * @return true if the book exists, false if it does not. loops through the bookList, comparing
   *         the String bookID to existing bookIDs if a match is found, bookExist = true. Loop runs
   *         until searchCounter reaches 0, and then returns bookExist.
   */
  public static boolean checkBookExist(String bookID) {
    boolean bookExist = false;
    int searchCounter = bookList.size();
    for (int i = 0; i < bookList.size(); i++) {
      if (bookList.get(i).getBookID().equals(bookID)) {
        bookExist = true;
      } else if (searchCounter == 0 && !bookList.get(i).getBookID().equals(bookID)) {
        bookExist = false;
      }
      searchCounter--;

    }
    return bookExist;
  }

  /**
   * @param bookID - the bookID to be checked
   * @return true if book is available, false if not. loops through lateBooks and loanList comparing
   *         bookIDs to the @param bookID. If the book exists in lateBooks, returns false. If it
   *         does not exist in lateBooks, loops through loanList. if the book exists in loanList,
   *         checks if the book has been returned. if it reaches the end and the book is either not
   *         there, or it's last instance in the list, had ReturnStatus true. The book is available
   */
  public static boolean checkBookAvailable(String bookID) {
    boolean available = true;
    int lateCounter = lateBooks.size();

    for (int i = 0; i < lateBooks.size(); i++) {
      if (lateBooks.get(i).getBookID().equals(bookID)) {
        available = false;
      } else if (lateCounter == 0 & !lateBooks.get(i).getBookID().equals(bookID)) {
        available = true;
      }
      lateCounter--;
    }
    for (int j = 0; j < loanList.size(); j++) {
      if (loanList.get(j).getBookID().equals(bookID) && loanList.get(j).getReturnStatus()) {
        available = true;
      } else if (loanList.get(j).getBookID().equals(bookID) && !loanList.get(j).getReturnStatus()) {
        available = false;
      }
    }
    return available;
  }


  /**
   * @param memberID - the memberID needing its existence confirmed
   * @return true if the memberID exists in memberList at all. False if it does not.
   */
  public static boolean checkMemberExist(String memberID) {
    boolean memberExist = false;

    for (int i = 0; i < memberList.size(); i++) {
      if (memberList.get(i).getMemberID().equals(memberID)) {
        memberExist = true;
      }

    }
    return memberExist;
  }

  /**
   * @param memberID - the memberID whose borrowing eligibility is being checked
   * @return true if the memberID is in the lateBooks list. false if it isn't.
   */
  public static boolean checkMemberLate(String memberID) {
    boolean late = false;

    for (int i = 0; i < memberList.size(); i++) {
      if (lateBooks.get(i).getMemberID().equals(memberID)) {
        late = true;
      }
    }
    return late;
  }

  /**
   * @param memberID - the memberID whose borrowing eligibility is being checked
   * @return True if booksBorrow is 3 or more. False if booksBorrowed is less than 3 loops through
   *         loanList and checks if that memberID exists in there. if it does, add 1 to
   *         bookBorrowed. Then checks if that book has been returned. if it has, subtract 1 from
   *         booksBorrowed. final booksBorrowed value determines if overBorrowed or not.
   */
  public static boolean checkMemberOverborrow(String memberID) {
    boolean overBorrowed = false;
    int booksBorrowed = 0;
    for (int i = 0; i < loanList.size(); i++) {
      if (loanList.get(i).getMemberID().equals(memberID)) {
        booksBorrowed++;
      }
      if (loanList.get(i).getMemberID().equals(memberID) && loanList.get(i).getReturnStatus()) {
        booksBorrowed--;
      }

    }
    if (booksBorrowed > 2) {
      overBorrowed = true;
    }
    return overBorrowed;
  }

  /**
   * @param str - string input
   * @return true if string input can be parsed as an Integer false if it can not
   */
  public static boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static void printIDError() {
    //Generic error to throw when an entered ID is not valid
    System.out.println("You must enter a unique 6 digit numeric ID. Please enter the ID:");
  }


  /**
   * @param input - bookID or memberID to be validated checks that the string input meets the
   *        following requirements: the input is a number it is 6 characters in length does not
   *        match an existing Book ID does not match an existing Member ID
   */
  public static void checkInputID(String input) {
    //assume input is not valid
    boolean validInput = false;

    /*
     * input is not valid until we confirm that: the ID is a number the ID length is 6 it is not
     * null, or empty does not match an existing bookID and does not match an existing memberID
     */
    while (!validInput) {
      //check if the ID entered is a number
      while (!isNumeric(input)) {
        printIDError();
        input = kb.nextLine();
        checkInputID(input);
      }
      //check if the ID length is 6
      while (input.length() != 6) {
        printIDError();
        input = kb.nextLine();
        checkInputID(input);
      }
      //check if the ID is not null, or empty.
      //here we will loop through our bookList ArrayList and check if the ID
      //is the same as any existing bookIDs
      for (Book_18114733 book_18114733 : bookList) {
        if (book_18114733.getBookID().equals(input)) {
          System.out.println("Error: ID cannot match an existing Book ID.");
          checkInputID(input);
        }
      }
      //here we will loop through the memberList ArrayList and check if the
      //ID matches any of our existing memberIDs
      for (Member_18114733 member_18114733 : memberList) {
        if (member_18114733.getMemberID().equals(input)) {
          System.out.println("Error: ID cannot match an existing Member ID.");
          checkInputID(input);
        }
      }
      //we have passed all our checks, validInput is true
      validInput = true;
    }
  }
}
