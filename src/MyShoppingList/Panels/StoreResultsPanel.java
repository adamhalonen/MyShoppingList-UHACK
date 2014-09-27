package MyShoppingList.Panels;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import MyShoppingList.Driver.Driver;
import MyShoppingList.Util.Util;

public class StoreResultsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Driver driver;
	private DefaultListModel stores;
	private JScrollPane scrollPane;
	private JLabel[] labels = new JLabel[10];
	
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
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(12, 13, 648, 16);
		panel.add(label_9);
		labels[0] = label_9;
		
		JLabel label = new JLabel("");
		label.setBounds(12, 36, 648, 16);
		panel.add(label);
		labels[1] = label;
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(12, 59, 648, 16);
		panel.add(label_1);
		labels[2] = label_1;
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(12, 82, 648, 16);
		panel.add(label_2);
		labels[3] = label_2;
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(12, 106, 648, 16);
		panel.add(label_3);
		labels[4] = label_3;
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(12, 128, 648, 16);
		panel.add(label_4);
		labels[5] = label_4;
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(12, 150, 648, 16);
		panel.add(label_5);
		labels[6] = label_5;
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(12, 172, 648, 16);
		panel.add(label_6);
		labels[7] = label_6;
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(12, 194, 648, 16);
		panel.add(label_7);
		labels[8] = label_7;
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(12, 216, 648, 16);
		panel.add(label_8);
		labels[9] = label_8;
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(353, 485, 97, 25);
		add(btnBack);
	}
	
	public void setUp()
	{
		String[][] rawStores;
		Util util = new Util(driver);
		String[] storeInfo;
		
		rawStores = util.closestStores(driver.getAddressPanel().getAddress(),driver.getAddressPanel().getRange());
		storeInfo = new String[rawStores.length];
		for(int i = 0; i < rawStores.length; i++)
		{
				storeInfo[i] = rawStores[i][1] + "\t" + rawStores[i][2] + "\t" + rawStores[i][3] + "\t" + rawStores[i][4];
		}
		
		for(int i = 0; i < storeInfo.length; i++)
		{
			labels[i].setText( storeInfo[i]);
		}
	}
}
