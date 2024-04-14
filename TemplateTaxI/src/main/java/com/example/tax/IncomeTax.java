package com.example.tax;

public class IncomeTax  implements Tax {
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */
    double taxableAmount;
    double taxAmount;
    boolean isTaxPayed;

    public IncomeTax() {
        this.isTaxPayed = false;
    }

    @Override
    public void setTaxableAmount(int amount) {
       this.taxableAmount=amount;
    }

    @Override
    public void calculateTaxAmount() {
      if(this.taxableAmount>0 && this.taxableAmount<300000){
         this.taxAmount=0;
      }
       else if(this.taxableAmount>300000 && this.taxableAmount<600000){
           this.taxAmount=taxableAmount*0.05;
        }
      else if(this.taxableAmount>600000 && this.taxableAmount<900000){
          this.taxAmount=taxableAmount*0.10;
      }
      else if(this.taxableAmount>900000 && this.taxableAmount<1200000){
          this.taxAmount=taxableAmount*0.15;
      }
      else if(this.taxableAmount>1200000 && this.taxableAmount<1500000){
          this.taxAmount=taxableAmount*0.20;
      } else{
          this.taxAmount=taxableAmount*0.30;
      }

    }

    @Override
    public double getTaxAmount() {
        return taxAmount;
    }

    @Override
    public String getTaxType() {
        return "income";
    }

    @Override
    public boolean isTaxPayed() {
        return false;
    }

    @Override
    public void payTax() {
     System.out.println("Income Tax Payed");
    }
}
