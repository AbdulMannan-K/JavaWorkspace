import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.javatuples.Pair;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {

    public static void read(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);
        int id=0,warning = 0,i=0,prevId=-1;double grade,CGPA = 0;String code,gradeLetter;
        ArrayList<Subject> subjects = new ArrayList<>();
        for (Row row : sheet) {
            if(i!=0) {
                prevId = id;
                id = (int) row.getCell(0).getNumericCellValue();
                if (prevId != id) {
                    boolean dsExists=false;
                    for(Subject subject : subjects){
                        if(subject.getCode().equals("CS201")&&subject.getGrade()!=-1) {
                            dsExists=true;
                            break;
                        }
                    }
                    if(dsExists) {
                        StudentRecord student = new StudentRecord(prevId, CGPA, warning);
                        Data.dataSet.add(new Pair<>(student,subjects));
                    }
                    subjects = new ArrayList<>();
                    continue;
                }
                code = row.getCell(2).getStringCellValue();
                grade = row.getCell(6).getNumericCellValue();
                gradeLetter = row.getCell(5).getStringCellValue();
                CGPA = row.getCell(8).getNumericCellValue();
                warning = (int) row.getCell(9).getNumericCellValue();
                boolean alreadyHere=false;
                for(Subject subject : subjects) {
                    if (subject.getCode().equals(code)) {
                        subject.setGrade(grade);
                        subject.setGradeLetter(gradeLetter);
                        alreadyHere=true;
                        break;
                    }
                }
                if(!alreadyHere)
                    subjects.add(new Subject(grade, code,gradeLetter));
            }
            i++;
        }

    }
}