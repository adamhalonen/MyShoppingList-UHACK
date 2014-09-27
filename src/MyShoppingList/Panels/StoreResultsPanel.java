package MyShoppingList.Panels;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import MyShoppingList.Driver.Driver;
import MyShoppingList.Util.Util;

public class StoreResultsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Driver driver;
	
	public StoreResultsPanel(Driver d)
	{
		driver = d;
		
		setBounds(0,0,800,600);
		setLayout(null);
	}
	
	public void setUp()
	{
		DefaultListModel stores = new DefaultListModel();
		String[][] rawStores;
		Util util = new Util(driver);
		String storeInfo;
		
		rawStores = util.closestStores(driver.getAddressPanel().getAddress(),driver.getAddressPanel().getRange());
		//stores = new String[rawStores.length];
		for(int i = 0; i < rawStores.length; i++)
		{
			storeInfo = "";
			for(int j = 0; j < rawStores[i].length; j++)
			{
				storeInfo += rawStores[i][j] + "\t\t";
			}
			stores.addElement(storeInfo);
		}
		
		JList<String> list = new JList<String>(stores);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(99, 81, 596, 426);
		add(scrollPane);
	}
}
