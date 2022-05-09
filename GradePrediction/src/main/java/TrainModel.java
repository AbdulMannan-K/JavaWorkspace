import org.apache.poi.ss.formula.functions.T;
import org.javatuples.Pair;

import java.util.*;

public class TrainModel {

//    private double targetEntropy;
////    private ArrayList<Double> InformationGain = new ArrayList<>();
//
//    public double findEntropy(String feature,String target_code){
//        Object[] array = findInstancesOfGrades(feature);
//        HashMap<String,Integer> map = (HashMap<String, Integer>) array[0];
//        ArrayList<ArrayList<Pair<StudentRecord,ArrayList<Subject>>>> list = (ArrayList<ArrayList<Pair<StudentRecord, ArrayList<Subject>>>>) array[1];
//        for (String name: map.keySet()) {
//            Integer value = map.get(name);
//            System.out.println(name + " "+ value);
//        }
//        int j=0;
//        double entropy=0;
//        double ig = 0;
//        ig=ig+targetEntropy;
//
//        for(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> l : list){
//            entropy=0;
//            int[] instances = compareWithTargetClass(l,target_code);
//            for (int instance : instances) {
//                System.out.println(Data.allGrades.get(j) + " " + instance);
//                entropy = entropy - returnEntropyValue(map.get(Data.allGrades.get(j)), instance);
//            }
//
//            System.out.println();
//            System.out.println();
//            System.out.println(entropy);
//            System.out.println();
//            System.out.println();
////            for(int i=0 ; i < 12 ;i++){
////                System.out.println("value : " + map.get(Data.allGrades.get(i)));
////            }
//            ig = ig-(((double) map.get(Data.allGrades.get(j))/Data.trainingSet.size())*entropy);
////            InformationGain.add(ig);
//            System.out.println();
//            System.out.println("ig = " + ig);
//            j++;
//        }
//        return ig;
//    }
//
//    public double returnEntropyValue(double total, double instance){
//            if(instance==0) return 0;
//            double d = ((double) instance / total);
//        return (d * (Math.log(d) / Math.log(2)));
//    }
//    public Object[] findInstancesOfGrades(String feature) {
//        HashMap<String,Integer> map = new HashMap<>();
//        ArrayList<ArrayList<Pair<StudentRecord,ArrayList<Subject>>>> list= new ArrayList<>();
//        for(String grade : Data.allGrades){
//            list.add(returnInstances(feature,grade));
//            map.put(grade,returnInstances(feature,grade).size());
//        }
//        Object[] array = {map,list};
//        return array;
//    }
//
//    public ArrayList<Pair<StudentRecord,ArrayList<Subject>>> returnInstances(String subject,String feature){
//        int i=0;
//        ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list = new ArrayList<>();
//        for(Pair<StudentRecord, ArrayList<Subject>> pair : Data.trainingSet){
//            for(Subject subject1 : pair.getValue1()){
//                if(subject1.getCode().equals(subject) && subject1.getGradeLetter().equals(feature)) {
//                    list.add(pair);
//                }
//            }
//        }
//        return list;
//    }
//
//    public void findEntropy(double feature){
//
//    }
//
//    public void calculateTargetEntropy(){
//        int[] instances = new int[12];
//        targetEntropy=0;
//        // A+,A,A-,B+,B,B-,C+,C,C-,D+,D,F
//        for(Pair<StudentRecord, ArrayList<Subject>> pair : Data.trainingSet){
//            for(Subject subject : pair.getValue1()){
//                if(subject.getCode().equals("CS201")) {
//                    switch (subject.getGradeLetter()) {
//                        case "A+" -> instances[0]++;
//                        case "A" -> instances[1]++;
//                        case "A-" -> instances[2]++;
//                        case "B+" -> instances[3]++;
//                        case "B" -> instances[4]++;
//                        case "B-" -> instances[5]++;
//                        case "C+" -> instances[6]++;
//                        case "C" -> instances[7]++;
//                        case "C-" -> instances[8]++;
//                        case "D+" -> instances[9]++;
//                        case "D" -> instances[10]++;
//                        case "F" -> instances[11]++;
//                    }
//                }
//            }
//        }
//        for (int instance : instances) {
//            if(instance==0) continue;
//            double d = ((double) instance / Data.trainingSet.size());
//            targetEntropy = targetEntropy - (d * (Math.log(d) / Math.log(2)));
//        }
//    }
//
//    public void shortenList(String code){
//        boolean isExist=false;
//        ArrayList<Pair<StudentRecord, ArrayList<Subject>>> toremove = new ArrayList<>();
//        for(Pair<StudentRecord, ArrayList<Subject>> pair : Data.trainingSet) {
//            isExist=false;
//            for(Subject subject : pair.getValue1()) {
//                if (subject.getCode().equals(code)) {
//                    isExist = true;
//                    break;
//                }
//            }
//            if(!isExist) toremove.add(pair);
//        }
//        for(Pair<StudentRecord, ArrayList<Subject>> pair : toremove) {
//            Data.trainingSet.remove(pair);
//
//        }
//        System.out.println("size : " + Data.trainingSet.size());
//    }
//
//    public int[] compareWithTargetClass(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String code){
//        int[] instances = new int[12];
//        // A+,A,A-,B+,B,B-,C+,C,C-,D+,D,F
//        targetEntropy=0;
//        for(Pair<StudentRecord, ArrayList<Subject>> pair : list){
//            for(Subject subject : pair.getValue1()){
//                if(subject.getCode().equals(code)) {
//                    switch (subject.getGradeLetter()) {
//                        case "A+" -> instances[0]++;
//                        case "A" -> instances[1]++;
//                        case "A-" -> instances[2]++;
//                        case "B+" -> instances[3]++;
//                        case "B" -> instances[4]++;
//                        case "B-" -> instances[5]++;
//                        case "C+" -> instances[6]++;
//                        case "C" -> instances[7]++;
//                        case "C-" -> instances[8]++;
//                        case "D+" -> instances[9]++;
//                        case "D" -> instances[10]++;
//                        case "F" -> instances[11]++;
//                    }
//                }
//            }
//        }
//        return instances;
//    }
//
//    public double getTargetEntropy() {
//        return targetEntropy;
//    }
//
//    public Tree<String> makeTree(ArrayList<String> features,String code){
//        Tree<String> tree = new Tree<>();
//        ArrayList<Double> entropies = new ArrayList<>();
//        double max=0;
//        for (String s: features) {
//            double d = findEntropy(s,code);
//            if(d>max) max=d;
//            entropies.add(d);
//        }
//        tree.setRoot(new Node<>(features.get(entropies.indexOf(max))));
//        for(String s : getGrades(features.get(entropies.indexOf(max)))){
//            tree.getRoot().getChilds().add(s);
//        }
//        entropies.remove(max);
//        ArrayList<ArrayList<Pair<StudentRecord,ArrayList<Subject>>>> reducedLists = new ArrayList<>();
//        for(String s : getGrades(features.get(entropies.indexOf(max))))
//            reducedLists.add(reduceList(Data.testingSet,features.get(entropies.indexOf(max)),s));
//
//        for(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> lists : reducedLists){
//
//        }
//        return tree;
//    }
//
//    public ArrayList<Pair<StudentRecord,ArrayList<Subject>>> reduceList(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String Code,String grade){
//        ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list1 =new ArrayList<>();
//        for(Pair<StudentRecord,ArrayList<Subject>> pair : list){
//            for(Subject subject : pair.getValue1()){
//                if(subject.getCode().equals(Code)  && subject.getGradeLetter().equals(grade)) list1.add(pair);
//            }
//        }
//        return list1;
//    }
//
//    public void addInTree(Node<String> root,ArrayList<String> grades){
//        for(String s: grades){
//            root.getChilds().add(s);
//        }
//    }
//
//    public ArrayList<String> getGrades(String code){
//        ArrayList<String> grades = new ArrayList<>();
//        for(Pair<StudentRecord,ArrayList<Subject>> pair : Data.trainingSet){
//            for(Subject subject : pair.getValue1()){
//                if(subject.getCode().equals(code))
//                    if(!grades.contains(subject.getGradeLetter()) && !subject.getGradeLetter().equals("W") && !subject.getGradeLetter().equals("FA") ) grades.add(subject.getCode());
//            }
//        }
//        return grades;
//    }


