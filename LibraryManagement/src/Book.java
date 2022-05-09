

public class Book {

    private String bookName;
    private int bookCopies;
    private boolean isIssued;
    private boolean isRead;
    private boolean isReturn;
    private String authorName;
    private int day;
    private int month;
    private int year;
    private int ReturnDay;
    private int ReturnMonth;
    private int ReturnYear;


    Student student = new Student();

    public int getBookCopies() {
        return bookCopies;
    }

    public String getBookName() {
        return bookName;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setReturnDay(int returnDay) {
        ReturnDay = returnDay;
    }

    public void setReturnMonth(int returnMonth) {
        ReturnMonth = returnMonth;
    }

    public void setReturnYear(int returnYear) {
        ReturnYear = returnYear;
    }

    public int getReturnDay() {
        return ReturnDay;
    }

    public int getReturnMonth() {
        return ReturnMonth;
    }

    public int getReturnYear() {
        return ReturnYear;
    }

    public String getDate() {
        return day+ "\\" + month + "\\" +  year;
    }
    public String getReturnDate() {
        return ReturnDay+ "\\" + ReturnMonth + "\\" +  ReturnYear;
    }
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCopies(int bookCopies) {
        this.bookCopies = bookCopies;
    }

    public void setIssued(boolean isIssued){
        this.isIssued=isIssued;
    }

    public boolean getIssued(){
        return isIssued;
    }

    public void setRead(boolean isRead){
        this.isRead = isRead;
    }

    public boolean getRead(){
        return isRead;
    }

    public void setReturn(boolean isReturn){
        this.isReturn=isReturn;
    }

    public boolean getReturn(){
        return isReturn;
    }

    Book(){
        setBookCopies(0);
        setBookName("NoRecord");
        setIssued(false);
        student.setStudentId("NotIssued");
        student.setPenalty(0);
        setRead(false);
        setAuthorName("");
        setReturn(false);
        setDay(0);
        setMonth(0);
        setYear(0);
        setReturnYear(0);
        setReturnMonth(0);
        setReturnDay(0);
    }
}
