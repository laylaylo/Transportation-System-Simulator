
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

import passengers.Passenger;
import locations.Location;

/**
 * Represents train.
 * @author leylayayladere
 * @version 1.0
 */
public class Train extends PublicTransport{
	
	/**
	 * Creates a <code>Train</code> with the specified ID and range.
	 * @param ID The <code>Train</code>'s ID.
	 * @param x1 The X-coordinate of first point.
	 * @param y1 The Y-coordinate of first point.
	 * @param x2 The X-coordinate of second point.
	 * @param y2 The Y-coordinate of second point.
	 */
	public Train (int ID, double x1, double y1, double x2, double y2) {
		super(ID, x1, y1, x2, y2);
	}	
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

