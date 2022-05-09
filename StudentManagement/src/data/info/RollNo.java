package data.info;

import SMExceptions.naming_exceptions.WrongInputException;
import data.Data;
import data.Department;
import data.Student;

import java.time.LocalDate;
import java.util.List;

public class RollNo extends Info {

    public RollNo() {
    }

    @Override
    protected boolean validate(CharSequence chars) throws WrongInputException {
        return true;
    }

    @Override
    public void generate(Student stu) {
        try {
            String yearCode = YearCode.generate();
            int number = 1;
            Department department = Data.getByName(stu.getDepart().getName().get());
            List<Student> list = null;
            if (department != null)
                list = department.getStudents();

            if (list != null && yearCode != null)
                for (int i = 0; i <= list.size() -1; i++) {
                    if (list.get(i).getRollNo().get().contains(yearCode) && list.get(i).getRollNo().get().contains(stu.getDepart().getDegreeCode()))
                        number++;
                }

            set(yearCode + "-" + stu.getDepart().getDegreeCode() + stu.getDepart().getName().getCode() + "-" + String.format("%03d", number));

        } catch (WrongInputException e) {
            e.printStackTrace();
        }
    }

    public void updateCode(Student stu) {
        String[] strings = get().split("-");
        strings[1] = stu.getDepart().getDegreeCode() + stu.getDepart().getName().getCode();
        try {
            set(strings[0] + "-" + strings[1] + "-" + strings[2]);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
    }

    public String getYear() {
        String year = get().split("-")[0];
        int i = Integer.parseInt(year.charAt(0)+"");
        i *= 1000;
        StringBuilder sb = new StringBuilder("");
        for (int j = 2; j < year.length(); j++)
            sb.append(year.charAt(j));
        i += Integer.parseInt(sb.toString());
        return ""+i;
    }

    abstract private static class YearCode {
        static String generate() {
            short year = (short) (LocalDate.now().getYear());
            if(year != 0) {
                byte b = (byte) (year/1000);
                short c = (short) (year%1000);
                return b + "K" + c;
            }
            return null;
        }
    }
}