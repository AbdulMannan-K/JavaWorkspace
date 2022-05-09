package data;

import data.io.Writer;

import java.util.LinkedList;
import java.util.List;

public class Data {

    public static class Temp {
        private static Student tempStudent = new Student();
        private static Department tempDepartment = new Department();

        public static void clearDepartment() {
            tempDepartment = new Department();
        }

        public static Student getTempStudent() {
            return tempStudent;
        }

        public static Department getTempDepartment() {
            return tempDepartment;
        }
    }

    private static final List<Department> departments = new LinkedList<>();


    public static List<Department> getDeparts() { return departments; }

    public static void remove(Department depart) {
        departments.remove(depart);
        Writer.addToRemoveQueue(depart);
    }

    public static void add(Department depart) {
        departments.add(depart);
        Writer.addToQueue(depart);
    }

    public static Department getByName(String name) {
        for(Department department: departments)
            if(department.getName().get().equals(name))
                return department;
        return null;
    }
}
