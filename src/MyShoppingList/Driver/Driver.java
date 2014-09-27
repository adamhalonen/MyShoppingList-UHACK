package MyShoppingList.Driver;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import MyShoppingList.Panels.AboutPanel;
import MyShoppingList.Panels.AddressPanel;
import MyShoppingList.Panels.ListPanel;
import MyShoppingList.Panels.MenuBar;
import MyShoppingList.Panels.ProductAvailabilityPanel;
import MyShoppingList.Panels.StoreResultsPanel;

public class Driver extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//Panels
	private AddressPanel addressPanel = new AddressPanel(this);
	private ListPanel listPanel = new ListPanel(this);
	private AboutPanel aboutPanel = new AboutPanel(this);
	private StoreResultsPanel storeResultsPanel = new StoreResultsPanel(this);
	private ProductAvailabilityPanel prodAvlPanel = new ProductAvailabilityPanel();
	
	//Menu Bar 
	private MenuBar menuBar = new MenuBar(this);
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					new Driver();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Driver()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		setVisible(true);
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
		
		contentPane.add(menuBar);
		
		contentPane.add(aboutPanel);
		aboutPanel.setVisible(false);
		
		contentPane.add(addressPanel);
		
		contentPane.add(listPanel);
		
		contentPane.add(storeResultsPanel);
		
		JLabel bg = new JLabel();
		bg.setBounds(0, 0, 794, 565);
		bg.setIcon(new ImageIcon("res/bg.png"));
		contentPane.add(bg);
	}
	
	public AboutPanel getAboutPanel(){return aboutPanel;}
	public ListPanel getListPanel(){return listPanel;}
	public AddressPanel getAddressPanel(){return addressPanel;}
	public StoreResultsPanel getStoreResults(){return storeResultsPanel;}

	public ProductAvailabilityPanel getProductAvailability(){return prodAvlPanel;}

}
