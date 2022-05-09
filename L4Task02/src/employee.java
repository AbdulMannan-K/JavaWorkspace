
public class employee {
	
	private  int empNo;
	private String empName;
	public int[] phone = new int[4];
	private double empComp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	employee(){
		this.setEmpNo(0);
		this.setEmpName(" ");
		this.setEmpComp(0);
		for(int i=0 ; i < 4;i++) {
			phone[i] = 0;
		}
	}
	
	employee(int empNo,String empName,int[] phones , double empComp ){
		this.setEmpNo(empNo);
		this.setEmpName(empName);
		this.setEmpComp(empComp);
		for(int i=0 ; i < 4;i++) {
			phone[i] = phones[i];
		}
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpComp() {
		return empComp;
	}

	public void setEmpComp(double empComp) {
		this.empComp = empComp;
	}
	protected void finalize() {
		System.out.println("Object is destroyed!");
	}
	
	public void ShowInfo() {
		System.out.println("emp Number is "+  getEmpNo());
		System.out.println("emp Name is "+  getEmpName());
		for(int i=0;i < 4;i++) {
			System.out.println("emp Phone numbers are "+  phone[i]);
		}
		
		System.out.println("emp Pay is "+  getEmpComp());
	}
	
}
