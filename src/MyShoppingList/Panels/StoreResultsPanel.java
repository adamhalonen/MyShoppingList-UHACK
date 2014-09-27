package MyShoppingList.Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import MyShoppingList.Driver.Driver;
import MyShoppingList.Util.Util;

public class StoreResultsPanel extends JPanel implements MouseListener , ActionListener
{
	private static final long serialVersionUID = 1L;
	private Driver driver;
	private DefaultListModel stores;
	private JScrollPane scrollPane;
	private JLabel[] labels = new JLabel[30];
	private String[][] rawStores;
	private String selectedStoreId;
	
	//Labels
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	
	public StoreResultsPanel(Driver d)
	{
		setOpaque(false);
		driver = d;
		
		setBounds(0,0,800,600);
		setLayout(null);
		setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(65, 106, 672, 253);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 341, 253);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		label_9 = new JLabel("");
		label_9.setBounds(10, 10, 315, 16);
		panel_1.add(label_9);
		labels[0] = label_9;
		
		label = new JLabel("");
		label.setBounds(10, 30, 315, 16);
		panel_1.add(label);
		labels[1] = label;
		
		label_1 = new JLabel("");
		label_1.setBounds(10, 50, 315, 16);
		panel_1.add(label_1);
		labels[2] = label_1;
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 70, 315, 16);
		panel_1.add(label_2);
		labels[3] = label_2;
		
		label_3 = new JLabel("");
		label_3.setBounds(10, 90, 315, 16);
		panel_1.add(label_3);
		labels[4] = label_3;
		
		label_4 = new JLabel("");
		label_4.setBounds(10, 110, 315, 16);
		panel_1.add(label_4);
		labels[5] = label_4;
		
		label_5 = new JLabel("");
		label_5.setBounds(10, 130, 315, 16);
		panel_1.add(label_5);
		labels[6] = label_5;
		
		label_6 = new JLabel("");
		label_6.setBounds(10, 150, 315, 16);
		panel_1.add(label_6);
		labels[7] = label_6;
		
		label_7 = new JLabel("");
		label_7.setBounds(10, 170, 315, 16);
		panel_1.add(label_7);
		labels[8] = label_7;
		
		label_8 = new JLabel("");
		label_8.setBounds(10, 190, 315, 16);
		panel_1.add(label_8);
		labels[9] = label_8;
		label_8.addMouseListener(this);
		label_7.addMouseListener(this);
		label_6.addMouseListener(this);
		label_5.addMouseListener(this);
		label_4.addMouseListener(this);
		label_3.addMouseListener(this);
		label_2.addMouseListener(this);
		label_1.addMouseListener(this);
		label.addMouseListener(this);
		label_9.addMouseListener(this);
		
		panel_2 = new JPanel();
		panel_2.setBounds(339, 0, 202, 253);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		label_10 = new JLabel("");
		label_10.setBounds(10, 10, 180, 16);
		panel_2.add(label_10);
		labels[10] = label_10;
		
		label_11 = new JLabel("");
		label_11.setBounds(10, 30, 180, 16);
		panel_2.add(label_11);
		labels[11] = label_11;
		
		label_12 = new JLabel("");
		label_12.setBounds(10, 50, 180, 16);
		panel_2.add(label_12);
		labels[12] = label_12;
		
		label_13 = new JLabel("");
		label_13.setBounds(10, 70, 180, 16);
		panel_2.add(label_13);
		labels[13] = label_13;
		
		label_14 = new JLabel("");
		label_14.setBounds(10, 90, 180, 16);
		panel_2.add(label_14);
		labels[14] = label_14;
		
		label_15 = new JLabel("");
		label_15.setBounds(10, 110, 180, 16);
		panel_2.add(label_15);
		labels[15] = label_15;
		
		label_16 = new JLabel("");
		label_16.setBounds(10, 130, 180, 16);
		panel_2.add(label_16);
		labels[16] = label_16;
		
		label_17 = new JLabel("");
		label_17.setBounds(10, 150, 180, 16);
		panel_2.add(label_17);
		labels[17] = label_17;
		
		label_18 = new JLabel("");
		label_18.setBounds(10, 170, 180, 16);
		panel_2.add(label_18);
		labels[18] = label_18;
		
		label_19 = new JLabel("");
		label_19.setBounds(10, 190, 180, 16);
		panel_2.add(label_19);
		labels[19] = label_19;
		
		panel_3 = new JPanel();
		panel_3.setBounds(540, 0, 132, 253);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		label_20 = new JLabel("");
		label_20.setBounds(10, 10, 110, 16);
		panel_3.add(label_20);
		labels[20] = label_20;
		
		label_21 = new JLabel("");
		label_21.setBounds(10, 30, 110, 16);
		panel_3.add(label_21);
		labels[21] = label_21;
		
		label_22 = new JLabel("");
		label_22.setBounds(10, 50, 110, 16);
		panel_3.add(label_22);
		labels[22] = label_22;
		
		label_23 = new JLabel("");
		label_23.setBounds(10, 70, 110, 16);
		panel_3.add(label_23);
		labels[23] = label_23;
		
		label_24 = new JLabel("");
		label_24.setBounds(10, 90, 110, 16);
		panel_3.add(label_24);
		labels[24] = label_24;
		
		label_25 = new JLabel("");
		label_25.setBounds(10, 110, 110, 16);
		panel_3.add(label_25);
		labels[25] = label_25;
		
		label_26 = new JLabel("");
		label_26.setBounds(10, 130, 110, 16);
		panel_3.add(label_26);
		labels[26] = label_26;
		
		label_27 = new JLabel("");
		label_27.setBounds(10, 150, 110, 16);
		panel_3.add(label_27);
		labels[27] = label_27;
		
		label_28 = new JLabel("");
		label_28.setBounds(10, 170, 110, 16);
		panel_3.add(label_28);
		labels[28] = label_28;
		
		label_29 = new JLabel("");
		label_29.setBounds(10, 190, 110, 16);
		panel_3.add(label_29);
		labels[29] = label_29;
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(353, 485, 97, 25);
		btnBack.setActionCommand("back");
		btnBack.addActionListener(this);
		add(btnBack);
	}
	
	public String getSelectedStoreId(){return selectedStoreId;}
	
	public void setUp()
	{
		Util util = new Util(driver);
		String[] storeInfo;
		String addition = "";
		rawStores = util.closestStores(driver.getAddressPanel().getAddress(),driver.getAddressPanel().getRange());
		storeInfo = new String[rawStores.length*3];

		
		
		for(int i = 0; i < rawStores.length; i++)
		{
				storeInfo[i] = rawStores[i][2];
		}
		for(int i = 0; i < rawStores.length; i++)
		{
				storeInfo[i+10] = rawStores[i][3];
		}
		for(int i = 0; i < rawStores.length; i++)
		{
				storeInfo[i+20] = rawStores[i][4];
		}
		
		for(int i = 0; i < storeInfo.length; i++)
		{
			labels[i].setText( storeInfo[i]);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{	
		setVisible(false);
		driver.getProductAvailability().setVisible(true);
		
		if(e.getSource().equals(label))
		{
			selectedStoreId = rawStores[1][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[1][2],rawStores[1][3] + " | " + rawStores[1][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_1))
		{
			selectedStoreId = rawStores[2][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[2][2],rawStores[2][3] + " | " + rawStores[2][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_2))
		{
			selectedStoreId = rawStores[3][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[3][2],rawStores[3][3] + " | " + rawStores[3][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_3))
		{
			selectedStoreId = rawStores[4][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[4][2],rawStores[4][3] + " | " + rawStores[4][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_4))
		{
			selectedStoreId = rawStores[5][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[5][2],rawStores[5][3] + " | " + rawStores[5][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_5))
		{
			selectedStoreId = rawStores[6][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[6][2],rawStores[6][3] + " | " + rawStores[6][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_6))
		{
			selectedStoreId = rawStores[7][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[7][2],rawStores[7][3] + " | " + rawStores[7][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_7))
		{
			selectedStoreId = rawStores[8][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[8][2],rawStores[8][3] + " | " + rawStores[8][4], driver.getListPanel().getProducts());
		}
		else if(e.getSource().equals(label_8))
		{
			selectedStoreId = rawStores[9][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[9][2],rawStores[9][3] + " | " + rawStores[9][4], driver.getListPanel().getProducts());			
		}
		else if(e.getSource().equals(label_9))
		{
			selectedStoreId = rawStores[0][0];
			driver.getProductAvailability().setLabelsAndProducts(rawStores[0][2],rawStores[0][3] + " | " + rawStores[0][4], driver.getListPanel().getProducts());			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("back"))
		{
			setVisible(false);
			driver.getListPanel().setVisible(true);
		}
		
	}
}
