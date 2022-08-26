package Project2;

import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* @author           <i>Nguyen Vi Cao</i>
* Project Number    2
* Due date          11/2/2020
*</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Class         PUDInvoiceGUI
* File          PUDInvoiceGUI.java
* Description   Calculates monthly electricity bill consists of several charges
* @author       <i>Nguyen Vi Cao</i>
* Environment   PC, Windows 10, jdk1.8.0_241, NetBeans 11.3
* Date          11/2/2020
* @version      1.0.0
* @see          javx.swing.frame
* History Log:  11/2/2020
*</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class PUDInvoiceGUI extends javax.swing.JFrame 
{
    private String fileName = "src/Project2/Customers.txt";
    private NumberFormat dollars = NumberFormat.getCurrencyInstance();
    private StringBuffer display = new StringBuffer("");
    PUDInvoiceBill bill = new PUDInvoiceBill();

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Constructor      PUDInvoiceGUI()--default constructor
* Description      Create a GUI form and displayed it centered with icon and
*                  DisplayBillJButton set as default, reads customers from a 
*                  file Customers.txt and populates the CustomerJComboBox
* @author          <i>Nguyen Vi Cao</i>
* Date             11/2/2020
*</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PUDInvoiceGUI() 
    {
        initComponents();    //build the form
        // set calculateJButton as default
        this.getRootPane().setDefaultButton(DisplayBillJButton);
        // set icon form
        this.setIconImage(Toolkit.getDefaultToolkit().
            getImage("src/Project2/SnoPUD-3.jpg"));
        // center the form at start
        this.setLocationRelativeTo(null);
        // read customers from external file
        readFromFile(fileName);
        // select first customer in CustomersJComboBox
        CustomerJComboBox.setSelectedIndex(0);
        setDate();
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        setDate()
    * Description   Display current date in mm/dd/yyy format in the 
    *               DateJTextField 
    * @see          java.text.format
    * @see          java.text.SimpleDateFormat
    * @see          java.util.Date
    * Date          11/2/2020
    * History Log   11/2/2020
    * @author       <i>Nguyen Vi Cao</i>	
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void setDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        DateJTextField.setText(dateFormat.format(date));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method           readFromFile
    * Description      Read customers from an external text file named 
    *                  Customers.txt and populate the CustomerJComboBox
    * @author          <i>Nguyen Vi Cao</i>
    * Date             11/2/2020
    * @parem           file String
    * @see             java.io.FileReader
    * @see             java.io.BufferedReader
    * @see             javax.swing.JFileChooser
    * @see             java.io.File
    * @see             java.io.FileNotFoundException
    * @see             java.io.IOException
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void readFromFile(String file)
    {
        try
        {
            FileReader freader = new FileReader(file);
            BufferedReader inputFile = new BufferedReader (freader);
            // scanner inputFile = new Scanner (new File(file));
            // read the first name from the file.
            String CustomerName = inputFile.readLine();
            
            // add customer name to JComboBox
            while (CustomerName != null)
            {
                CustomerJComboBox.addItem(CustomerName);
                CustomerName = inputFile.readLine();
            }
        }
        catch (FileNotFoundException exp)   // file not found--bring JFileChooser
        {
            //exp.printStackTrace();
            JFileChooser chooser = new JFileChooser("src/Project2");
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION)
            {
                File chosenFile = chooser.getSelectedFile();
                readFromFile("src/Project2" + chosenFile.getName());
            }
        }
        catch (IOException exp)
        {
            // display error message
            JOptionPane.showMessageDialog ( null, 
            "Cannot find or open file",
            "File Read Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PUDJPanel = new javax.swing.JPanel();
        InputJPanel = new javax.swing.JPanel();
        MeterReadingsJLabel = new javax.swing.JLabel();
        InvoiceDateJLabel = new javax.swing.JLabel();
        PresentJLabel = new javax.swing.JLabel();
        PreviousJLabel = new javax.swing.JLabel();
        TotalUnitsJLabel = new javax.swing.JLabel();
        PresentJTextField = new javax.swing.JTextField();
        PreviousJTextField = new javax.swing.JTextField();
        TotalUnitsJTextField = new javax.swing.JTextField();
        DateJTextField = new javax.swing.JTextField();
        AccountJLabel = new javax.swing.JLabel();
        AccountJTextField = new javax.swing.JTextField();
        PUDimageJLabel = new javax.swing.JLabel();
        AddressJScrollPane = new javax.swing.JScrollPane();
        AddressJTextArea = new javax.swing.JTextArea();
        ElectricityImageJLabel = new javax.swing.JLabel();
        CustomerJLabel = new javax.swing.JLabel();
        CustomerJComboBox = new javax.swing.JComboBox<>();
        AddressJLabel = new javax.swing.JLabel();
        AddressJTextField = new javax.swing.JTextField();
        CityJLabel = new javax.swing.JLabel();
        CityJTextField = new javax.swing.JTextField();
        StateJLabel = new javax.swing.JLabel();
        StateJComboBox = new javax.swing.JComboBox<>();
        DisplayJPanel = new javax.swing.JPanel();
        OutJScrollPane = new javax.swing.JScrollPane();
        OutJTextArea = new javax.swing.JTextArea();
        DisplayBillJButton = new javax.swing.JButton();
        PrintInvoiceJButton = new javax.swing.JButton();
        ClearJButton = new javax.swing.JButton();
        QuitJButton = new javax.swing.JButton();
        ZipJLabel = new javax.swing.JLabel();
        ZipJTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        ThankYouJLabel = new javax.swing.JLabel();
        PUDJMenuBar = new javax.swing.JMenuBar();
        FileJMenu = new javax.swing.JMenu();
        ClearJMenuItem = new javax.swing.JMenuItem();
        PrintBillJMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        QuitJMenuItem = new javax.swing.JMenuItem();
        HelpJMenu = new javax.swing.JMenu();
        AboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PUD Invoice");
        setResizable(false);

        PUDJPanel.setBackground(new java.awt.Color(153, 204, 255));

        InputJPanel.setBackground(new java.awt.Color(153, 204, 255));

        MeterReadingsJLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        MeterReadingsJLabel.setText("Meter Readings");

        InvoiceDateJLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        InvoiceDateJLabel.setText("Invoice Date");

        PresentJLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PresentJLabel.setText("Present");

        PreviousJLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PreviousJLabel.setText("Previous");

        TotalUnitsJLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        TotalUnitsJLabel.setText("Total Units");

        PresentJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresentJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        PreviousJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PreviousJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        TotalUnitsJTextField.setEditable(false);
        TotalUnitsJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalUnitsJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        DateJTextField.setEditable(false);
        DateJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DateJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        AccountJLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        AccountJLabel.setText("Account #");

        AccountJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout InputJPanelLayout = new javax.swing.GroupLayout(InputJPanel);
        InputJPanel.setLayout(InputJPanelLayout);
        InputJPanelLayout.setHorizontalGroup(
            InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputJPanelLayout.createSequentialGroup()
                .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TotalUnitsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PreviousJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PresentJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PresentJTextField)
                            .addComponent(PreviousJTextField)
                            .addComponent(TotalUnitsJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(InputJPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(MeterReadingsJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputJPanelLayout.createSequentialGroup()
                        .addComponent(AccountJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(InputJPanelLayout.createSequentialGroup()
                        .addComponent(AccountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputJPanelLayout.createSequentialGroup()
                        .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InvoiceDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        InputJPanelLayout.setVerticalGroup(
            InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MeterReadingsJLabel)
                    .addComponent(InvoiceDateJLabel))
                .addGap(14, 14, 14)
                .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PresentJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PresentJLabel)
                    .addComponent(DateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousJLabel)
                    .addComponent(PreviousJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccountJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(InputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalUnitsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalUnitsJLabel)))
        );

        PUDimageJLabel.setBackground(new java.awt.Color(153, 204, 255));
        PUDimageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project2/Snohomish-County-Public-Utility-District-Logo-18v1-295x148.jpg"))); // NOI18N

        AddressJTextArea.setEditable(false);
        AddressJTextArea.setBackground(new java.awt.Color(153, 204, 255));
        AddressJTextArea.setColumns(20);
        AddressJTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddressJTextArea.setRows(5);
        AddressJTextArea.setText("Snohomish County PUD\nP.O. Box 1100\nEverett, WA 98206-1100\nwww.snopud.com\n425-731-100");
        AddressJTextArea.setBorder(null);
        AddressJScrollPane.setViewportView(AddressJTextArea);

        ElectricityImageJLabel.setBackground(new java.awt.Color(153, 204, 255));
        ElectricityImageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project2/Surge-Damage-Small-300x218.png"))); // NOI18N

        CustomerJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CustomerJLabel.setText("Name");

        CustomerJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CustomerJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerJComboBoxActionPerformed(evt);
            }
        });

        AddressJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddressJLabel.setText("Address");

        AddressJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        CityJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CityJLabel.setText("City");
        CityJLabel.setToolTipText("");

        CityJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        StateJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StateJLabel.setText("State");

        StateJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StateJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));

        DisplayJPanel.setBackground(new java.awt.Color(153, 204, 255));

        OutJTextArea.setEditable(false);
        OutJTextArea.setColumns(20);
        OutJTextArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        OutJTextArea.setLineWrap(true);
        OutJTextArea.setRows(5);
        OutJTextArea.setWrapStyleWord(true);
        OutJScrollPane.setViewportView(OutJTextArea);

        javax.swing.GroupLayout DisplayJPanelLayout = new javax.swing.GroupLayout(DisplayJPanel);
        DisplayJPanel.setLayout(DisplayJPanelLayout);
        DisplayJPanelLayout.setHorizontalGroup(
            DisplayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisplayJPanelLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(OutJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        DisplayJPanelLayout.setVerticalGroup(
            DisplayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayJPanelLayout.createSequentialGroup()
                .addComponent(OutJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        DisplayBillJButton.setBackground(new java.awt.Color(204, 204, 0));
        DisplayBillJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DisplayBillJButton.setMnemonic('d');
        DisplayBillJButton.setText("Display Bill");
        DisplayBillJButton.setToolTipText("Display the bill");
        DisplayBillJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayBillJButtonActionPerformed(evt);
            }
        });

        PrintInvoiceJButton.setBackground(new java.awt.Color(204, 204, 0));
        PrintInvoiceJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PrintInvoiceJButton.setMnemonic('p');
        PrintInvoiceJButton.setText("Print Invoice");
        PrintInvoiceJButton.setToolTipText("Print the invoice");
        PrintInvoiceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintInvoiceJButtonActionPerformed(evt);
            }
        });

        ClearJButton.setBackground(new java.awt.Color(204, 204, 0));
        ClearJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearJButton.setMnemonic('c');
        ClearJButton.setText("Clear");
        ClearJButton.setToolTipText("Clear the form");
        ClearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearJButtonActionPerformed(evt);
            }
        });

        QuitJButton.setBackground(new java.awt.Color(204, 204, 0));
        QuitJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        QuitJButton.setMnemonic('q');
        QuitJButton.setText("Quit");
        QuitJButton.setToolTipText("Exit the application");
        QuitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitJButtonActionPerformed(evt);
            }
        });

        ZipJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ZipJLabel.setText("Zip:");

        ZipJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ZipJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PUDJPanelLayout = new javax.swing.GroupLayout(PUDJPanel);
        PUDJPanel.setLayout(PUDJPanelLayout);
        PUDJPanelLayout.setHorizontalGroup(
            PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUDJPanelLayout.createSequentialGroup()
                .addComponent(PUDimageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addGroup(PUDJPanelLayout.createSequentialGroup()
                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PUDJPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PUDJPanelLayout.createSequentialGroup()
                                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CityJLabel)
                                    .addComponent(CustomerJLabel)
                                    .addComponent(AddressJLabel))
                                .addGap(34, 34, 34)
                                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CustomerJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PUDJPanelLayout.createSequentialGroup()
                                        .addComponent(CityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(StateJLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(StateJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(AddressJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PUDJPanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(AddressJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ElectricityImageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(PUDJPanelLayout.createSequentialGroup()
                        .addComponent(DisplayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DisplayBillJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PrintInvoiceJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PUDJPanelLayout.createSequentialGroup()
                                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PUDJPanelLayout.createSequentialGroup()
                                        .addComponent(ZipJLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(ZipJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PUDJPanelLayout.createSequentialGroup()
                                        .addComponent(ClearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(QuitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PUDJPanelLayout.setVerticalGroup(
            PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUDJPanelLayout.createSequentialGroup()
                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InputJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PUDimageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ElectricityImageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StateJLabel)
                        .addComponent(StateJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ZipJLabel)
                        .addComponent(ZipJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CityJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DisplayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PUDJPanelLayout.createSequentialGroup()
                        .addComponent(DisplayBillJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrintInvoiceJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PUDJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClearJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(QuitJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        getContentPane().add(PUDJPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        ThankYouJLabel.setFont(new java.awt.Font("Wide Latin", 2, 16)); // NOI18N
        ThankYouJLabel.setForeground(new java.awt.Color(51, 153, 255));
        ThankYouJLabel.setText("Thank you for being our customer!");
        ThankYouJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(ThankYouJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThankYouJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        FileJMenu.setMnemonic('f');
        FileJMenu.setText("File");

        ClearJMenuItem.setMnemonic('c');
        ClearJMenuItem.setText("Clear");
        ClearJMenuItem.setToolTipText("Clear the form");
        ClearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(ClearJMenuItem);

        PrintBillJMenuItem.setMnemonic('p');
        PrintBillJMenuItem.setText("Print Bill");
        PrintBillJMenuItem.setToolTipText("Print the bill");
        PrintBillJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBillJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(PrintBillJMenuItem);
        FileJMenu.add(jSeparator1);

        QuitJMenuItem.setMnemonic('q');
        QuitJMenuItem.setText("Quit");
        QuitJMenuItem.setToolTipText("Exit the application");
        QuitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(QuitJMenuItem);

        PUDJMenuBar.add(FileJMenu);

        HelpJMenu.setMnemonic('h');
        HelpJMenu.setText("Help");

        AboutJMenuItem.setMnemonic('a');
        AboutJMenuItem.setText("About");
        AboutJMenuItem.setToolTipText("About the PUD Invoice");
        AboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutJMenuItemActionPerformed(evt);
            }
        });
        HelpJMenu.add(AboutJMenuItem);

        PUDJMenuBar.add(HelpJMenu);

        setJMenuBar(PUDJMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        quitJButtonActionPerformed()
    * Description   Ends the application.
    * Date          11/2/2020
    * History Log   11/2/2020
    * @author       <i>Nguyen Vi Cao</i>	
    * @param        evt java.awt.event.ActionEvent
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void QuitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        QuitJMenuItemActionPerformed()
    * Description   Calls the QuitJButtonActionPerformed to end the application
    * Date          11/2/2020
    * History Log   11/2/2020
    * @author       <i>Nguyen Vi Cao</i>	
    * @param        evt java.awt.event.ActionEvent
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void QuitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitJMenuItemActionPerformed
        QuitJButtonActionPerformed(evt);
    }//GEN-LAST:event_QuitJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method          PrintJMenuItemActionPerformed()
    *	Description     Print the GUI.
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>	
    *	@param		evt java.awt.event.ActionEvent
    *   @see            java.awt.event.ActionEvent
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void PrintInvoiceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintInvoiceJButtonActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_PrintInvoiceJButtonActionPerformed
    
    private void CustomerJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerJComboBoxActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method          clearJButtonActionPerformed()
    *	Description     Clears the form and resets it to its original state.
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>	
    *	@param		evt java.awt.event.ActionEvent
    *   @see            java.awt.event.ActionEvent
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void ClearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearJButtonActionPerformed
        // clear the textfield and the combobox
        PresentJTextField.setText("");
        PreviousJTextField.setText("");
        TotalUnitsJTextField.setText("");
        AccountJTextField.setText("");
        AddressJTextField.setText("");
        CityJTextField.setText("");
        OutJTextArea.setText("");
        CustomerJComboBox.setSelectedIndex(0);
        StateJComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_ClearJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        DisplayBillJButtonActionPerformed()
    * Description   Calculate PUD bill by creating an instance of the 
    *               PUDInvoiceBill object with all the pertinent information
    *               passed to the constructor and calls the bill's displayBill()
    *               method to display the bill
    * Date          11/2/2020
    * History Log   11/2/2020	
    * @author       <i>Nguyen Vi Cao</i>	
    * @param        evt java.awt.event.ActionEvent
    * @see          java.awt.event.ActionEvent
    * @see          java.swing.JOptionPane
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void DisplayBillJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayBillJButtonActionPerformed
        // get customer's name
        String Customer = CustomerJComboBox.getSelectedItem().toString();
        double TotalUnits=0.0;          // difference between Present and Previous
        double Total;
        try
        {
            double Present = Double.parseDouble(PresentJTextField.getText());
            double Previous = Double.parseDouble(PreviousJTextField.getText());
            if (Present <= 0 || Previous <= 0)
                throw new NumberFormatException();
            else TotalUnits = Present - Previous;
                
            if (TotalUnits <= 0)
            {
            // display error message
            JOptionPane.showMessageDialog(null,
            "The amount of Present kW must be greater than Previous kW ",
            "Incorrect Data", JOptionPane.ERROR_MESSAGE);
            }
            else    // display total units used
            TotalUnitsJTextField.setText(String.valueOf(TotalUnits));
            
            //crucial line: create a PUDInvoiceBill passing parameters to constructor
            bill = new PUDInvoiceBill(Customer, Present, Previous);
            Total = bill.CalculatePUDBill();
            
            //display bill
            display.delete(0, display.length());        //clear display
            OutJTextArea.setText(bill.displayBill().toString()); 
        }
        catch (NumberFormatException nume)
        {
        // display error message if no meter readings
        JOptionPane.showMessageDialog(null,
        "Please enter a positive number or the amount of "
            + "kW of electricity used.",
            "Incorrect Data", JOptionPane.ERROR_MESSAGE);
        PresentJTextField.requestFocus();
        PresentJTextField.selectAll();
        }       
    }//GEN-LAST:event_DisplayBillJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method          ClearJMenuItemActionPerformed()
    *	Description     Calls the ClearJButtonActionPerformed event handler to
    *                   clear the form and reset it to its original state.
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>	
    *	@param		evt java.awt.event.ActionEvent
    *   @see            java.awt.event.ActionEvent
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void ClearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearJMenuItemActionPerformed
        ClearJButton.doClick();
    }//GEN-LAST:event_ClearJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method          PrintJMenuItemActionPerformed()
    *	Description     Print the content of the OutJTextArea
    *	Date            11/2/2020
    *   History Log     11/2/2020
    *	@author         <i>Nguyen Vi Cao</i>	
    *	@param		evt java.awt.event.ActionEvent
    *   @see            java.awt.event.ActionEvent
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void PrintBillJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBillJMenuItemActionPerformed
        try 
        {
            OutJTextArea.print();
        } 
        catch (PrinterException exp) 
        {
            exp.printStackTrace();
        }
    }//GEN-LAST:event_PrintBillJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        AboutJMenuItemActionPerformed()
    * Description   Creates and shows the About form
    * Date          11/2/2020
    * History Log   11/2/2020	
    * @author       <i>Nguyen Vi Cao</i>	
    * @param        evt java.awt.event.ActionEvent
    * @see          java.awt.event.ActionEvent
    * @see          java.text.DecimalFormat
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void AboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutJMenuItemActionPerformed
        About myAbout = new About(this, true);
        myAbout.setVisible(true);
    }//GEN-LAST:event_AboutJMenuItemActionPerformed

    private void ZipJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipJTextFieldActionPerformed

   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Method       main()
 * Description  Invokes default constructor to create an instance of
 *              the form
 * @param       args are the command line strings
 * @author      <i>Nguyen Vi Cao</i>
 * Date         11/2/2020
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PUDInvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PUDInvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PUDInvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PUDInvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PUDInvoiceGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutJMenuItem;
    private javax.swing.JLabel AccountJLabel;
    private javax.swing.JTextField AccountJTextField;
    private javax.swing.JLabel AddressJLabel;
    private javax.swing.JScrollPane AddressJScrollPane;
    private javax.swing.JTextArea AddressJTextArea;
    private javax.swing.JTextField AddressJTextField;
    private javax.swing.JLabel CityJLabel;
    private javax.swing.JTextField CityJTextField;
    private javax.swing.JButton ClearJButton;
    private javax.swing.JMenuItem ClearJMenuItem;
    private javax.swing.JComboBox<String> CustomerJComboBox;
    private javax.swing.JLabel CustomerJLabel;
    private javax.swing.JTextField DateJTextField;
    private javax.swing.JButton DisplayBillJButton;
    private javax.swing.JPanel DisplayJPanel;
    private javax.swing.JLabel ElectricityImageJLabel;
    private javax.swing.JMenu FileJMenu;
    private javax.swing.JMenu HelpJMenu;
    private javax.swing.JPanel InputJPanel;
    private javax.swing.JLabel InvoiceDateJLabel;
    private javax.swing.JLabel MeterReadingsJLabel;
    private javax.swing.JScrollPane OutJScrollPane;
    private javax.swing.JTextArea OutJTextArea;
    private javax.swing.JMenuBar PUDJMenuBar;
    private javax.swing.JPanel PUDJPanel;
    private javax.swing.JLabel PUDimageJLabel;
    private javax.swing.JLabel PresentJLabel;
    private javax.swing.JTextField PresentJTextField;
    private javax.swing.JLabel PreviousJLabel;
    private javax.swing.JTextField PreviousJTextField;
    private javax.swing.JMenuItem PrintBillJMenuItem;
    private javax.swing.JButton PrintInvoiceJButton;
    private javax.swing.JButton QuitJButton;
    private javax.swing.JMenuItem QuitJMenuItem;
    private javax.swing.JComboBox<String> StateJComboBox;
    private javax.swing.JLabel StateJLabel;
    private javax.swing.JLabel ThankYouJLabel;
    private javax.swing.JLabel TotalUnitsJLabel;
    private javax.swing.JTextField TotalUnitsJTextField;
    private javax.swing.JLabel ZipJLabel;
    private javax.swing.JTextField ZipJTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
