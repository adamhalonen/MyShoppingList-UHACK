package MyShoppingList.Panels;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		
		JList list = new JList();
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(99, 81, 596, 426);
		add(scrollPane);
	}
}
