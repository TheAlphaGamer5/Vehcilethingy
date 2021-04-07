package mainPackage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class masterList {
	
	private ArrayList<Vehicle> master = new ArrayList();
	
	public int getSize() {
		return master.size();
	}
	
	public Vehicle getTask(int index) {
		return master.get(index);
	}
	
	public void addTask(Vehicle task) {
		master.add(task);
	}
	
	public void removeTask(Vehicle task) {
		master.remove(task);
	}
	
	public void clearList() {
		master.clear();
	}
	
	public void saveToFile(String fileName) {
		String pathString = fileName + ".txt";
		
		try {
			File creation = new File(pathString);
			PrintWriter printOut = new PrintWriter(creation);
			
			for(int i = 0; i < master.size(); i++) {
				printOut.println(master.get(i).getVehicleType());
				printOut.println(master.get(i).getRepairChoices());
				printOut.println(master.get(i).getID());
			}
			
			printOut.flush();
			printOut.close();
		}
		catch(IOException e){
			System.err.println(e);
		}
	}
	
	public void showVehicleList() {
		if(getSize() > 0) {
			for (int i = 0; i < getSize(); i++) {
				System.out.println("\t" + getTask(i));
			}
		}
		else {
				System.out.println("list is empty");
			}
		}
	
	
	@Override
	public String toString() {
		return "show tasks";
	}
}
