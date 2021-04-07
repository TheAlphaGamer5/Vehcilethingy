package mainPackage;

public abstract class Vehicle {
	protected static int IDnumber;
	protected int numberOfTires = 0;
	
	public int getID() {
		return IDnumber;
	}
	
	public int getNumberOfTires() {
		return numberOfTires;
	}
	
	public void setNumberOFTires(int numTires) {
		numberOfTires = numTires;
	}
	
	public abstract String getVehicleType();
	
	protected abstract String getRepairChoices();
	
	protected abstract double doRepair(int selectRepair);
	
	public static void SetIDNumber(int IDnumber) {
		Vehicle.IDnumber = IDnumber;
	}
	
}
