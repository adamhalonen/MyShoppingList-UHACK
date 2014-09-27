package MyShoppingList.Panels;

import javax.swing.JPanel;

import MyShoppingList.Driver.Driver;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Driver driver;
	private JTextField txtItems;
	
	public ListPanel(Driver d)
	{
		setOpaque(false);
		driver = d;
		
		setBounds(0,0,800,600);
		setVisible(false);
		setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(456, 71, 97, 25);
		add(btnAdd);
		
		txtItems = new JTextField();
		txtItems.setBounds(198, 72, 235, 22);
		add(txtItems);
		txtItems.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(212, 525, 97, 25);
		add(btnBack);
		
		JButton btnFindStore = new JButton("Find Store");
		btnFindStore.setBounds(456, 525, 97, 25);
		add(btnFindStore);
		
		JList<String> list = new JList<String>();
		
		list = new JList();
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener()
		{

			public void valueChanged(ListSelectionEvent e)
			{
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(91, 126, 569, 361);
		add(scrollPane);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(336, 525, 97, 25);
		add(btnRemove);
	}
}
