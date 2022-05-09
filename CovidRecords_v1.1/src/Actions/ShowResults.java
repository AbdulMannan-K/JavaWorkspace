package Actions;

import DataHandle.AllRecord;
import Interface.Menu;
import Models.Group;
import Models.Record;

import java.util.Scanner;

public class ShowResults {

    Scanner scan = new Scanner(System.in);

    // shows the table when its no range meaning only one record to show
    // So we send a record and a locationType so locationType is basically either the data is being grouped from country or continent 1 for country and 2 for continent
    public void showTable(int Locationtype, Record record){
        Menu menu = new Menu();
        record.setNewPeopleVaccinated();

        System.out.printf("\n\t\t%-30.30s  %-30.30s  %-30.30s  %-30.30s%n\n", "Date" ,"New Cases","New Deaths", "New People Vaccinated");
        System.out.printf("\n\t\t%-30.30s  %-30.30s  %-30.30s  %-30.30s%n\n", record.getDate(),record.getNewCases() , record.getNewDeaths() , record.getNewPeopleVaccinated());

        int uptoCases=0,uptoDeaths=0;

        // Loop through all records to find upto new cases and new dates till that date
        for(Record record1 : AllRecord.Allrecords){
            if(record.getCountryName().equals(record1.getCountryName())){
                uptoCases+=record1.getNewCases();
                uptoDeaths+=record1.getNewDeaths();
                if(record1.getDate().equals(record.getDate()))
                    break;
            }
        }

        System.out.printf("\n\t\t%-30.30s  %-30.30s  %-30.30s  %-30.30s%n\n", "Upto Data" ,uptoCases,uptoDeaths, record.getPeopleVaccinated());

        // Shows option to continue or go back
        int choice=1;
        do{
            if(choice!=1 && choice!=2){
                System.out.println("\nEnter Choice from 1 or 2!\n");
            }
            System.out.print("Enter \n1- Check Again \n2- Go Back : ");
            choice = scan.nextInt();
        }while (choice!=1 && choice!=2);

        if(choice==1)
            if(Locationtype==1)
                menu.noRangeMenu(Locationtype,record.getCountryName());
            else
                menu.noRangeMenu(Locationtype,record.getContinentName());
        else
            menu.startMenu(false);
    }

