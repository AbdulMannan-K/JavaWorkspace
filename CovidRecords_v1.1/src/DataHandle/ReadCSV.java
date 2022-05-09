package DataHandle;

import Models.Record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    // Reads the data from CSV file
    public void read(){

        String line;
        String[] data ;
        try {
            BufferedReader br = new BufferedReader(new FileReader("covid_data.csv"));
            line=br.readLine(); // 1st Line contains title so ignoring it
            while ((line = br.readLine()) != null){
                data = line.split(","); // split function divides the line into array with every index having 1 word of Line

                // if you see data in CSV file is also absent from some columns so while reading file the data array has not one size it has variable size so i had to create checks
                // if the data array has only 4 index the data will store irregularly like country name having continent name type thing and we don't want tthat
                // so i created checks for every situation and wehn the data is not present it replaces it with zero
                if(data.length==4) {
                    AllRecord.Allrecords.add(new Record(data[2], data[1], data[3], 0, 0, 0, 0));
                }
                else if(data.length==5) {
                    if(data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,0,0,0));
                    else
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,0));
                }
                else if(data.length==6) {
                    // if the data is null in some of these data array indexs then it will be replaced with zero instead of null
                    if(data[5].equals("") && data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,0,0,0));
                    else if(data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),0,0));
                    else if(data[5].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,0));
                    else
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),0,0));

                }
                else if(data.length==7){
                    if(data[6].equals("") && data[5].equals("") && data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,0,0,0));
                    else if(data[5].equals("") && data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,0,0,Integer.parseInt(data[6])));
                    else if(data[6].equals("") && data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),0,0));
                    else if(data[6].equals("") && data[5].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,0));
                    else if(data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),0,Integer.parseInt(data[6])));
                    else if(data[5].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,0,Integer.parseInt(data[6])));
                    else if(data[6].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),0,0));
                    else
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),0,Integer.parseInt(data[6])));
                }
                else{
                    if(data[6].equals("") && data[5].equals("") && data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,0,Long.parseLong(data[7]),0));
                    else if(data[5].equals("") && data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,0,Long.parseLong(data[7]),Integer.parseInt(data[6])));
                    else if(data[6].equals("") && data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),Long.parseLong(data[7]),0));
                    else if(data[6].equals("") && data[5].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,Long.parseLong(data[7]),0));
                    else if(data[4].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],0,Integer.parseInt(data[5]),Long.parseLong(data[7]),Integer.parseInt(data[6])));
                    else if(data[5].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),0,Long.parseLong(data[7]),Integer.parseInt(data[6])));
                    else if(data[6].equals(""))
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),Long.parseLong(data[7]),0));
                    else
                        AllRecord.Allrecords.add(new Record(data[2],data[1],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),Long.parseLong(data[7]),Integer.parseInt(data[6])));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
