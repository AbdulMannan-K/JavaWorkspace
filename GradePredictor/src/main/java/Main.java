import org.javatuples.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ReadFile.read("src\\main\\resources\\Dataset.xlsx");
        Data.SplitData();
        ArrayList<String> features = new ArrayList<>();
       features.add("MT104");features.add("CL118"); features.add("SS101");features.add("MT119");features.add("CL217");

        TrainData trainer = new TrainData("CS201",features);
        System.out.println(trainer.getTargetEntropy());
        System.out.println(trainer.getInformationGain("MT119",Data.trainingSet));
        System.out.println(trainer.cleanData(features).size());
        System.out.println(trainer.findTargetEntropy("CS201",trainer.cleanData(features)));
        System.out.println(trainer.getTargetEntropy());
        System.out.println(trainer.getInformationGain("MT119",trainer.cleanData(features)));
        trainer.makeTree();
        }

}
