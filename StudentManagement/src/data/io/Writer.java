package data.io;

import admin.Admin;
import admin.User;
import cryptography.Cryptography;
import data.Department;
import data.Student;

import java.io.*;
import java.util.*;

public class Writer extends Cryptography {

    private final static Queue<Student> TO_BE_WRITTEN_STUDENT = new LinkedList<>();
    private final static Queue<Department> TO_BE_WRITTEN_DEPARTMENT = new LinkedList<>();
    private final static Queue<User> TO_BE_WRITTEN_USERS = new LinkedList<>();

    private final static Queue<Student> TO_BE_REMOVED_STUDENT = new LinkedList<>();
    private final static Queue<Department> TO_BE_REMOVED_DEPARTMENT = new LinkedList<>();
    private final static Queue<User> TO_BE_REMOVED_USERS = new LinkedList<>();

    public static void addToQueue(Student s) {
        TO_BE_WRITTEN_STUDENT.add(s);
    }
    public static void addToQueue(Department d) {
        TO_BE_WRITTEN_DEPARTMENT.add(d);
    }
    public static void addToQueue(User u) {
        TO_BE_WRITTEN_USERS.add(u);
    }

    public static void addToRemoveQueue(Student s) {TO_BE_REMOVED_STUDENT.add(s); }
    public static void addToRemoveQueue(Department d) {TO_BE_REMOVED_DEPARTMENT.add(d); }
    public static void addToRemoveQueue(User u) {TO_BE_REMOVED_USERS.add(u); }


    public static void writeAll() {
        if (Admin.isUnlock()) {
            writeStudents();
            writeDepartments();
            writeUsers();
        }
    }

    public static void removeAll() throws IOException {
        if (Admin.isUnlock()) {
            removeStudents();
            removeDepartments();
            removeUsers();
        }
    }

    private static void writeStudents() {
        Iterator<Student> iterator = TO_BE_WRITTEN_STUDENT.iterator();

        while(iterator.hasNext()) {
            writeData(TO_BE_WRITTEN_STUDENT.remove());
        }
    }

    private static void removeStudents() throws IOException {
        Iterator<Student> iterator = TO_BE_REMOVED_STUDENT.iterator();

        while(iterator.hasNext()) {
            removeData(TO_BE_REMOVED_STUDENT.remove());
        }
    }

    private static void writeDepartments() {
        Iterator<Department> iterator = TO_BE_WRITTEN_DEPARTMENT.iterator();

        while(iterator .hasNext()) {
            writeData(TO_BE_WRITTEN_DEPARTMENT.remove());
        }
    }

    private static void removeDepartments() throws IOException {
        Iterator<Department> iterator = TO_BE_REMOVED_DEPARTMENT.iterator();

        while(iterator .hasNext()) {
            removeData(TO_BE_REMOVED_DEPARTMENT.remove());
        }
    }

    private static void writeUsers() {
        Iterator<User> iterator = TO_BE_WRITTEN_USERS.iterator();

        while(iterator.hasNext()) {
            writeData(TO_BE_WRITTEN_USERS.remove());
        }
    }

    private static void removeUsers() {
        Iterator<User> iterator = TO_BE_REMOVED_USERS.iterator();

        while(iterator.hasNext()) {
            writeData(TO_BE_REMOVED_USERS.remove());
        }
    }


    private static void writeData(Department depart) {
        try {
            File f = checkAndCreateDepartmentFile(depart.getName().getCode());
            if (f != null) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                bw.write(depart.getName().getEncrypted());
                bw.newLine();
                bw.write(encrypt(depart.getDegrees().isBs2year() + "", 1234567890L));
                bw.newLine();
                bw.write(encrypt(depart.getDegrees().isBs4year() + "", 1234567890L));
                bw.newLine();
                bw.write(encrypt(depart.getDegrees().isMs() + "", 1234567890L));
                bw.newLine();
                bw.write(encrypt(depart.getDegrees().isPhd() + "", 1234567890L));
                bw.newLine();
                bw.write(encrypt(depart.getTime(), 12345L));
                bw.newLine();
                bw.write(depart.getDetails().getEncrypted());

                bw.flush();
                bw.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void removeData(Student stu) throws IOException {
        File f = checkAndCreateStudentFile(stu.getRollNo().get());
        if(f != null)
            f.delete();
    }

    private static void writeData(User user) {
        try {
            File f = checkAndCreateUserFile(user.getUserName());
            if (f != null) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                bw.write(encrypt(user.getUserName(), 12345));
                bw.newLine();
                bw.write(encrypt(user.getPassWords(), 12345));
                bw.flush();
                bw.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void writeData(Student stu) {
        try {
            File f = checkAndCreateStudentFile(stu.getRollNo().get());
            if (f != null) {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
                for (int i = 0; i < stu.getAllDetails().length; i++) {
                    bw.write(stu.getAllDetails()[i].getEncrypted());
                    bw.newLine();
                }

                bw.write(stu.getDepart().getName().getEncrypted() + "-" + Cryptography.encrypt(stu.getDepart().getDegree(), 12345));
                bw.newLine();
                bw.write(Cryptography.encrypt(stu.getTime(), 1234567890L));

                bw.flush();
                bw.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void removeData(Department department) throws IOException {
        File f = checkAndCreateDepartmentFile(department.getName().getCode());
        if(f != null)
            f.delete();
    }

    private static File checkAndCreateStudentFile(String roll) throws IOException {
        File f = new File(Directories.STUDENT_FOLDER + "/" + roll + ".txt");
        create(f);
        return f;
    }

    private static File checkAndCreateDepartmentFile(String code) throws IOException {
        File f = new File(Directories.DEPART_FOLDER + "/" + code + ".txt");
        create(f);
        return f;
    }

    private static File checkAndCreateUserFile(String code) throws IOException {
        File f = new File(Directories.USER_FOLDER + "/" + code + ".txt");
        create(f);
        return f;
    }

    private static void create(File f) throws IOException {
        createFolders();
        try {
            if(!f.exists())
                if(!f.createNewFile())
                    throw new IOException("File was Not Created");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void createFolders() throws IOException {
        if(! new File(Directories.STUDENT_FOLDER).exists())
            if(! new File(Directories.STUDENT_FOLDER).mkdirs())
                throw new IOException("Can not Create Folders");

        if(! new File(Directories.DEPART_FOLDER).exists())
            if(! new File(Directories.DEPART_FOLDER).mkdirs())
                throw new IOException("Can not Create Folders");

        if(! new File(Directories.USER_FOLDER).exists())
            if(! new File(Directories.USER_FOLDER).mkdirs())
                throw new IOException("Can not Create Folders");
    }
}