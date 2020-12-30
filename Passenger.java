
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import vehicles.Car;
import vehicles.Bus;
import vehicles.Train;
import vehicles.PublicTransport;
import locations.Location;
import interfaces.ownCar;
import interfaces.usePublicTransport;

/**
 * Represents a parent passenger class includes discounted and standard passengers.
 * @author leylayayladere
 * @version 1.0
 */
public class Passenger implements ownCar, usePublicTransport{
	
	/**
	 * <i>Unique<i> <code>ID</code> of each <code>Passenger</code>.
	 */
	private int ID;
	/**
	 * True if this <code>Passenger</code> has driver's license, false if she/he has not.
	 */
	public boolean hasDriversLicense;
	/**
	 * Current card balance of this <code>Passenger</code>.
	 */
	public double cardBalance = 0;
	/**
	 * Car object belongs to this <code>Passenger</code>.
	 */
	public Car car;
	/**
	 * Current location of this <code>Passenger</code>.
	 */
	public Location currentLocation ;
	/**
	 * True if this <code>Passenger</code> has <code>Car</code>, false if she/he has not.
	 */
	public boolean hasCar = false;
	
	
	/**
	 * Creates a <code>Passenger</code> with the specified <code>ID</code>, ability to drive car, and <code>Location</code>.
	 * @param ID <i>Unique<i> <code>ID</code> of this <code>Passenger</code>.
	 * @param hasDriversLicense Whether this <code>Passenger</code> has driver's license or not.
	 * @param l <code>Location</code> of where this <code>Passenger</code> is.
	 */
	public Passenger(int ID, boolean hasDriversLicense, Location l) {
		this.ID = ID;
		this.hasDriversLicense = hasDriversLicense;
	}
	
	/**
	 * Creates a <code>Passenger</code> with the specified ID, location, and fuel consumption of passenger's <code>Car</code>.
	 * @param ID <i>Unique<i> <code>ID</code> of this <code>Passenger</code>.
	 * @param l <code>Location</code> of where this <code>Passenger</code> is.
	 * @param fuelConsumption Fuel consumption rate of this <code>Passenger</code>'s <code>Car</code>.
	 */
	public Passenger(int ID, Location l, double fuelConsumption) {
		this.hasDriversLicense = true;
		this.ID = ID;
		purchaseCar(fuelConsumption);
	}
	
	/**
	 * Makes <code>Passenger</code> travel to desired location with requested public transport.
	 * @param p <code>PublicTransport</code> which is used in the journey.
	 * @param l <code>Location</code> where this <code>Passenger</code> wants to go.
	 */
	public void ride(PublicTransport p, Location l) {
		if(p.canRide(this.currentLocation, l)){
			if(this.cardBalance >= p.getPrice(p, this, l))  {
				this.cardBalance -= p.getPrice(p, this, l);
				this.currentLocation.outgoingPassenger(this);
				this.currentLocation = l;
				this.currentLocation.incomingPassenger(this);
			}
		}
	}
	
	/**
	 * Refills this <code>Passenger</code>'s travel card with requested amount of money.
	 * @param amount Amount of money which is used to refill this <code>Passenger</code>'s travel card.
	 */
	public void refillCard(double amount) {
		this.cardBalance += amount;
	}
	
	/**
	 * Makes this <code>Passenger</code> travel to desired location with his/her own car.
	 * @param l <code>Location</code> where this <code>Passenger</code> wants to go.
	 */
	public void drive(Location l) {
		if(this.car.fuelAmount >= this.car.fuelConsumption*this.currentLocation.getDistance(l)) {
			this.car.fuelAmount -= this.car.fuelConsumption*this.currentLocation.getDistance(l);
			this.currentLocation.outgoingPassenger(this);
			this.currentLocation = l;
			this.currentLocation.incomingPassenger(this);
		}
	}
	
	/**
	 * Makes this <code>Passenger</code> purchase a car with given fuel consumption rate.
	 * @param fuelConsumption Fuel consumption rate of purchasing <code>Car</code>.
	 */
	public void purchaseCar(double fuelConsumption) {
		this.hasDriversLicense = true;
		this.car = new Car(this.ID, fuelConsumption);
		hasCar = true;
		car.fuelAmount = 0;	
	}
	
	/**
	 * Refuels this <code>Passenger</code>'s <code>Car</code> with requested amount.
	 * @param amount Amount of fuel which is used to refuel this <code>Passenger</code>'s <code>Car</code>.
	 */
	public void refuel(double amount) {
		this.car.refuel(amount);
	}
	
	/**
	 * Checks this <code>Passenger</code> whether has <code>Car</code> or not.
	 * @return A boolean data type. True if this <code>Passenger</code> has <code>Car</code>, false if she/he has not.
	 */
	public boolean hasCar() {
		return hasCar;
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

