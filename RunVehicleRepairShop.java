package mainPackage;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class RunVehicleRepairShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int dayNum = 0;
		
		System.out.println("Welcome to the Vehicle Repair System Management Tool");
		
		System.out.println("Enter Vehicles repair requests: ");	
		
		Automobile a = new Automobile();
		PartsAndSupplies.createRestockOrderFile();
		System.out.println(a.getRepairChoices());
		String request = scan.nextLine();
		System.out.println("reapir time: " + a.doRepair(Integer.parseInt(request)));
		
		try {
			File myObj = new File("src/mainPackage/textFiles/dailyReport_" + PartsAndSupplies.todayish + ".txt");
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				}
				else {
					System.out.println("file aready exists.");
				}
			}
			catch(IOException e){
				System.out.println("An unexpected error occured.");
				e.printStackTrace();
			}
		
		
	}

}
