package com.cg.cabinvoicegenerator;

public class InvoiceSummary {

	public int numOfRides;
	public double totalFare;
	public double avgFarePerRide;
	public InvoiceSummary(int numOfRides, double totalFare) {
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
		this.avgFarePerRide = this.totalFare/this.numOfRides;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(avgFarePerRide) != Double.doubleToLongBits(other.avgFarePerRide))
			return false;
		if (numOfRides != other.numOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}
	


}
