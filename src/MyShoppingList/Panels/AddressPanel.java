package MyShoppingList.Panels;

import javax.swing.JPanel;

import MyShoppingList.Driver.Driver;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddressPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private Driver driver;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZipCode;
	private JLabel lblMileRadius;
	private JButton btnSubmit;
	
	public AddressPanel(Driver d)
	{
		setOpaque(false);
		this.driver = d;
		setLayout(null);
		setBounds(0,0,800,600);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(272, 214, 51, 16);
		add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(365, 211, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(284, 241, 26, 16);
		add(lblCity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(365, 238, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblState = new JLabel("State:");
		lblState.setBounds(280, 268, 35, 16);
		add(lblState);
		
		textField_2 = new JTextField();
		textField_2.setBounds(365, 265, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setBounds(270, 295, 55, 16);
		add(lblZipCode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(365, 292, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		lblMileRadius = new JLabel("Mile Radius");
		lblMileRadius.setBounds(265, 322, 65, 16);
		add(lblMileRadius);
		
		textField_4 = new JTextField();
		textField_4.setBounds(365, 319, 116, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(309, 360, 97, 25);
		add(btnSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
