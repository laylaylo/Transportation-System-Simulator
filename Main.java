
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package main;

import java.util.*;
import vehicles.*;
import java.io.*;
import passengers.*;
import locations.*;

/**
 * Defines a class that implements a simulation of a transportation system.
 * @author leylayayladere
 * @version 1.0
 */
public class Main {
	/**
	 * Reads the input from input file, takes the operation number from input and then does the appropriate operations.
	 * <p>After does the appropriate operations which are given in input file, writes every locations and passengers 
	 * in this locations to output file. 
	 * @param args Takes input file to give an appropriate output file, also in order to test the code.
	 * @throws FileNotFoundException Prevents from an error in case of the file not found.
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));

		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<PublicTransport> vehicles = new ArrayList<PublicTransport>();
		
		// Uncomment the lines below after implementing the Location class
		
		  Location l = new Location(0, 0, 0); // The first location is always (0,0).
		  locations.add(l);
		int operations = input.nextInt(); // operation count

		int locationID=1;
		int passengerID=0;
		int vehicleID=0;
		
		while(operations!=0) {
			
			int wantedPassenger = 0;
			int wantedLocation = 0;
			int wantedVehicle = 0;
			
			int action = input.nextInt();
	
			if(action==1) {
				String s = input.next();
				int driversLicense = input.nextInt();
				boolean hasDriversLicense = (driversLicense==1);
				int car = input.nextInt();
				if(car==1) {
					double fuelConsumption = input.nextDouble();
					if(s.equals("D")) {
						passengers.add(new DiscountedPassenger(passengerID, l, fuelConsumption));
					}
					if(s.equals("S")) {
						passengers.add(new StandardPassenger(passengerID, l, fuelConsumption));
					}
				}else {
					if(s.equals("D")) {
						passengers.add(new DiscountedPassenger(passengerID, hasDriversLicense, l));
					}
					if(s.equals("S")) {
						passengers.add(new StandardPassenger(passengerID, hasDriversLicense, l));
					}
				}
				passengers.get(passengerID).currentLocation = l;
				l.incomingPassenger(passengers.get(passengerID));
				passengerID++;				
			}
			if(action==2) {
				double locationX = input.nextDouble();
				double locationY = input.nextDouble();
			
				locations.add(new Location(locationID, locationX, locationY));
				locationID++;			
			}
			if(action==3) {
				int transportationType = input.nextInt();
				double x1 = input.nextDouble();
				double y1 = input.nextDouble();
				double x2 = input.nextDouble();
				double y2 = input.nextDouble();
				
				if(transportationType == 1) {
				    vehicles.add(new Bus(vehicleID, x1, y1, x2, y2));
				}else {
					vehicles.add(new Train(vehicleID, x1, y1, x2, y2));
				}
				vehicleID++;			
			}
			if(action==4) {
				
				int IDpassenger = input.nextInt();
				int IDlocation = input.nextInt();
				int transportationType = input.nextInt();
				boolean existVehicle = false;
				if(transportationType!=3) {
					int IDvehicle = input.nextInt();
					if(vehicleID>=IDvehicle) {
						for(int i =0; i<vehicles.size(); i++) {
							if(vehicles.get(i).getID() == IDvehicle) {
								wantedVehicle = i;
							}
						}
						existVehicle = true;
					}
				}
			if(passengerID>=IDpassenger) {	
				for(int i=0; i<passengers.size(); i++) {
					if(passengers.get(i).getID() == IDpassenger) {
						 wantedPassenger = i;
					}
				}	
				if(locationID>=IDlocation) {
					for(int i=0; i<locations.size(); i++) {
						if(locations.get(i).getID() == IDlocation) {
							wantedLocation = i;
						}
					}	
	
					if(transportationType==3) {
						if(passengers.get(wantedPassenger).hasCar()) {
							passengers.get(wantedPassenger).drive(locations.get(wantedLocation));
						}
					}else {
						if(existVehicle) {
							if(transportationType==1 && vehicles.get(wantedVehicle) instanceof Bus)
								passengers.get(wantedPassenger).ride(vehicles.get(wantedVehicle), locations.get(wantedLocation));
							if(transportationType==2 && vehicles.get(wantedVehicle) instanceof Train)
								passengers.get(wantedPassenger).ride(vehicles.get(wantedVehicle), locations.get(wantedLocation));
						}
					}
				}
			}
			
				
		}
			if(action==5) {
				int IDpassenger = input.nextInt();
				double fuelConsumption = input.nextDouble();
				
				for(int i=0; i<passengers.size(); i++) {
					if(passengers.get(i).getID() == IDpassenger) {
						wantedPassenger = i;
					}
				}		
				passengers.get(wantedPassenger).purchaseCar(fuelConsumption);
				
			}
			if(action==6) {
				int IDpassenger = input.nextInt();
				double amountFuel = input.nextDouble();
				
				for(int i=0; i<passengers.size(); i++) {
					if(passengers.get(i).getID() == IDpassenger) {
						wantedPassenger = i;
					}
				}
				if(passengers.get(wantedPassenger).hasCar()) {
					passengers.get(wantedPassenger).refuel(amountFuel);			
				}
			}
			if(action==7) {
				int IDpassenger = input.nextInt();
				double amountCard = input.nextDouble();
				
				for(int i=0; i<passengers.size(); i++) {
					if(passengers.get(i).getID() == IDpassenger) {
						wantedPassenger = i;
					}
				}
				passengers.get(wantedPassenger).refillCard(amountCard);			
			}
			operations--;
		}	
		
		for(int i=0; i<locations.size(); i++) {
			output.print("Location "+i+": (");
			output.printf("%.2f",locations.get(i).locationX);
			output.printf(", %.2f)\n", locations.get(i).locationY );
			
			Collections.sort(locations.get(i).current, new Comparator<Passenger>() {
				public int compare(Passenger p1, Passenger p2) {
					return Integer.valueOf(p1.getID()).compareTo(p2.getID());
				}
			});
			
			for(int j=0; j<locations.get(i).current.size(); j++) {
				output.print("Passenger " + locations.get(i).current.get(j).getID() + ": ");
				if(locations.get(i).current.get(j).hasCar()) {
					output.println(twoDecimal(locations.get(i).current.get(j).car.fuelAmount));
				}else {
					output.printf("%.2f\n",locations.get(i).current.get(j).cardBalance);
				}
			}					
		}		
	}
	
	/**
	 * Shortens given number to two decimal.
	 * @param amount A double data type, which is wanted to shorten two decimal.
	 * @return A double data type. 
	 */
	public static String twoDecimal(double amount) {
		String value = Double.toString(amount);
		String wanted = "";
		int index = 0;
		while(index != value.indexOf("."))	{
			wanted += value.charAt(index);
			index++;
		}
		for(int i=0; i<3; i++) {
			wanted += value.charAt(index);
			if(value.length() > index+1)
			index++;
		}
		return wanted;
	}

}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

