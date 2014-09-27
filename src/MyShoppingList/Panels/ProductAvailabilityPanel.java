package MyShoppingList.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import MyShoppingList.Driver.Driver;
import MyShoppingList.Util.Util;

public class ProductAvailabilityPanel extends JPanel implements ActionListener , MouseListener
{
	private Driver driver;
	private JTextArea textArea;
	private JLabel lblName;
	private JLabel lblPhoneNumberaddress;
	private JButton btnBack;
	private JLabel lblDirectionsimage;
	private Util util = new Util();
	
	public ProductAvailabilityPanel(Driver d)
	{
		setOpaque(false);
		setLayout(null);
		driver = d;
		
		lblDirectionsimage = new JLabel("");
		lblDirectionsimage.setBounds(0, 0, 800, 600);
		add(lblDirectionsimage);
		lblDirectionsimage.addMouseListener(this);
		
		setVisible(false);
		setBounds(0,0,800,600);
		
		lblName = new JLabel("Name");
		lblName.setBounds(95, 62, 371, 44);
		add(lblName);
		
		JButton btnDirections = new JButton("Directions");
		btnDirections.setBounds(596, 115, 97, 25);
		btnDirections.addActionListener(this);
		btnDirections.setActionCommand("directions");
		add(btnDirections);
		
		lblPhoneNumberaddress = new JLabel("Phone Number/Address");
		lblPhoneNumberaddress.setBounds(95, 119, 173, 16);
		add(lblPhoneNumberaddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 148, 598, 365);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(347, 526, 97, 25);
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
		if(e.getActionCommand().equals("directions"))
		{
			lblDirectionsimage.setIcon(util.getDirections(driver.getAddressPanel().getAddress(), lblName.getText()));
		}
		else if(e.getActionCommand().equals("back"))
		{
			setVisible(false);
			driver.getStoreResults().setVisible(true);
			textArea.setText("");
			lblDirectionsimage.setIcon(null);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		((JComponent) e.getSource()).setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
