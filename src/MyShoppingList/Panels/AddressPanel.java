package MyShoppingList.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MyShoppingList.Driver.Driver;

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
	private String address;
	
	public AddressPanel(Driver d)
	{
		setOpaque(false);
		this.driver = d;
		setLayout(null);
		setBounds(0,0,800,600);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(313, 214, 51, 16);
		add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(395, 211, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(326, 241, 26, 16);
		add(lblCity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(395, 238, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblState = new JLabel("State:");
		lblState.setBounds(320, 268, 35, 16);
		add(lblState);
		
		textField_2 = new JTextField();
		textField_2.setBounds(395, 265, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		lblMileRadius = new JLabel("Mile Radius:");
		lblMileRadius.setBounds(304, 295, 76, 16);
		add(lblMileRadius);
		
		textField_4 = new JTextField();
		textField_4.setBounds(395, 292, 116, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(352, 325, 97, 25);
		btnSubmit.setActionCommand("submit");
		btnSubmit.addActionListener(this);
		add(btnSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equalsIgnoreCase("submit"))
		{
			this.address="";
			
			
			if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("") && !textField_4.getText().equals(""))
			{
				setVisible(false);
				driver.getListPanel().setVisible(true);
				String[] a = textField.getText().split(" ");
				for(int i = 0; i < a.length; i++)
				{
					address += a[i] + "+";
				}
				address = address.substring(0,address.length()-1);
				this.address+=",+";
				a = textField_1.getText().split(" ");
				for(int i = 0; i < a.length; i++)
				{
					address += a[i] + "+";
				}		
				
				address+=",+";
				a = textField_2.getText().split(" ");
				for(int i = 0; i < a.length; i++)
				{
					address += a[i] + "+";
				}					
			}
			//returns string in format Address,State,MileRadius,Range
			
		}
		
	}
	
	public String getAddress(){return this.address;}
	public int getRange(){return Integer.parseInt(this.textField_4.getText());}
}
