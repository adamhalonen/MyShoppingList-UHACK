package MyShoppingList.Driver;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyShoppingList.Panels.AddressPanel;

public class Driver extends JFrame
{
	private JPanel contentPane;
	
	//Panels
	AddressPanel addressPanel = new AddressPanel(this);
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Driver frame = new Driver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Driver() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		setTitle("My Shopping List");
		try {setIconImage(ImageIO.read(new File("res/icon.png")));}
		catch (IOException e) {e.printStackTrace();}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)width/2-400, (int)height/2-300, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addressPanel.setBounds(5, 5, 784, 555);
		
		contentPane.add(addressPanel);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 794, 565);
		bg.setIcon(new ImageIcon("res/bg.png"));
		contentPane.add(bg);
	}
}
