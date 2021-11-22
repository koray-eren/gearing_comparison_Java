package gearingComparison.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener{
	
	int count = 0;
	private JLabel growthLabel;
	private JTextField growthText;
	private JLabel yearsLabel;
	private JTextField yearsText;
	private JLabel capitalLabel;
	private JTextField capitalText;
	private JLabel lvrLabel;
	private JTextField lvrText;
	private JButton button;
	private JLabel result;
	private static int TEXTWIDTH = 150;
	
	public GUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);

		//growth rate
		growthLabel = new JLabel("Growth Rate (Decimal) ");
		growthLabel.setBounds(10, 30, TEXTWIDTH, 25);
		panel.add(growthLabel);
		
		growthText = new JTextField(20);
		growthText.setBounds(TEXTWIDTH+10, 30, 165, 25);
		panel.add(growthText);
		
		// years
		yearsLabel = new JLabel("Years");
		yearsLabel.setBounds(10,30*2,150,25);
		panel.add(yearsLabel);
		
		yearsText = new JTextField(20);
		yearsText.setBounds(TEXTWIDTH+10,30*2,165,25);
		panel.add(yearsText);
		
		// capital
		capitalLabel = new JLabel("Starting Capital");
		capitalLabel.setBounds(10,30*3,150,25);
		panel.add(capitalLabel);
		
		capitalText = new JTextField(20);
		capitalText.setBounds(TEXTWIDTH+10,30*3,165,25);
		panel.add(capitalText);

		// LVR
		lvrLabel = new JLabel("LVR (Decimal)");
		lvrLabel.setBounds(10,30*4,150,25);
		panel.add(lvrLabel);
		
		lvrText = new JTextField(20);
		lvrText.setBounds(TEXTWIDTH+10,30*4,165,25);
		panel.add(lvrText);
		
		button = new JButton("Calculate");
		button.setBounds(165,30*5,TEXTWIDTH,25);
		button.addActionListener( this );
		panel.add(button);
		
		result = new JLabel("");
		result.setBounds(10, 30*6, 300, 25);
		panel.add(result);
		result.setText("");
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double growth = Double.parseDouble( growthText.getText() );
		double years = Double.parseDouble( yearsText.getText() );
		double capital = Double.parseDouble( capitalText.getText() );
		double lvr = Double.parseDouble( lvrText.getText() );

		
		DecimalFormat df = new DecimalFormat("#,###.##");
		
		double geared_asset_value = capital / (1-lvr);
		
		double future_asset_value = geared_asset_value * ( Math.pow( (1+growth), years) );
		result.setText("Geared asset value after " + years + " years: " + df.format(future_asset_value) );
		System.out.println("Geared asset value after " + years + " years: " + df.format(future_asset_value) );
		
		double total_growth = future_asset_value - geared_asset_value;
		System.out.print("Capital growth: ");
		System.out.println( df.format(total_growth) );
		
		double total_return = total_growth / capital * 100;
		System.out.print("Total return: ");
		System.out.println( df.format(total_return) + "%" );
		
		double non_geared_equivalent_return = (Math.pow( ((total_growth+capital)/capital) , (1/years) ) - 1 ) * 100;
		result.setText("Equivalent annualised return: " + df.format(non_geared_equivalent_return) + "% p.a.");
	}
}

