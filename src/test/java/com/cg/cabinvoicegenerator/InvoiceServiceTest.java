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
}
