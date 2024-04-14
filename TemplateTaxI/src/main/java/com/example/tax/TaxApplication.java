package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve the beans for IncomeTax and PropertyTax
		Tax incomeTax = (Tax) context.getBean("incomeTax");
		Tax propertyTax = (Tax) context.getBean("propertyTax");

		// Set the taxable amounts
		incomeTax.setTaxableAmount(30000); // For example, set the income to $5000
		propertyTax.setTaxableAmount(100000); // For example, set the property value to $100,000

		// Calculate the tax amounts
		incomeTax.calculateTaxAmount();
		propertyTax.calculateTaxAmount();

		// Print the tax amounts
		System.out.println("Income Tax Amount: $" + incomeTax.getTaxAmount());
		System.out.println("Property Tax Amount: $" + propertyTax.getTaxAmount());

		// Optionally, pay the taxes
		incomeTax.payTax();
		propertyTax.payTax();
	}

}
