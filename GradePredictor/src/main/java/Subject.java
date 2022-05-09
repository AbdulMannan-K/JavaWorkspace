public class Subject {
    private double grade;
    private String gradeLetter;
    private String code;

    public Subject(double grade, String code, String gradeLetter) {
        this.grade = grade;
        this.code=code;
        this.gradeLetter=gradeLetter;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }
}
