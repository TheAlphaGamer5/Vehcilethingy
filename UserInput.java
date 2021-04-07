package mainPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
	masterList listOfTasks = new masterList();
	
	public masterList runUserIterface(int dayNum) {
		listOfTasks.clearList();
		System.out.println("####################################################");
		System.out.println("Welcome to day number " + dayNum + ".");
		System.out.println("-----------------------------");
		importTaskList();
		System.out.println("Task from previous day work orders have been added to the repair list.");
		showVehicleList();
		runUserInputMenu();
		System.out.println("Tasks to be completed on day " + dayNum + ": ");
		showVehicleList();
		System.out.println("-----------------------------");
		return getWorkList();
	}
	
	private void runUserInputMenu() {
		try {
			Scanner inScan = new Scanner(System.in);
			showSelectionMenu_1();
			boolean runLoop = true;
			while (runLoop) {
				String stringInput = inScan.nextLine();
				
				switch(stringInput) {
				case "0":
					System.out.println("Sorry to see that you have gone out of business. Good bye");
					System.exit(0);
					break;
				case "1":
					runTestCreateJobList();
					System.out.println("Hard coded jobs have been added.");
					break;
				case "2":
					showVehicleList();
					break;
				case "3":
					System.out.println("repair time!");
					runLoop = false; // escape the while loop
					break;
				case "4":
				
					break; 
				default:
					System.out.println("Invalid input");
				}
				
				showSelectionMenu_1();
			}
		}
		catch(Exception x) {
			System.out.println(x);
		}
	}
	
	private void showSelectionMenu_1() {
		System.out.println("Please make a selection:"
				+ "\n0 - Quit program " 
				+ "\n1 - Add hard coded job list "
				+ "\n2 - Show current Job List" 
				+ "\n3 - Begin repairs");
	}
	
	public void importTaskList() {
		String pathString = "workOrder.txt";
		ArrayList<String> workInput = new ArrayList<>();
		
		try {
			File aFile = new File(pathString);
			Scanner myScan = new Scanner(aFile);
			String tempText = "";
			int highestOrderNumberFound = 0;
			while (myScan.hasNext()) {
				String lineInput = myScan.nextLine();
				int newTime = myScan.nextInt();
				myScan.nextLine();
				int newOrderNumber = myScan.nextInt();
				myScan.nextLine();
				
				if(newOrderNumber > highestOrderNumberFound) {
					highestOrderNumberFound = newOrderNumber;
				}
				
				if(lineInput.equals("Automobile")) {
					
				}
				
				else {
					throw new Exception("bad file format");
				}
				
				Vehicle.SetIDNumber(highestOrderNumberFound);
			}
			
			myScan.close();
		}
		catch(Exception x) {
			System.out.println(x);
		}
	}
	
	public void showVehicleList() {
		listOfTasks.showVehicleList();
	}
	
	public void printEndOfDayReport(){
		System.out.println("*********************************");
		System.out.println("printEndOfDayReport here");
		System.out.println("*********************************");
	}
	
	public masterList getWorkList() {
		// probably be better to return a clone of jobList ... later
		return listOfTasks;
	}
	
	public void runTestCreateJobList() {
		
	}
}
