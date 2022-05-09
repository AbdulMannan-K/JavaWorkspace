package data;

import SMExceptions.naming_exceptions.WrongInputException;
import data.info.Details;
import data.info.Info;
import data.info.Name;
import data.io.Writer;
import utilities.StringUtilities;

import java.time.LocalDateTime;
import java.util.*;

public class Department {

    private final DepartName name = new DepartName();
    private final Degrees degrees = new Degrees();
    private final Info details = new Details();
    private String time = StringUtilities.getCreationDate(LocalDateTime.now());
    private final LinkedList<Student> students = new LinkedList<>();

    public Department() {
        try {
            details.set("No Details Entered. ");
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public Info getDetails() {
        return details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Department clone() {
        try {
            return (Department) super.clone();
        } catch (CloneNotSupportedException e) {
            Department department = new Department();
            try {
                department.getName().set(this.getName().get());
                department.getDegrees().setMs(this.getDegrees().isMs());
                department.getDegrees().setPhd(this.getDegrees().isPhd());
                department.getDegrees().setBs2year(this.getDegrees().isBs2year());
                department.getDegrees().setBs4year(this.getDegrees().isBs4year());
                department.getDetails().set(this.getDetails().get());
                for (Student student: this.students)
                    department.getStudents().add(student);
            } catch (WrongInputException e1) {
                e1.printStackTrace();
            }
            return department;
        }
    }

    public DepartName getName() {
        return name;
    }

    public Degrees getDegrees() {
        return degrees;
    }

    public void addStu(Student stu) {
        students.add(stu);
        Writer.addToQueue(stu);
    }

    public void removeStu(Student stu) {
        students.remove(stu);
        Writer.addToRemoveQueue(stu);
    }

    public static class DepartName extends Name {
        public String getCode() {

            String s[] = get().split("\\s+");
            StringBuilder sb = new StringBuilder("");

            for (String ss: s)
                sb.append(ss.charAt(0));

            return sb.toString();
        }
    }

    public class Degrees {
        boolean bs4year = false;
        boolean bs2year = false;
        boolean ms = false;
        boolean phd = false;

        Degrees() {
        }

        public void set(boolean b0, boolean b1, boolean b2, boolean b3) {
            this.ms = b2;
            this.phd = b3;
            this.bs4year = b0;
            this.bs2year = b1;
        }

        public boolean isBs4year() {
            return bs4year;
        }

        public void setBs4year(boolean bs4year) {
            this.bs4year = bs4year;
        }

        public boolean isBs2year() {
            return bs2year;
        }

        public void setBs2year(boolean bs2year) {
            this.bs2year = bs2year;
        }

        public boolean isMs() {
            return ms;
        }

        public void setMs(boolean ms) {
            this.ms = ms;
        }

        public boolean isPhd() {
            return phd;
        }

        public void setPhd(boolean phd) {
            this.phd = phd;
        }

        @Override
        public String toString() {
            ArrayList<String> strings = new ArrayList<>();

            if (isBs2year()) strings.add("BS 2-year");
            if (isBs4year()) strings.add("BS 4-year");
            if (isMs()) strings.add("MS");
            if (isPhd()) strings.add("Phd");

            StringBuilder builder = new StringBuilder("");

            builder.append(strings.get(0));
            for (int i = 1; i < strings.size(); i++)
                builder.append(", ").append(strings.get(i));

            return builder.toString();
        }
    }

//    public static Student getByName(String name) {
//        for(Student student: students)
//            if(student.getStudentName().get().equals(name))
//                return student;
//        return null;
//    }
}