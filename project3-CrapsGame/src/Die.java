package Project3;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        Die
 * File         Die.java
 * Description  A class representing a die used in a rolling dice simulation.
 * Project      Dice Simulation
 * Environment  PC, Windows 10, NetBeans IDE 11.3, jdk 1.8.0_241
 * Date         11/30/2020
 * History Log  11/30/2018
 * @author      <i>Nguyen Vi Cao</i>
 * @version:    %1% %2%
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Die 
{
    // Class instance variables
    private int num = 0;// number rolled on the die
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Constructor  Die()
    * Description  Default constructor. Sets die face to 1.
    * @author      <i>Nguyen Vi Cao</i>
    * @see         java.awt.Toolkit
    * Date         11/30/2020
    * History Log  11/30/2018
    *</pre>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Die()
    {
        num = 1;
    }    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Die()
     * Description  Overloded constructor. Sets die face to num.
     * @param       num int
     * @author      <i>Nguyen Vi Cao</i>
     * @see         java.awt.Toolkit
     * Date         11/30/2020
     * History Log  11/30/2018
     *</pre>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Die(int num)
    {
        this.num = num;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       roll()
     * Description  method to rolls a die--returns the number rolled.
     * @author      <i>Nguyen Vi Cao</i>
     * @see         java.awt.Toolkit
     * @return      num int 1-6
     * Date         11/30/2020
     * History Log  11/30/2020
     *</pre>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static int roll()
    {
        return (int)(6 * Math.random() + 1);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       roll()
     * Description  Getter method to return the number on the die.
     * @author      <i>Nguyen Vi Cao</i>
     * @see         java.awt.Toolkit
     * @return      num int 1-6
     * Date         11/30/2020
     * History Log  11/30/2020
     *</pre>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getSide()
    {
        return num;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       roll()
     * Description  Setter method to set the number on the die with num.
     * @author      <i>Nguyen Vi Cao</i>
     * @see         java.awt.Toolkit
     * @param       num public void setSide(int num)
     * Date         11/30/2020
     * History Log  11/30/2020
     *</pre>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setSide(int num)
    {
        this.num = num;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Method to display die.
     * @author      <i>Nguyen Vi Cao</i>
     * @see         java.awt.Toolkit
     * Date         11/30/2020
     * History Log  11/30/2020
     *</pre>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString()
    {
        return "Die{" + "num=" + num + '}';
    }
}
