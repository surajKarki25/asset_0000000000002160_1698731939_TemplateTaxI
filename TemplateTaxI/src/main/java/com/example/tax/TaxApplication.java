package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Initialize the Spring application context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Create a Scanner object to read user input
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Tax Payment Application");

		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int userChoice = scanner.nextInt();

			switch (userChoice) {
				case 1:
					payTax("incomeTax", context);
					break;
				case 2:
					payTax("propertyTax", context);
					break;
				case 3:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice");
					return;
			}
		}
	}

	private static void payTax(String taxChoice, ClassPathXmlApplicationContext context) {
		// Pick the tax bean using context.getBean() method using taxChoice string.
		Tax tax = (Tax) context.getBean(taxChoice);
		System.out.println("Paying " + tax.getTaxType() + " tax.");
		tax.payTax();
	}
}
