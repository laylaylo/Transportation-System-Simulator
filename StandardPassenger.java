
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import locations.Location;

/**
 * Represents a standard passenger.
 * @author leylayayladere
 * @version 1.0
 */
public class StandardPassenger extends Passenger{
	
	/**
	 * Creates a <code>Passenger</code> with the specified <code>ID</code>, ability to drive car, and <code>Location</code>.
	 * @param ID <i>Unique<i> <code>ID</code> of this <code>StandardPassenger</code>.
	 * @param hasDriversLicense Whether this <code>StandardPassenger</code> has driver's license or not.
	 * @param l <code>Location</code> of where this <code>StandardPassenger</code> is.
	 */
	public StandardPassenger(int ID, boolean hasDriverLicense, Location l) {
		super(ID, hasDriverLicense, l);
	}
	
	/**
	 * Creates a passenger with the specified ID, location, and fuel consumption of passenger's <code>Car</code>.
	 * @param ID <i>Unique<i> <code>ID</code> of this <code>StandardPassenger</code>.
	 * @param l <code>Location</code> of where this <code>StandardPassenger</code> is.
	 * @param fuelConsumption Fuel consumption rate of this <code>StandardPassenger</code>'s <code>Car</code>.
	 */
	public StandardPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

