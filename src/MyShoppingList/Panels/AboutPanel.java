package MyShoppingList.Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MyShoppingList.Driver.Driver;

public class AboutPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Driver driver;
	
	public AboutPanel(Driver d)
	{
		driver = d;
		
		setBounds(30,30,300,200);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(191, 162, 97, 25);
		btnClose.setActionCommand("close");
		btnClose.addActionListener(this);
		add(btnClose);
		
		JTextArea txtrVersion = new JTextArea();
		txtrVersion.setText("Version 0.0.1\r\nCreated at UHack 2014\r\n\r\nDeveloped By:\r\nJosh Greenwell\r\nJake Braaten\r\nAdam Halonen\r\nNick McDonagh");
		txtrVersion.setToolTipText("");
		txtrVersion.setBounds(12, 13, 288, 187);
		txtrVersion.setEditable(false);
		add(txtrVersion);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equalsIgnoreCase("close")){driver.getAboutPanel().setVisible(false);;}
		
	}
}
