package MyShoppingList.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

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
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JPanel panel_1;
	
	private String[] items;
	private String[] prices;
	private String[] quantities;
	private JLabel lblItems;
	private JLabel lblPrices;
	private JLabel lblQuantities;
	
	public ProductAvailabilityPanel(Driver d)
	{
		setOpaque(false);
		setLayout(null);
		driver = d;
		
		setVisible(false);
		setBounds(0,0,800,600);
		
		lblName = new JLabel("Name");
		lblName.setBounds(95, 45, 371, 44);
		add(lblName);
		
		JButton btnDirections = new JButton("Directions");
		btnDirections.setBounds(590, 526, 97, 25);
		btnDirections.addActionListener(this);
		btnDirections.setActionCommand("directions");
		btnDirections.setVisible(false);
		add(btnDirections);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(347, 526, 97, 25);
		btnBack.addActionListener(this);
		btnBack.setActionCommand("back");
		add(btnBack);
		
		lblItems = new JLabel("Items");
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setBounds(212, 124, 56, 16);
		add(lblItems);
		
		lblPrices = new JLabel("Prices");
		lblPrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrices.setBounds(430, 124, 56, 16);
		add(lblPrices);
		
		lblQuantities = new JLabel("Quantities");
		lblQuantities.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantities.setBounds(572, 124, 82, 16);
		add(lblQuantities);
		
		lblPhoneNumberaddress = new JLabel("Phone Number/Address");
		lblPhoneNumberaddress.setBounds(95, 81, 173, 16);
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
		textArea.setLineWrap(true);
		panel_1.add(textArea);
		textArea.setEditable(false);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(295, 0, 150, 363);
		textArea_1.setLineWrap(true);
		panel_1.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setBounds(449, 0, 147, 363);
		textArea_2.setLineWrap(true);
		panel_1.add(textArea_2);
		
		lblDirectionsimage = new JLabel("");
		lblDirectionsimage.setBounds(0, 0, 800, 600);
		add(lblDirectionsimage);
		lblDirectionsimage.addMouseListener(this);
	}
	
	public void setLabelsAndProducts(String name, String addressPhoneNumber, String[] products)
	{	
		lblName.setText(name);
		lblPhoneNumberaddress.setText(addressPhoneNumber);
		System.out.println(driver.getStoreResults().getSelectedStoreId());
		String[][] prodInfo = util.getProductInfo(driver.getListPanel().getProducts(), driver.getStoreResults().getSelectedStoreId());
		items = new String[prodInfo.length];
		prices = new String[prodInfo.length];
		quantities = new String[prodInfo.length];
		
		for(int i = 0; i < products.length; i++)
		{
			items[i] = prodInfo[i][0];
			textArea.setText(textArea.getText()+items[i]+"\n");
		}
		for(int i = 0; i < products.length; i++)
		{
			prices[i] = prodInfo[i][1];
			textArea_1.setText(textArea_1.getText()+prices[i]+"\n");
		}
		for(int i = 0; i < products.length; i++)
		{
			quantities[i] = prodInfo[i][2];
			textArea_2.setText(textArea_2.getText()+quantities[i]+"\n");
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
			textArea_1.setText("");
			textArea_2.setText("");
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
