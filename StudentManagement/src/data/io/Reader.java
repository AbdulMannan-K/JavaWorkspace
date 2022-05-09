package data.io;

import SMExceptions.naming_exceptions.*;
import admin.Admin;
import admin.User;
import cryptography.Cryptography;
import data.Data;
import data.Department;
import data.Student;
import data.info.Depart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader extends Cryptography {

    public static void readAll() {
        readDepartments();
        readStudents();
        readUsers();
    }


    private static void readStudents() {
        File[] f = getStudentFiles();
        if(f != null)
            for(File ff: f)
                addStu(readStudent(ff));
    }

    private static void readUsers() {
        File[] f = getUserFiles();
        if (f != null)
            for (File ff: f)
                addUser(readUser(ff));
    }

    private static void addStu(Student stu) {
        for(Department department: Data.getDeparts())
            if(department.getName().get().equals(stu.getDepart().getName().get())) {
                department.getStudents().add(stu);
                return;
            }
    }

    private static void addUser(User user) {
        Admin.getUsers().add(user);
    }

    private static void addDepart(Department depart) {
        Data.getDeparts().add(depart);
    }

    private static void readDepartments() {
        File[] f = getDepartmentFiles();
        if(f != null)
            for(File ff: f)
                addDepart(readDepartment(ff));
    }

    private static File[] getStudentFiles() {
        return new File(Directories.STUDENT_FOLDER).listFiles();
    }

    private static File[] getUserFiles() {
        return new File(Directories.USER_FOLDER).listFiles();
    }

    private static File[] getDepartmentFiles() {
        return new File(Directories.DEPART_FOLDER).listFiles();
    }

    private static User readUser(File f) {
        String name = "Unknown";
        String pass = "Unknown";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            name = decrypt(br.readLine(), 12345);
            pass = decrypt(br.readLine(), 12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new User(name, pass);
    }

    private static Student readStudent(File f) {
        Student stu = new Student();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
            List<String> list = new ArrayList<>();

            for (int i = 0; i < 12; i++)
                list.add(decrypt(br.readLine(), 1234567890L));

            stu.setAllDetails(list);

            String str[] = br.readLine().split("-");
            stu.getDepart().getName().set(decrypt(str[0], 1234567890L));
            stu.getDepart().setDegree(Depart.toDegree(decrypt(str[1], 12345)));
            stu.setTime(decrypt(br.readLine(), 1234567890L));

            br.close();
        } catch (IOException | WrongInputException e) {
            e.printStackTrace();
        }

        return stu;
    }

    private static Department readDepartment(File f) {
        Department depart = new Department();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            depart.getName().set(decrypt(br.readLine(), 1234567890L));
            depart.getDegrees().setBs2year(Boolean.parseBoolean(decrypt(br.readLine(), 1234567890L)));
            depart.getDegrees().setBs4year(Boolean.parseBoolean(decrypt(br.readLine(), 1234567890L)));
            depart.getDegrees().setMs(Boolean.parseBoolean(decrypt(br.readLine(), 1234567890L)));
            depart.getDegrees().setPhd(Boolean.parseBoolean(decrypt(br.readLine(), 1234567890L)));
            depart.setTime(Cryptography.decrypt(br.readLine(), 12345L));
            depart.getDetails().set(Cryptography.decrypt(br.readLine(), 1234567890L));
        } catch (IOException | WrongInputException e) {
            e.getMessage();
        }

        return depart;
    }
}