    // Location type to tell if the grouping is from continents or country
    // resultType is if user selected to show upto results or total results or individual results
    // Group method is if its either Grouping by days or grouping by number of groups and this is used when to go back to menu because the menu of both grouping methods is change
    // showTable shows the table of All the Groups or some indiviudal Groups
    public void showTable(int Locationtype,int resultType, int groupMethod) {

        if (resultType == 3) { // if result type is 3 meaning the user wants to show individual groups
            System.out.println("\nAll Groups :- "); // to show all groups
            int i = 0;
            for (; i < AllRecord.Allgroups.size(); i++) {
                System.out.println(i + 1 + "- " + AllRecord.Allgroups.get(i).getRecords().get(0).getDate() + " to " + AllRecord.Allgroups.get(i).getRecords().get(AllRecord.Allgroups.get(i).getRecords().size() - 1).getDate());
            }
            int index = 1;
            do {
                if (index < 1 || index > i)
                    System.out.println("\nEnter in between the Range!\n");
                System.out.print("\nEnter Index of The Group You want summary of : ");
                index = scan.nextInt();
            } while (index < 1 || index > i);
            Group group = AllRecord.Allgroups.get(index - 1); // Make a Group that user has chose by help of index beacause the numbering is shown from 1 so index-1 to start from 0

            System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n","Country" ,"Date", "New Cases", "New Deaths", "People Vaccinated");

            for (Record record : group.getRecords()) { // Print the records of that specified Group
                System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n", record.getCountryName() ,record.getDate(), record.getNewCases(), record.getNewDeaths(), record.getNewPeopleVaccinated());
            }
            group.setResults(Locationtype);
            System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n", "Total Results : ", "----" , group.getTotalCases(), group.getTotalDeaths(), group.getTotalVacc());
            System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n", "Upto Results : ", "----" ,group.getUptoCases(), group.getUptoDeaths(), group.getUptoVacc());

        } else { // if the user wants to see reults of all Groups either upto Data or total Data
            if (resultType == 1) // if user want total Data
                System.out.printf("\n\t\t%-30.30s  %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n", "Group Number", "Range", "Total New Cases", "Total New Deaths", "Total People Vaccinated");
            else // if user wants upto Data
                System.out.printf("\n\t\t%-30.30s  %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n", "Group Number", "Range", "Upto Cases", "Upto Deaths", "Upto People Vaccinated");

            int i = 1;
            for (Group group : AllRecord.Allgroups) {
                group.setResults(Locationtype);
                if (resultType == 1)
                    System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n", i, AllRecord.Allgroups.get(i - 1).getRecords().get(0).getDate() + " to " + AllRecord.Allgroups.get(i - 1).getRecords().get(AllRecord.Allgroups.get(i - 1).getRecords().size() - 1).getDate(), group.getTotalCases(), group.getTotalDeaths(), group.getTotalVacc());
                else
                    System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s  %-30.30s%n\n", i, AllRecord.Allgroups.get(i - 1).getRecords().get(0).getDate() + " to " + AllRecord.Allgroups.get(i - 1).getRecords().get(AllRecord.Allgroups.get(i - 1).getRecords().size() - 1).getDate(), group.getUptoCases(), group.getUptoDeaths(), group.getUptoVacc());
                i++;
            }
        }

        // Show the Menu if user wants to go back and exit or wants to continue
            Menu menu = new Menu();

            int choice = 1;
            do {
                if (choice != 1 && choice != 2) {
                    System.out.println("\nEnter Choice from 1 or 2!\n");
                }
                System.out.print("Enter \n1- Check Again \n2- Go Back : ");
                choice = scan.nextInt();
            } while (choice != 1 && choice != 2);

            if (choice == 1 && groupMethod == 1)
                if(Locationtype==1)
                    menu.groupingByDaysMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getCountryName());
                else
                    menu.groupingByDaysMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getContinentName());
            else if (choice == 1 && groupMethod == 2)
                if(Locationtype==1)
                    menu.groupingByNumMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getCountryName());
                else
                    menu.groupingByNumMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getContinentName());
            else
                menu.startMenu(false);

    }

    // LocationType as same as explained before
    // groupMethod is also same
    // This function show the Total data of all Groups in form of graph
    // Total Data include Total new Cases, Total new Deaths , Total Vaccinated people
    public void showGraph(int Locationtype ,int groupMethod) {

        // A graph is basically 2D array of 24x80 size with 80 colms and 24 rows
        String[][]  Graph = new String[24][80];

        for(int i=0 ; i < 24 ; i++)
            for(int j=0 ; j < 80 ; j++)
                Graph[i][j]=" ";

        // making 24th row and 1st col of Graph its borders
        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 79; j >= 0; j--) {
                if (i == 0)
                    Graph[i][j] = "_";
                else if(j==0)
                    Graph[i][j] = "|";
            }
        }

        // Loop to find maximum and minimums of The total Data
        int max=0;int min=100000000,maxTD=0,minTD=1000000000,maxTV=0,minTV=1000000000;// max = max total cases  // maxTD = max total Deaths  // maxTV = max total vaccinated // same for min
        for(Group group : AllRecord.Allgroups){
            group.setResults(Locationtype);
            if(group.getTotalCases() > max)
                max=group.getTotalCases();
            if(group.getTotalCases() < min)
                min=group.getTotalCases();

            if(group.getTotalDeaths() > maxTD)
                maxTD=group.getTotalDeaths();
            if(group.getTotalDeaths() < minTD)
                minTD=group.getTotalDeaths();

            if(group.getTotalVacc() > maxTV)
                maxTV=group.getTotalVacc();
            if(group.getTotalVacc() < minTV)
                minTV=group.getTotalVacc();
        }

        // Find Gap that will be between y-axis each ploted point
        int gap = (int) Math.round((double) (max)/23)+1 ;
        int gapTD = (int) Math.round((double) (maxTD)/23)+1;
        int gapTV = (int) Math.round((double) (maxTV)/23)+1;

        System.out.println("\nX-Axis : 1 to 80  |  1 dash(-) = 1 point \n"); // Shows the Scaling of Graph
        System.out.println("Y-Axis : "+ min +" to " + max + "  |  1 pipe(|) = " + gap + " point/s \n"); // Shows the Scaling of Graph

        // Loop to Plot the Graph
        for(int k=0 ; k < AllRecord.Allgroups.size() ; k++) {
            AllRecord.Allgroups.get(k).setResults(Locationtype); // Set the total and upto data of group
            for (int i = min,j=0; i < max; i+=gap,j++) { // Loop find the temp , temp is basically a temporary index that shows where we have to plot * in graph where the data matchees with x and y axis, number of group with x-axis and total data with y-axis
                int temp=0,diff=0,min1=1000000;
                for(int a=min ; a <= max ; a+=gap){
                    diff=AllRecord.Allgroups.get(k).getTotalCases()-a;
                    if(diff<0)
                        diff*=-1;
                    if(diff<min1){
                        min1=diff;
                        temp=a;
                    }
                }
                if (i == temp ){
                    if(k<79)
                        Graph[j][k+1]="*";
                }
            }
        }

        // Print the Graph
        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 0; j < 80; j++)
                System.out.print(Graph[i][j]);
            System.out.println();
        }

        System.out.println("\nGraph of Total New Cases in Each Group\n"); // Name of Above Graph

        // All the other graphs are also same but with different data like the above one was for total new cases the below one is for total new deaths and soon


        System.out.println("\nX-Axis : 1 to 80  |  1 dash(-) = 1 point \n");
        System.out.println("Y-Axis : "+ minTD +" to " + maxTD + "  |  1 pipe(|) = " + gapTD + " point/s \n");

        for(int i=0 ; i < 24 ; i++)
            for(int j=0 ; j < 80 ; j++)
                Graph[i][j]=" ";

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 79; j >= 0; j--) {
                if (i == 0)
                    Graph[i][j] = "_";
                else if(j==0)
                    Graph[i][j] = "|";
            }
        }

        for(int k=0 ; k < AllRecord.Allgroups.size() ; k++) {
            AllRecord.Allgroups.get(k).setResults(Locationtype);
            for (int i = minTD,j=0; i < maxTD; i+=gapTD,j++) {
                int temp=0,diff=0,min1=1000000;
                for(int a=minTD ; a <= maxTD ; a+=gapTD){
                    diff=AllRecord.Allgroups.get(k).getTotalDeaths()-a;
                    if(diff<0)
                        diff*=-1;
                    if(diff<min1){
                        min1=diff;
                        temp=a;
                    }
                }
                if (i == temp ){
                    if(k<79)
                        Graph[j][k+1]="*";
                }
            }
        }

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 0; j < 80; j++)
                System.out.print(Graph[i][j]);
            System.out.println();
        }

        System.out.println("\nGraph of Total New Deaths in Each Group\n");

        System.out.println("\nX-Axis : 1 to 80  |  1 dash(-) = 1 point \n");
        System.out.println("Y-Axis : "+ minTV +" to " + maxTV + "  |  1 pipe(|) = " + gapTV + " point/s \n");

        for(int i=0 ; i < 24 ; i++)
            for(int j=0 ; j < 80 ; j++)
                Graph[i][j]=" ";

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 79; j >= 0; j--) {
                if (i == 0)
                    Graph[i][j] = "_";
                else if(j==0)
                    Graph[i][j] = "|";
            }
        }

        for(int k=0 ; k < AllRecord.Allgroups.size() ; k++) {
            AllRecord.Allgroups.get(k).setResults(Locationtype);
            for (int i = minTV,j=0; i < maxTV; i+=gapTV,j++) {
                int temp=0,diff=0,min1=10000000;
                for(int a=minTV ; a <= maxTV ; a+=gapTV){
                    diff=AllRecord.Allgroups.get(k).getTotalVacc()-a;
                    if(diff<0)
                        diff*=-1;
                    if(diff<min1){
                        min1=diff;
                        temp=a;
                    }
                }
                if (i == temp ){
                    if(k<79)
                        Graph[j][k+1]="*";
                }
            }
        }

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 0; j < 80; j++)
                System.out.print(Graph[i][j]);
            System.out.println();
        }

        System.out.println("\nGraph of Total New Vaccinated People in Each Group\n");

        Menu menu = new Menu();

        int choice=1;
        do{
            if(choice!=1 && choice!=2){
                System.out.println("\nEnter Choice from 1 or 2!\n");
            }
            System.out.print("Enter \n1- Check Again \n2- Go Back : ");
            choice = scan.nextInt();
        }while (choice!=1 && choice!=2);

        if(choice==1 && groupMethod==1) {
            if (Locationtype == 1)
                menu.groupingByDaysMenu(Locationtype, AllRecord.Allgroups.get(0).getRecords().get(0).getCountryName());
            else
                menu.groupingByDaysMenu(Locationtype, AllRecord.Allgroups.get(0).getRecords().get(0).getContinentName());
        } else if(choice ==1 && groupMethod==2) {
            if(Locationtype==1)
                menu.groupingByNumMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getCountryName());
            else
                menu.groupingByNumMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getContinentName());
        }
        else
            menu.startMenu(false);

    }

    // Same as above graph function but with Upto Data
    public void showUptoGraph(int Locationtype,int groupMethod) {

        String[][]  Graph = new String[24][80];

        for(int i=0 ; i < 24 ; i++)
            for(int j=0 ; j < 80 ; j++)
                Graph[i][j]=" ";

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 79; j >= 0; j--) {
                if (i == 0)
                    Graph[i][j] = "_";
                else if(j==0)
                    Graph[i][j] = "|";
            }
        }

        int max=0;int min=100000000,maxTD=0,minTD=1000000000,maxTV=0,minTV=1000000000;  // max = max upto cases // maxTD = max upto Deaths  // maxTV = max upto vaccinated
        for(Group group : AllRecord.Allgroups){
            group.setResults(Locationtype);
            if(group.getUptoCases() > max)
                max=group.getUptoCases();
            if(group.getUptoCases() < min)
                min=group.getUptoCases();

            if(group.getUptoDeaths() > maxTD)
                maxTD=group.getUptoDeaths();
            if(group.getUptoDeaths() < minTD)
                minTD=group.getUptoDeaths();

            if(group.getUptoVacc() > maxTV)
                maxTV=group.getUptoVacc();
            if(group.getUptoVacc() < minTV)
                minTV=group.getUptoCases();
        }

        int gap = (int) Math.round((double) (max)/23)+1 ;
        int gapTD = (int) Math.round((double) (maxTD)/23)+1;
        int gapTV = (int) Math.round((double) (maxTV)/23)+1;

        System.out.println("\nX-Axis : 1 to 80  |  1 dash(-) = 1 point \n");
        System.out.println("Y-Axis : "+ min +" to " + max + "  |  1 pipe(|) = " + gap + " point/s \n");

        for(int k=0 ; k < AllRecord.Allgroups.size() ; k++) {
            AllRecord.Allgroups.get(k).setResults(Locationtype);
            for (int i = min,j=0; i < max; i+=gap,j++) {
                int temp=0,diff=0,min1=1000000;
                for(int a=min ; a <= max ; a+=gap){
                    diff=AllRecord.Allgroups.get(k).getUptoCases()-a;
                    if(diff<0)
                        diff*=-1;
                    if(diff<min1){
                        min1=diff;
                        temp=a;
                    }
                }
                if (i == temp ){
                    if(k<79)
                        Graph[j][k+1]="*";
                }
            }
        }

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 0; j < 80; j++)
                System.out.print(Graph[i][j]);
            System.out.println();
        }

        System.out.println("\nGraph of Upto New Cases in Each Group\n");


        System.out.println("\nX-Axis : 1 to 80  |  1 dash(-) = 1 point \n");
        System.out.println("Y-Axis : "+ minTD +" to " + maxTD + "  |  1 pipe(|) = " + gapTD + " point/s \n");

        for(int i=0 ; i < 24 ; i++)
            for(int j=0 ; j < 80 ; j++)
                Graph[i][j]=" ";

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 79; j >= 0; j--) {
                if (i == 0)
                    Graph[i][j] = "_";
                else if(j==0)
                    Graph[i][j] = "|";
            }
        }

        for(int k=0 ; k < AllRecord.Allgroups.size() ; k++) {
            AllRecord.Allgroups.get(k).setResults(Locationtype);
            for (int i = minTD,j=0; i < maxTD; i+=gapTD,j++) {
                int temp=0,diff=0,min1=1000000;
                for(int a=minTD ; a <= maxTD ; a+=gapTD){
                    diff=AllRecord.Allgroups.get(k).getUptoDeaths()-a;
                    if(diff<0)
                        diff*=-1;
                    if(diff<min1){
                        min1=diff;
                        temp=a;
                    }
                }
                if (i == temp ){
                    if(k<79)
                        Graph[j][k+1]="*";
                }
            }
        }

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 0; j < 80; j++)
                System.out.print(Graph[i][j]);
            System.out.println();
        }

        System.out.println("\nGraph of Upto New Deaths in Each Group\n");

        System.out.println("\nX-Axis : 1 to 80  |  1 dash(-) = 1 point \n");
        System.out.println("Y-Axis : "+ minTV +" to " + maxTV + "  |  1 pipe(|) = " + gapTV + " point/s \n");

        for(int i=0 ; i < 24 ; i++)
            for(int j=0 ; j < 80 ; j++)
                Graph[i][j]=" ";

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 79; j >= 0; j--) {
                if (i == 0)
                    Graph[i][j] = "_";
                else if(j==0)
                    Graph[i][j] = "|";
            }
        }

        for(int k=0 ; k < AllRecord.Allgroups.size() ; k++) {
            AllRecord.Allgroups.get(k).setResults(Locationtype);
            for (int i = minTV,j=0; i < maxTV; i+=gapTV,j++) {
                int temp=0,diff=0,min1=10000000;
                for(int a=minTV ; a <= maxTV ; a+=gapTV){
                    diff=AllRecord.Allgroups.get(k).getUptoVacc()-a;
                    if(diff<0)
                        diff*=-1;
                    if(diff<min1){
                        min1=diff;
                        temp=a;
                    }
                }
                if (i == temp ){
                    if(k<79)
                        Graph[j][k+1]="*";
                }
            }
        }

        for(int i=23 ; i >= 0 ; i--) {
            for (int j = 0; j < 80; j++)
                System.out.print(Graph[i][j]);
            System.out.println();
        }

        System.out.println("\nGraph of Upto New Vaccinated People in Each Group\n");

        Menu menu = new Menu();

        int choice=1;
        do{
            if(choice!=1 && choice!=2){
                System.out.println("\nEnter Choice from 1 or 2!\n");
            }
            System.out.print("Enter \n1- Check Again \n2- Go Back : ");
            choice = scan.nextInt();
        }while (choice!=1 && choice!=2);

        if(choice==1 && groupMethod==1) {
            if(Locationtype==1)
                menu.groupingByDaysMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getCountryName());
            else
                menu.groupingByDaysMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getContinentName());
        }
        else if(choice ==1 && groupMethod==2) {
            if(Locationtype==1)
                menu.groupingByNumMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getCountryName());
            else
                menu.groupingByNumMenu(Locationtype,AllRecord.Allgroups.get(0).getRecords().get(0).getContinentName());
        }
        else
            menu.startMenu(false);

    }

}
