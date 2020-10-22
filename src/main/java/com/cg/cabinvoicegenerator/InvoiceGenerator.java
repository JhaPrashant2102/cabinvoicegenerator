package com.cg.cabinvoicegenerator;

public class InvoiceGenerator {

	private static final double RATE_PER_MINUTE = 1;
	private static final double RATE_PER_KILOMETER = 10;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(Ride ride) {
		return Math.max(MINIMUM_FARE, ride.getDistance()*RATE_PER_KILOMETER + ride.getTime()*RATE_PER_MINUTE);
	}

	public double calculateTotalFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare+=calculateFare(ride);
		}
		return totalFare;
	}

}
