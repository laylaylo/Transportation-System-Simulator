
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import locations.Location;
import vehicles.PublicTransport;
import vehicles.Bus;
import vehicles.Train;

/**
 * Represents a discounted passenger.
 * @author leylayayladere
 * @version 1.0
 */
public class DiscountedPassenger extends Passenger{
	
	/**
	 * Creates a <code>Passenger</code> with the specified <code>ID</code>, ability to drive car, and <code>Location</code>.
	 * @param ID <i>Unique<i> <code>ID</code> of this <code>DiscountedPassenger</code>.
	 * @param hasDriversLicense Whether this <code>DiscountedPassenger</code> has driver's license or not.
	 * @param l <code>Location</code> of where this <code>DiscountedPassenger</code> is.
	 */
	public DiscountedPassenger(int ID, boolean hasDriverLicense, Location l) {
		super(ID, hasDriverLicense, l);
	}
	
	/**
	 * Creates a passenger with the specified ID, location, and fuel consumption of passenger's <code>Car</code>.
	 * @param ID <i>Unique<i> <code>ID</code> of this <code>DiscountedPassenger</code>.
	 * @param l <code>Location</code> of where this <code>DiscountedPassenger</code> is.
	 * @param fuelConsumption Fuel consumption rate of this <code>DiscountedPassenger</code>'s <code>Car</code>.
	 */
	public DiscountedPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void ride(PublicTransport p, Location l) {	
		if(p.canRide(this.currentLocation, l)){
			if(p instanceof Bus) {
				double price = p.getPrice(p, this, l)/2;
				if(this.cardBalance >= price) {
					this.cardBalance -= price;
					this.currentLocation.outgoingPassenger(this);
					this.currentLocation = l;
					this.currentLocation.incomingPassenger(this);
				}
			}
			if(p instanceof Train) {
				double price = p.getPrice(p, this, l)/100*80;
				if(this.cardBalance >= price) {
					this.cardBalance -= price;
					this.currentLocation.outgoingPassenger(this);
					this.currentLocation = l;
					this.currentLocation.incomingPassenger(this);
				}
			}
		}
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

