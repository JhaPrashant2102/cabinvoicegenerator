package com.cg.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator = null;
	
	@Before
	public void init() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {	
		double distance = 2.0;
		double time = 5;
		double fare = invoiceGenerator.calculateFare(new Ride(distance,time));
		Assert.assertEquals(25,fare,0.0);
	}
	
	@Test
	public void givenlessDistanceAndTimeShouldReturnMinimumFare() {
		double distance = 0.1;
		double time = 1;
		double fare = invoiceGenerator.calculateFare(new Ride(distance,time));
		Assert.assertEquals(5,fare,0.0);
	}
	
	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		Ride[] rides = {
				new Ride(2.0,5),
				new Ride(0.1,1)
		};
		double fare = invoiceGenerator.calculateTotalFare(rides);
		Assert.assertEquals(30,fare,0.0);
	}
	
	@Test
	public void givenMultipleRidesShouldReturnRideSummary() {
		Ride[] rides = {
				new Ride(2.0,5),
				new Ride(0.1,1)
		};
		InvoiceSummary summary = invoiceGenerator.returnRideSummary(rides);
		InvoiceSummary checkSummary = new InvoiceSummary(2,30.0);
		Assert.assertEquals(summary,checkSummary);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void givenUserIdShouldReturnTheListOfRides() {
		RideRepository rideRepository = new RideRepository();
		String id = "123";
		Ride[] rides = {
				new Ride(2.0,5),
				new Ride(0.1,1)
		};
		rideRepository.insertNewRider(id,rides);
		Assert.assertEquals(rides,rideRepository.ridemap.get("123"));
	}
	
	@Test
	public void givenUserIdShouldReturnTheInvoice() {
		RideRepository rideRepository = new RideRepository();
		String id = "123";
		Ride[] rides = {
				new Ride(2.0,5),
				new Ride(0.1,1)
		};
		rideRepository.insertNewRider(id,rides);
		InvoiceSummary summary = invoiceGenerator.returnRideSummary(rideRepository.ridemap.get("123"));
		InvoiceSummary checkSummary = new InvoiceSummary(2,30.0);
		Assert.assertEquals(summary,checkSummary);
	}
}
