package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Tax Payment Application");

		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int userChoice = scanner.nextInt();

			String taxChoice = "";
			switch (userChoice) {
				case 1 -> taxChoice = "incomeTax";
				case 2 -> taxChoice = "propertyTax";
				case 3 -> {
					System.out.println("Exiting...");
					context.close();
					return;
				}
				default -> {
					System.out.println("Invalid choice");
					return;
				}
			}

			Tax tax = (Tax) context.getBean(taxChoice);
			if (tax.isTaxPayed()) {
				System.out.println("You have already paid " + tax.getTaxType() + " tax.");
			} else {
				System.out.println("Please enter your Income/Property value:");
				double taxableAmount = scanner.nextDouble();
				tax.setTaxableAmount((int)taxableAmount);
				tax.calculateTaxAmount();
				System.out.println("Tax amount to be paid:" + tax.getTaxAmount());
				System.out.println("Do you want to pay the tax? (yes/exit)");
				String payChoice = scanner.next();
				if (payChoice.equalsIgnoreCase("yes")) {
					tax.payTax();
					System.out.println("Tax paid successfully.");
				} else {
					System.out.println("Tax payment cancelled.");
				}
			}
		}
	}
}