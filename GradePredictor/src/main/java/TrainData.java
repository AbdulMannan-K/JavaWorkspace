import org.javatuples.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class TrainData {

    private final String toPredict;
    private double targetEntropy;
    private ArrayList<String> features ;
    private ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list;

    TrainData(String toPredict,ArrayList<String> features){
        this.toPredict=toPredict;
        this.features = features;
        this.targetEntropy=findTargetEntropy(toPredict,cleanData(features));
        this.list = cleanData(features);
    }

    public double findTargetEntropy(String feature,ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list){
        ArrayList<String> possibles = getPossibles(feature,list);
        ArrayList<Integer> instances = new ArrayList<>();
        for(String possible : possibles) instances.add(getInstances(feature,possible,list));
        this.targetEntropy = processEntropy(instances);
        return targetEntropy;
    }

    public double getEntropyFromFormula(double total, double instance){
        if(instance==0) return 0;
        double d = (instance / total);
        return (d * (Math.log(d) / Math.log(2)));
    }

    public double processEntropy(ArrayList<Integer> instances){
        double entropy=0;
        for(int i : instances) entropy = entropy - getEntropyFromFormula(getTotal(instances),i);
        return entropy;
    }

    public int getTotal(ArrayList<Integer> instances){
        int i=0;
        for(int instance : instances) i+=instance;
        return i;
    }

    public int getInstances(String feature,String grade,ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list ){
        int instance = 0;
        for(Pair<StudentRecord, ArrayList<Subject>> pair : list){
            for(Subject subject : pair.getValue1()) if(subject.getCode().equals(feature)) if(subject.getGradeLetter().equals(grade)) instance++;
        }
        return instance;
    }

    public ArrayList<String> getPossibles(String feature,ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list){
        ArrayList<String> possibles = new ArrayList<>();
        for(Pair<StudentRecord, ArrayList<Subject>> pair : list){
            for(Subject subject : pair.getValue1()) if(subject.getCode().equals(feature)) if(!possibles.contains(subject.getGradeLetter())) possibles.add(subject.getGradeLetter());
        }
        return possibles;
    }

    public String getToPredict() {
        return toPredict;
    }

    public double getTargetEntropy() {
        return targetEntropy;
    }

    public double getInformationGain(String feature,ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list ){
        ArrayList<String> possibles = getPossibles(feature,list);
        ArrayList<Double> entropies = new ArrayList<>();
        ArrayList<Integer> totalInstances = new ArrayList<>();
        for(String possible : possibles) {
            totalInstances.add(getInstances(feature,possible,list));
            ArrayList<Pair<StudentRecord,ArrayList<Subject>>> shortenList = getShortenList(list,feature,possible);
            ArrayList<String> sub_possibles = getPossibles(toPredict,shortenList);
            ArrayList<Integer> instances = new ArrayList<>();
            for(String subPossible : sub_possibles)
                instances.add(getInstances(toPredict,subPossible,shortenList));
            entropies.add(processEntropy(instances));
        }

        double ig=targetEntropy;
        for(int i=0 ; i < entropies.size() ; i++){
            ig= ig - ((double) totalInstances.get(i)/getTotal(totalInstances))*entropies.get(i);
        }
        return ig;
    }

    public ArrayList<Pair<StudentRecord,ArrayList<Subject>>> getShortenList(ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list,String feature,String grade){
        ArrayList<Pair<StudentRecord,ArrayList<Subject>>> shortenList=new ArrayList<>();
        for(Pair<StudentRecord, ArrayList<Subject>> pair : list){
            for(Subject subject : pair.getValue1()) {
                if (subject.getCode().equals(feature)) {
                    if (subject.getGradeLetter().equals(grade)) {
                        shortenList.add(pair);
                        break;
                    }
                }
            }
        }
        return shortenList;
    }

    public ArrayList<Pair<StudentRecord,ArrayList<Subject>>> cleanData(ArrayList<String> features){
        ArrayList<Pair<StudentRecord,ArrayList<Subject>>> list = new ArrayList<>();
        int i=0;
        for(Pair<StudentRecord,ArrayList<Subject>> pair : Data.trainingSet){
            for(Subject subject : pair.getValue1()) {
                for (String feature : features) {
                    if(subject.getCode().equals(feature)) i++;
                }
            }
            if(i==features.size()) list.add(pair);
            i=0;
        }
        return list;
    }

    public Tree setTreeRote(){
        ArrayList<Double> Igs = new ArrayList<>();
        for(String feature : features){
            Igs.add(getInformationGain(feature,list));
        }
        int index = Igs.indexOf(Collections.max(Igs));
        return new Tree(new Node(null,features.get(index)));
    }

    public void processTree(Node node, ArrayList<String> features){
        ArrayList<String> possibleGrades = getPossibles(node.getFeature(),list);md[p]
    }


}