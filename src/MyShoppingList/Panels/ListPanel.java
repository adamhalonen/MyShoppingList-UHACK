package MyShoppingList.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import MyShoppingList.Driver.Driver;

public class ListPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Driver driver;
	private JTextField txtItems;
	private DefaultListModel listModel;
	
	public ListPanel(Driver d)
	{
		setOpaque(false);
		driver = d;
		
		setBounds(0,0,800,600);
		setVisible(false);
		setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(456, 71, 97, 25);
		btnAdd.setActionCommand("add");
		btnAdd.addActionListener(this);
		add(btnAdd);
		
		txtItems = new JTextField();
		txtItems.setBounds(198, 72, 235, 22);
		add(txtItems);
		txtItems.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(212, 525, 97, 25);
		btnBack.setActionCommand("back");
		btnBack.addActionListener(this);
		add(btnBack);
		
		JButton btnFindStore = new JButton("Find Store");
		btnFindStore.setBounds(456, 525, 97, 25);
		btnFindStore.setActionCommand("findStore");
		btnFindStore.addActionListener(this);
		add(btnFindStore);
		
		JList<String> list = new JList<String>();
		listModel = new DefaultListModel();
		list = new JList(listModel);
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
		btnRemove.setActionCommand("remove");
		btnRemove.addActionListener(this);
		add(btnRemove);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		
		if(cmd.equalsIgnoreCase("add"))
		{
			if(!txtItems.getText().equals("")){listModel.addElement(txtItems.getText());}
		}
		else if(cmd.equalsIgnoreCase("remove"))
		{
			
		}
		else if(cmd.equalsIgnoreCase("findStore"))
		{
			
		}
		else if(cmd.equalsIgnoreCase("back"))
		{
			setVisible(false);
			driver.getAddressPanel().setVisible(true);
		}
	}
}
