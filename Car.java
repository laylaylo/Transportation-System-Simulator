
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

/**
 * Represents a car.
 * @author leylayayladere
 * @version 1.0
 */
public class Car{
	
	/**
	 * <code>ID</code> of <code>Passenger</code>'s who owns this <code>Car</code>
	 */
	public int ownerID;
	/**
	 * Fuel amount of this <code>Car</code>.
	 */
	public double fuelAmount = 0;
	/**
	 * Fuel consumption rate of this <code>Car</code>.
	 */
	public double fuelConsumption;
	
	/**
	 * Creates a <code>Car</code> with specified <code>ownerID</code> and fuel consumption rate.
	 * @param ID <code>ID</code> of <code>Passenger</code> who owns this <code>Car</code>.
	 * @param fuelConsumption Fuel consumption rate of this <code>Car</code>.
	 */
	public Car(int ID, double fuelConsumption) {
		this.ownerID = ID;
		this.fuelConsumption = fuelConsumption;
	}
	
	/**
	 * Refuels this <code>Car</code> with requested amount.
	 * @param amount Amount of fuel which is used to refuel this <code>Car</code>.
	 */
	public void refuel(double amount) {
		this.fuelAmount += amount;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

