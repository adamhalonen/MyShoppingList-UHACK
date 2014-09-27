package MyShoppingList.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import MyShoppingList.Driver.Driver;

public class MenuBar extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Driver driver;
	
	public MenuBar(Driver d)
	{
		driver = d;
		
		setOpaque(false);
		setLayout(null);
		setBounds(0,0,800,25);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 26);
		add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setActionCommand("new");
		mntmNew.addActionListener(this);
		mnFile.add(mntmNew);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.setActionCommand("load");
		mntmLoad.addActionListener(this);
		mnFile.add(mntmLoad);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setActionCommand("save");
		mntmSave.addActionListener(this);
		mnFile.add(mntmSave);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setActionCommand("quit");
		mntmQuit.addActionListener(this);
		mnFile.add(mntmQuit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.setActionCommand("clear");
		mntmClear.addActionListener(this);
		mntmClear.setEnabled(false);
		mnEdit.add(mntmClear);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setActionCommand("about");
		mntmAbout.addActionListener(this);
		mnHelp.add(mntmAbout);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		
		if(cmd.equalsIgnoreCase("new"))
		{
			driver.dispose();
			new Driver();
		}
		else if(cmd.equalsIgnoreCase("save"))
		{
			
		}
		else if(cmd.equalsIgnoreCase("load"))
		{
			
		}
		else if(cmd.equalsIgnoreCase("quit"))
		{
			driver.dispose();
		}
		else if(cmd.equalsIgnoreCase("clear"))
		{
			
		}
		else if(cmd.equalsIgnoreCase("about"))
		{
			driver.getAboutPanel().setVisible(true);
		}
	}
}
