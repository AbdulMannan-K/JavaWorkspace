package data.info;

import data.Department;

public class Depart {

    private final Department.DepartName name = new Department.DepartName();
    private Degree degree;


    public Department.DepartName getName() {
        return name;
    }

    public enum Degree {
        BS4, BS2,MS, Phd
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getDegree() {
        if (degree == null)
            return null;

        return degree.toString();
    }

    public static Degree toDegree(String name) {
        System.out.println(name);
        if (name.equals("BS2"))
            return Degree.BS2;
        if (name.equals("BS4"))
            return Degree.BS4;
        if (name.equals("MS"))
            return Degree.MS;
        if (name.equals("Phd"))
            return Degree.Phd;
        else
            return null;
    }

    public String getDegreeCode() {
        if (degree == Degree.BS4 || degree == Degree.BS2)
            return "BS";
        if (degree == Degree.MS)
            return "MS";
        if (degree == Degree.Phd)
            return "Phd";
        else return null;
    }
}