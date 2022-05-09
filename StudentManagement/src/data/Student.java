package data;

import SMExceptions.naming_exceptions.*;
import data.info.*;
import utilities.StringUtilities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private final Info email = new EMail();
    private final Info rollNo = new RollNo();
    private final Info gender = new Gender();
    private final Info address = new Details();
    private final Info nicNumber = new NICNumber();
    private final Info fatherName = new Name();
    private final Info motherName = new Name();
    private final Info stuContact = new ContactNumber();
    private final Info studentName = new Name();
    private final Info dateOfBirth = new SMDate();
    private final Info fathersContact = new ContactNumber();
    private final Info fathersOccupation = new Details();

    private String time;

    private final Depart depart = new Depart();

    public Student() {
        this.time = StringUtilities.getCreationDate(LocalDateTime.now());
    }

    public final Info getEmail() { return this.email; }
    public final Info getGender() { return this.gender; }
    public final Info getRollNo() { return this.rollNo; }
    public final Info getAddress() { return this.address; }
    public final Info getNicNumber() { return this.nicNumber; }
    public final Info getStuContact() { return this.stuContact; }
    public final Info getFatherName() { return this.fatherName; }
    public final Info getMotherName() { return this.motherName; }
    public final Info getDateOfBirth() { return this.dateOfBirth; }
    public final Info getStudentName() { return this.studentName; }
    public final Info getFathersContact() { return this.fathersContact; }
    public final Info getFathersOccupation() { return this.fathersOccupation; }

    public final Depart getDepart() { return this.depart; }

    public boolean isNull() {
        for (Info f: getAllDetails())
            if (f.get() == null || f.get().equals("Unknown") || f.get().equals(""))
                return true;

        return getDepart() == null || getDepart().getName() == null || getDepart().getName().get() == null ||
                getDepart().getName().get().equals("") || getDepart().getName().get().equals("Unknown") || getDepart().getDegree() == null;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            Student student = new Student();
            for (int i = 0; i<student.getAllDetails().length; i++) {
                try {
                    student.getAllDetails()[i].set(this.getAllDetails()[i].get());
                } catch (WrongInputException e1) {
                    e1.printStackTrace();
                }
            }
            try {
                student.getDepart().getName().set(this.getDepart().getName().get());
                student.getDepart().setDegree(Depart.toDegree(this.getDepart().getDegree()));
            } catch (WrongInputException e1) {
                e1.printStackTrace();
            }
            return student;
        }
    }

    public final Info[] getAllDetails() {
        List<Info> list = new ArrayList<>();

        list.add(this.email);
        list.add(this.rollNo);
        list.add(this.gender);
        list.add(this.address);
        list.add(this.nicNumber);
        list.add(this.fatherName);
        list.add(this.motherName);
        list.add(this.stuContact);
        list.add(this.dateOfBirth);
        list.add(this.studentName);
        list.add(this.fathersContact);
        list.add(this.fathersOccupation);

        return list.toArray(new Info[list.size()]);
    }

    public boolean equals(Student student) {
        Info[] info1 = this.getAllDetails();
        Info[] info2 = student.getAllDetails();

        for (int i = 0; i< this.getAllDetails().length; i++)
            if (! (info1[i].get().equals(info2[i].get())))
                return false;
        return true;
    }

    public final void setAllDetails(List<String> list) {
        for(int i = 0; i < getAllDetails().length; i++) {
            try {
                getAllDetails()[i].set(list.get(i));
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
        }
    }
}