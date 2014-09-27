package MyShoppingList.Panels;

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
		
		String[] stores;
		String[][] rawStores;
		Util util = new Util(driver);
		
		rawStores = util.closestStores(driver.getAddressPanel().getAddress());
		stores = new String[rawStores.length];
		for(int i = 0; i < rawStores.length; i++)
		{
			for(int j = 0; j < rawStores[i].length; j++)
			{
				stores[i] = stores[i] + rawStores[i][j] + "\t\t";
			}
		}
		
		JList list = new JList(stores);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(99, 81, 596, 426);
		add(scrollPane);
	}
}
