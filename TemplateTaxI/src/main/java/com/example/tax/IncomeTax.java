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
      if(this.taxableAmount>0 && this.taxableAmount<3){
         this.taxAmount=taxableAmount;
      }
       else if(this.taxableAmount>3 && this.taxableAmount<6){
           this.taxAmount=taxableAmount*0.05;
        }
      else if(this.taxableAmount>6 && this.taxableAmount<9){
          this.taxAmount=taxableAmount*0.10;
      }
      else if(this.taxableAmount>9 && this.taxableAmount<12){
          this.taxAmount=taxableAmount*0.15;
      }
      else if(this.taxableAmount>12 && this.taxableAmount<15){
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
