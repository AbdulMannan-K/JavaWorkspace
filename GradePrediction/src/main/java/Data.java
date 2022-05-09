import org.javatuples.Pair;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Pair<StudentRecord,ArrayList<Subject>>> dataSet = new ArrayList<>();

    public static ArrayList<Pair<StudentRecord,ArrayList<Subject>>> trainingSet = new ArrayList<>();

    public static ArrayList<Pair<StudentRecord,ArrayList<Subject>>> testingSet = new ArrayList<>();

    public static ArrayList<String> allCourses = new ArrayList<>() ;

    public static ArrayList<String> allGrades = new ArrayList<>();



    public static void SplitData(){
        for(int i=0 ; i < dataSet.size()-62 ; i++) trainingSet.add(dataSet.get(i));

        for(int i=dataSet.size()-62 ; i < dataSet.size() ; i++) testingSet.add(dataSet.get(i));
    }

    public static void setAllCourses(){
//        for(Pair<StudentRecord,ArrayList<Subject>> pair : trainingSet){
//            for(Subject subject : pair.getValue1()){
//                if(!allCourses.contains(subject.getCode())) allCourses.add(subject.getCode());
//                if(!allGrades.contains(subject.getGradeLetter()) && !subject.getGradeLetter().equals("W") && !subject.getGradeLetter().equals("FA")) allGrades.add(subject.getGradeLetter());
//            }
//        }
        allGrades.add("A+");
        allGrades.add("A");
        allGrades.add("A-");
        allGrades.add("B+");
        allGrades.add("B");
        allGrades.add("B-");
        allGrades.add("C+");
        allGrades.add("C");
        allGrades.add("C-");
        allGrades.add("D+");
        allGrades.add("D");
        allGrades.add("F");
        allGrades.add("W");
        allGrades.add("FA");
    }

}
