package Project2;

import java.text.NumberFormat;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Class         PUDInvoiceBill
* File          PUDInvoiceBill.java
* Description   Provides PUD bill consists of several charges. Method include 
*               CalculatePUDBill(), displayBill(), padSpaces(), toString(),
*               equals(), getAmount().
* @author       <i>Nguyen Vi Cao</i>
* Environment   PC, Windows 10, jdk1.8.0_241, NetBeans 11.3
* Date          11/2/2020
* @version      1.0.0
* History Log:  11/2/2020
*</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class PUDInvoiceBill
{
    
    // class constants
    private static final double     CostOfElectricityFirst500kW = 0.07764,
                                    CostOfElectricity500kWto1000kw = 0.08852,
                                    CostOfElectricityThereafter = 0.09893,
                                    BenefitCharges = 0.00139,
                                    StatePublicUtilityTax = 0.03873,
                                    MunicipalTax = 0.06;
    private double Total = 0.0;                           // sum of all charges
    private StringBuffer display = new StringBuffer();    // output
    private NumberFormat dollars = NumberFormat.getCurrencyInstance();
    
    // instance variables
    private String Customer;
    private double Present = 0.0;
    private double Previous = 0.0;
    private double TotalUnits = 0.0;
    private double CostOfElectricity = 0.0;
    private double BPAcharge = 0.0;
    private double StatePublicUtilityCharge = 0.0;
    private double CityTax = 0.0;
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Default          Constructor
    * Description      Creates an instance of a Parcel object with default 
    *                  values for its fields.
    * @author          <i>Nguyen Vi Cao</i>
    * Date             11/2/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PUDInvoiceBill()
    {
        Customer = "";
        Present = 0.0;
        Previous = 0.0;
        TotalUnits = 0.0;
        CostOfElectricity = 0.0;
        BPAcharge = 0.0;
        StatePublicUtilityCharge = 0.0;
        CityTax = 0.0;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Overloaded       Constructor
    * Description      Creates an instance of a Parcel object with specided
    *                  parameter provided value for its fields.
    * @author          <i>Nguyen Vi Cao</i>
    * Date             11/2/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PUDInvoiceBill (String customer, double present, double previous)
    {
        Customer = customer;
        Present = present;
        Previous = previous;
        TotalUnits = Present - Previous;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *   Method          CalculatePUDBill()
    *   Description     Calculate the PUD invoice bill
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>	
    *   @return         total double
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public double CalculatePUDBill()
    {
        // calculate customer's bill
        Total = 0.0;
        
        // calculate the bill if customer has used under 500kW 
        if (TotalUnits <= 500)
        {
            CostOfElectricity = TotalUnits * CostOfElectricityFirst500kW;
            BPAcharge = TotalUnits * BenefitCharges;
            StatePublicUtilityCharge = (CostOfElectricity+BPAcharge)*StatePublicUtilityTax;
            CityTax = (CostOfElectricity+BPAcharge)*MunicipalTax;
            Total = CostOfElectricity+BPAcharge+StatePublicUtilityCharge+CityTax;
        }
        // calculate the bill if customer has used between 500kW-1000kw
        if (TotalUnits > 500 && TotalUnits <=1000)
        {
            CostOfElectricity = (500*CostOfElectricityFirst500kW)+((TotalUnits - 500)*CostOfElectricity500kWto1000kw);
            BPAcharge = TotalUnits * BenefitCharges;
            StatePublicUtilityCharge = (CostOfElectricity+BPAcharge)*StatePublicUtilityTax;
            CityTax = (CostOfElectricity+BPAcharge)*MunicipalTax;
            Total = CostOfElectricity+BPAcharge+StatePublicUtilityCharge+CityTax;
        }
        // calculate the bill if customer has used over 1000kw
        if (TotalUnits >1000)
        {
            CostOfElectricity = (500*CostOfElectricityFirst500kW)+
                                (500*CostOfElectricity500kWto1000kw)+
                                ((TotalUnits-1000)*CostOfElectricityThereafter);
            BPAcharge = TotalUnits * BenefitCharges;
            StatePublicUtilityCharge = (CostOfElectricity+BPAcharge)*StatePublicUtilityTax;
            CityTax = (CostOfElectricity+BPAcharge)*MunicipalTax;
            Total = CostOfElectricity+BPAcharge+StatePublicUtilityCharge+CityTax;
        }
        return Total;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method          toString()
    *	Description     Display the Parcel info: returns the customer's name and
    *                   total bill by calling CalculatePUDBill()
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>	
    *	@return         Customer info String
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString()
    {
        return "Customer" + Customer + "has a total bill of" +
                dollars.format(CalculatePUDBill());
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method          padSpaces()
    *	Description     Accepts two strings as input and returns a formatted 
    *                   line (StringBuffer) with the first String left-justified
    *                   and the second right-justified.
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>
    *   @param          first String
    *   @parem          second String
    *	@return         line StringBuffer
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private StringBuffer padSpaces(String first, String second)
    {
        final int MAX_SPACES = 60;          //width of output TextArea
        StringBuffer line = new StringBuffer(first);
        
        //find number of spaces needed to pad the string for right-justification
        
        int numSpaces = MAX_SPACES - first.length() - second.length();
        for (int i=0; i<numSpaces; i++)
            line.append(" ");               //add appropriate number of spaces
        line.append(second);                //add second string
        return line;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method          DisplayBill()
    *	Description     Display bill with appropriate formatting which is 
    *                   accomplished by calling the padSpaces() method.
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>	
    *	@return         Display StringBuffer
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    StringBuffer displayBill() 
    {    
        display.delete(0, display.length());
        display.append(padSpaces("Customer", Customer + '\n'));
        display.append('\n');
        if (TotalUnits <= 500)
        {
            display.append(padSpaces("Cost of Electricity", dollars.format(CostOfElectricity) + '\n'));
            display.append(padSpaces("BPA Charge", dollars.format(BPAcharge) + '\n'));
            display.append(padSpaces("State Public Utility Charge", dollars.format(StatePublicUtilityCharge) + '\n'));
            display.append(padSpaces("City Tax", dollars.format(CityTax) + '\n'));
        }
        if (TotalUnits > 500 && TotalUnits <=1000)
        {
            display.append(padSpaces("Cost of Electricity", dollars.format(CostOfElectricity) + '\n'));
            display.append(padSpaces("BPA Charge", dollars.format(BPAcharge) + '\n'));
            display.append(padSpaces("State Public Utility Charge", dollars.format(StatePublicUtilityCharge) + '\n'));
            display.append(padSpaces("City Tax", dollars.format(CityTax) + '\n'));
        }
        if (TotalUnits >1000)
        {
            display.append(padSpaces("Cost of Electricity", dollars.format(CostOfElectricity) + '\n'));
            display.append(padSpaces("BPA Charge", dollars.format(BPAcharge) + '\n'));
            display.append(padSpaces("State Public Utility Charge", dollars.format(StatePublicUtilityCharge) + '\n'));
            display.append(padSpaces("City Tax", dollars.format(CityTax) + '\n'));
        }
        display.append("-----------------------------------------------------------" + '\n');
        display.append(padSpaces("Total", dollars.format(CalculatePUDBill()) + '\n'));
        return display;
    }
}
