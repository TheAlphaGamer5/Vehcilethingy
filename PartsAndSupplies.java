package mainPackage;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class PartsAndSupplies {
	public static ArrayList<String> itemsUsed = new ArrayList<>();
	static LocalDate todayish = LocalDate.now();
	
	public static String getItem(String item) {
		itemsUsed.add(item);
		return "issued " + item;
	}
	
	public static void clearList() {
		itemsUsed.clear();
	}
	
	public static void createRestockOrderFile() {
		//TODO
		//save the itemsUsed to a text file
		try {
		File myObj = new File("src/mainPackage/textFiles/RestockOrder_" + todayish + ".txt");
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
		clearList();
	}
}
