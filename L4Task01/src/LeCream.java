import java.util.Scanner;
public final class LeCream {
	private static int price=0;
	public String flav = "";
	public int scoop = 0;
	public boolean waffer=false;
	public boolean choc = false;
	public void Scopes(int scope) {
		if(scope == 2) {
			if(choc)
				setPrice(getPrice() + 120);
			else
				setPrice(getPrice() + 100);
		}else if(scope==3) {
			if(choc)
				setPrice(getPrice() + 180);
			else 
				setPrice(getPrice() + 150);
		}else {
			System.out.println("Invalid!");
			return ;
		}
	}
	
	public void Wafer() {
		setPrice(getPrice() + 10);
	}
	
	public void choclate() {
		choc= true;
	}
	
	
	public static int getPrice() {
		return price;
	}
	public static void setPrice(int price) {
		LeCream.price = price;
	}
	
	public void menu() {
		System.out.println("Slect Flavour :\n1- chocolate\n2- vanilla\n3- strawberry\n4- mango\n5- tutti fruit\n6- almond crunch\n7- coffee.");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt(); 
		switch(choice) {
		case 1:
			flav= "Choclate";
			break;
		case 2:
			flav= "vanilla";
			break;
		case 3:
			flav= "strawberry";
			break;
		case 4:
			flav= "mango";
			break;
		case 5:
			flav= "trutti fruti";
			break;
		case 6:
			flav= "coffee";
			break;
		}
		if(choice==1) 
			choclate();
		System.out.print("Select Scoops :\n2 Scoops\n3 Scoops");
		choice = scan.nextInt();
		Scopes(choice);
		switch(choice) {
		case 2:
			scoop= 2;
			break;
		case 3:
			scoop = 3;
			break;
		}
		System.out.print("Do you want Waffer : (press 1 for yes) ");
		choice = scan.nextInt();
		if(choice==1) {
			Wafer();
			waffer=true;
		}
		scan.close();
	}
	
	public void bill() {
		System.out.println("You flavour is  : " + flav);
		System.out.println("Scoops are : " + scoop);
		if(waffer==true)
			System.out.println("You ice cream has waffers");
		else
			System.out.println("You ice cream has no waffers");
		System.out.println("Your total bill is: " + getPrice());
	}
	
	
}
