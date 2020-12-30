
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

import locations.Location;
import passengers.Passenger;

/**
 * Represents a parent public transport class includes train and bus.
 * @author leylayayladere
 * @version 1.0
 */
public class PublicTransport {
	
	/**
	 * <i>Unique<i> <code>ID</code> of each <code>PublicTransport</code>.
	 */
	private int ID;
	/**
	 * The X-coordinate of first point.
	 */
	public double x1;
	/**
	 * The Y-coordinate of first point.
	 */
	public double y1;
	/**
	 * The X-coordinate of second point.
	 */
	public double x2;
	/**
	 * The Y-coordinate of second point.
	 */
	public double y2;
	
	/**
	 * Creates a <code>PublicTransport</code> with the specified ID and range.
	 * @param ID The <code>PublicTransport</code>'s ID.
	 * @param x1 The X-coordinate of first point.
	 * @param y1 The Y-coordinate of first point.
	 * @param x2 The X-coordinate of second point.
	 * @param y2 The Y-coordinate of second point.
	 */
	public PublicTransport(int ID, double x1, double y1, double x2, double y2) {
		this.ID = ID;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Checks this vehicle whether it is suitable for the journey or not.
	 * @param departure <code>Location</code> where the journey begins.
	 * @param arrival <code>Location</code> where the journey ends.
	 * @return A boolean data type. True if this vehicle is suitable for the journey, false if it is not.
	 */
	public boolean canRide (Location departure, Location arrival) {
		if(departure.locationX == arrival.locationX & departure.locationY == arrival.locationY) {
			return false;
		}else {
			if(Math.max(this.x1, this.x2)>=departure.locationX & Math.min(this.x1, this.x2)<=departure.locationX 
					& Math.max(this.y1, this.y2)>=departure.locationY & Math.min(this.y1, this.y2)<=departure.locationY) {
				if(Math.max(this.x1, this.x2)>=arrival.locationX & Math.min(this.x1, this.x2)<=arrival.locationX 
						& Math.max(this.y1, this.y2)>=arrival.locationY & Math.min(this.y1, this.y2)<=arrival.locationY) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
			
	}
	
	/**
	 * Calculates the amount of money that passenger should pay for the journey.
	 * @param t <code>PublicTransport</code> which is used in the journey.
	 * @param p <code>Passenger</code> who makes the journey.
	 * @param l <code>Location</code> where the journey ends.
	 * @return A double data type. The amount of money that passenger should pay for the journey.
	 */
	public double getPrice(PublicTransport t, Passenger p, Location l) {
		if(t instanceof Bus) {
			return 2.00;
		}else{
			return 5.00 * Math.round(Math.sqrt((p.currentLocation.locationX-l.locationX)*(p.currentLocation.locationX-l.locationX)+(p.currentLocation.locationY-l.locationY)*(p.currentLocation.locationY-l.locationY))/15); 
		}
		
	}
	
	/** 
	 * Retrieves the value of an ID.
	 * @return An integer data type.
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * Sets the value of an ID.
	 * @param ID A variable of type integer.
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE





