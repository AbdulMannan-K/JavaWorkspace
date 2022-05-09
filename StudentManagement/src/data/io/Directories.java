package data.io;

public interface Directories {
    String HOME = System.getProperty("user.home");
    String STUDENT_FOLDER = HOME + "/Students";
    String DEPART_FOLDER = HOME + "/Departments";
    String USER_FOLDER = HOME + "/Users";
}