    public int[] getInstances(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String code){
        int[] instances = new int[14];
        // A+,A,A-,B+,B,B-,C+,C,C-,D+,D,F,W,FA
        for (Pair<StudentRecord,ArrayList<Subject>> pair : list) {
            for(Subject subject : pair.getValue1()){
                if(subject.getCode().equals(code)){
                    switch (subject.getGradeLetter()) {
                        case "A+" -> instances[0]++;
                        case "A" -> instances[1]++;
                        case "A-" -> instances[2]++;
                        case "B+" -> instances[3]++;
                        case "B" -> instances[4]++;
                        case "B-" -> instances[5]++;
                        case "C+" -> instances[6]++;
                        case "C" -> instances[7]++;
                        case "C-" -> instances[8]++;
                        case "D+" -> instances[9]++;
                        case "D" -> instances[10]++;
                        case "F" -> instances[11]++;
                        case "W" -> instances[12]++;
                        case "FA" -> instances[13]++;
                    }
                }
            }
        }
        return instances;
    }

    public double getEntropyFromFormula(double total, double instance){
        if(instance==0) return 0;
        double d = (instance / total);
        return (d * (Math.log(d) / Math.log(2)));
    }

    public double processEntropy(int[] instances){
        double entropy=0;
        for(int i : instances){
            entropy = entropy - getEntropyFromFormula(getTotal(instances),i);
        }
        return entropy;
    }

