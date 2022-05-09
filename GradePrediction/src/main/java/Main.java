import java.io.IOException;
import java.util.ArrayList;

import org.javatuples.Pair;

public class Main {

    public static void main(String[] args) throws IOException {
            ReadFile.read("src\\main\\resources\\Dataset.xlsx");

        int i=1;
        for(Pair<StudentRecord, ArrayList<Subject>> pair : Data.dataSet){
            System.out.print("íd " + pair.getValue0().getId()+" ");
            for(Subject subject : pair.getValue1())
                System.out.print(subject.getCode()+" "+subject.getGrade()+" ");
            System.out.println("cgpa : " + pair.getValue0().getCGPA()+" warning : "+pair.getValue0().getWarning());
            i++;
        }
        System.out.println(i);
        System.out.println();
        Data.SplitData();
        TrainModel model = new TrainModel();
//        model.calculateTargetEntropy();
//        System.out.println("Target Entropy 0 : " + model.getTargetEntropy());
//        System.out.println();
        Data.setAllCourses();
//        for(String code : Data.allCourses) System.out.println(code);
//        System.out.println();
//        System.out.println(Data.allCourses.size());
//        System.out.println();
//        System.out.println();
//        for(String code : Data.allGrades) System.out.println(code);
//        System.out.println();
//        System.out.println(Data.allGrades.size());
//        HashMap<String,Integer> map = (HashMap<String, Integer>) model.findInstancesOfGrades("CS118")[0];
//        for (String name: map.keySet()) {
//            Integer value = map.get(name);
//            System.out.println(name + " "+ value);
//        }
//        model.shortenList("MT104");
//        model.findEntropy("MT104","CS201");

        int[] instances = model.getInstances(Data.trainingSet,"CS201");
//        System.out.println("target entropy : "+model.processEntropy(instances));
        model.processSubFeature("MT119",model.processEntropy(instances));
        ArrayList<String> features = new ArrayList<>();
        features.add("MT119");features.add("SS101");features.add("MT104");
//        Tree<String> tree = model.getTree();
//        tree = model.processTree(tree.getRoot());
//        Node<String> root = tree.getRoot();
//        while(root.getChilds()!=null){
//            System.out.println(root.getChilds().get(0));
//            root=root.getChilds().get(0);
//        }
//        Tree<String> tree = model.processTree(features);
//        System.out.println(tree.getRoot().getChilds().get(0).getData());
//        System.out.println(tree.getRoot().getChilds().get(0).getChilds().get(1).getData());
    }

}
