package MyShoppingList.Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
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
	private JPanel panel;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JPanel panel_1;
	
	private String[] items;
	private String[] prices;
	private String[] quantities;
	
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
		
		btnBack = new JButton("Back");
		btnBack.setBounds(347, 526, 97, 25);
		btnBack.addActionListener(this);
		btnBack.setActionCommand("back");
		add(btnBack);
		
		lblPhoneNumberaddress = new JLabel("Phone Number/Address");
		lblPhoneNumberaddress.setBounds(95, 119, 173, 16);
		add(lblPhoneNumberaddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 148, 598, 365);
		add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 291, 363);
		panel_1.add(textArea);
		textArea.setEditable(false);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(295, 0, 150, 363);
		panel_1.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setBounds(449, 0, 147, 363);
		panel_1.add(textArea_2);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 800, 600);
		add(panel);
		
		lblDirectionsimage = new JLabel("");
		panel.add(lblDirectionsimage);
		lblDirectionsimage.setBackground(Color.BLACK);
	}
	
	public void setLabelsAndProducts(String name, String addressPhoneNumber, String[] products)
	{
		lblName.setText(name);
		lblPhoneNumberaddress.setText(addressPhoneNumber);
		String[][] prodInfo = util.getProductInfo(driver.getListPanel().getProducts(), driver.getStoreResults().getSelectedStoreId());
		items = prodInfo[0];
		prices = prodInfo[1];
		quantities = prodInfo[2];
		for(int i = 0; i < products.length; i++)
		{
			textArea.setText(textArea.getText()+items[i]+"\n");
		}
		for(int i = 0; i < products.length; i++)
		{
			textArea_1.setText(textArea.getText()+prices[i]+"\n");
		}
		for(int i = 0; i < products.length; i++)
		{
			textArea_2.setText(textArea.getText()+quantities[i]+"\n");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("directions"))
		{
			//JFrame dir = new JFrame();
			//dir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//dir.setBounds(0, 0, 500, 300);
			lblDirectionsimage.setIcon(util.getDirections(driver.getAddressPanel().getAddress(), lblName.getText()));
			lblDirectionsimage.setVisible(true);
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
