package MyShoppingList.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import MyShoppingList.Driver.Driver;

public class ProductAvailabilityPanel extends JPanel implements ActionListener
{
	private Driver driver;
	private JTextArea textArea;
	private JLabel lblName;
	private JLabel lblPhoneNumberaddress;
	private JButton btnBack;
	
	public ProductAvailabilityPanel(Driver d)
	{
		setLayout(null);
		driver = d;
		
		setVisible(false);
		setBounds(0,0,800,600);
		
		lblName = new JLabel("Name");
		lblName.setBounds(95, 75, 371, 44);
		add(lblName);
		
		JButton btnDirections = new JButton("Directions");
		btnDirections.setBounds(600, 127, 97, 25);
		btnDirections.addActionListener(this);
		btnDirections.setActionCommand("directions");
		add(btnDirections);
		
		lblPhoneNumberaddress = new JLabel("Phone Number/Address");
		lblPhoneNumberaddress.setBounds(95, 131, 173, 16);
		add(lblPhoneNumberaddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 169, 598, 365);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(347, 547, 97, 25);
		btnBack.addActionListener(this);
		btnBack.setActionCommand("back");
		add(btnBack);
	}
	
	public void setLabelsAndProducts(String name, String addressPhoneNumber, String[] products)
	{
		lblName.setText(name);
		lblPhoneNumberaddress.setText(addressPhoneNumber);
		for(int i = 0; i < products.length; i++)
		{
			textArea.setText(textArea.getText()+products[i]+"\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("directions")){}
		else if(e.getActionCommand().equals("back")){}
	}
}
