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
	private JLabel[] labels = new JLabel[10];
	
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
		
		label_9 = new JLabel("");
		label_9.setBounds(12, 13, 648, 16);
		panel.add(label_9);
		labels[0] = label_9;
		label_9.addMouseListener(this);
		
		label = new JLabel("");
		label.setBounds(12, 36, 648, 16);
		panel.add(label);
		labels[1] = label;
		label.addMouseListener(this);
		
		label_1 = new JLabel("");
		label_1.setBounds(12, 59, 648, 16);
		panel.add(label_1);
		labels[2] = label_1;
		label_1.addMouseListener(this);
		
		label_2 = new JLabel("");
		label_2.setBounds(12, 82, 648, 16);
		panel.add(label_2);
		labels[3] = label_2;
		label_2.addMouseListener(this);
		
		label_3 = new JLabel("");
		label_3.setBounds(12, 106, 648, 16);
		panel.add(label_3);
		labels[4] = label_3;
		label_3.addMouseListener(this);
		
		label_4 = new JLabel("");
		label_4.setBounds(12, 128, 648, 16);
		panel.add(label_4);
		labels[5] = label_4;
		label_4.addMouseListener(this);
		
		label_5 = new JLabel("");
		label_5.setBounds(12, 150, 648, 16);
		panel.add(label_5);
		labels[6] = label_5;
		label_5.addMouseListener(this);
		
		label_6 = new JLabel("");
		label_6.setBounds(12, 172, 648, 16);
		panel.add(label_6);
		labels[7] = label_6;
		label_6.addMouseListener(this);
		
		label_7 = new JLabel("");
		label_7.setBounds(12, 194, 648, 16);
		panel.add(label_7);
		labels[8] = label_7;
		label_7.addMouseListener(this);
		
		label_8 = new JLabel("");
		label_8.setBounds(12, 216, 648, 16);
		panel.add(label_8);
		labels[9] = label_8;
		label_8.addMouseListener(this);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(353, 485, 97, 25);
		btnBack.setActionCommand("back");
		btnBack.addActionListener(this);
		add(btnBack);
	}
	
	public void setUp()
	{
		String[][] rawStores;
		Util util = new Util(driver);
		String[] storeInfo;
		String longest = "";
		String addition = "";
		rawStores = util.closestStores(driver.getAddressPanel().getAddress(),driver.getAddressPanel().getRange());
		storeInfo = new String[rawStores.length];
		for(int i = 0;i<10;i++)
		{
			if(rawStores[i][2].length() > longest.length())
			{
				longest = rawStores[i][2];
			}
			
		}
		longest = longest + " ";
		for(int i = 0; i < rawStores.length; i++)
		{
				if(rawStores[i][2].length() < longest.length())
				{
					while(rawStores[i][2].length() < longest.length())
					{
						rawStores[i][2] = rawStores[i][2] + " ";
					}
					
				}
				storeInfo[i] = rawStores[i][2] /*+ "  "*/ + rawStores[i][3] + "  " + rawStores[i][4];
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
			
		}
		else if(e.getSource().equals(label_1))
		{
			
		}
		else if(e.getSource().equals(label_2))
		{
			
		}
		else if(e.getSource().equals(label_3))
		{
			
		}
		else if(e.getSource().equals(label_4))
		{
			
		}
		else if(e.getSource().equals(label_5))
		{
			
		}
		else if(e.getSource().equals(label_6))
		{
			
		}
		else if(e.getSource().equals(label_7))
		{
			
		}
		else if(e.getSource().equals(label_8))
		{
			
		}
		else if(e.getSource().equals(label_9))
		{
			
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
