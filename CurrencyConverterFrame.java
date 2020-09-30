import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CurrencyConverterFrame extends JFrame
{
		
		//Build a panel for each section,
		//then add each panel to the JFrame
		//Building individual panels is not required,
		//but it helps to organize things
		private JPanel dollarsPanel;			//To hold Dollars text field
		private JPanel conversionPanel;			//To hold Conversion text field
		private JPanel dracsPanel;
		private JPanel buttonPanel;				//To hold convert button
		private JTextField dollarsTextField;	//Dollar amount
		private JTextField conversionTextField;	//Conversion rate
		private JTextField dracsTextField;		//Dracs
		
		//The variable serialVersionUID is not used in this project
		//You can leave it out, but then you will get a warning message
		//that the class TemperatureConverter does not have this variable...
		static final long serialVersionUID = 0;

		public CurrencyConverterFrame()
		{
			super("Currency Converter");
			
			//build panels
			buildDollarsPanel();
			buildConversionPanel();
			buildDracsPanel();
			buildButtonPanel();

			//create layout manager
			setLayout(new GridLayout(3, 1));

			//add panels to frame
			add(dollarsPanel);
			add(conversionPanel);
			add(dracsPanel);
			add(buttonPanel);
		}//end CurrencyConverterFrame constructor

		//buildDollarPanel creates a panel with a text field
		//for the user to enter a dollar amount
		private void buildDollarsPanel()
		{
			//create panel
			dollarsPanel = new JPanel();

			//create label to display message
			JLabel dollarLabel = new JLabel("Dollars: ");

			//create text field for dollar amount
			dollarsTextField = new JTextField(10);

			//create layout manager for panel
			dollarsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

			//add label and text field to panel
			dollarsPanel.add(dollarLabel);
			dollarsPanel.add(dollarsTextField);
		}//end buildDollarsPanel method

		private void buildConversionPanel()
		{
			//create panel
			conversionPanel = new JPanel();

			//create label to display message
			JLabel conversionLabel = new JLabel("Conversion Rate: ");

			//create text field for dollar amount
			conversionTextField = new JTextField(10);

			//create layout manager for panel
			conversionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

			//add label and text field to panel
			conversionPanel.add(conversionLabel);
			conversionPanel.add(conversionTextField);
		}		
		
		//buildDracsPanel creates a panel that displays the
		//Dracs in a read-only text field
		private void buildDracsPanel()
		{
			//create panel
			dracsPanel = new JPanel();

			//create label to display message
			JLabel dracsLabel = new JLabel("Dracs: ");

			//create read-only text field for the dracs
			dracsTextField = new JTextField(10);
			dracsTextField.setEditable(false);

			//create layout manager for the panel
			dracsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

			//add label and text field to the panel
			dracsPanel.add(dracsLabel);
			dracsPanel.add(dracsTextField);
		}//end buildDracsPanel method

		//buildButtonPanel creates a panel with a button that
		//converts Dollars to Dracs
		private void buildButtonPanel()
		{
			//create panel
			buttonPanel = new JPanel();

			//create Convert & Exit buttons
			JButton convertButton = new JButton("Convert");
			JButton exitButton = new JButton("Exit");

			//add action listeners to buttons
			convertButton.addActionListener(new ConvertButtonListener());
			exitButton.addActionListener(new ExitButtonListener());

			//add button to panel
			buttonPanel.add(convertButton);
			buttonPanel.add(exitButton);
		}//end buildButtonPanel method

		//private inner class ConvertButtonListener handles convert button click
		private class ConvertButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				double dollars, conversionRate;  //to hold temperatures

				//create DecimalFormat object to format numbers
				DecimalFormat decimalFormatter = new DecimalFormat("0.0");

				//get dollar amount and convert to a double
				dollars = Double.parseDouble(dollarsTextField.getText());
				conversionRate = Double.parseDouble(conversionTextField.getText());

				//display Dracs
				conversionRate = dollars * conversionRate;
				dracsTextField.setText(decimalFormatter.format(conversionRate));
			}//end actionPerformed method
		}//end class ConvertButtonListener

		//private inner class ExitButtonListener handles exit button click
		private class ExitButtonListener implements ActionListener
		{
			//probably more common in C++, but single line methods may be written like this
			public void actionPerformed(ActionEvent event) { System.exit(0); }
		}
}
