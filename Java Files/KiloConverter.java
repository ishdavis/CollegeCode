import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KiloConverter extends JFrame
{
	
		private JPanel panel;
		private JLabel messageLabel;
		private JLabel enterName;
		private JTextField kiloTextField;
		private JTextField nameTextField;
		private JButton calcButton;
		private final int windowWidth = 500;
		private final int windowHeight = 300;
		
		public KiloConverter()
		{
		
		setTitle("Kilometer Converter");
		
		setSize(windowWidth, windowHeight);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		add(panel);
		
		setVisible(true);
		}
		
		private void buildPanel()
		{
		messageLabel = new JLabel("Enter a distance in kilometers");
		
		kiloTextField = new JTextField(10);
		
		enterName = new JLabel("Enter your name");
		
		nameTextField = new JTextField(20);
		
		calcButton = new JButton("Calculate");
		
		calcButton.setBackground(Color.RED);
		
		calcButton.addActionListener(new CalcButtonListener());
		
		panel = new JPanel();
		
		panel.add(messageLabel);
		panel.add(kiloTextField);
		panel.add(enterName);  
		panel.add(nameTextField);
		panel.add(calcButton);
		}
		
		private class CalcButtonListener implements ActionListener
		{
		
			private int joke = 25;
			private String Ish;
		
			public void actionPerformed(ActionEvent e)
			{
				String input;
				double miles;
				
				String userName = nameTextField.getText();
				
				input = kiloTextField.getText();
				
				miles = Double.parseDouble(input) * .6214;
				
				JOptionPane.showMessageDialog(null, input + " kilometers is " + miles + " miles.");
				
				JOptionPane.showMessageDialog(null, "My Name is " + userName);
				
			}
			
		}
	
}