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
	private JTextField textField_4;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblMileRadius;
	private JButton btnSubmit;
	
	public AddressPanel(Driver d)
	{
		setOpaque(false);
		this.driver = d;
		setLayout(null);
		setBounds(0,0,800,600);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(280, 214, 51, 16);
		add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(376, 211, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(290, 241, 26, 16);
		add(lblCity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(376, 238, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblState = new JLabel("State:");
		lblState.setBounds(286, 268, 35, 16);
		add(lblState);
		
		textField_2 = new JTextField();
		textField_2.setBounds(376, 265, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		lblMileRadius = new JLabel("Mile Radius:");
		lblMileRadius.setBounds(272, 296, 76, 16);
		add(lblMileRadius);
		
		textField_4 = new JTextField();
		textField_4.setBounds(376, 292, 116, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(352, 325, 97, 25);
		add(btnSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
