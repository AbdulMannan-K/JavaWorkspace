import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {

    private String grade;

    private String targetGrade;

    private String feature;
    private ArrayList<Node> possibles;

    private ArrayList<Pair<StudentRecord,ArrayList<Subject>>> data;

    public Node(String grade){
        this.grade=grade;
        feature=null;
        possibles= new ArrayList<>();
    }

    public Node(String grade,String feature){
        this.grade=grade;
        this.feature=feature;
        possibles=new ArrayList<>();
    }

    public ArrayList<Node> getPossibles() {
        return possibles;
    }

    public String getFeature() {
        return feature;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setPossibles(ArrayList<Node> possibles) {
        this.possibles = possibles;
    }

    public String getTargetGrade() {
        return targetGrade;
    }

    public void setTargetGrade(String targetGrade) {
        this.targetGrade = targetGrade;
    }

    public ArrayList<Pair<StudentRecord, ArrayList<Subject>>> getData() {
        return data;
    }

    public void setData(ArrayList<Pair<StudentRecord, ArrayList<Subject>>> data) {
        this.data = data;
    }
}
