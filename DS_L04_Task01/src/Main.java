import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        SortingAlgorithms sorter= new SortingAlgorithms();
        int option;
        while((option=getUserSelection())!=0) {
            switch(option) {
                case 1:{

                    int[][] sortedJaggedPuzzle=new int[3][];

                    int[][] unsortedJaggedPuzzle={
                            {32,30,39,34,37,35,33},
                            {50,48,54,59,47,49,52,51,55,53,57,58},
                            {9,3,6,5,2}
                    };
                    //call your sorting algorithms
                    sortedJaggedPuzzle[0] =  sorter.selectionSort(unsortedJaggedPuzzle[0]);
                    sortedJaggedPuzzle[1] = sorter.selectionSort(unsortedJaggedPuzzle[1]);
                    sortedJaggedPuzzle[2] = sorter.bubbleSort(unsortedJaggedPuzzle[2]);

                    System.out.println("The sorted puzzle is: ");
                    for (int i = 0; i < sortedJaggedPuzzle.length; i++){
                        for (int j = 0; j < sortedJaggedPuzzle[i].length; j++){

                            System.out.print(sortedJaggedPuzzle[i][j]+" ");

                        }
                        System.out.println();
                    }



                    break;
                }
                case 2:{
                    int[][] indices;
                    char crossword[][]={
                            {'C','E','M'},
                            {'B','A','O'},
                            {'X','W','T'}
                    };

                    char word[]={'C','A','T'};
                    indices=searchForWord( crossword,word);
                    System.out.println("The row and column indices are: ");
                    for (int i = 0; i < indices.length; i++){
                        for (int j = 0; j < indices[i].length; j++){

                            System.out.print(indices[i][j]+" ");

                        }
                        System.out.println();
                    }



                    break;
                }


                case 3:{

                    double[][] arr1 = { {0.1,0.6,0.3},{0.3,0.4,0.3},{0.5,0.5,0.0}};
                    double[][] arr2 = { {0.1,0.9,0.3},{0.3,0.4,0.5},{0.5,0.5,0.9}};

                    System.out.println("Is it a Markov Matrix? "+isMarkovMatrix(arr1));
                    System.out.println("Is it a Markov Matrix? "+isMarkovMatrix(arr2));





                    break;
                }


            }
        }





    }//main function ends

    public static boolean linearSeach(char[] arr, char ch){

        for(int i=0  ; i < arr.length ; i++){
            if(arr[i]==ch)
                return true;
        }

        return false;
    }


    public static int[][] searchForWord(char arr[][],char[] word){

        int[][] words_col_row = new int[2][word.length];

        for(int i=0,col=0; i < arr.length ; i++){
            for(int j=0 ; j < arr[i].length ; j++){
                if(linearSeach(word,arr[i][j])) {
                    words_col_row[0][col] = i;
                    words_col_row[1][col] = j;
                    col++;
                }
            }
        }

        return words_col_row;
    }


    public static boolean isMarkovMatrix(double[][] arr){
        double[] row_sum= new double[arr.length];
        for(int i=0 ; i < arr.length ; i++){
            row_sum[i]=0;
            for(int j=0  ; j < arr[i].length ; j++){
                row_sum[i]+=arr[i][j];
            }
        }

        int i=0 ;
        for(int k=0; k < arr.length ; k++){
            if(row_sum[k]==(double)1)
                i++;
        }

        if(i==arr.length)
            return true;
        return false;
    }

    public static int getUserSelection() {
        int option=0;
        System.out.println("Press 1 for testing sorted puzzle");
        System.out.println("Press 2 for testing cross word");
        System.out.println("Press 3 for testing Markov Matrix");

        System.out.println("Press 0 to exit");
        System.out.println();
        while(true) {
            System.out.print("Enter your choice: ");
            Scanner sc=new Scanner(System.in);
            option=sc.nextInt();
            if(option>=0 && option<=3)
                break;
            else{
                System.out.println("Invalid Input");
            }
        }
        return option;
    }

}
