import java.io.IOException;
import java.util.Scanner;


// Node Class
public class Node {

  public int roll;
  public String Name;
  public String Dept;
  public int Marks;
  Node next;
  Node prev;
  static Node head = new Node();
 
	
	// Record Already Exist or Not
		Boolean check(int x)
		{
		    if (head == null) //base case
		        return false;
	 
		    Node t = new Node();
		    t = head;
	 
		    // Traverse the Linked List
		    while (t != null) {
		        if (t.roll == x)
		            return true;
		        t = t.next;
		    }
	 
	    return false;
	     }
 
		// Function to insert the record
		public void Insert_Record(int roll, String Name, String Dept, int Marks)
		{
		    // if Record Already Exist
		    if (check(roll)) {
		        System.out.println("Student with this record Already Exists");
		        return;
		    }
		 
		    // Create new Node to Insert Record
		    Node t = new Node();
		    t.roll = roll;
		    t.Name = Name;
		    t.Dept = Dept;
		    t.Marks = Marks;
		    t.next = null;
		 
		    // Insert at Begin
		    if (head == null || (head.roll >= t.roll)) {
		        t.next = head;
				t.prev=null;
		        head = t;
		    }
		 
		    // Insert at middle or End
		    else {
		        Node c = head;
		        while (c.next != null && c.next.roll < t.roll) {
		            c = c.next;
		        }
		        t.next = c.next;
				t.prev = c;
		        c.next = t;
		    }
		 
		    System.out.println("Record Inserted Successfully");
		}

		
		void Show_Record()
		{
		    Node p = head;
		    if (p == null) {
		        System.out.println("No RecordAvailable\n");
		    }
		    else {
		    	System.out.println("Index\tName\tCourse\tMarks\n");
		 
		        // Until p is not NULL
		        while (p != null) {
		        	System.out.println(p.roll+"\t"+p.Name+"\t"+p.Dept+"\t"+p.Marks);
		        	p = p.next;
		        }
		            
		        }
		    }
		
		// students Record with roll number
		void Search_Record(int roll)
		{
		    // if head is NULL
		    if (head==null) {
		       System.out.println("No such Record Available");
		        return;
		    }
		 
		    // Otherwise
		    else {
		        Node p = head;
		        while (p != null) {
		            if (p.roll == roll) {
			        	System.out.println(p.roll+"\t"+p.Name+"\t"+p.Dept+"\t"+p.Marks);

		                return;
		            }
		            p = p.next;
		        }
		 
		        if (p == null)
		            System.out.println("No such Record Available\n");
		    }
		}
		
		
		// if it exist
		int Delete_Record(int roll)
		{
		    Node t = head;
		    Node p = null;
		 
		    // Deletion at Begin
		    if (t != null && t.roll == roll) {
		        head = t.next;
				t.prev=null;
		        System.out.println("Record Deleted Successfully\n");
		        return 0;
		    }
		 
		    // Deletion Other than Begin
		    while (t != null && t.roll != roll) {
		        p = t;
		        t = t.next;
		    }
		    if (t == null) {
		    	System.out.println( "Record does not Exist\n");
		        return -1;
		    }
		        p.next = t.next;
				t.prev=p;
		        System.out.println("Record Deleted Successfully\n");
		 
		        return 0;
		    }
		

	public static void main(String[] args) throws IOException {

		Node node=new Node();
		    head = null;
		    String Name, Course;
		    int Roll, Marks;
		    // Menu-driven program
		    while (true) {
		        System.out.println("\n\t\tWelcome to Student Record Management System\n\n\tPress\n\t1 to create a new Record\n\t2 to delete a student record\n\t3 to Search a Student Record\n\t4 to view all students  record\n\t5 to Exit\n");
		        System.out.println("Enter your Choice");
		       
		        Scanner input= new Scanner(System.in);
		        int Choice=input.nextInt();

		        if (Choice == 1) {
		       System.out.println("Enter Name of Student");
		       Name=input.next();
		       System.out.println( "Enter Roll Number of Student");
		       Roll=input.nextInt();
		       System.out.println("Enter Course of Student");
		       Course=input.next();
			   System.out.println("Enter Total Marks of Student");
			   Marks=input.nextInt();
			   node.Insert_Record(Roll, Name, Course, Marks);
		        }
		        else if (Choice == 2) {
		        	System.out.println( "Enter Roll Number of Student");
				    Roll=input.nextInt();
		            node.Delete_Record(Roll);
		        }
		        else if (Choice == 3) {
				    System.out.println( "Enter Roll Number of Student");
				    Roll=input.nextInt();
		            node.Search_Record(Roll);
		        }
		        else if (Choice == 4) {
		            node.Show_Record();
		        }
		        else if (Choice == 5) {
		            System.exit(0);
		        }
		        else {
		        	 System.out.println( "Invalid Choice Try Again\n");
		        }
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}

		}}