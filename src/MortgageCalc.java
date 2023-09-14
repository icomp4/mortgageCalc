/**
 * The MortgageCalc class uses JFrame to calculate and display monthly mortgage payments.
 * It takes the principal loan amount, interest rate as a percentage, loan term in years,
 * and calculates the monthly payments.
 *
 * @author Isaiah Compere
 * @version 1.0
 * @since 2023-07-26
 */


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MortgageCalc extends JFrame implements ActionListener {
    private JLabel rateLabel;          // Label for interest rate
    private JLabel periodLabel;        // Label for loan term
    private JLabel amountLabel;        // Label for monthly payment
    private JTextField principalField; // Input field for loan amount
    private JTextField rateField;      // Input field for interest rate
    private JTextField periodField;    // Input field for loan term
    private JTextField amountField;    // Display field for monthly payment
    private JButton calcButton;        // Button to trigger calculation

    /**
     * Constructs a MortgageCalc GUI with input fields and a Calculate button.
     * The GUI allows users to input the loan amount, interest rate, and loan term,
     * and calculates the monthly mortgage payment.
     */
    MortgageCalc() {
        // Used to specify GUI component layout
        GridBagConstraints positionConst = null;

        // Set frame's title
        setTitle("Mortgage Calculator");

        // Position and set all labels and fields
        JLabel principalLabel = new JLabel("Loan Amount:");
        rateLabel = new JLabel("Interest Rate (percentage):");
        periodLabel = new JLabel("Loan Term (in years)");
        amountLabel = new JLabel("Monthly Payment:");

        principalField = new JTextField(15);
        principalField.setEditable(true);
        principalField.setText("0");

        periodField = new JTextField(15);
        periodField.setEditable(true);
        periodField.setText("0");

        rateField = new JTextField(15);
        rateField.setEditable(true);
        rateField.setText("0");

        amountField = new JTextField(15);
        amountField.setEditable(false);
        amountField.setText("0");

        // Create a "Calculate" button
        calcButton = new JButton("Calculate");

        // Use "this" class to handle button presses
        calcButton.addActionListener(this);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();

        // Specify component's grid location
        positionConst.gridx = 0;
        positionConst.gridy = 0;

        // 10 pixels of padding around component
        positionConst.insets = new Insets(10, 10, 10, 10);

        // Add component using the specified constraints
        add(principalLabel, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 0;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(principalField, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(rateLabel, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(rateField, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 2;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(periodField, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 2;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(periodLabel, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 4;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(calcButton, positionConst);

        positionConst.gridx = 0;
        positionConst.gridy = 3;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(amountLabel, positionConst);

        positionConst.gridx = 1;
        positionConst.gridy = 3;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(amountField, positionConst);
    }

    /**
     * Calculates the monthly mortgage payment based on user inputs and displays the result.
     *
     * @param event The event that triggered the calculation.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        double principal;  // Principal
        double annualRate;  // Annual interest rate
        double years;  // Mortgage term in years

        principal = Double.parseDouble(principalField.getText());
        annualRate = Double.parseDouble(rateField.getText()) / 100; // Convert to decimal form
        years = Double.parseDouble(periodField.getText());

        double monthlyRate = annualRate / 12; // Monthly interest rate
        double totalPayments = years * 12; // Total number of monthly payments

        double numerator = Math.pow((1 + monthlyRate), totalPayments);
        double denominator = Math.pow((1 + monthlyRate), totalPayments) - 1;
        double monthlyPayment = principal * (monthlyRate * numerator) / denominator;
        String monthlyPaymentStr = String.format("$%.2f",monthlyPayment); // two decimal points and a dollar sign

        amountField.setText(monthlyPaymentStr);
    }

    /**
     * Creates an instance of the MortgageCalc class, initializes its components, and displays the GUI.
     *
     */
    public static void main(String[] args) {
        MortgageCalc myFrame = new MortgageCalc();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}