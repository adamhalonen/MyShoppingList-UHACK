package MyShoppingList.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
				this.driver.getListPanel().setProducts();
				
				pw=new PrintWriter(new FileWriter(file));
				
				if(!str.equals(""))
				{
					hold=str.indexOf(",");
				
					pw.println("Address: " + str.substring(0,hold));
				
					hold2=str.indexOf(",",hold+2);
				
					pw.println("City: " + str.substring(hold+2,hold2-1));
				
					hold=str.indexOf(",",hold2);
					
					pw.println("State: " + str.substring(hold+2,str.length()-1));
					
					pw.println("MileRadius: " + this.driver.getAddressPanel().getRange());
					
					for(int i=0; i<this.driver.getListPanel().getProducts().length;i++)
					{
						pw.println(this.driver.getListPanel().getProducts()[i]);
					}
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
			File file;
			BufferedReader br;
			String record;
			String result;
			int count;
			String[] array;
			String theAddress;
			String theDistanceVariable;
			
			count=0;
			file=new File("preferences.txt");
			result="";
			theAddress = "";
			theDistanceVariable = "";
			
			
			
			try
			{
				br=new BufferedReader(new FileReader(file));
				
				record=br.readLine();
				
				while(record!=null)
				{
					result=result+record.substring(record.indexOf(" ")+1)+",+";
					record=br.readLine();
				}
				
				result=result.substring(0,result.length()-2);
				
				array=result.split(",+");
				
				
				for(int i = 0; i < 2; i++)
				{
					theAddress = theAddress + array[i]+",";
				}
					theAddress = theAddress + array[2];
					theDistanceVariable = array[3];
				
				//System.out.println(theAddress);
				//System.out.println(Integer.parseInt(theDistanceVariable));
				
				this.driver.getAddressPanel().setAddress(theAddress);
				
				this.driver.getAddressPanel().setRange(Integer.parseInt(theDistanceVariable));
				
				//System.out.println(this.driver.getAddressPanel().getAddress());
				//System.out.println(this.driver.getAddressPanel().getRange());
				
				br.close();
			}
			catch(Exception ioe)
			{
				ioe.printStackTrace();
			}
		}
		else if(cmd.equalsIgnoreCase("quit"))
		{
			driver.dispose();
		}
		else if(cmd.equalsIgnoreCase("clear"))
		{
			driver.getListPanel().clearProducts();
		}
		else if(cmd.equalsIgnoreCase("about"))
		{
			driver.getAboutPanel().setVisible(true);
		}
	}
}
