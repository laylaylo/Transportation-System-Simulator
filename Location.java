
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package locations;

import passengers.Passenger;
import java.util.*;

/**
 * Represents a location.
 * @author leylayayladere
 * @version 1.0
 */
public class Location{
	
	/**
	 * <i>Unique<i> <code>ID</code> of each <code>Location</code>.
	 */
	private int ID;
	/**
	 * The X-coordinate of this <code>Location</code>.
	 */
	public double locationX;
	/**
	 * The Y-coordinate of this <code>Location</code>.
	 */
	public double locationY;
	/**
	 * Keeps track of all passengers who have been in this location.
	 */
	public  ArrayList<Passenger> history = new ArrayList<Passenger>();;
	/**
	 * Keeps track of all passengers who are currently in this location.
	 */
	public  ArrayList<Passenger> current = new ArrayList<Passenger>();;
	
	/**
	 * Creates a location with the specified ID, X value, and Y value.
	 * @param ID <i>Unique<i> <code>ID</code> of this <code>Location</code>.
	 * @param locationX The X-coordinate of this <code>Location</code>.
	 * @param locationY The Y-coordinate of this <code>Location</code>.
	 */
	public Location(int ID, double locationX, double locationY) {
		this.ID = ID;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	/**
	 * Calculates distance between this <code>Location</code> and given <code>Location</code>.
	 * @param other <code>Location</code> to which is wanted to calculate distance from this <code>Location</code>.
	 * @return A double data type. Distance between this <code>Location</code> and given <code>Location</code>.
	 */
	public double getDistance(Location other) {
		return Math.sqrt((this.locationX-other.locationX)*(this.locationX-other.locationX)+(this.locationY-other.locationY)*(this.locationY-other.locationY));
	}
	
	/**
	 * Adds <code>Passenger</code> to <code>current</code> <i>list<i> and <code>history</code> <i>list<i>, when she/he comes to this <code>Location</code>.
	 * @param p <code>Passenger</code> who comes to this <code>Location</code>.
	 */
	public void incomingPassenger(Passenger p) {
		if(!this.history.contains(p)) {
			this.history.add(p);
		}
		this.current.add(p);
	}
	
	/**
	 * Removes <code>Passenger</code> from <code>current</code> <i>list<i>, when she/he moves from from this <code>Location</code>.
	 * @param p <code>Passenger</code> who moves from this <code>Location</code>.
	 */
	public void outgoingPassenger(Passenger p) {
		this.current.remove(p);
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