    public double getEntropy(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String feature){
        int[] instances = getInstances(Data.trainingSet,feature);
        return processEntropy(instances);
    }

    public int getTotal(int[] instances){
        int i=0;
        for(int instance : instances) i+=instance;
        return i;
    }

    public double processSubFeature(String feature, double targetEntropy){
        int[] instances = getInstances(Data.trainingSet,feature);
        ArrayList<ArrayList<Pair<StudentRecord,ArrayList<Subject>>>> subLists  = new ArrayList<>();
        for(String grade : Data.allGrades){
            subLists.add(getShortenList(Data.trainingSet,feature,grade));
        }
        int[][] subInstances = new int[subLists.size()][];
        int i=0;
        for(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list : subLists){
            subInstances[i] = getInstances(list,"CS201");
            i++;
        }

        double[] entropies = new double[14];
        for(i=0 ; i < subInstances.length ; i++){
            entropies[i]=processEntropy(subInstances[i]);
        }
        System.out.println("ig = " + getInformationGain(entropies,instances,targetEntropy));
        return getInformationGain(entropies,instances,targetEntropy);
    }

    public double getInformationGain(double[] entropies ,int[] instances, double targetEntropy){
        double ig=targetEntropy;
        for(int i=0 ; i < entropies.length ; i++){
            ig= ig - ((double) instances[i]/getTotal(instances))*entropies[i];
        }
        return ig;
    }

    public ArrayList<Pair<StudentRecord,ArrayList<Subject>>> getShortenList(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String code, String grade){
        ArrayList<Pair<StudentRecord,ArrayList<Subject>>> newList = new ArrayList<>();
        for (Pair<StudentRecord,ArrayList<Subject>> pair : list) {
            for (Subject subject : pair.getValue1()) {
                if(subject.getCode().equals(code) && subject.getGradeLetter().equals(grade)) newList.add(pair);
            }
        }
        return newList;
    }
    Tree<String> tree = new Tree<>();

//    public void makeTree(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,ArrayList<String> features,double targetEntropy,Node<String> roott){
//        if(features.size()==1) {//            System.out.println("Tree formed");
//            return;
//        }
//        ArrayList<Double> informationGain = new ArrayList<>();
//        for (String feature : features) {
//            informationGain.add(processSubFeature(feature, targetEntropy));
//        }
//        int root = informationGain.indexOf(findMax(informationGain));
//        if(roott==null) {
//            tree.setRoot(new Node<>(features.get(root)));
//            roott=tree.getRoot();
//        }
//        roott = (new Node<>(features.get(root)));
//        setchilds(roott,getGrades(list,features.get(root)));
//        String subject = features.get(root);
//        features.remove(features.get(root));
//        int i=0;
//        for(String grade : getGrades(list,subject)) {
//            int[] instances = getInstances(Data.trainingSet,subject);
//            makeTree(getShortenList(Data.trainingSet, subject, grade),features,processEntropy(instances),roott.getChilds().get(i++));
//        }
//    }
    public Node<String> makeTree(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list, ArrayList<String> features,double targetEntropy){

        Queue<Node<String>> grades = new Queue<>(10000);

        Node<String> root = returnRoot(list,getMaxInformationGain(list,features,targetEntropy));
        features.remove(root.getData());
        for(Node<String> node : root.getChilds()) grades.enqueue(node);
        processSubGradesInTree(grades,features,root.getData(),list,root);
        return root;
    }

    public void processSubGradesInTree(Queue<Node<String>> grades,ArrayList<String> features,String code,ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,Node<String> node){
        if(grades.isEmpty() || grades.size>=5000) {
            System.out.println("Not here");
            return;
        }
        Node<String> root = grades.dequeue();
        if(root==null) return;
        ArrayList<Pair<StudentRecord,ArrayList<Subject>>> shortList = getShortenList(list,code,root.getData());
        String[] targetedGrades = getGrades(shortList,"CS201");
        if(checkProceed(targetedGrades)) {
            System.out.println("size  0 " + grades.size );

            for(int i=0 ; i < node.getChilds().size() ; i++){
                if(node.getChilds().get(i).equals(root))
                    node.getChilds().set(i,processSubFeaturesInTree(grades, features, code, shortList));
            }

            System.out.println("size 1  " + grades.size );

            processSubGradesInTree(grades,features,code,list,root.getParent());
        }
    }

    public Node<String> processSubFeaturesInTree(Queue<Node<String>> grades,ArrayList<String> features,String code,ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list){
        Node<String> root = returnRoot(list,getMaxInformationGain(list,features,getEntropy(list,code)));
//        System.out.println();
        for(Node<String> node : root.getChilds()) {
            grades.enqueue(node);
//            System.out.println("here " + grades.size );
        }
//        System.out.println();
        return root;
    }

    public boolean checkProceed(String[] grades){
        int i=0;
        for(String grade : grades){
            if(grade==null) i++;
        }
        System.out.println("i = " + i);
        return i != grades.length - 1;
    }

    public String getMaxInformationGain(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,ArrayList<String> features,double targetEntropy){
        double max =0;int max_index=0;
        for(int i=0 ; i < features.size() ; i++){
            double d = targetEntropy-getEntropy(list,features.get(i));
            if(d>max) {
                System.out.println("lll : " + d);
                max = d;
                max_index=i;
            }
        }
        return features.get(max_index);
    }

    public Node<String> returnRoot(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String feature){
        String[] grades = getGrades(list,feature);
        ArrayList<String> newGrades = new ArrayList<>();
        for(String grade : grades){
            if(grade!=null) newGrades.add(grade);
        }
        String[] grade = new String[newGrades.size()];
        for(int i=0 ; i < grade.length ; i++) grade[i]=newGrades.get(i);
        Node<String> root = new Node<>(feature);
//        Queue<String> queue = new Queue<>();
//        for(String grade : grades) queue.enqueue(grade);
        setchilds(root, grade);
        return root;
    }

    public int processPossibility(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String subject,String grade){
        int i=0;
        for (Pair<StudentRecord,ArrayList<Subject>> pair : list) {
            for(Subject subject1 : pair.getValue1()){
                if(subject1.getCode().equals(subject) && subject1.getGradeLetter().equals(grade)) i++;
            }
        }
        return i;
    }


    public Tree<String> processTree(ArrayList<String> features){
        Tree<String> tree = new Tree<>();
        Node<String> root = makeTree(Data.trainingSet,features,getEntropy(Data.trainingSet,"CS201"));
        tree.setRoot(root);
        return tree;
    }

    public double findMax(ArrayList<Double> list){
        double max =0;
        for(double d : list) if(d>max) max=d;
        return max;
    }

    public void setchilds(Node<String> root,String[] grades){
        root.setChilds(convertToList(root,grades));
    }

    public ArrayList<Node<String>> convertToList(Node<String> root, String[] array){
        ArrayList<Node<String>> list = new ArrayList<>();

        for(String s : array){
            Node<String> node = new Node<>(s);
            node.setParent(root);
            list.add(node);
        }
        return list;
    }

    public String[] getGrades(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String code){
        String[] instances = new String[14];
        // A+,A,A-,B+,B,B-,C+,C,C-,D+,D,F,W,FA
        for (Pair<StudentRecord,ArrayList<Subject>> pair : list) {
            for(Subject subject : pair.getValue1()){
                if(subject.getCode().equals(code)){
                    switch (subject.getGradeLetter()) {
                        case "A+" -> instances[0]="A+";
                        case "A" -> instances[1]="A";
                        case "A-" -> instances[2]="A-";
                        case "B+" -> instances[3]="B+";
                        case "B" -> instances[4]="B";
                        case "B-" -> instances[5]="B-";
                        case "C+" -> instances[6]="C+";
                        case "C" -> instances[7]="C";
                        case "C-" -> instances[8]="C-";
                        case "D+" -> instances[9]="D+";
                        case "D" -> instances[10]="D";
                        case "F" -> instances[11]="F";
                        case "W" -> instances[12]="W";
                        case "FA" -> instances[13]="FA";
                    }
                }
            }
        }
        return instances;
    }

    public Tree<String> getTree() {
        return tree;
    }
}