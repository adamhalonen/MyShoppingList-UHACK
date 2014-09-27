package MyShoppingList.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
			String str= this.driver.getAddressPanel().getAddress();
			File file;
			PrintWriter pw;
			int hold;
			int hold2;
			
			
			
			file=new File("preferences.txt");
			
			try
			{
				pw=new PrintWriter(new FileWriter(file));
				
				if(!str.equals(""))
				{
					hold=str.indexOf(",");
				
					pw.println("Address: " + str.substring(0,hold));
				
					hold2=str.indexOf(",",hold+1);
				
					pw.println("City: " + str.substring(hold+1,hold2));
				
					hold=str.indexOf(",",hold2+1);
					pw.println("State: " + str.substring(hold2+1,hold));
					
					pw.println("Mile Radius: " + str.substring(hold+1));
				}
				
				
				pw.flush();
				
				
				pw.close();
				
				
			}
			catch(IOException ioe)
			{
				
				ioe.printStackTrace();
			}
			
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
