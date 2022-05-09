
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		employee[] emp = new employee[3];
		int[] phone = {13,432,4524,234};
		int m=2;
		String name = "Abdul";
		double pr = 4.22;
		emp[0] = new employee(m,name,phone,pr) ;
		emp[0].ShowInfo();
		
	}

}
