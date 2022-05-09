package Data;

import Models.Record;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadCSV {

    public void read(){

        String line;
        String[] data ;
        try {
            BufferedReader br = new BufferedReader(new FileReader("covid_data.csv"));
            line=br.readLine();
            while ((line = br.readLine()) != null){
                data = line.split(",");
                if(data.length==4) {
                    AllRecord.records.add(new Record(data[2], data[1], data[3], 0, 0, 0, 0));
                }
                else if(data.length==5) {
                    if(data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,0,0,0));
                    else
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,0));
                }
                else if(data.length==6) {
                    if(data[5].equals("") && data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,0,0,0));
                    else if(data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),0,0));
                    else if(data[5].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,0));
                    else
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),0,0));

                }
                else if(data.length==7){
                    if(data[6].equals("") && data[5].equals("") && data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,0,0,0));
                    else if(data[5].equals("") && data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,0,0,Integer.parseInt(data[6])));
                    else if(data[6].equals("") && data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),0,0));
                    else if(data[6].equals("") && data[5].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,0));
                    else if(data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),0,Integer.parseInt(data[6])));
                    else if(data[5].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,Integer.parseInt(data[6])));
                    else if(data[6].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),0,0));
                    else
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),0,Integer.parseInt(data[6])));
                }
                else{
                    if(data[6].equals("") && data[5].equals("") && data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,0,Long.parseLong(data[7]),0));
                    else if(data[5].equals("") && data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,0,Long.parseLong(data[7]),Integer.parseInt(data[6])));
                    else if(data[6].equals("") && data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),Long.parseLong(data[7]),0));
                    else if(data[6].equals("") && data[5].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,Long.parseLong(data[7]),0));
                    else if(data[4].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),Long.parseLong(data[7]),Integer.parseInt(data[6])));
                    else if(data[5].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,Long.parseLong(data[7]),Integer.parseInt(data[6])));
                    else if(data[6].equals(""))
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),Long.parseLong(data[7]),0));
                    else
                        AllRecord.records.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),Long.parseLong(data[7]),Integer.parseInt(data[6])));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
